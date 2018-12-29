package br.com.guiacistore.lojas.greg

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R




class GregCartaoFidelidadeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Cartão fidelidade"

        setContentView(R.layout.greg_cartao_fidelidade_activity)

    }



}
