package br.com.guiacistore.lojas.biosinfopaper
import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.support.v7.app.AppCompatActivity

import android.view.Menu
import android.view.MenuItem

import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.interfaces.ICallNumber

import br.com.guiacistore.lojas.biosinfopaper.extensions.mostrarServicosOferecidos

import kotlinx.android.synthetic.main.bios_activity.*


class BiosInfoPaperActivity : AppCompatActivity(), ICallNumber{

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.bios_activity)

        supportActionBar?.title = "Bios InfoPaper"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, BiosInfoPaperServicosActivity::class.java))
                position == 1 ->  startActivity(Intent(this, BiosInfoPaperPromocoesActivity::class.java))
                position == 2 ->  startActivity(Intent(this, BiosInfoPaperFotosActivity::class.java))
                position == 3 ->  startActivity(Intent(this, BiosInfoPaperRedesSociaisActivity::class.java))

            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_bios, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_tel -> {

                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, BiosInformaticaEnderecoActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 3645-5134")
        startActivity(callIntent)
    }



}