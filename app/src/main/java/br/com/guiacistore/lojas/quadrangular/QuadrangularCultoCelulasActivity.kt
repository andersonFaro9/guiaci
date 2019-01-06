package br.com.guiacistore.lojas.quadrangular
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class QuadrangularCultoCelulasActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.quadrangular_cultos_celulas_activity)


        supportActionBar?.title = "Cultos e células"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F


    }


}



