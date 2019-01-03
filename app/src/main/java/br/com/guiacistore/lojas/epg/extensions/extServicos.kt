package br.com.guiacistore.lojas.epg.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.adapter.ListaSimplesTextoSemImagemAdapter
import br.com.guiacistore.lojas.epg.EpgActivity
import br.com.guiacistore.lojas.epg.EpgRedesSociaisActivity
import br.com.guiacistore.lojas.epg.EpgServicosActivity
import br.com.guiacistore.model.dados.ListaModel

fun EpgServicosActivity.mostraNossosServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Carimbos", "Carimbos personalizados", "", 0) )
    listaModel.add(ListaModel(" Cartões de visita", "Vem ver nossos exemplares", "", 0) )

    listaModel.add ( ListaModel("Chaveiros", "Do jeito que você desejar", "", 0) )

    listaModel.add( ListaModel(" Impressão em camisas", "Camisas com fotos e frases criativas", "", 0) )

    listaModel.add( ListaModel(" Sacolas", "Sacolas de papel, sacolas de plástico", "", 0) )

    listaModel.add( ListaModel(" Folhetos", "Vem ver nosso catálogo", "", 0) )

    listaModel.add( ListaModel(" Bolsas", "Diversos tipos de bolsas", "", 0) )

    listaModel.add(  ListaModel(" Taças", "Taças personalizadas", "", 0) )

    listaModel.add( ListaModel(" Imã de geladeira", " Imãs divertidos", "", 0) )

    listaModel.add( ListaModel(" Banner", "Banner de lona, oxford, etc", "", 0) )


    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)


}

fun EpgRedesSociaisActivity.mostraRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("/epgimpressoes", "", "", R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("(71) 9.9636-3518", "", "", R.drawable.ic_rede_social_whatsapp))
    listaModel.add(ListaModel("/epgimpressoes", "", "", R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}


fun EpgActivity.mostrarServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("EPG Impressões", "", "", R.drawable.ic_home_epg))
    listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_novidades_epg))
    listaModel.add(ListaModel("Serviços", "", "", R.drawable.ic_servicos_epg))
    listaModel.add(ListaModel("Redes sociais", "Participe", "", R.drawable.ic_rede_sociais_epg))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}






