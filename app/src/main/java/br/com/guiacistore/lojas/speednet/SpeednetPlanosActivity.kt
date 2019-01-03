package br.com.guiacistore.lojas.speednet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.speednet.extensions.mostraPlanos


class SpeednetPlanosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Planos"

        setContentView(R.layout.speednet_activity)

        mostraPlanos()

    }


}
