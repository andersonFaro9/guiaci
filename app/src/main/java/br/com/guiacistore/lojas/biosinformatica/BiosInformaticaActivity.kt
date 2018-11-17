package br.com.guiacistore.lojas.biosinformatica
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import br.com.guiacistore.R
import br.com.guiacistore.fragments.BiosInformaticaPromocoesFragment
import br.com.guiacistore.fragments.BiosInformaticaServicosFragment
import br.com.guiacistore.interfaces.CallNumber
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasFireBaseModel
import br.com.guiacistore.redesocial.BiosInformaticaRedesSociaisActivity
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.bios_informatica_fragment_servicos.*

class BiosInformaticaActivity : AppCompatActivity(),  Invisible, IFirebase,CallNumber {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {

        servicosBiosInformaticaProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasFireBaseModel::class.java)

                    val listaApp  = listOf(
                            //Mostra a lista de serviços da  Barbearia do Greg
                            cliente?.bios_servico1, cliente?.bios_servico2,
                            cliente?.bios_servico3, cliente?.bios_servico4,
                            cliente?.bios_servico5, cliente?.bios_servico6,
                            cliente?.bios_servico7, cliente?.bios_servico8

                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@BiosInformaticaActivity, android.R.layout.simple_list_item_1, listaApp)
                    servicos_bios_informatica?.adapter = arrayAdapter //<- com as extensions

                    servicosBiosInformaticaProgressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doDatabaseInstance(1)

        setContentView(R.layout.loja_bios_informatica)

        supportActionBar?.title = "Bios Informática"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("SERVIÇOS", BiosInformaticaServicosFragment::class.java)
                .add("PROMOÇÕES", BiosInformaticaPromocoesFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)



    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_lojas, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_menu-> {

                val intent = Intent(this@BiosInformaticaActivity, BiosInformaticaRedesSociaisActivity::class.java)

                startActivity (intent)
                return true
            }

            R.id.ic_phone -> {

                callNumber()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {
        when {
            ContextCompat.checkSelfPermission(SpeedNetActivity@ this,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED -> if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CALL_PHONE)) {

            } else {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 42)
            }
            else -> callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when { requestCode == 42 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> callPhone() }

    }

    @SuppressLint("MissingPermission")
    fun callPhone(){

        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel: 988104762")
        startActivity(callIntent)
    }



}