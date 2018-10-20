package br.com.guiacistore.lojas.blueway

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.fragments.BlueWayMetodologiaFragment
import br.com.guiacistore.fragments.BlueWayMissaoFragment
import br.com.guiacistore.fragments.BlueWayQuemSomosFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class BlueWayFragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loja_blue_way)

        supportActionBar?.elevation = 0F
        supportActionBar?.title = "Blue Way Idiomas"

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("METODOLOGIA", BlueWayMetodologiaFragment::class.java)
                .add("QUEM SOMOS", BlueWayQuemSomosFragment::class.java)
                .add("MISSÃO", BlueWayMissaoFragment::class.java)
                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)
    }

}
