package br.com.guiacistore.lojas.lilidoces

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import kotlinx.android.synthetic.main.evolution_activity.*

class LiliHistoriaActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.lili_historia_activity)

        supportActionBar?.title = "História"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F




    }
}