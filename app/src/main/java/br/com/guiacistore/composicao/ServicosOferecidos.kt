package br.com.guiacistore.composicao

import br.com.guiacistore.model.ListaSimplesCustomModel


class ServicosOferecidos {

    val lista = ArrayList<ListaSimplesCustomModel>()

    fun exibirServicosDaEpg() {

        var  listaServicosDaEpg = ListaSimplesCustomModel("Carimbos", "Fazemos carimbos personalizados", "")
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaSimplesCustomModel(" Cartões de visita", "Vem ver de perto e veja nossos exemplares", "")
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaSimplesCustomModel("Chaveiros", "Do jeito que você desejar", "")
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaSimplesCustomModel(" Impressão em camisas", "Camisas com fotos e frases criativas", "")
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaSimplesCustomModel(" Sacolas", "Sacolas de papel, sacolas de plástico, venha conferir", "")
        lista.add(listaServicosDaEpg)


        listaServicosDaEpg = ListaSimplesCustomModel(" Folhetos", "Faça-nos uma visita e veja  nosso catálogo", "")
        lista.add(listaServicosDaEpg)



        listaServicosDaEpg = ListaSimplesCustomModel(" Bolsas", "Fazemos diversos tipos de bolsas", "")
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaSimplesCustomModel(" Taças", "Taças personalizadas", "")
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaSimplesCustomModel(" Imã de geladeira", " Criamos um imã divertido para você", "")
        lista.add(listaServicosDaEpg)

        listaServicosDaEpg = ListaSimplesCustomModel(" Banner", " Diversos tipos de banner: banner de lona, oxford, entre outros ", "")
        lista.add(listaServicosDaEpg)




    }
}