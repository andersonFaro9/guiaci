package br.com.guiacistore.lojas.publicart
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


class PubliCartActivity : AppCompatActivity(),  ICallNumber{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_activity)

        val listView = findViewById<ListView>(R.id.listView)
        val listaModel: ArrayList<ListaModel> = ArrayList()


        listaModel.add(ListaModel("A Publicart", "", "", R.drawable.ic_a_publi_cart))
        listaModel.add(ListaModel("Nossos serviços", "", "", R.drawable.ic_a_publi_cart_servicos))
        listaModel.add(ListaModel("Contatos e redes sociais", "", "", R.drawable.ic_phone_publicart_menu))
        listaModel.add(ListaModel("Nossos parceiros", "", "", R.drawable.ic_a_publi_cart_parceiros))
        listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_a_publi_cart_novidades))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

        supportActionBar?.title = "Publicart"

        listView.setOnItemClickListener {

            adapterView, view, position, l -> when (position) {

                0 ->  startActivity(Intent(this, PubliCartFragmentsActivity::class.java))
                1 ->  startActivity(Intent(this, PubliCartServicosActivity::class.java))
                2 ->  startActivity(Intent(this, PublicartContatosActivity::class.java))
                3 ->  startActivity(Intent(this, PublicartParceirosActivity::class.java))
                4 ->  startActivity(Intent(this, PubliCartNovidadesActivity::class.java))

            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_publicart, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_phone -> {

                callNumber()
                return true
            }

            R.id.ic_mapa_publi_cart -> {

                verMapa(Uri.parse("https://goo.gl/maps/Cu1JkvVYymk"))

                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {

        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:75999672401")
        startActivity(callIntent)
    }


}



