package br.com.guiacistore.lojas.auto_escola_franca.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaActivity
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaRedesSociaisActivity
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaServicosActivity
import br.com.guiacistore.lojas.evolution.EvolutionRedesSociaisActivity
import br.com.guiacistore.model.dados.ListaModel


fun AutoEscolaFrancaActivity.mostrarServicosOferecidos() {

        val listView = findViewById<ListView>(R.id.listView)
        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("História", "", 0, R.drawable.ic_auto_escola_franca_home) )
        listaModel.add(ListaModel("Serviços", "", 0, R.drawable.ic_auto_escola_franca_servicos) )
        listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_auto_escola_franca_promocoes) )
        listaModel.add(ListaModel("Fotos", "", 0, R.drawable.ic_auto_escola_franca_fotos) )
        listaModel.add(ListaModel("Endereço", "", 0, R.drawable.ic_auto_escola_franca_endereco) )
        listaModel.add(ListaModel("Contato e redes sociais", "", 0, R.drawable.ic_auto_escola_franca_rede_social) )

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}



fun AutoEscolaFrancaServicosActivity.mostrarServicos() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Carro e moto", "Entre em contato.",  R.drawable.ok_promocao,R.drawable.ic_franca_carros))

        listaModel.add(ListaModel("Laudo (primeira habilitação)", "", 0, R.drawable.ic_franca_primeira_habilitacao) )
        listaModel.add(ListaModel("Renovação", "", 0, R.drawable.ic_franca_renovacao_cnh) )
        listaModel.add(ListaModel("Adição de Categoria", "", 0, R.drawable.ic_franca_adicao_categoria) )
        listaModel.add(ListaModel("Curso de reciclagem", "", 0, R.drawable.ic_franca_curso_reciclagem) )
        listaModel.add(ListaModel("Curso de atualização", "", 0, R.drawable.ic_franca_atualizacao) )


        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


fun AutoEscolaFrancaRedesSociaisActivity.mostrarRedesSociais() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("autoescolafrank/", "", 0, R.drawable.ic_facebook) )
        listaModel.add(ListaModel("(71) 99981-9741", "", 0, R.drawable.ic_zap) )


        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}

