package br.com.guiacistore.lojas.evolution
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.evolution.extensions.mostrarRedesSociais


class EvolutionRedesSociaisActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.evolution_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        mostrarRedesSociais()



    }



}