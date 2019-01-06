package br.com.guiacistore.lojas.evolution.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.evolution.AcademiaEvolutionActivity
import br.com.guiacistore.lojas.evolution.EvolutionRedesSociaisActivity
import br.com.guiacistore.lojas.evolution.EvolutionServicosActivity
import br.com.guiacistore.model.dados.ListaModel


fun AcademiaEvolutionActivity.mostrarServicosOferecidos() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("História", "", "", R.drawable.ic_evolution_home) )
        listaModel.add(ListaModel("Serviços", "", "", R.drawable.ic_evolution_servicos) )
        listaModel.add(ListaModel("Promoções", "", "", R.drawable.ic_evolution_promocoes) )
        listaModel.add(ListaModel("Fotos", "", "", R.drawable.ic_evolution_novidades) )
        listaModel.add(ListaModel("Contato e redes sociais", "", "", R.drawable.ic_evolution_rede_social) )

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}



fun EvolutionServicosActivity.mostrarServicos() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Aeróbica", "", "", R.drawable.ic_aerobica_evolution) )
        listaModel.add(ListaModel("Fit Dance", "", "", R.drawable.ic_fit_dance_evolution) )
        listaModel.add(ListaModel("Boxe", "", "", R.drawable.ic_boxe_evolution) )
        listaModel.add(ListaModel("Musculação", "", "", R.drawable.ic_musculos_evolution) )
        listaModel.add(ListaModel("Circuit Funcional", "", "", R.drawable.ic_circuito_funcional_evolution) )

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


fun EvolutionRedesSociaisActivity.mostrarRedesSociais() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("academiaevolutionfitnesspojucaba/", "", "", R.drawable.ic_facebook) )
        listaModel.add(ListaModel("evolution_pojuca/", "", "", R.drawable.ic_instagram) )
        listaModel.add(ListaModel("(71) 99709-7427", "", "", R.drawable.ic_telefone) )


        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}

