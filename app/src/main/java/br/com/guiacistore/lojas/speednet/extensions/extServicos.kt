package br.com.guiacistore.lojas.speednet.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.speednet.SpeedNetActivity
import br.com.guiacistore.lojas.speednet.SpeednetPlanosActivity
import br.com.guiacistore.lojas.speednet.SpeednetRedesSociaisActivity
import br.com.guiacistore.model.dados.ListaModel

fun SpeedNetActivity.mostraServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Speednet Alliance", "", 0, R.drawable.ic_historia_speednet))
    listaModel.add(ListaModel("Planos", "", 0, R.drawable.ic_planos_speednet))
    listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocoes_speednet))
    listaModel.add(ListaModel("Novidades", "", 0, R.drawable.ic_novidades_speednet))
    listaModel.add(ListaModel("Redes sociais", "Participe de nossas redes sociais!", 0, R.drawable.ic_redes_sociais_speednet))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}


fun SpeednetPlanosActivity.mostraPlanos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("5 megas por R$60,00 reais", "Para quem envia mensagens!", 0, R.drawable.ic_5_megas_speednet))
    listaModel.add(ListaModel("7 megas por R$80,00 reais", "Para redes sociais!", 0, R.drawable.ic_7_megas_speednet))
    listaModel.add(ListaModel("10 megas por R$100,00 reais", "Para amantes de filmes!", 0, R.drawable.ic_10_megas_speednet))
    listaModel.add(ListaModel("15 megas por R$125,00 reais", "Para navegar, assistir e jogar!", 0, R.drawable.ic_15_megas_speednet))
    listaModel.add(ListaModel("20 megas por R$150,00 reais", "Para assistir, navegar e fazer downloads!", 0, R.drawable.ic_20_megas_speednet))
    listaModel.add(ListaModel("Link dedicado (empresarial)", "Internet 24 horas com alta performance e confiabilidade!.", 0, R.drawable.ic_link_dedicado_speednet))


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}

fun SpeednetRedesSociaisActivity.mostraRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("/speednetalliance", "", 0, R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("(71) 3645.5134", "", 0, R.drawable.ic_telefone))
    listaModel.add(ListaModel("/speednetalliance", "", 0, R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}




