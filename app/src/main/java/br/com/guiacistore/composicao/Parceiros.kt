package br.com.guiacistore.composicao

import br.com.guiacistore.model.ListaSimplesCustomModel

class Parceiros {

    val lista = ArrayList<ListaSimplesCustomModel>()

    fun exibirParceirosDaBlueWay() {

        // Lista dos parceiros em Pojuca

        var listaDeparceirosDaBlueWay = ListaSimplesCustomModel("Unidade de Pojuca", "Tel: 99628-7958", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Academia Evolution", "")
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Surpresa", "")
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Colégio 29 de Julho", "")
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Betel", "")
        lista.add(listaDeparceirosDaBlueWay)

//        Lista dos parceiros em Catu

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("Unidade de Catu", "Tel: 99694-6672", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Halliburton", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Ágappe", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Traços e Letras", "")
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola da Tia Lia", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola da Tia Margô", "")
        lista.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Colégio Athena", "")
        lista.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Filhote de Ogro", "")
        lista.add(listaDeparceirosDaBlueWay)

    }

    fun exibirParceirosDaPubliCart() {

        // Lista dos parceiros em Alagoinhas

        var  listaDeparceirosDaPubliCart = ListaSimplesCustomModel("Welson Saxofonista", "Tel: (75) 99878-1224", "")
        lista.add(listaDeparceirosDaPubliCart)

        listaDeparceirosDaPubliCart = ListaSimplesCustomModel(" Centro de Treinamento Bruno Melo(CT das Águas)", "Tel: (71) 99735-7450", "")
        lista.add(listaDeparceirosDaPubliCart)

    }



}