package br.com.guiacistore.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class ParceirosDaBlueWayFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_blue_way)

        supportActionBar?.title = "Blue Way Idiomas"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F





    }






}
