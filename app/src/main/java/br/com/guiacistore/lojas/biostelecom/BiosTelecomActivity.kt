package br.com.guiacistore.lojas.biostelecom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.biostelecom.extensions.mostraServicosOferecidos
import kotlinx.android.synthetic.main.biostelecom_activity.*


class BiosTelecomActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biostelecom_activity)

        supportActionBar?.title = "Bios Telecom"

        mostraServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when  {
                position == 0 ->  startActivity(Intent(this, BiosTelecomHistoriaActivity::class.java))
                position == 1 -> exibirMensagem("Em breve")
                position == 2 ->  startActivity(Intent(this, BiosTelecomPromocoesActivity::class.java))
                position == 3 ->  startActivity(Intent(this, BiosTelecomRedesSociaisActivity::class.java))

            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_biostelecom, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {
            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {

                startActivity(Intent(this, BiosTelecomEnderecoActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:  40628811")
        startActivity(callIntent)
    }
}
