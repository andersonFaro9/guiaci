package br.com.guiacistore.lojas.blueway
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.blueway.extensions.mostraServicosOferecidos
import kotlinx.android.synthetic.main.blue_way_activity.*

class BlueWayActivity : AppCompatActivity(), ICallNumber {


    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.blue_way_activity)

            supportActionBar?.title = "Blue Way Idiomas"

            mostraServicosOferecidos()

            listView.setOnItemClickListener { adapterView, view, position, l ->

                when {

                  position ==  0 -> startActivity(Intent(this, BlueWayFragmentsActivity::class.java))
                  position ==  1 -> startActivity(Intent(this, BlueWayMatriculasActivity::class.java))
                  position ==  2 -> startActivity(Intent(this, BlueWayParceirosActivity::class.java))
                  position ==  3 -> startActivity(Intent(this, BlueWayPromocoesActivity::class.java))
                  position ==  4 -> startActivity(Intent(this, BlueWayContatosActivity::class.java))
                  position ==  5 -> startActivity(Intent(this, BlueWayRedesSociaisActivity::class.java))
                }
            }
        }


        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu_main_blue_way, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.ic_phone -> {
                    callNumber()
                    return true
                }
                R.id.ic_mapa_blue_way -> {
                    startActivity(Intent(this, BlueWayEnderecoActivity::class.java))
                    return true
                }
            }
            return super.onOptionsItemSelected(item)
        }



        override fun callNumber() {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:71 9627-1187")
            startActivity(callIntent)
        }

}

