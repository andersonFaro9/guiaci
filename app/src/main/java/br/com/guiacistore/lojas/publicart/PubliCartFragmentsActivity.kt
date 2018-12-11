package br.com.guiacistore.lojas.publicart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.fragments.PublicartMissaoFragment
import br.com.guiacistore.fragments.PublicartValoresFragment
import br.com.guiacistore.fragments.PublicartVisaoFragment
import br.com.guiacistore.interfaces.ICallNumber
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class PubliCartFragmentsActivity : AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loja_publicart)

        supportActionBar?.elevation = 0F
        supportActionBar?.title = "Publicart"

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("MISSÃO", PublicartMissaoFragment::class.java)
                .add("VISÃO", PublicartVisaoFragment::class.java)
                .add("VALORES", PublicartValoresFragment::class.java)
                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_publicart, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }
            R.id.ic_mapa -> {
                verMapa(Uri.parse("https://goo.gl/maps/kByyFXc2kQA2"))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {

        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:75 9 99672401")
        startActivity(callIntent)
    }


}
