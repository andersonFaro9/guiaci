package br.com.guiacistore.lojas.dinei_barber.extensions

import android.graphics.Color
import android.graphics.Color.BLUE
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaRedesSociaisActivity
import br.com.guiacistore.lojas.auto_escola_franca.AutoEscolaFrancaServicosActivity
import br.com.guiacistore.lojas.dinei_barber.DineiBarberActivity
import br.com.guiacistore.lojas.dinei_barber.DineiBarberRedesSociaisActivity
import br.com.guiacistore.lojas.dinei_barber.DineiBarberServicosActivity
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.layout_lista_simples_texto_sem_imagem_adapter.*
import kotlinx.android.synthetic.main.lista_layout_imagem_texto.*

fun DineiBarberActivity.mostrarServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)
    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("História", "", 0, R.drawable.ic_historia_diney) )

    listaModel.add(ListaModel("Cortes", "", 0, R.drawable.ic_diney_cortes) )

    listaModel.add(ListaModel("Fotos", "", 0, R.drawable.ic_fotos_diney) )
    listaModel.add(ListaModel("Promoções", "", 0, R.drawable.ic_promocoes_diney) )
    listaModel.add(ListaModel("Endereço", "", 0, R.drawable.ic_endereco_diney) )
    listaModel.add(ListaModel("Contato e redes sociais", "", 0, R.drawable.ic_rede_social_diney) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}



fun DineiBarberActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Cortes de cabelo", "Ligue para saber mais.", R.drawable.ic_cortes_diney, 0))

    listaModel.add(ListaModel("Degradê", "", 0, R.drawable.ic_degrade_diney))
    listaModel.add(ListaModel("Navalhado", "", 0, R.drawable.ic_navalhado_diney))
    listaModel.add(ListaModel("Social", "", 0, R.drawable.ic_social_diney))
    listaModel.add(ListaModel("Estilos diversos", "", 0, R.drawable.ic_estilos_diney))

}

fun DineiBarberRedesSociaisActivity.mostrarRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("diinei.barber/", "Confira todas novidades", 0, R.drawable.ic_instagram) )
    listaModel.add(ListaModel("(71)9.9999-4927", "", 0, R.drawable.ic_zap) )


    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


fun DineiBarberServicosActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Cortes", "cartões Visa, Mastercard, D. Club, A. Express ",  R.drawable.ok_promocao, R.drawable.ic_cortes_dinei))

    listaModel.add(ListaModel("Degradê", "", 0, R.drawable.ic_degrade_dinei) )
    listaModel.add(ListaModel("Navalhado", "", 0,R.drawable.ic_navalhado_dinei ))
    listaModel.add(ListaModel("Social", "", 0, R.drawable.ic_social_dinei ))
    listaModel.add(ListaModel("Diversos", "", 0, R.drawable.ic_diversos_dinei ) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}