package br.com.guiacistore.lojas.jsbarbearia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.js_barbearia_servicos_activity.*


class JsBarbeariaServicosActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Serviços"

        setContentView(R.layout.js_barbearia_servicos_activity)

        //val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Cortes", "", "", R.drawable.ic_cortes_jsbarbearia))

        listaModel.add(ListaModel("", "Corte social por R$ 15,00 reais!", "", R.drawable.ic_corte_social_jsbarbearia))
        listaModel.add(ListaModel("", " Corte degradê por R$ 17,00 reais!!", "",R.drawable.ic_corte_degrade_jsbarbearia))
        listaModel.add(ListaModel("", " Corte tesoura por R$ 18,00 reais", "", R.drawable.ic_tesoura_jsbarbearia))
        listaModel.add(ListaModel("", " Barba simples por R$ 5,00 reais!!", "", R.drawable.ic_barba_simples_jsbarbearia))
        listaModel.add(ListaModel("", " Barba desenhada por R$ 7,00 reais!", "",R.drawable.ic_barba_desenhada_jsbarbearia))



        listaModel.add(ListaModel("Combos", "", "", R.drawable.ic_combo_jsbarbearia) )

        listaModel.add(ListaModel("", " Corte social + barba R$ 18,00 reais.", "", R.drawable.ic_corte_social_jsbarbearia))
        listaModel.add(ListaModel("", " Corte degradê + barba por R$ 20,00 reais.", "", R.drawable.ic_corte_degrade_jsbarbearia))
        listaModel.add(ListaModel("", " Corte tesoura + barba por R$ 20,00 reais.", "", R.drawable.ic_tesoura_jsbarbearia))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_jsbarbearia, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }


    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99628-2113")
        startActivity(callIntent)
    }
}
