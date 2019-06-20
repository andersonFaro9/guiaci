package br.com.guiacistore.lojas.MultivixPojuca
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.MultivixPojuca.extensions.mostrarServicosOferecidos

class MultivixPojucaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.multivix_activity)

        supportActionBar?.title = "Multivix - Polo Pojuca"

        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()


    }
}