package br.com.guiacistore.lojas.blueway

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.model.dados.ListaModel

class BlueWayRedesSociaisActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blue_way_activity_redes_sociais)

        supportActionBar?.title = "Redes sociais"

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("/idiomasblueway/", "", "", R.drawable.ic_rede_social_facebook))
        listaModel.add(ListaModel("Zap: (71) 99648-1470", "", "", R.drawable.ic_telefone))
        listaModel.add(ListaModel("/bluewayidiomas/", "", "", R.drawable.ic_rede_social_instagram))

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

    }

}