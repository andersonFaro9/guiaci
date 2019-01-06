package br.com.guiacistore.lojas.evolution

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.evolution.extensions.mostrarServicos


class EvolutionServicosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Serviços"

        setContentView(R.layout.evolution_servicos_activity)

        mostrarServicos()

    }


}
