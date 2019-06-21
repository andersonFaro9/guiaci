package br.com.guiacistore.lojas.evolution

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.evolution_endereco.*

class EvolutionEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.evolution_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco_multivix.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/BZkXTkab9WQ2"))

        }


        texto_segundo_endereco_evolution.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/1oH4C4mwoi42"))
        }

        ic_endereco_multivix.setOnClickListener {
            verMapa(Uri.parse("https://goo.gl/maps/BZkXTkab9WQ2"))
        }


        ic_endereco_evolution2.setOnClickListener {
            verMapa(Uri.parse("https://goo.gl/maps/1oH4C4mwoi42"))
        }


    }






}
