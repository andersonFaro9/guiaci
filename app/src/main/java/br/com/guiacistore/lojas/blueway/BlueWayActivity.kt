package br.com.guiacistore.lojas.blueway
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

class BlueWayActivity : AppCompatActivity(), ICallNumber {


    override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.blue_way_activity)

            val listView = findViewById<ListView>(R.id.listView)

            val listaModel: ArrayList<ListaModel> = ArrayList()

            listaModel.add(ListaModel("Blue Way Idiomas", "", "", R.drawable.ic_a_blue_way))
            listaModel.add(ListaModel("Matrículas", "", "", R.drawable.ic_matricula_blue_way))
            listaModel.add(ListaModel("Nossos parceiros", "", "", R.drawable.ic_parceiros_blue_way))
            listaModel.add(ListaModel("Promoções", "", "", R.drawable.ic_promocao))
            listaModel.add(ListaModel("Contatos", "", "", R.drawable.ic_contatos_blue_way))
            listaModel.add(ListaModel("Redes Sociais", "", "", R.drawable.ic_redes_sociais_blue_way))

            listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

            supportActionBar?.title = "Blue Way Idiomas"

            listView.setOnItemClickListener { adapterView, view, position, l ->

                when (position) {
                    0 -> startActivity(Intent(this, BlueWayFragmentsActivity::class.java))
                    1 -> startActivity(Intent(this, BlueWayMatriculasActivity::class.java))
                    2 -> startActivity(Intent(this, BlueWayParceirosActivity::class.java))
                    3 -> startActivity(Intent(this, BlueWayPromocoesActivity::class.java))
                    4 -> startActivity(Intent(this, BlueWayContatosActivity::class.java))
                    5 -> startActivity(Intent(this, BlueWayRedesSociaisActivity::class.java))
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
                    verMapa(Uri.parse("https://goo.gl/maps/xveDad3JKWk"))
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

