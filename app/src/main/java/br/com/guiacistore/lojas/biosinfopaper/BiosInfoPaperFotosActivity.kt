package br.com.guiacistore.lojas.biosinfopaper

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.*
import br.com.guiacistore.R
import br.com.guiacistore.adapter.BiosInfoPaperAdapter
import br.com.guiacistore.adapter.ListaDoTerraNossosOleosAdapter
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.activity_recycleview.*

class BiosInfoPaperFotosActivity : AppCompatActivity(), ICallNumber {

    var list = ArrayList<ListaModel>()
    var adapter = BiosInfoPaperAdapter( this,list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycleview)

        supportActionBar?.title = "Fotos"

        supportActionBar?.elevation = 0F

        //mostrarServicos()
        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)

    }

    private fun  prepareList(list: ArrayList<ListaModel>) {

        list.add(ListaModel("Canetas Newpen e perfumadas", "Um universo de cores maravilhoso", 0, R.drawable.canetas) )
        list.add(ListaModel("Mouse Wireless, 2.4 GHZ", "Rápido e prático", 0, R.drawable.mouse) )

        list.add(ListaModel("Chaveiros em pelúcias em formato de animaizinhos", "Lindos e fofos", 0, R.drawable.chaveiros) )
        list.add(ListaModel("Borrachas Tris Jelly", "Lindas e marcantes", 0, R.drawable.borracha) )

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_main_loja_doterra, menu)
//        return true
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when  {
//
//            item.itemId == R.id.ic_telefone -> {
//                callNumber()
//                return true
//            }
//
//            item.itemId == R.id.ic_zap -> {
//                callZap()
//                return true
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99619-8678")
        startActivity(callIntent)
    }



}
