package br.com.guiacistore.lojas.doterra

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaDoTerraKitAdapter
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.activity_recycleview.*


class DoTerraKitActivity : AppCompatActivity(), ICallNumber {

    var list = ArrayList<ListaModel>()
    var adapter = ListaDoTerraKitAdapter( this,list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycleview)

        supportActionBar?.title = "Kit's e Acessórios"

        supportActionBar?.elevation = 0F


        //mostrarServicos()
        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
    }

    private fun  prepareList(list: ArrayList<ListaModel>) {
        list.add(ListaModel("Kit Essencial para o Lar", "Lavanda, Limão Siciliano e muito outros estão aqui.", 0, R.drawable.kit_lar) )
        list.add(ListaModel("Óleo de Coco Fracionado", "Essencial para peles secas", 0, R.drawable.kit_oleo_coco) )
        list.add(ListaModel("Kit Soluções Naturais", "Um kit para manter uma vida saudável", 0, R.drawable.kit_solucoes_naturais) )
        list.add(ListaModel("Kit Bamboo Box", "Uma obra de arte exposta em uma moldura que comporta 8 frascos de 15 ml e 10 frascos de 5 ml/10 ml, com capacidade para armazenar 53 Óleos Essenciais.", 0, R.drawable.kit_bambu) )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_doterra, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_zap -> {
                callZap()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99619-8678")
        startActivity(callIntent)
    }

     fun callZap() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99169-7422")
        startActivity(callIntent)
    }

}
