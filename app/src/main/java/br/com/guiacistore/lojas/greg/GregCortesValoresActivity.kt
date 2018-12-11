package br.com.guiacistore.lojas.greg

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




class GregCortesValoresActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Cortes e valores"

        setContentView(R.layout.greg_activity)

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Degradê e Navalhado", "Por R$ 18,00 reais!", "", R.drawable.ic_navalhado_greg))
        listaModel.add(ListaModel("Corte Tesoura", "Por R$ 20,00 reais!!", "", R.drawable.ic_tesoura_greg))
        listaModel.add(ListaModel("Corte Social e Militar", "Por R$ 13,00 reais", "", R.drawable.ic_corte_militar_greg))
        listaModel.add(ListaModel("Corte de Máquina 1", "Por R$ 10,00 reais!!", "", R.drawable.ic_maquina_greg))
        listaModel.add(ListaModel("Barba", "Por R$ 8,00 reais!", "", R.drawable.ic_barba_greg))
        listaModel.add(ListaModel("Sobrancelhas", "Por R$ 6,00 reais.", "", R.drawable.ic_sobrancelha_greg))
        listaModel.add(ListaModel("Pezinho de Cabelo", "Por R$ 5,00 reais.", "", R.drawable.ic_pezinho_cabelo_greg))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)



    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_greg, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }
            R.id.ic_mapa -> {
                verMapa(Uri.parse("https://her.is/2G4so27"))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99648-1470")
        startActivity(callIntent)
    }
}
