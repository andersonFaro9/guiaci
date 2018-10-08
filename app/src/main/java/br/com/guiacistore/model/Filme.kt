package br.com.guiacistore.model

class Filme {

    var tituloFilme: String? = null
    var genero: String? = null
    var ano: String? = null

    constructor() {

    }

    constructor(tituloFilme: String, genero: String, ano: String) {
        this.tituloFilme = tituloFilme
        this.genero = genero
        this.ano = ano
    }
}
