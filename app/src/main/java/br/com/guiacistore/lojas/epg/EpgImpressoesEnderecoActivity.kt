package br.com.guiacistore.lojas.epg

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.epg_endereco_activity.*

class EpgImpressoesEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.epg_endereco_activity)

        supportActionBar?.title = "Epg Impressões"

        texto_endereco_epg.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/ksJywuYQX3y"))

        }


        ic_endereco_epg.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/ksJywuYQX3y"))
        }


    }


}
