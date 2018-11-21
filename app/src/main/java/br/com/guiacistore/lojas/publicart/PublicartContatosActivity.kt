package br.com.guiacistore.lojas.publicart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R


class PublicartContatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_contatos)

        supportActionBar?.title = "Publicart"

    }

}