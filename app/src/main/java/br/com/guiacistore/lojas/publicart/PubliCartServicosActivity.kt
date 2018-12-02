package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import br.com.guiacistore.R
import br.com.guiacistore.adapter.publicart.ListaPublicartServicosAdapter
import br.com.guiacistore.model.ListaDeFotosModel
import kotlinx.android.synthetic.main.activity_recycleview.*


open class PubliCartServicosActivity : AppCompatActivity()  {

    var list = ArrayList<ListaDeFotosModel>()
    var adapter = ListaPublicartServicosAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Publicart"

    }


    //Responsável por criar as categorias e mostrar as fotos
    private fun  prepareList(list: ArrayList<ListaDeFotosModel>) {

        list.add(ListaDeFotosModel("", ""," Autoescola Caarapó ", R.drawable.publicart_primeira_foto))
        list.add(ListaDeFotosModel("", "","Outubro Rosa na Caarapó", R.drawable.publicart_segunda_foto))
        list.add(ListaDeFotosModel("Bar", "","Colchões Ortobom", R.drawable.publicart_terceira_foto))
        list.add(ListaDeFotosModel("", "","Welson Saxofonista", R.drawable.publicart_quarta_foto))

    }

}



