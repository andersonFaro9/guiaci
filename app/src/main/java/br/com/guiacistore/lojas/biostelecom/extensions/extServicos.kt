package br.com.guiacistore.lojas.biostelecom.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.biostelecom.BiosTelecomActivity
import br.com.guiacistore.lojas.biostelecom.BiosTelecomPlanosActivity
import br.com.guiacistore.lojas.biostelecom.BiosTelecomRedesSociaisActivity
import br.com.guiacistore.model.dados.ListaModel

fun BiosTelecomActivity.mostraServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Bios Telecom", "", 0, R.drawable.ic_historia_biostelecom))
    listaModel.add(ListaModel("Planos", "", 0, R.drawable.ic_planos_biostelecom))
    listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocoes_biostelecom))
    listaModel.add(ListaModel("Redes sociais", "Participe de nossas redes sociais!", 0, R.drawable.ic_redes_sociais_biostelecom))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}


fun BiosTelecomPlanosActivity.mostraPlanos() {

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

fun BiosTelecomRedesSociaisActivity.mostraRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("/biostelecomunicacoes/", "", 0, R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("(71) 4062.8811", "", 0, R.drawable.ic_telefone))
    listaModel.add(ListaModel("/biostelecomunicacoes/", "", 0, R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}




