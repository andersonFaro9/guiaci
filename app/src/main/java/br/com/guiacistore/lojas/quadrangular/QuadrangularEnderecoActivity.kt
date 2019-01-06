package br.com.guiacistore.lojas.quadrangular

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.evolution_endereco.*

class QuadrangularEnderecoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.quadrangular_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco_quadrangular.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/znp61dgUXcx"))

        }


        ic_endereco_quadrangular.setOnClickListener {
            verMapa(Uri.parse("https://goo.gl/maps/znp61dgUXcx"))
        }



    }






}
