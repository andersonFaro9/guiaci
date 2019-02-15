package br.com.guiacistore.lojas.dinei_barber

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.auto_escola_franca_endereco.*
import kotlinx.android.synthetic.main.evolution_endereco.*

class DineiBarberEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.dinei_barber_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco.setOnClickListener {

            verMapa(Uri.parse("https://goo.gl/maps/YYv69YJYf2n"))

        }


        ic_endereco_auto_escola_franca.setOnClickListener {
            verMapa(Uri.parse("https://goo.gl/maps/YYv69YJYf2n"))
        }

    }






}
