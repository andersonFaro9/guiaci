package br.com.guiacistore.composicao

import br.com.guiacistore.model.BlueWayModel

class ListaDeParceirosBlueWay {

    val listaDeParceiros = ArrayList<BlueWayModel>()

    fun exibirParceirosDaBlueWay() {

        // Lista dos parceiros em Pojuca

        var listaDeparceirosDaBlueWay = BlueWayModel("Unidade de Pojuca", "Tel: 99628-7958", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Academia Evolution", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola Surpresa", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = BlueWayModel("", "Colégio 29 de Julho", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola Betel", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)


//        Lista dos parceiros em Catu
        listaDeparceirosDaBlueWay = BlueWayModel("Unidade de Catu", "Tel: 99694-6672", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Halliburton", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola Ágappe", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola Traços e Letras", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola da Tia Lia", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Escola da Tia Margô", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

        listaDeparceirosDaBlueWay = BlueWayModel("", "Colégio Athena", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)
        listaDeparceirosDaBlueWay = BlueWayModel("", "Filhote de Ogro", "")
        listaDeParceiros.add(listaDeparceirosDaBlueWay)

    }
}