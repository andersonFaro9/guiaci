package br.com.guiacistore.lojas.publicart
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.publicart.extensions.mostraServicosOferecidos
import kotlinx.android.synthetic.main.publicart_activity.*


class PubliCartActivity : AppCompatActivity(),  ICallNumber{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_activity)

        supportActionBar?.title = "Publicart"
        mostraServicosOferecidos()

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

                startActivity(Intent(this, PublicartEnderecoActivity::class.java))

                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {

        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:75 9 99672401")
        startActivity(callIntent)
    }


}



