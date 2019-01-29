package br.com.guiacistore.lojas.jsbarbearia

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.model.dados.ListaModel

fun JsBarbeariaActivity.mostraServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("JS Barbearia à Domicílio", "", 0, R.drawable.ic_historia_jsbarbearia))
    listaModel.add(ListaModel("Serviços", " ", 0, R.drawable.ic_servicos_jsbarbearia))
    listaModel.add(ListaModel("Fotos", "", 0, R.drawable.ic_novidades_jsbarbearia))
    listaModel.add(ListaModel("Promoções", "Belas promoções", 0, R.drawable.ic_promocoes_jsbarbearia))
    listaModel.add(ListaModel("Contatos e Redes sociais", "Participe de nossas redes sociais!", 0, R.drawable.ic_rede_sociais_jsbarbearia))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}


fun JsBarbeariaServicosActivity.mostraServicosCortesValores() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Cortes", "", 0, R.drawable.ic_cortes_jsbarbearia))

    listaModel.add(ListaModel("", "Corte social por R$ 15,00 reais!", 0, R.drawable.ic_corte_social_jsbarbearia))
    listaModel.add(ListaModel("", " Corte degradê por R$ 17,00 reais!!", 0,R.drawable.ic_corte_degrade_jsbarbearia))
    listaModel.add(ListaModel("", " Corte tesoura por R$ 18,00 reais", 0, R.drawable.ic_tesoura_jsbarbearia))
    listaModel.add(ListaModel("", " Barba simples por R$ 5,00 reais!!", 0, R.drawable.ic_barba_simples_jsbarbearia))
    listaModel.add(ListaModel("", " Barba desenhada por R$ 7,00 reais!", 0,R.drawable.ic_barba_desenhada_jsbarbearia))

    listaModel.add(ListaModel("Combos", "", 0, R.drawable.ic_combo_jsbarbearia) )

    listaModel.add(ListaModel("", " Corte social + barba R$ 18,00 reais.", 0, R.drawable.ic_corte_social_jsbarbearia))
    listaModel.add(ListaModel("", " Corte degradê + barba por R$ 20,00 reais.", 0, R.drawable.ic_corte_degrade_jsbarbearia))
    listaModel.add(ListaModel("", " Corte tesoura + barba por R$ 20,00 reais.", 0, R.drawable.ic_tesoura_jsbarbearia))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}

fun JsBarbeariaRedesSociaisActivity.mostraRedesSociais() {

    val listaModel: ArrayList<ListaModel> = ArrayList()

    val listView = findViewById<ListView>(R.id.listView)

    listaModel.add(ListaModel("/jsbarbeariaadomicilio/", "", 0, R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("Zap: (71) 9.9628-2113", "", 0, R.drawable.ic_telefone))
    listaModel.add(ListaModel("/js_barbearia_a_domicilio/", "", 0, R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}





