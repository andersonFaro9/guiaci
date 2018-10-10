package br.com.guiacistore.lojas

import android.Manifest
import android.R
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
import br.com.guiacistore.fragments.HistoriaDoStudioESoundFragment
import br.com.guiacistore.fragments.PromocoesDoStudioESoundFragment
import br.com.guiacistore.fragments.ServicosDoStudioESoundFragment
import br.com.guiacistore.interfaces.ICheckPermission
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_servicos_do_studio_esound.*

class StudioESoundActivity : AppCompatActivity(), Invisible, IFirebase, ICheckPermission {

    override fun checkPermissionForCallPhone() {
        when {
            ContextCompat.checkSelfPermission(StudioESoundActivity@ this,
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
        callIntent.data = Uri.parse("tel:999036450")
        startActivity(callIntent)
    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {

        servicosEsoundProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(

                            cliente?.studio_esound_produto_1, cliente?.studio_esound_produto_2,
                            cliente?.studio_esound_produto_3, cliente?.studio_esound_produto_4,
                            cliente?.studio_esound_produto_5, cliente?.studio_esound_produto_6

                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@StudioESoundActivity, R.layout.simple_list_item_1, listaApp)
                    servicos_esound?.adapter = arrayAdapter //<- com as extensions


                }

                servicosEsoundProgressBar?.visibility = View.INVISIBLE


            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(br.com.guiacistore.R.menu.menu_main_loja_esound, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            br.com.guiacistore.R.id.ic_phone -> {

                checkPermissionForCallPhone()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doDatabaseInstance(1)

        setContentView(br.com.guiacistore.R.layout.loja_esound)

        supportActionBar?.title = "E Sound"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA", HistoriaDoStudioESoundFragment::class.java)
                .add("SOM", ServicosDoStudioESoundFragment::class.java)
                .add("PROMOÇÕES", PromocoesDoStudioESoundFragment::class.java)

                .create())

        val viewPager = findViewById<View>(br.com.guiacistore.R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(br.com.guiacistore.R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)



    }

}
