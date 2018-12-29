package br.com.guiacistore.lojas.blueway

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.blue_way_endereco_activity.*

class BlueWayEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.blue_way_endereco_activity)

        supportActionBar?.title = "Endereço"

        texto_endereco_Blue_way.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/PgC4Q9hufpk"))

        }


        ic_endereco_Blue_way.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/PgC4Q9hufpk"))
        }


    }

}
