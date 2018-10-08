package br.com.guiacistore.lojas
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import br.com.guiacistore.R
import br.com.guiacistore.model.BlueWayAdapter
import br.com.guiacistore.model.Filme




class BlueWayIdiomasActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    private val listaFilmes = ArrayList<Filme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_way)

        recyclerView = findViewById(R.id.recyclerView)

        //Listagem de filmes
        this.criarFilmes()

        //Configurar adapter
        val adapter = BlueWayAdapter(listaFilmes)

        supportActionBar?.title = "Blue Way Idiomas"

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
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                            }

                            override fun onItemClick(view: View, position: Int) {
                                when (position) {
                                    0 ->  startActivity(Intent(this@BlueWayIdiomasActivity, SpeedNetActivity::class.java))

                                }
                            }

                            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {


                            }
                        }
                )
        )

    }

    fun criarFilmes() {

        var filme = Filme("Quem Somos", "Um pouco de nós para vocês", "2017")
        listaFilmes.add(filme)

        filme = Filme("Nossa missão", "Não importa o tamanho do seu sonho, nós te ajudamos à realizá-lo", "2017")
        listaFilmes.add(filme)

        filme = Filme("Liga da Justiça", "Ficção", "2017")
        listaFilmes.add(filme)

        filme = Filme("Capitão América - Guerra Civíl", "Aventura/Ficção", "2016")
        listaFilmes.add(filme)

        filme = Filme("It: A Coisa", "Drama/Terror", "2017")
        listaFilmes.add(filme)

        filme = Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017")
        listaFilmes.add(filme)

        filme = Filme("A Múmia", "Terror", "2017")
        listaFilmes.add(filme)

        filme = Filme("A Bela e a Fera", "Romance", "2017")
        listaFilmes.add(filme)

        filme = Filme("Meu malvado favorito 3", "Comédia", "2017")
        listaFilmes.add(filme)

        filme = Filme("Carros 3", "Comédia", "2017")
        listaFilmes.add(filme)

    }

}