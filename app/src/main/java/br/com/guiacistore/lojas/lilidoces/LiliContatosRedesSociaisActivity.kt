package br.com.guiacistore.lojas.lilidoces

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.lilidoces.extensions.mostrarRedesSociais

class LiliContatosRedesSociaisActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lili_redesocial)

        supportActionBar?.title = "Redes sociais"

        mostrarRedesSociais()



    }
}