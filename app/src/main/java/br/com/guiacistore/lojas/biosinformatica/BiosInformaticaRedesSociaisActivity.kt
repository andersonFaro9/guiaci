package br.com.guiacistore.lojas.biosinformatica
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biosinformatica.extensions.mostrarRedesSociais
import br.com.guiacistore.lojas.evolution.extensions.mostrarRedesSociais


class BiosInformaticaRedesSociaisActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bios_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        mostrarRedesSociais()



    }



}