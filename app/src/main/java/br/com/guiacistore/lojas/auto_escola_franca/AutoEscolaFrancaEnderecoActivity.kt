package br.com.guiacistore.lojas.auto_escola_franca

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.auto_escola_franca_endereco.*
import kotlinx.android.synthetic.main.evolution_endereco.*

class AutoEscolaFrancaEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.auto_escola_franca_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/Uu8gowkZp7S2"))

        }


        ic_endereco_auto_escola_franca.setOnClickListener {
            verMapa(Uri.parse("https://goo.gl/maps/Uu8gowkZp7S2"))
        }

    }






}
