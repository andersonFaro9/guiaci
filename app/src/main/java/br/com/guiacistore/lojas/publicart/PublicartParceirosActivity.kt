package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.publicart.extensions.mostrarParceiros


class PublicartParceirosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Parceiros"

        setContentView(R.layout.publicart_activity)

        mostrarParceiros ()

    }


}