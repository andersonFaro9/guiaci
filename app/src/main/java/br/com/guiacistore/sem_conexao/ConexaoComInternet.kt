package br.com.guiacistore.sem_conexao

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IConexaoComInternet
import kotlinx.android.synthetic.main.sem_conexao.*

class ConexaoComInternet : AppCompatActivity(), IConexaoComInternet {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Promoções"

        setContentView(R.layout.sem_conexao)

        conecta()

    }


    override fun conecta () {


        conectar?.setOnClickListener { view ->

            val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetworkInfo = cm.activeNetworkInfo

            if (activeNetworkInfo != null && activeNetworkInfo.isConnected)  finish()

            else  Snackbar.make(view, "Sem conexão com a internet!!", Snackbar.LENGTH_LONG).show()

        }
    }
}