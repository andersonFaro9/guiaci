package br.com.guiacistore.lojas.dinei_barber

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class DineiBarberHistoriaActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinei_historia_activity)

        supportActionBar?.title = "História"
    }



}