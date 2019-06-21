package br.com.guiacistore.lojas.multivixPojuca
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.lojas.biostelecom.BiosTelecomHistoriaActivity
import br.com.guiacistore.lojas.biostelecom.BiosTelecomPromocoesActivity
import br.com.guiacistore.lojas.biostelecom.BiosTelecomRedesSociaisActivity
import br.com.guiacistore.lojas.multivixPojuca.extensions.mostrarServicosOferecidos
import kotlinx.android.synthetic.main.multivix_activity.*
import android.view.MenuInflater

import android.support.v7.widget.PopupMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.biosinfopaper.BiosInformaticaEnderecoActivity


class MultivixPojucaActivity : AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.multivix_activity)

        supportActionBar?.title = "Multivix - Polo Pojuca"

        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when  {
                //position == 0 -> exibirMensagem("Telefone sempre disponível")
                position == 1 -> startActivity(Intent(this, MultivixPojucaCursosActivity::class.java))
                //position == 2 -> exibirMensagem("Promoção relampago")
                position == 3 -> startActivity(Intent(this, MultivixPojucaInscricaoActivity::class.java))
                position == 4 -> startActivity(Intent(this, MultivixEnderecoActivity::class.java))
            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_multivix, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_tel -> {

                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, MultivixEnderecoActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99613-8781")
        startActivity(callIntent)
    }


}