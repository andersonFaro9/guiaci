package br.com.guiacistore.blueway

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class BlueWayIdiomasQuemSomosActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_way_quem_somos)
        supportActionBar?.title = "Quem somos Blue Way"
    }

}