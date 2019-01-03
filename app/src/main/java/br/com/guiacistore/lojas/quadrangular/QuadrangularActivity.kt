package br.com.guiacistore.lojas.quadrangular
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.fragments.QuadrangularCelulaFragment
import br.com.guiacistore.fragments.QuadrangularCultoFragment
import br.com.guiacistore.fragments.QuadrangularHistoriaFragment
import br.com.guiacistore.redesocial.IgrejaQuadrangularRedesSociaisActivity
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class QuadrangularActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_quadrangular)


        supportActionBar?.title = "Igreja Quadrangular"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("CÉLULAS", QuadrangularCelulaFragment::class.java)
                .add("CULTOS", QuadrangularCultoFragment::class.java)
                .add("HISTÓRIA", QuadrangularHistoriaFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)



    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_igreja_quadrangular, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_menu -> {

                val intent = Intent(this@QuadrangularActivity, IgrejaQuadrangularRedesSociaisActivity::class.java)

                startActivity (intent)

                return true
            }


        }

        return super.onOptionsItemSelected(item)
    }


}



