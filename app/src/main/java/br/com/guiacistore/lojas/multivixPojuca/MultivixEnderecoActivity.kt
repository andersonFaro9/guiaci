package br.com.guiacistore.lojas.multivixPojuca

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import kotlinx.android.synthetic.main.evolution_endereco.*

class MultivixEnderecoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.multivix_endereco)

        supportActionBar?.title = "Endereço"

        texto_endereco_multivix.setOnClickListener {

            verMapa(Uri.parse("https://bit.ly/2FpyZBy"))

        }

        ic_endereco_multivix.setOnClickListener {
            verMapa(Uri.parse("https://bit.ly/2FpyZBy"))
        }



    }






}
