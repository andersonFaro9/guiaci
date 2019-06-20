package br.com.guiacistore.lojas.biostelecom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class BiosTelecomHistoriaActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biostelecom_historia_activity)

        supportActionBar?.title = "História"
    }



}