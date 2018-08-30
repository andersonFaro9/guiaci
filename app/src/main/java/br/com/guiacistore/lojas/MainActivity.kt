package br.com.guiacistore.lojas

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaDeClientes
import br.com.guiacistore.model.ListaDeClientesAdapter
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var list = ArrayList<ListaDeClientes>()
    var adapter = ListaDeClientesAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareList(list)

        rView.adapter = adapter
        rView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)


    }


    private fun  prepareList(list: ArrayList<ListaDeClientes>) {

        list.add(ListaDeClientes("Speednet", "Aqui tem internet para família inteira, com os melhores planos.", R.drawable.loja_speednet))
        list.add(ListaDeClientes("Barbearia do Greg.", "Seu estilo passa primeiro por aqui.", R.drawable.loja_barbearia_greg))
        list.add(ListaDeClientes("Job Sat.", "Vendas, instalação e manutenção de antenas.", R.drawable.loja_job_sat))
        list.add(ListaDeClientes("Lili Doces & Cakes.", "Trabalhamos à pronta entrega, e sob encomenda.", R.drawable.loja_lili_doces_cakes))
        list.add(ListaDeClientes("Bios Informática e Papelaria", "Trazendo soluções para sua vida.", R.drawable.loja_bios_informatica))
        list.add(ListaDeClientes("RepSol Moto Center.", "Vendas e manutenção de peças para moto.", R.drawable.loja_repsol))
        list.add(ListaDeClientes("Academia Evolution Fitness de Pojuca.", "Sua evolução começa agora!!.", R.drawable.loja_evolution))
        list.add(ListaDeClientes("Igreja do Ev. Quadrangular de Pojuca.", "Vivendo em Cristo.", R.drawable.loja_quadrangular))

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

                //N esquecer de atualizar esse link para que os celulares com versão 05 funcionem corretamente!
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=br.com.guiacistore")
                startActivity(Intent.createChooser(intent, "Compartilhe nosso app" ))

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