package br.com.guiacistore.lojas.epg
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
import br.com.guiacistore.fragments.EpgContatosFragment
import br.com.guiacistore.fragments.EpgNovidadesFragment
import br.com.guiacistore.fragments.EpgServicosFragment
import br.com.guiacistore.interfaces.ICheckPermission
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.LojasModelFireBase
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.epg_fragment_servicos.*


class EpgActivity : AppCompatActivity(),  Invisible, IFirebase, ICheckPermission {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()


    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {

        epgServicosProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModelFireBase::class.java)

                    val listaApp  = listOf(

                            cliente?.epg_servico1,cliente?.epg_servico2,
                            cliente?.epg_servico3,cliente?.epg_servico4,
                            cliente?.epg_servico5, cliente?.epg_servico6,
                            cliente?.epg_servico7,cliente?.epg_servico8,
                            cliente?.epg_servico9,cliente?.epg_servico10,
                            cliente?.epg_servico11, cliente?.epg_servico12,
                            cliente?.epg_servico13, cliente?.epg_servico14,
                            cliente?.epg_servico15, cliente?.epg_servico16,
                            cliente?.epg_servico17, cliente?.epg_servico18,
                            cliente?.epg_servico19, cliente?.epg_servico20
                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@EpgActivity, android.R.layout.simple_list_item_1, listaApp)
                    epg_servicos?.adapter = arrayAdapter //<- com as extensions

                    epgServicosProgressBar?.visibility = View.INVISIBLE

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

        setContentView(R.layout.loja_epg)

        supportActionBar?.title = "EPG Impressões"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("CONTATOS",  EpgContatosFragment::class.java)
                .add("SERVIÇOS",  EpgServicosFragment::class.java)
                .add("NOVIDADES", EpgNovidadesFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.ic_phone -> {

                checkPermissionForCallPhone()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }



    override fun checkPermissionForCallPhone() {
        when {
            ContextCompat.checkSelfPermission(EpgActivity@ this,
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
            callIntent.data = Uri.parse("tel:96363518")
        startActivity(callIntent)
    }



}