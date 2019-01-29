package br.com.guiacistore.lojas.auto_escola_franca

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class AutoEscolaFrancaHistoriaActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auto_escola_franca_historia_activity)

        supportActionBar?.title = "História"
    }



}