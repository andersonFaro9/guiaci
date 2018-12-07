package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ParceirosAdapter
import br.com.guiacistore.composicao.Servicos
import br.com.guiacistore.lojas.blueway.RecyclerItemClickListener


class PublicartParceirosActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        recyclerView = findViewById(R.id.recView)

        val parceirosPubliCart = Servicos()

        parceirosPubliCart.exibirParceirosDaPubliCart()

        val adapter = ParceirosAdapter(parceirosPubliCart.lista)

        supportActionBar?.title = "Publicart"

        confiraListaRecycleView(adapter)

    }

    private fun confiraListaRecycleView(adapter: ParceirosAdapter) {

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

}