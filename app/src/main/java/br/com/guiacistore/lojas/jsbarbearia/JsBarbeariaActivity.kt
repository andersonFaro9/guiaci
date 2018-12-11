package br.com.guiacistore.lojas.jsbarbearia
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.R.id.listView
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.js_barbearia_activity.*


class JsBarbeariaActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.js_barbearia_activity)

        //val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("JS Barbearia à Domicílio", "", "", R.drawable.ic_historia_jsbarbearia))
        listaModel.add(ListaModel("Serviços", " Atendimento especial para idosos e pessoas com mobilidade física reduzida!.", "", R.drawable.ic_servicos_jsbarbearia))
        listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_novidades_jsbarbearia))
        listaModel.add(ListaModel("Promoções", "Belas promoções", "", R.drawable.ic_promocoes_jsbarbearia))
        listaModel.add(ListaModel("Contatos e Redes sociais", "Participe de nossas redes sociais!", "", R.drawable.ic_rede_sociais_jsbarbearia))


        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

        supportActionBar?.title = "JS Barbearia à Domicílio"

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when (position) {
                0 ->  startActivity(Intent(this, JsBarbeariaHistoriaActivity::class.java))
                1 ->  startActivity(Intent(this, JsBarbeariaServicosActivity::class.java))
                2 ->  startActivity(Intent(this, JsBarbeariaNovidadeActivity::class.java))
                3 ->  startActivity(Intent(this, JsBarbeariaPromocoesActivity::class.java))
                4 ->  startActivity(Intent(this, JsBarbeariaRedesSociaisActivity::class.java))

            }
        }
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
        callIntent.data = Uri.parse( "tel: 71 9628-2113")
        startActivity(callIntent)
    }
}
