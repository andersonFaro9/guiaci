package br.com.guiacistore.lojas.greg

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.greg_endereco_activity.*

class GregBarbeariaEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.greg_endereco_activity)

        supportActionBar?.title = "Endereço"

        texto_primeiro_endereco_greg.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/KZVfbNN4UnN2"))

        }


        ic_endereco_quadrangular.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/KZVfbNN4UnN2"))
        }


    }






}
