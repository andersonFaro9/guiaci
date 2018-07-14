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

        //speednet
        var speednet_empresa: String= "",
        var speednet_historia_da_empresa: String= "",

        var speednet_promocoes : String= "",
        var speednet_conteudo_de_promocoes : String= "",

        var speednet_servicos : String = "",
        var speednet_conteudo_de_servicos: String = "",


        //quadrangular
        var quadrangular_igreja: String = "",
        var quadrangular_historia_da_igreja: String = "",

        var quadrangular_cultos : String = "",
        var quadrangular_conteudo_dos_cultos: String = "",

        var quadrangular_celulas: String = "",
        var quadrangular_conteudo_das_celulas : String = "",


        //Greg barbearia
        var gregbarbearia_empresa: String= "",
        var gregbarbearia_historia_da_empresa: String= "",

        var gregbarbearia_promocoes : String= "",
        var gregbarbearia_conteudo_de_promocoes : String= "",

        var gregbarbearia_servicos : String = "",
        var gregbarbearia_conteudo_de_servicos: String = ""



)


