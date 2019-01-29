package br.com.guiacistore.lojas.biosinformatica.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.adapter.ListaSimplesTextoSemImagemAdapter
import br.com.guiacistore.lojas.biosinformatica.BiosInformaticaActivity
import br.com.guiacistore.lojas.biosinformatica.BiosInformaticaRedesSociaisActivity
import br.com.guiacistore.lojas.biosinformatica.BiosInformaticaServicosActivity
import br.com.guiacistore.lojas.evolution.AcademiaEvolutionActivity
import br.com.guiacistore.lojas.evolution.EvolutionRedesSociaisActivity
import br.com.guiacistore.lojas.evolution.EvolutionServicosActivity
import br.com.guiacistore.model.dados.ListaModel


fun BiosInformaticaActivity.mostrarServicosOferecidos() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Serviços", "", 0, R.drawable.ic_servicos_bios) )
        listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocoes_bios) )
        listaModel.add(ListaModel("Fotos", "", 0, R.drawable.ic_fotos_bios) )
        listaModel.add(ListaModel("Contato e redes sociais", "", 0, R.drawable.ic_rede_social_bios) )

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


fun BiosInformaticaServicosActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Manutenção ", "Faça a manutenção de seu computador", 0, 0) )
    listaModel.add(ListaModel("Impressoras", "Fazemos a sua manutenção", 0, 0) )
    listaModel.add(ListaModel("Câmeras de segurança", "Instalamos sua câmera", 0,0) )
    listaModel.add(ListaModel("Alarmes", "Instalamos seu alarme", 0, 0) )
    listaModel.add(ListaModel("Cartuchos e toner", "Faça sua recarga", 0, 0) )
    listaModel.add(ListaModel("Papelaria", "Faça sua encadernação e plastificação", 0, 0) )
    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)

}


fun BiosInformaticaRedesSociaisActivity.mostrarRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("biosinformaticaepapelaria/", "", 0, R.drawable.ic_facebook) )
    listaModel.add(ListaModel("biosinformaticaepapelaria/", "", 0, R.drawable.ic_instagram) )
    listaModel.add(ListaModel("(71) 3645-5134", "", 0, R.drawable.ic_telefone) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}






