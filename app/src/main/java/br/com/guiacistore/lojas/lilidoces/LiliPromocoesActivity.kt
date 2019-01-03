package br.com.guiacistore.lojas.lilidoces

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.interfaces.IConexaoComInternet
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDados
import br.com.guiacistore.model.dados.ListaModel
import br.com.guiacistore.sem_conexao.ConexaoComInternet
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.lili_promocoes_activity.*
import java.util.ArrayList

class LiliPromocoesActivity : AppCompatActivity(), IFirebase, IConexaoComInternet {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.lili_promocoes_activity)

        supportActionBar?.title = "Promoções"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        doDatabaseInstance(1)
        conecta()
    }



    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {


                val listView = findViewById<ListView>(R.id.listView)

                val listaModel: ArrayList<ListaModel> = ArrayList()

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDados::class.java)

                    lili_promocoes?.text =  cliente?.lili_doces_cakes_promocoes
                    liliProgressBar.visibility = View.INVISIBLE

                }


            }




            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }


    override fun conecta() {
        var cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var activeNetworkInfo = cm.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) liliProgressBar?.visibility = View.VISIBLE

        else {
            exibirMensagem("sem conexão com a internet")
            startActivity(Intent(this, ConexaoComInternet::class.java ))
        }
    }


}