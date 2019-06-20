package br.com.guiacistore.lojas.MultivixPojuca.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.MultivixPojuca.MultivixPojucaActivity
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaActivity
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaServicosActivity
import br.com.guiacistore.model.dados.ListaModel

fun MultivixPojucaActivity.mostrarServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)
    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Cursos", "", 0, R.drawable.ic_cursos) )
    listaModel.add(ListaModel("Inscrição", "", 0, R.drawable.ic_inscricao) )
    listaModel.add(ListaModel("Enem", "", 0, R.drawable.ic_enem) )
    listaModel.add(ListaModel("Encceja", "", 0, R.drawable.ic_encceja) )
    listaModel.add(ListaModel("Mec", "", 0, R.drawable.ic_mec) )
    listaModel.add(ListaModel("Endereço", "", 0, R.drawable.ic_endereco_multivix) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}



fun MultivixPojucaActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Carro e moto", "Entre em contato.",  R.drawable.ok_promocao, R.drawable.ic_franca_carros))

    listaModel.add(ListaModel("Laudo (primeira habilitação)", "", 0, R.drawable.ic_franca_primeira_habilitacao) )
    listaModel.add(ListaModel("Renovação", "", 0, R.drawable.ic_franca_renovacao_cnh) )
    listaModel.add(ListaModel("Adição de Categoria", "", 0, R.drawable.ic_franca_adicao_categoria) )
    listaModel.add(ListaModel("Curso de reciclagem", "", 0, R.drawable.ic_franca_curso_reciclagem) )
    listaModel.add(ListaModel("Curso de atualização", "", 0, R.drawable.ic_franca_atualizacao) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}