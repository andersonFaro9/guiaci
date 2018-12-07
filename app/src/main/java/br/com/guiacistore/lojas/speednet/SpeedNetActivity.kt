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




class SpeedNetActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speednet_activity)

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Speednet Alliance", "", "", R.drawable.ic_historia_speednet))
        listaModel.add(ListaModel("Planos", "", "", R.drawable.ic_planos_speednet))
        listaModel.add(ListaModel("Promoções", "", "", R.drawable.ic_promocoes_speednet))
        listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_novidades_speednet))
        listaModel.add(ListaModel("Redes sociais", "", "", R.drawable.ic_redes_sociais_speednet))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

        supportActionBar?.title = "Speednet Alliance"

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when (position) {
                0 ->  startActivity(Intent(this, SpeednetHistoriaActivity::class.java))
                1 ->  startActivity(Intent(this, SpeednetPlanosActivity::class.java))
                2 ->  startActivity(Intent(this, SpeednetPromocoesActivity::class.java))
                4 ->  startActivity(Intent(this, SpeednetRedesSociaisActivity::class.java))

            }
        }
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
