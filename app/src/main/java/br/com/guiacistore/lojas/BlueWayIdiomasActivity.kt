package br.com.guiacistore.lojas
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
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
import br.com.guiacistore.blueway.*
import br.com.guiacistore.interfaces.ICheckPermission
import br.com.guiacistore.model.BlueWayIdiomasAdapter
import br.com.guiacistore.model.Filme


class BlueWayIdiomasActivity : AppCompatActivity(), ICheckPermission {

    private var recyclerView: RecyclerView? = null

    private val listaFilmes = ArrayList<Filme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_way)

        recyclerView = findViewById(R.id.recyclerView)

        //Listagem de filmes
        this.criarFilmes()

        //Configurar adapter
        val adapter = BlueWayIdiomasAdapter(listaFilmes)

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
                            override fun onLongItemClick(view: View?, position: Int) {  }


                            override fun onItemClick(view: View, position: Int) {
                                when (position) {
                                    0 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasQuemSomosActivity::class.java))
                                    1 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasPrecosActivity::class.java))
                                    2 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasMetodologiaActivity::class.java))
                                    3 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasRedesSociaisActivity::class.java))
                                    4 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasContatosActivity::class.java))
                                    5 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasParceirosActivity::class.java))
                                    6 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasPromocoesActivity::class.java))
                                    7 ->  startActivity(Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasNossaMissaoActivity::class.java))

                                }
                            }

                            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) { }
                        }
                )
        )

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_blue_way, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_phone -> {

                checkPermissionForCallPhone()
                return true
            }

            R.id.ic_preco_blue_way -> {

                mostrarPrecoDosCursos()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun mostrarPrecoDosCursos() {
        val intent = Intent(this@BlueWayIdiomasActivity, BlueWayIdiomasPrecosActivity::class.java)

        startActivity (intent)
    }

    fun criarFilmes() {

        var filme = Filme("Quem somos", "", "")
        listaFilmes.add(filme)

        filme = Filme("Matrícula", "", "")
        listaFilmes.add(filme)

        filme = Filme("Metodologia", "", "")
        listaFilmes.add(filme)

        filme = Filme("Nossas redes sociais", "", "")
        listaFilmes.add(filme)


        filme = Filme("Contatos", "", "")
        listaFilmes.add(filme)

        filme = Filme("Parceiros", "", "")
        listaFilmes.add(filme)


        filme = Filme("Promoções", "", "")
        listaFilmes.add(filme)

        filme = Filme("Nossa missão", "", "")
        listaFilmes.add(filme)


    }


    override fun checkPermissionForCallPhone() {
        when {
            ContextCompat.checkSelfPermission(BlueWayIdiomasActivity@ this,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED -> if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CALL_PHONE)) {

            } else {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 42)
            }
            else -> callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when { requestCode == 42 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> callPhone() }

    }

    @SuppressLint("MissingPermission")
    fun callPhone(){

        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:996287958")
        startActivity(callIntent)
    }


}