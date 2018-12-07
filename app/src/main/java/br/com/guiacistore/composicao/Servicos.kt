package br.com.guiacistore.composicao

import br.com.guiacistore.model.dados.ListaModel

class Servicos {

    val lista = ArrayList<ListaModel>()

    fun exibirParceirosDaBlueWay() {

        // Lista dos parceiros em Pojuca

        var listaDeparceirosDaBlueWay = ListaModel("Unidade de Pojuca", "Tel: 99628-7958", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Academia Evolution", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaModel("", "Escola Surpresa", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaModel("", "Colégio 29 de Julho", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaModel("", "Escola Betel", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

//        Lista dos parceiros em Catu

        listaDeparceirosDaBlueWay = ListaModel("Unidade de Catu", "Tel: 99694-6672", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Halliburton", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Escola Ágappe", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Escola Traços e Letras", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaModel("", "Escola da Tia Lia", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Escola da Tia Margô", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaModel("", "Colégio Athena", "", 0)
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaModel("", "Filhote de Ogro", "", 0)
        lista.add(listaDeparceirosDaBlueWay)

    }

    fun exibirParceirosDaPubliCart() {

        // Lista dos parceiros em Alagoinhas

        var  listaDeparceirosDaPubliCart = ListaModel("Welson Saxofonista", "Tel: (75) 99878-1224", "", 0)
        lista.add(listaDeparceirosDaPubliCart)

        listaDeparceirosDaPubliCart = ListaModel(" Centro de Treinamento Bruno Melo(CT das Águas)", "Tel: (71) 99735-7450", "", 0)
        lista.add(listaDeparceirosDaPubliCart)

    }



    fun exibirServicosDaPubliCart() {

        var  listaDeServicosDaPubliCart = ListaModel("Comunicação Visual", "A comunicação, os detalhes e cores ficam ainda mais bonito!", "", 0)
        lista.add(listaDeServicosDaPubliCart)

        listaDeServicosDaPubliCart = ListaModel(" Propaganda", "Sua propaganda com profissionais de verdade", "", 0)
        lista.add(listaDeServicosDaPubliCart)

        listaDeServicosDaPubliCart = ListaModel(" Redes sociais", "O mundo é digital e todos estão nas redes sociais", "", 0)
        lista.add(listaDeServicosDaPubliCart)

    }




    fun exibirServicosDaEpg() {

        var  listaServicosDaEpg = ListaModel("Carimbos", "Fazemos carimbos personalizados", "", 0)
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaModel(" Cartões de visita", "Vem ver de perto e veja nossos exemplares", "", 0)
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaModel("Chaveiros", "Do jeito que você desejar", "", 0)
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaModel(" Impressão em camisas", "Camisas com fotos e frases criativas", "", 0)
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaModel(" Sacolas", "Sacolas de papel, sacolas de plástico, venha conferir", "", 0)
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaModel(" Folhetos", "Faça-nos uma visita e veja  nosso catálogo", "", 0)
        lista.add(listaServicosDaEpg)



        listaServicosDaEpg = ListaModel(" Bolsas", "Fazemos diversos tipos de bolsas", "", 0)
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaModel(" Taças", "Taças personalizadas", "", 0)
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaModel(" Imã de geladeira", " Criamos um imã divertido para você", "", 0)
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaModel(" Banner", " Diversos tipos de banner: banner de lona, oxford, entre outros ", "", 0)
        lista.add(listaServicosDaEpg)




    }



}