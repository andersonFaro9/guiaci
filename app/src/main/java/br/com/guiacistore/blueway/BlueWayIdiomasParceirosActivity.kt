package br.com.guiacistore.blueway
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import br.com.guiacistore.R
import br.com.guiacistore.lojas.RecyclerItemClickListener
import br.com.guiacistore.model.BlueWayIdiomasParceirosAdapter
import br.com.guiacistore.model.Filme


class BlueWayIdiomasParceirosActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    private val listaFilmes = ArrayList<Filme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_way)

        recyclerView = findViewById(R.id.recyclerView)


        this.criarFilmes()

        //Configurar adapter
        val adapter = BlueWayIdiomasParceirosAdapter(listaFilmes)

        supportActionBar?.title = "Parceiros Blue Way"

        //Configurar Recyclerview
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView?.adapter = adapter

        //evento de click
        recyclerView?.addOnItemTouchListener(
                RecyclerItemClickListener(
                        applicationContext,
                        recyclerView!!,
                        object : RecyclerItemClickListener.OnItemClickListener {
                            override fun onLongItemClick(view: View?, position: Int) {
                                TODO("not implemented")
                            }

                            override fun onItemClick(view: View, position: Int) {
                                when (position) {
                                }
                            }

                            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {}
                        }
                )
        )

    }

    fun criarFilmes() {

        // Lista dos parceiros em Pojuca

        var filme = Filme("Unidade de Pojuca", "Tel: 99628-7958", "")
        listaFilmes.add(filme)
        filme = Filme("", "Academia Evolution", "")
        listaFilmes.add(filme)

        filme = Filme("", "Escola Surpreza", "")
        listaFilmes.add(filme)

        filme = Filme("", "Colégio 29 de Julho", "")
        listaFilmes.add(filme)

        filme = Filme("", "Escola Betel", "")
        listaFilmes.add(filme)


//        Lista dos parceiros em Catu
         filme = Filme("Unidade de Catu", "Tel: 99694-6672", "")
        listaFilmes.add(filme)
        filme = Filme("", "Halliburton", "")
        listaFilmes.add(filme)
        filme = Filme("", "Escola Ágappe", "")
        listaFilmes.add(filme)
        filme = Filme("", "Escola Traços e Letras", "")
        listaFilmes.add(filme)

        filme = Filme("", "Escola da Tia Lia", "")
        listaFilmes.add(filme)
        filme = Filme("", "Escola da Tia Margô", "")
        listaFilmes.add(filme)

        filme = Filme("", "Colégio Athena", "")
        listaFilmes.add(filme)
                filme = Filme("", "Filhote de Ogro", "")
        listaFilmes.add(filme)







    }

}