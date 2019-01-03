package br.com.guiacistore.lojas.publicart

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.fragments.PublicartMissaoFragment
import br.com.guiacistore.fragments.PublicartValoresFragment
import br.com.guiacistore.fragments.PublicartVisaoFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class PubliCartFragmentsActivity : AppCompatActivity() {

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






}
