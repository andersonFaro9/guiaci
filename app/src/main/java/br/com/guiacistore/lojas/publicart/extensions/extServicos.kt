package br.com.guiacistore.lojas.publicart.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.adapter.ListaSimplesTextoSemImagemAdapter
import br.com.guiacistore.lojas.publicart.PubliCartActivity
import br.com.guiacistore.lojas.publicart.PubliCartServicosActivity
import br.com.guiacistore.lojas.publicart.PublicartParceirosActivity
import br.com.guiacistore.model.dados.ListaModel

fun PubliCartActivity.mostraServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)
    val listaModel: ArrayList<ListaModel> = ArrayList()


    listaModel.add(ListaModel("A Publicart", "", "", R.drawable.ic_a_publi_cart))
    listaModel.add(ListaModel("Nossos serviços", "", "", R.drawable.ic_a_publi_cart_servicos))
    listaModel.add(ListaModel("Contatos e redes sociais", "", "", R.drawable.ic_phone_publicart_menu))
    listaModel.add(ListaModel("Nossos parceiros", "", "", R.drawable.ic_a_publi_cart_parceiros))
    listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_a_publi_cart_novidades))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}

fun PublicartParceirosActivity.mostrarParceiros () {


    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()


    listaModel.add( ListaModel("Welson Saxofonista", "Tel: (75) 99878-1224", "", 0) )


    listaModel.add (ListaModel(" C. de Treinamento Bruno Melo(CT das Águas)", "Tel: (71) 99735-7450", "", 0) )

    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)
}




fun PubliCartServicosActivity.mostraServicos () {


    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add( ListaModel("Comunicação Visual", "A comunicação, os detalhes e cores ficam ainda mais bonito!", "", 0) )

    listaModel.add( ListaModel(" Propaganda", "Sua propaganda com profissionais de verdade", "", 0) )

    listaModel.add( ListaModel(" Redes sociais", "O mundo é digital e todos estão nas redes sociais", "", 0) )

    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)
}




