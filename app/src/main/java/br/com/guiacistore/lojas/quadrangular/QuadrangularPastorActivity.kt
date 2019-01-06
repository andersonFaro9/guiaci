package br.com.guiacistore.lojas.quadrangular
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R

class QuadrangularPastorActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.quadrangular_pastor_activity)
        supportActionBar?.title = "Pastor Osvaldo Sousa"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F


    }


}



