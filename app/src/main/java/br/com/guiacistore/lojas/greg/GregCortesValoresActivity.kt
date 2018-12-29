package br.com.guiacistore.lojas.greg

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.greg.extensions.mostraNossosServicos


class GregCortesValoresActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Cortes e valores"

        setContentView(R.layout.greg_activity)

        mostraNossosServicos()



    }


}
