package br.com.guiacistore.lojas.publicart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber


class PublicartContatosActivity : AppCompatActivity(), ICallNumber {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_publicart, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }
            R.id.ic_mapa -> {
                verMapa(Uri.parse("https://goo.gl/maps/kByyFXc2kQA2"))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

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