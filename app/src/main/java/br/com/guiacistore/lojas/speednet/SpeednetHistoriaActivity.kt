package br.com.guiacistore.lojas.speednet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class SpeednetHistoriaActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speednet_historia_activity)

        supportActionBar?.title = "História"
    }



}