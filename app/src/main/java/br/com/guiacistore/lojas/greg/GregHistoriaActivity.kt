package br.com.guiacistore.lojas.greg

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class GregHistoriaActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.greg_historia_activity)

        supportActionBar?.title = "História"
    }



}