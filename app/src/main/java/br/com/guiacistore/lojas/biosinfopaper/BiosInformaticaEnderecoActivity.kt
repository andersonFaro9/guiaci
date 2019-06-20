package br.com.guiacistore.lojas.biosinfopaper

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.bios_endereco.*

class BiosInformaticaEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.bios_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco_bios.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/SubZSekGi4t"))

        }


        ic_endereco_bios.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/SubZSekGi4t"))
        }

    }






}
