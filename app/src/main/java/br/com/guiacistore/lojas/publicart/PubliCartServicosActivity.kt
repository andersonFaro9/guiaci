package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaDasLojasPublicartAdapter
import br.com.guiacistore.model.ListaDasLojasPublicartModel
import kotlinx.android.synthetic.main.activity_main.*


open class PubliCartServicosActivity : AppCompatActivity()  {

    var list = ArrayList<ListaDasLojasPublicartModel>()
    var adapter = ListaDasLojasPublicartAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareList(list)

        rView.adapter = adapter
        rView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Publicart"

    }



    private fun  prepareList(list: ArrayList<ListaDasLojasPublicartModel>) {

        list.add(ListaDasLojasPublicartModel("Publicart", "Social midia.","Show de Arrocha", R.drawable.loja_speednet))
        list.add(ListaDasLojasPublicartModel("Speednet", "","Speednet - internet é aqui!!", R.drawable.loja_blueway))
        list.add(ListaDasLojasPublicartModel("Bar", "","Speednet - internet é aqui!!", R.drawable.loja_rosa_saron))

        list.add(ListaDasLojasPublicartModel("Publicart", "Cartões de visita.","Saxofone de qualidade", R.drawable.loja_speednet))
        list.add(ListaDasLojasPublicartModel("Speednet", "","Inglês - BlueWay!!", R.drawable.loja_blueway))
        list.add(ListaDasLojasPublicartModel("Bar", "","Igrej Rosa de Saron", R.drawable.loja_rosa_saron))




    }




}



