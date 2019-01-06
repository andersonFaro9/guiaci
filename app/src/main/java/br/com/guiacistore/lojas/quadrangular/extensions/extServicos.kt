package br.com.guiacistore.lojas.quadrangular.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.evolution.EvolutionRedesSociaisActivity
import br.com.guiacistore.lojas.quadrangular.QuadrangularActivity
import br.com.guiacistore.lojas.quadrangular.QuadrangularRedeSocialActivity
import br.com.guiacistore.model.dados.ListaModel

fun QuadrangularActivity.mostrarServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("História", "", "", R.drawable.ic_home_quadrangular) )
    listaModel.add(ListaModel("Cultos e células", "", "", R.drawable.ic_cultos_celula) )
    listaModel.add(ListaModel("Pastor", "Livros do Pr. Osvaldo", "", R.drawable.ic_pastor) )
    listaModel.add(ListaModel("Fotos", "", "", R.drawable.ic_fotos_quadrangular) )
    listaModel.add(ListaModel("Redes sociais", "", "", R.drawable.ic_rede_social_quadrangular) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}

fun QuadrangularRedeSocialActivity.mostrarRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Igreja-do-Evangelho-Quadrangular-em-Pojuca/", "", "", R.drawable.ic_facebook) )
    listaModel.add(ListaModel("ieq_pojuca/", "", "", R.drawable.ic_instagram) )
    //listaModel.add(ListaModel("(71) 99709-7427", "", "", R.drawable.ic_telefone) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}