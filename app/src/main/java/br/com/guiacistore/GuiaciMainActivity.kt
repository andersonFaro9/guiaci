package br.com.guiacistore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.adapter.ListaDasLojasAdapter
import br.com.guiacistore.model.ListaDasLojasModel
import kotlinx.android.synthetic.main.activity_recycleview.*

open class GuiaciMainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var list = ArrayList<ListaDasLojasModel>()
    var adapter = ListaDasLojasAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        prepareList(list)


//        var mToolbar = findViewById<Toolbar>(R.id.mCustomToolbar)
//        setSupportActionBar(mToolbar)


        //supportActionBar?.setIcon(R.drawable.guiaci);

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

    }



    private fun  prepareList(list: ArrayList<ListaDasLojasModel>) {

        list.add(ListaDasLojasModel("Speednet", "Aqui tem internet para família inteira, com os melhores planos.", R.drawable.loja_speednet))
        list.add(ListaDasLojasModel("Barbearia do Greg.", "Seu estilo passa primeiro por aqui.", R.drawable.loja_barbearia_greg))
        list.add(ListaDasLojasModel("Job Sat.", "Vendas, instalação e manutenção de antenas.", R.drawable.loja_job_sat))
        list.add(ListaDasLojasModel("Lili Doces & Cakes.", "Trabalhamos à pronta entrega e sob encomenda.", R.drawable.loja_lili_doces_cakes))
        list.add(ListaDasLojasModel("Bios Informática e Papelaria", "Trazendo soluções para sua vida.", R.drawable.loja_bios_informatica))
        list.add(ListaDasLojasModel("Publicart.", "Soluções em comunicação visual, conteúdo e entretenimento .", R.drawable.loja_publicart))
        list.add(ListaDasLojasModel("Academia Evolution Fitness de Pojuca.", "Sua evolução começa agora!!.", R.drawable.loja_evolution))
        list.add(ListaDasLojasModel("Igreja do Ev. Quadrangular de Pojuca.", "Vivendo em Cristo.", R.drawable.loja_quadrangular))
        list.add(ListaDasLojasModel("Blue Way Idiomas", "Faça a diferença, faça Blue Way!.", R.drawable.loja_blueway))
        list.add(ListaDasLojasModel("E Sound, sonorização.", "Casamento, aniversário e festa particular.", R.drawable.loja_esound))
        list.add(ListaDasLojasModel("Igreja Batista Nacional Rosa de Saron.", " Graça e paz.", R.drawable.loja_rosa_saron))
        list.add(ListaDasLojasModel("EPG Impressões.", " Impressão em camisas, canecas, cartões de visita e muito mais.", R.drawable.loja_epg))
        list.add(ListaDasLojasModel("Inove.", "Fabricação, Montagem e Manutenção industrial.", R.drawable.loja_inove))


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
                startActivity(Intent.createChooser(intent, "Compartilhe nosso app" ))

                return true
            }

            R.id.telefone -> {

                val intent = Intent(this@GuiaciMainActivity, SobreActivity::class.java)

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