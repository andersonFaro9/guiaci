package br.com.guiacistore.lojas.publicart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber


class PublicartContatosActivity : AppCompatActivity(), ICallNumber {


    override fun callNumber() {

        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:75 9 99672401")
        startActivity(callIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_contatos)

        supportActionBar?.title = "Publicart"

    }

}