package br.com.guiacistore.lojas.blueway.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.adapter.ListaSimplesTextoSemImagemAdapter
import br.com.guiacistore.lojas.blueway.BlueWayActivity
import br.com.guiacistore.lojas.blueway.BlueWayParceirosActivity
import br.com.guiacistore.lojas.blueway.BlueWayRedesSociaisActivity
import br.com.guiacistore.model.dados.ListaModel

fun BlueWayActivity.mostraServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Blue Way Idiomas", "", 0, R.drawable.ic_a_blue_way))
    listaModel.add(ListaModel("Matrículas", "", 0, R.drawable.ic_matricula_blue_way))
    listaModel.add(ListaModel("Nossos parceiros", "", 0, R.drawable.ic_parceiros_blue_way))
    listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocao))
    listaModel.add(ListaModel("Contatos", "", 0, R.drawable.ic_contatos_blue_way))
    listaModel.add(ListaModel("Redes Sociais", "Participe!", 0, R.drawable.ic_redes_sociais_blue_way))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}


fun BlueWayParceirosActivity.exibirParceiros() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Unidade de Pojuca", "Tel: 99628-7958", 0, 0) )

    listaModel.add(ListaModel("", "Academia Evolution", 0, 0) )
    listaModel.add(ListaModel("", "Escola Surpresa", 0, 0) )
    listaModel.add(ListaModel("", "Colégio 29 de Julho", 0, 0) )
    listaModel.add(ListaModel("", "Escola Betel", 0, 0) )


    listaModel.add(ListaModel("Unidade de Catu", "Tel: 99694-6672", 0, 0) )

    listaModel.add(ListaModel("", "Halliburton", 0, 0) )
    listaModel.add(ListaModel("", "Escola Ágappe", 0, 0) )
    listaModel.add(ListaModel("", "Escola Traços e Letras", 0, 0) )

    listaModel.add(ListaModel("", "Escola da Tia Lia", 0, 0) )
    listaModel.add(ListaModel("", "Escola da Tia Margô", 0, 0) )
    listaModel.add(ListaModel("", "Colégio Athena", 0, 0) )
    listaModel.add(ListaModel("", "Filhote de Ogro", 0, 0) )





    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)


}



fun BlueWayRedesSociaisActivity.mostraRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("/idiomasblueway/", "", 0, R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("Zap: (71) 99648-1470", "", 0, R.drawable.ic_telefone))
    listaModel.add(ListaModel("/bluewayidiomas/", "", 0, R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}

