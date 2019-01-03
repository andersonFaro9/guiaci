package br.com.guiacistore.lojas.greg
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.greg.extensions.mostrarRedesSociais


class GregRedesSociaisActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.greg_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        mostrarRedesSociais()

    }




}