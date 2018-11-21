package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import br.com.guiacistore.R
import br.com.guiacistore.adapter.publicart.ListaPublicartServicosAdapter
import br.com.guiacistore.model.ListaDasLojasPublicartModel
import kotlinx.android.synthetic.main.activity_recycleview.*


open class PubliCartServicosActivity : AppCompatActivity()  {

    var list = ArrayList<ListaDasLojasPublicartModel>()
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
    private fun  prepareList(list: ArrayList<ListaDasLojasPublicartModel>) {

        list.add(ListaDasLojasPublicartModel("", ""," Autoescola Caarapó ", R.drawable.publicart_primeira_foto))
        list.add(ListaDasLojasPublicartModel("", "","Outubro Rosa na Caarapó", R.drawable.publicart_segunda_foto))
        list.add(ListaDasLojasPublicartModel("Bar", "","Colchões Ortobom", R.drawable.publicart_terceira_foto))
        list.add(ListaDasLojasPublicartModel("", "","Welson Saxofonista", R.drawable.publicart_quarta_foto))

    }

}



