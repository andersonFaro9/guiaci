package br.com.guiacistore.lojas.epg
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel


class EpgRedesSociaisActivity: AppCompatActivity(), ICallNumber {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epg_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("/epgimpressoes", "", "", R.drawable.ic_rede_social_facebook))
        listaModel.add(ListaModel("(71) 9.9636-3518", "", "", R.drawable.ic_rede_social_whatsapp))
        listaModel.add(ListaModel("/epgimpressoes", "", "", R.drawable.ic_rede_social_instagram))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
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
        callIntent.data = Uri.parse("tel:71 3645-1028")
        startActivity(callIntent)
    }
}