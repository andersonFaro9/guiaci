package br.com.guiacistore.lojas.speednet

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.speednet_endereco_activity.*

class SpeedNetEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.speednet_endereco_activity)

        supportActionBar?.title = "Speednet Alliance"

        texto_endereco_speednet.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/AvwfVueiPm32"))

        }


        ic_endereco_speednet.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/AvwfVueiPm32"))
        }


    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
        return true
    }

}
