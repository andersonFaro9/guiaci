package br.com.guiacistore.lojas.multivixPojuca

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.lojas.multivixPojuca.extensions.mostrarServicos
import kotlinx.android.synthetic.main.multivix_activity.*

class MultivixPojucaInscricaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.multivix_activity)

        supportActionBar?.title = "Multivix - Polo Pojuca"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicos()
        exibirMensagem("Consulte regulamento ou entre em contato!!!")

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                //position == 2 ->  exibirMensagem("Acesse e inscreva-se: multivix.edu.br/ead/")

            }
        }
    }

}
