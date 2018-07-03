package br.com.guiacistore.model


/**
 * Created by faro on 3/22/18.
 */


data class LojasModel(

        //venivici
        var venivici_empresa: String = "",
        var venivici_historia_da_empresa: String = "",

        var venivici_promocoes: String = "",
        var venivici_conteudo_de_promocoes: String = "",

        var venivici_servicos : String = "",
        var venivici_conteudo_de_servicos: String = "",


        //TODO -> Precisa mudar os campos abaixo com os nomes das lojas reais

        //padaria
        var titulo_promocoes_padaria: String= "",
        var resumo_promocoes_padaria : String= "",
        var novidades_padaria : String= "",
        var resumo_novidades_padaria : String= "",

        //carros
        var titulo_promocoes_carros: String = "",
        var resumo_promocoes_carros: String = "",
        var novidades_carros : String = "",
        var resumo_novidades_carros: String = "",

        //farmacia
        var titulo_promocoes_farmacia: String= "",
        var resumo_promocoes_farmacia: String= "",
        var novidades_farmacia : String= "",
        var resumo_novidades_farmacia : String= ""



)


