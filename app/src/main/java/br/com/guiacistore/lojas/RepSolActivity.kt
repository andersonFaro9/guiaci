package br.com.guiacistore.lojas
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
import br.com.guiacistore.fragments.HistoriaDaRepSolFragment
import br.com.guiacistore.fragments.PromocoesDaRepSolFragment
import br.com.guiacistore.fragments.ServicosDaRepsolFragment
import br.com.guiacistore.interfaces.ICheckPermission
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import br.com.guiacistore.redesocial.VeniviciRedesSociaisActivity
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_servicos_da_repsol.*


class RepSolActivity : AppCompatActivity(), Invisible, IFirebase, ICheckPermission {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {


        repSolServicosProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(


                            cliente?.repsol_produto_1.toString(), cliente?.repsol_produto_2.toString(),
                            cliente?.repsol_produto_3.toString(),cliente?.repsol_produto_4.toString(),
                            cliente?.repsol_produto_5.toString(),cliente?.repsol_produto_6.toString()


                    )


                    val arrayAdapter : ArrayAdapter<Any?> = ArrayAdapter(this@RepSolActivity, android.R.layout.simple_list_item_1, listaApp)
                    repsol_servicos?.adapter = arrayAdapter //<- com as extensions


                    repSolServicosProgressBar?.visibility = View.INVISIBLE


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

        setContentView(R.layout.loja_repsol)
        doDatabaseInstance(1)

        supportActionBar?.title = "RepSol Moto Center"



        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA", HistoriaDaRepSolFragment::class.java)
                .add("SERVIÇOS", ServicosDaRepsolFragment::class.java)
                .add("PROMOÇÕES", PromocoesDaRepSolFragment::class.java)
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

            R.id.ic_phone -> {

                checkPermissionForCallPhone()
                return true
            }

            R.id.ic_menu-> {

                val intent = Intent(this@RepSolActivity, VeniviciRedesSociaisActivity::class.java)

                startActivity (intent)
                return true
            }


            }


        return super.onOptionsItemSelected(item)
    }

    override fun checkPermissionForCallPhone() {
        when {
            ContextCompat.checkSelfPermission(VeniviciActivity@ this,
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
        callIntent.data = Uri.parse("tel:998393329")
        startActivity(callIntent)
    }



}



