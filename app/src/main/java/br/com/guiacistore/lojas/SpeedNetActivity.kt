package br.com.guiacistore.lojas

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.fragments.HistoriaDaSpeedNetFragment
import br.com.guiacistore.fragments.LinkDedicadoSpeedNetFragment
import br.com.guiacistore.fragments.PlanosDaSpeednetFragment
import br.com.guiacistore.fragments.PromocoesDaSpeedNetFragment
import br.com.guiacistore.interfaces.IRedeSocial
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_plano_speednet.*

class SpeedNetActivity : AppCompatActivity(),
           Invisible, IRedeSocial, IFirebase{

    override fun abrirFacebook(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/speednetalliance/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/speednetalliance/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/speednetalliance/"))
        }
    }

    override fun abrirInstagram(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/speednetalliance/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/speednetalliance/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/speednetalliance/"))
        }
    }
    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {
        referenciaFirebase?.child(id.toString())


            planoSpeednetprogressBar?.visibility = View.VISIBLE



        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    speednet_download_5_megas?.text = cliente?.speednet_download_5_megas
                    speednet_download_5_megas_speedZap?.text = cliente?.speednet_download_5_megas_speedZap

                    speednet_download_7_megas?.text = cliente?.speednet_download_7_megas
                    speednet_download_7_megas_speedFace?.text = cliente?.speednet_download_7_megas_speedFace

                    speednet_download_10_megas?.text = cliente?.speednet_download_10_megas
                    speednet_download_10_megas_speedFlix?.text = cliente?.speednet_download_10_megas_speedFlix

                    speednet_download_15_megas?.text = cliente?.speednet_download_15_megas
                    speednet_download_15_megas_speedUltra?.text = cliente?.speednet_download_15_megas_speedUltra

                    speednet_download_20_megas?.text = cliente?.speednet_download_20_megas
                    speednet_download_20_megas_speedFull?.text = cliente?.speednet_download_20_megas_speedFull


                }

                planoSpeednetprogressBar?.visibility = View.INVISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_speednet)
        supportActionBar?.title = "Speednet Alliance"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F
        doDatabaseInstance(1)

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA", HistoriaDaSpeedNetFragment::class.java)
                .add("PROMOÇÕES", PromocoesDaSpeedNetFragment::class.java)
                .add("PLANOS", PlanosDaSpeednetFragment::class.java)
                .add("LINK DEDICADO", LinkDedicadoSpeedNetFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)

        abrirInstagram(this)
        abrirFacebook(this)

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_speednet, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_instagram -> {

                val instagramIntent = abrirInstagram(this)
                startActivity(instagramIntent)

                return true
            }

            R.id.ic_facebook-> {

                val facebookIntent = abrirFacebook(this)
                startActivity(facebookIntent )

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


}
