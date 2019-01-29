package br.com.guiacistore.lojas.lilidoces.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.evolution.EvolutionRedesSociaisActivity
import br.com.guiacistore.lojas.evolution.EvolutionServicosActivity
import br.com.guiacistore.lojas.lilidoces.LiliContatosRedesSociaisActivity
import br.com.guiacistore.lojas.lilidoces.LiliDocesCakesActivity
import br.com.guiacistore.lojas.lilidoces.LiliDocesTortasServicosActivity
import br.com.guiacistore.model.dados.ListaModel

fun LiliDocesCakesActivity.mostrarServicosOferecidos() {
    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("História", "", 0, R.drawable.ic_home_lili))
    listaModel.add(ListaModel("Doces e Tortas", "", 0, R.drawable.ic_torta_lili))
    listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocoes_lili))
    listaModel.add(ListaModel("Fotos", "Saboreie nossas delícias", 0, R.drawable.ic_fotos_lili))
    listaModel.add(ListaModel("Redes sociais", "Participe", 0, R.drawable.ic_rede_social_lili))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}

fun LiliDocesTortasServicosActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Tortellete Gourmet(criação nossa).", "", 0, R.drawable.ic_tortellete_lili) )
    listaModel.add(ListaModel("Tortas de vitrine.", "", 0, R.drawable.ic_torta_vitrine_lili) )
    listaModel.add(ListaModel("Bolos Personalizados.", "", 0, R.drawable.ic_torta_personalizada_lili) )
    listaModel.add(ListaModel("Bolotones.", "", 0, R.drawable.ic_bolotone_lili) )
    listaModel.add(ListaModel("Brownie, o mais top da doceria.", "", 0, R.drawable.ic_brownie_lili) )
    listaModel.add(ListaModel("Cupcakes.", "", 0, R.drawable.ic_cupcake_lili) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}

fun LiliContatosRedesSociaisActivity.mostrarRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Lilli-Doces-e-Cakes/", "", 0, R.drawable.ic_facebook) )
    listaModel.add(ListaModel("lilidocesecakes/", "", 0, R.drawable.ic_instagram) )
    listaModel.add(ListaModel("(71) 98810-4762", "", 0, R.drawable.ic_telefone) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


