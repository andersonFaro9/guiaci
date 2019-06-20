package br.com.guiacistore.lojas.doterra.extensions
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.lojas.doterra.DoTerraActivity
import br.com.guiacistore.model.dados.ListaModel



fun DoTerraActivity.mostrarServicosOferecidos() {

        val listView = findViewById<ListView>(R.id.listView)

        val listaModel: ArrayList<ListaModel> = ArrayList()

        listaModel.add(ListaModel("Produtos", "", 0 , R.drawable.ic_doterra_produtos) )
        listaModel.add(ListaModel("Nossos óleos", "", 0, R.drawable.ic_doterra_oleos) )
        listaModel.add(ListaModel("Kits e Acessórios", "", 0, R.drawable.ic_doterra_kit) )
        listaModel.add(ListaModel("O melhor para você", "", 0, R.drawable.ic_doterra_eventos) )

        //listaModel.add(ListaModel("Fotos", "", 0, R.drawable.ic_doterra_kit) )

        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}





//fun EvolutionRedesSociaisActivity.mostrarRedesSociais() {
//
//        val listView = findViewById<ListView>(R.id.listView)
//
//        val listaModel: ArrayList<ListaModel> = ArrayList()
//
//        listaModel.add(ListaModel("academiaevolutionfitnesspojucaba/", "", 0, R.drawable.ic_facebook) )
//        listaModel.add(ListaModel("evolution_pojuca/", "", 0, R.drawable.ic_instagram) )
//        listaModel.add(ListaModel("(71) 99709-7427", "", 0, R.drawable.ic_telefone) )
//
//
//        listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)
//
//}

