package br.com.guiacistore.composicao

import br.com.guiacistore.model.ListaSimplesCustomModel

class ListaDeParceiros {

    val listaDeParceiros = ArrayList<ListaSimplesCustomModel>()

    fun exibirParceirosDaBlueWay() {

        // Lista dos parceiros em Pojuca

        var listaDeparceirosDaBlueWay = ListaSimplesCustomModel("Unidade de Pojuca", "Tel: 99628-7958", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Academia Evolution", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Surpresa", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Colégio 29 de Julho", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Betel", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

//        Lista dos parceiros em Catu

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("Unidade de Catu", "Tel: 99694-6672", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Halliburton", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Ágappe", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola Traços e Letras", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola da Tia Lia", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Escola da Tia Margô", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Colégio Athena", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = ListaSimplesCustomModel("", "Filhote de Ogro", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

    }

    fun exibirParceirosDaPubliCart() {

        // Lista dos parceiros em Alagoinhas

        var  listaDeparceirosDaPubliCart = ListaSimplesCustomModel("Welson Saxofonista", "Tel: (75) 99878-1224", "")
        listaDeParceiros.add(listaDeparceirosDaPubliCart)

        listaDeparceirosDaPubliCart = ListaSimplesCustomModel(" Centro de Treinamento Bruno Melo(CT das Águas)", "Tel: (71) 99735-7450", "")
        listaDeParceiros.add(listaDeparceirosDaPubliCart)

    }
}