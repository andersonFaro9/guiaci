package br.com.guiacistore.lojas.multivixPojuca.extensions

import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaImagemTextoSimplesAdapter
import br.com.guiacistore.adapter.ListaSimplesTextoSemImagemAdapter
import br.com.guiacistore.lojas.multivixPojuca.MultivixPojucaActivity
import br.com.guiacistore.lojas.multivixPojuca.MultivixPojucaCursosActivity
import br.com.guiacistore.lojas.multivixPojuca.MultivixPojucaInscricaoActivity
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.multivix_listview_activity.*

fun MultivixPojucaActivity.mostrarServicosOferecidos() {

    val listaModel: ArrayList<ListaModel> = ArrayList()
    listaModel.add(ListaModel("ESTUDE DE GRAÇA", "indique amigos e ganhe até 100%" , 0, R.drawable.ic_alarm_multivix))
    listaModel.add(ListaModel("Cursos", "autorizado pelo MEC" , 0, R.drawable.ic_cursos))
    listaModel.add(ListaModel("PROMOÇÃO: R$99,00 REAIS", "válido até segundo semestre 2019/2, nas 6 primeiras parcelas", 0, R.drawable.ic_multivix_promocoes) )
    listaModel.add(ListaModel("INSCRIÇÃO ", "pelo site: multivix.edu.br/ead/", 0, R.drawable.ic_inscricao) )
    listaModel.add(ListaModel("Endereço", "", 0, R.drawable.ic_endereco_multivix) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}

fun MultivixPojucaCursosActivity.mostrarServicos() {

    val listaModel: ArrayList<ListaModel> = ArrayList()

    listaModel.add(ListaModel("GRADUAÇÃO - Bacharelado, 4 anos", "100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )

    listaModel.add(ListaModel("", "Administração", 0, 0))
    listaModel.add(ListaModel("", "Ciências Contábeis", 0, R.drawable.ic_franca_adicao_categoria) )
    listaModel.add(ListaModel("", "Serviço Social", 0, 0))

    listaModel.add(ListaModel("GRADUAÇÃO - Licenciatura, 4 anos", "100% on-LINE ", 0, R.drawable.ic_franca_primeira_habilitacao) )

    listaModel.add(ListaModel("", "História", 0, 0))
    listaModel.add(ListaModel("", "Letras(Português)", 0, R.drawable.ic_franca_adicao_categoria) )
    listaModel.add(ListaModel("", "Matemática", 0, 0))
    listaModel.add(ListaModel("", "Pedagogia", 0, 0))
    listaModel.add(ListaModel("", "Ciências Biológicas", 0, 0))



    listaModel.add(ListaModel("GRADUAÇÃO - Tecnológico, 2 anos", " 100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )

    listaModel.add(ListaModel("", "Análise e Des. de Sistemas", 0, 0))
    listaModel.add(ListaModel("", "Processos Gerenciais", 0, R.drawable.ic_franca_adicao_categoria) )
    listaModel.add(ListaModel("", "Gestão Ambiental", 0, 0))
    listaModel.add(ListaModel("", "Gestão Pública", 0, 0))
    listaModel.add(ListaModel("", "Logistica", 0, 0))
    listaModel.add(ListaModel("", "Marketing", 0, 0))
    listaModel.add(ListaModel("", "Tecnologia em Gestão de Recursos Humanos", 0, 0))


    listaModel.add(ListaModel("Pós-graduação - DIREITO", " 100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )

    listaModel.add(ListaModel("", "Direito Ambiental", 0, 0))
    listaModel.add(ListaModel("", "Direito Civil e Processual Civil", 0, R.drawable.ic_franca_adicao_categoria) )
    listaModel.add(ListaModel("", "Direito Constitucional e Administrativo", 0, 0))
    listaModel.add(ListaModel("", "Direito Penal e Processo Penal", 0, 0))

    listaModel.add(ListaModel("Pós-graduação - SAÚDE", " 100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )
    listaModel.add(ListaModel("", "Controle de Infecções Hospitalares", 0, 0))
    listaModel.add(ListaModel("", "Gestão Serviços Saúde Ênfase de Saúde Família", 0, 0))


    listaModel.add(ListaModel("Pós-graduação - EDUCAÇÃO", " 100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )
    listaModel.add(ListaModel("", "Alfabetização e Letramento", 0, 0))
    listaModel.add(ListaModel("", "Arte e Educação", 0, 0))
    listaModel.add(ListaModel("", "Didática do Ensino Superior", 0, 0))
    listaModel.add(ListaModel("", "Educação Especial e Inclusiva", 0, 0))
    listaModel.add(ListaModel("", "Filosofia da Educação", 0, 0))
    listaModel.add(ListaModel("", "Gestão Escolar com Hab. em Adm, Supervisão, Orientação e Inspeção.", 0, 0))
    listaModel.add(ListaModel("", "Lingua Portuguesa e Literatura Brasileira.", 0, 0))
    listaModel.add(ListaModel("", "Psicopedagogia Instituicional.", 0, 0))
    listaModel.add(ListaModel("", "Séries Iniciais Ensino Fundamental e Ed Infantil.", 0, 0))



    listaModel.add(ListaModel("Pós-graduação - GESTÃO", " 100% on-LINE", 0, R.drawable.ic_franca_primeira_habilitacao) )
    listaModel.add(ListaModel("", "Gestão Empresarial", 0, 0))
    listaModel.add(ListaModel("", "Gestão Financeira e Controladoria", 0, 0))
    listaModel.add(ListaModel("", "Gestão Pública", 0, 0))
    listaModel.add(ListaModel("", "Gestão e Educação Ambiental", 0, 0))



    listView.adapter = ListaSimplesTextoSemImagemAdapter(applicationContext, listaModel)

}

fun MultivixPojucaInscricaoActivity.mostrarServicos() {

    val listView = findViewById<ListView>(R.id.listView)

    val listaModel: ArrayList<ListaModel> = ArrayList()
    listaModel.add(ListaModel("SIMPLES PROCESSO SELETIVO", "Sua inscrição on-line com uma redação.", 0, R.drawable.ic_selecao) )
    listaModel.add(ListaModel("ENEM", "Bolsa de até 100% de desconto.", 0, R.drawable.ic_curso_enem) )
    listaModel.add(ListaModel("ENCEEJA", "Matricule-se com a certificação ENCEEJA.",  0, R.drawable.ic_enceeja_cursos) )

    listView.adapter = ListaImagemTextoSimplesAdapter(applicationContext, listaModel)

}


