package br.com.guiacistore.lojas.auto_escola_franca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.auto_escola_franca.extensions.mostrarServicos

class AutoEscolaFrancaServicosActivity  : AppCompatActivity(), ICallNumber{

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.auto_escola_franca_servicos_activity)

        supportActionBar?.title = "Serviços"

        mostrarServicos()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_auto_escola_franca, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, AutoEscolaFrancaEnderecoActivity::class.java))
                return true
            }

            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 9981-9741")
        startActivity(callIntent)
    }

}
