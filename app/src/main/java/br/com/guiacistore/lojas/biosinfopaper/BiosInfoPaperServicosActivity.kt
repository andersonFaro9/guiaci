package br.com.guiacistore.lojas.biosinfopaper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biosinfopaper.extensions.mostrarServicos

class BiosInfoPaperServicosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Serviços"

        setContentView(R.layout.bios_servicos_activity)

        mostrarServicos()

    }


}
