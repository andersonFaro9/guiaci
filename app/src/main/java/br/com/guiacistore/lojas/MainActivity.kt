package br.com.guiacistore.lojas

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.GuiaCity
import br.com.guiacistore.GuiaCityAdapter
import br.com.guiacistore.R
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var list = ArrayList<GuiaCity>()
    var adapter = GuiaCityAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareList(list)


        rView.adapter = adapter


        rView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)



    }



    private fun prepareList(list: ArrayList<GuiaCity>) {

        list.add(GuiaCity("The Best Chocolate", "Delicia de Chocolate", R.drawable.loja_chocolate))
        list.add(GuiaCity("Padaria Pão RR", "O melhor Pão da Cidade", R.drawable.loja_padaria))
        list.add(GuiaCity("Locadora de Carros BR", "Escolha o melhor", R.drawable.loja_carros))
        list.add(GuiaCity("Farmácia do Povo", "Aqui você encontra tudo", R.drawable.farmacia))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.search)

        val searchView = menu.findItem(R.id.search).actionView as? SearchView

        searchView?.setOnQueryTextListener(this)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menu_share -> {

                val intent = Intent(android.content.Intent.ACTION_SEND)
                intent.type = "text/plain"


                intent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=br.com.guiacistore")
                startActivity(Intent.createChooser(intent, "Compartilhe" ))

                return true
            }

            R.id.telefone -> {

                val intent = Intent(this@MainActivity, SobreActivity::class.java)

                startActivity(intent)
                return true
            }


        }


        return super.onOptionsItemSelected(item)
    }


    override fun onQueryTextSubmit(query: String): Boolean {

        val tag = "Script"
        Log.i(tag, "onQueryTextSubmit $query")

        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {

        Log.i("Script", "onQueryTextChange $newText")

        adapter.filter.filter(newText)
        return true
    }


}