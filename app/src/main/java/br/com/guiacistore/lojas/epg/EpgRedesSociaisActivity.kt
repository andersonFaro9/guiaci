package br.com.guiacistore.lojas.epg
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.epg.CustomListaSimplesEpgAdapter
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.ListaCustomizadaModel


class EpgRedesSociaisActivity: AppCompatActivity(), ICallNumber {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epg_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        val listView = findViewById<ListView>(R.id.listView)

        val listaCustomizadaModel: ArrayList<ListaCustomizadaModel> = ArrayList()

        listaCustomizadaModel.add(ListaCustomizadaModel("/epgimpressoes", R.drawable.ic_facebook_epg))
        listaCustomizadaModel.add(ListaCustomizadaModel("(71) 9.9636-3518", R.drawable.ic_whatsapp_epg))
        listaCustomizadaModel.add(ListaCustomizadaModel("/epgimpressoes", R.drawable.ic_instagram_epg))

        listView.adapter = CustomListaSimplesEpgAdapter(applicationContext, listaCustomizadaModel)

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