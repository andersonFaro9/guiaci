package br.com.guiacistore.lojas.quadrangular
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.evolution.*
import br.com.guiacistore.lojas.quadrangular.extensions.mostrarRedesSociais

class QuadrangularRedeSocialActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.quadrangular_redesocial)

        supportActionBar?.title = "Redes sociais"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarRedesSociais()


    }







}


