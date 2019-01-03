package br.com.guiacistore.lojas.lilidoces

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.lilidoces.extensions.mostrarServicos

class LiliDocesTortasServicosActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Doces e tortas"

        setContentView(R.layout.lili_servicos_activity)
        mostrarServicos()
    }
}