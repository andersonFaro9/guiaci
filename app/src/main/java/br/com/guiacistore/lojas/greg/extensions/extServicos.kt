package br.com.guiacistore.lojas.greg.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.greg.GregActivity
import br.com.guiacistore.lojas.greg.GregCortesValoresActivity
import br.com.guiacistore.lojas.greg.GregRedesSociaisActivity
import br.com.guiacistore.model.dados.ListaModel

fun GregActivity.mostrarServicosOferecidos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("Barbearia do Greg", "", "", R.drawable.ic_historia_greg))
    listaModel.add(ListaModel("Cortes e valores", "", "", R.drawable.ic_cortes_greg))
    listaModel.add(ListaModel("Seu cartão fidelidade", "", "", R.drawable.ic_cartao_greg))
    listaModel.add(ListaModel("Novidades", "", "", R.drawable.ic_novidade_greg))
    listaModel.add(ListaModel("Promoções", "", "", R.drawable.ic_promocao_greg))
    listaModel.add(ListaModel("Contatos e Redes sociais", "Participe de nossas redes sociais!", "", R.drawable.ic_redes_sociais_greg))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}




fun GregCortesValoresActivity.mostraNossosServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()

    /*  Código usado em caso de precisar atualizar apenas o titulo da listview (cliente precisa atualizar sabores das pizzas, por exemplo)
    *
    *   var x = cliente?.evolution_primeira_promocao.toString()
        listaModel.add(ListaModel(x, "Por R$ 18,00 reais!", "", R.drawable.ic_navalhado_greg))

     */


    listaModel.add(ListaModel("Degradê e Navalhado", "Por R$ 18,00 reais!", "", R.drawable.ic_navalhado_greg))
    listaModel.add(ListaModel("Corte Tesoura", "Por R$ 20,00 reais!!", "", R.drawable.ic_tesoura_greg))
    listaModel.add(ListaModel("Corte Social e Militar", "Por R$ 13,00 reais", "", R.drawable.ic_corte_militar_greg))
    listaModel.add(ListaModel("Corte de Máquina 1", "Por R$ 10,00 reais!!", "", R.drawable.ic_maquina_greg))
    listaModel.add(ListaModel("Barba", "Por R$ 8,00 reais!", "", R.drawable.ic_barba_greg))
    listaModel.add(ListaModel("Sobrancelhas", "Por R$ 6,00 reais.", "", R.drawable.ic_sobrancelha_greg))
    listaModel.add(ListaModel("Pezinho de Cabelo", "Por R$ 5,00 reais.", "", R.drawable.ic_pezinho_cabelo_greg))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)


}

fun GregRedesSociaisActivity.mostrarRedesSociais() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()


    listaModel.add(ListaModel("/GregBarber88/", "", "", R.drawable.ic_rede_social_facebook))
    listaModel.add(ListaModel("Zap: (71) 99648-1470", "", "", R.drawable.ic_telefone))
    listaModel.add(ListaModel("/gregbarber88/", "", "", R.drawable.ic_rede_social_instagram))

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
}





