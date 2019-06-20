package br.com.guiacistore.lojas.biostelecom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biostelecom.extensions.mostraPlanos


class BiosTelecomPlanosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Planos"

        setContentView(R.layout.biostelecom_activity)

        mostraPlanos()

    }


}
