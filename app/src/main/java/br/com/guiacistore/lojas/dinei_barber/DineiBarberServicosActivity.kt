package br.com.guiacistore.lojas.dinei_barber

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.auto_escola_franca.extensions.mostrarServicos
import br.com.guiacistore.lojas.dinei_barber.extensions.mostrarServicos

class DineiBarberServicosActivity  : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.dinei_servicos_activity)

        supportActionBar?.title = "Cortes"

        mostrarServicos()
    }



}
