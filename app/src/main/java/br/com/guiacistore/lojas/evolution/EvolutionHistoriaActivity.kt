package br.com.guiacistore.lojas.evolution

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class EvolutionHistoriaAcvity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.evolution_historia_activity)

        supportActionBar?.title = "História"
    }



}