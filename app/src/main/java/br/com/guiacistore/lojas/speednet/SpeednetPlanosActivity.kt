package br.com.guiacistore.lojas.speednet

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




class SpeednetPlanosActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Speednet Alliance"

        setContentView(R.layout.speednet_activity)

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("5 megas por R$60,00 reais", "Para quem envia mensagens!", "", R.drawable.ic_5_megas_speednet))
        listaModel.add(ListaModel("7 megas por R$80,00 reais", "Para redes sociais!", "", R.drawable.ic_7_megas_speednet))
        listaModel.add(ListaModel("10 megas por R$100,00 reais", "Para amantes de filmes!", "", R.drawable.ic_10_megas_speednet))
        listaModel.add(ListaModel("15 megas por R$125,00 reais", "Para navegar, assistir e jogar!", "", R.drawable.ic_15_megas_speednet))
        listaModel.add(ListaModel("20 megas por R$80,00 reais", "Para assistir, navegar e fazer downloads!", "", R.drawable.ic_20_megas_speednet))
        listaModel.add(ListaModel("Link dedicado", "Para empresas que necessitam de internet 24 horas com alta performance e confiabilidade!.", "", R.drawable.ic_link_dedicado_speednet))

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
                verMapa(Uri.parse("https://bit.ly/2QBoTVg"))
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
