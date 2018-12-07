package br.com.guiacistore.lojas.epg
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ServicosAdapter
import br.com.guiacistore.composicao.Servicos
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.blueway.RecyclerItemClickListener


class EpgServicosActivity : AppCompatActivity(), ICallNumber {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        recyclerView = findViewById(R.id.recView)

        val servicosOferecidos = Servicos()

        servicosOferecidos.exibirServicosDaEpg()

        val adapter = ServicosAdapter(servicosOferecidos.lista)

        supportActionBar?.title = "Serviços"

        confiraListaRecycleView(adapter)

    }

    private fun confiraListaRecycleView(adapter: ServicosAdapter) {

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView?.adapter = adapter


        recyclerView?.addOnItemTouchListener(
                RecyclerItemClickListener(
                        applicationContext, recyclerView!!, object : RecyclerItemClickListener.OnItemClickListener {

                    override fun onLongItemClick(view: View?, position: Int) {

                    }

                    override fun onItemClick(view: View, position: Int) {
                        when {
                            /*Aqui vc pode direcionar todas as activitys com os clicks*/
                        }
                    }

                    override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {

                    }
                }
                )
        )
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
                verMapa(Uri.parse("https://goo.gl/maps/kByyFXc2kQA2"))
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