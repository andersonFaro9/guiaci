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


class GregActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.greg_activity)

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Barbearia do Greg", "", "", R.drawable.ic_historia_greg))
        listaModel.add(ListaModel("Cortes e valores", "", "", R.drawable.ic_cortes_greg))
        listaModel.add(ListaModel("Seu cartão fidelidade", "", "", R.drawable.ic_cartao_greg))
        listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_novidade_greg))
        listaModel.add(ListaModel("Promoções", "", "", R.drawable.ic_promocao_greg))
        listaModel.add(ListaModel("Contatos e Redes sociais", "Participe de nossas redes sociais!", "", R.drawable.ic_redes_sociais_greg))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

        supportActionBar?.title = "Barbearia do Greg"

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when (position) {
                0 ->  startActivity(Intent(this, GregHistoriaActivity::class.java))
                1 ->  startActivity(Intent(this, GregCortesValoresActivity::class.java))
                2 ->  startActivity(Intent(this, GregCartaoFidelidadeActivity::class.java))
                3 ->  startActivity(Intent(this, GregNovidadeActivity::class.java))
                4 ->  startActivity(Intent(this, GregPromocoesActivity::class.java))
                5 ->  startActivity(Intent(this, GregRedesSociaisActivity::class.java))

            }
        }
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
