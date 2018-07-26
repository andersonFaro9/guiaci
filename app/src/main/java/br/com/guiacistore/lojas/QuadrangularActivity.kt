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
import br.com.guiacistore.fragments.CelulaDaQuadrangularFragment
import br.com.guiacistore.fragments.CultoNaIgrejaQuadrangularFragment
import br.com.guiacistore.fragments.HistoriaDaIgrejaQuadrangularFragment
import br.com.guiacistore.interfaces.IRedeSocial
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_celulas_da_igreja_quadrangular.*


class QuadrangularActivity : AppCompatActivity(), IRedeSocial {







    override fun abrirFacebook(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/"))
        }
    }

    override fun abrirInstagram(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/ieq_pojuca/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ieq_pojuca/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ieq_pojuca/"))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_quadrangular)


        supportActionBar?.title = "Quadrangular"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("CÉLULAS", CelulaDaQuadrangularFragment::class.java)
                .add("CULTOS", CultoNaIgrejaQuadrangularFragment::class.java)
                .add("HISTÓRIA", HistoriaDaIgrejaQuadrangularFragment::class.java)

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



