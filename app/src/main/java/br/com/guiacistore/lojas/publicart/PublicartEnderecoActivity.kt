package br.com.guiacistore.lojas.publicart

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.publicart_endereco_activity.*

class PublicartEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.publicart_endereco_activity)

        supportActionBar?.title = "Endereço"

        texto_endereco_publicart.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/j2JkKEmWY4Q2"))

        }


        ic_endereco_publicart.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/j2JkKEmWY4Q2"))
        }


    }
}