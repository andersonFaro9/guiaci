package br.com.guiacistore.lojas.jsbarbearia

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.interfaces.IConexaoComInternet
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDados
import br.com.guiacistore.model.dados.ListaModel
import br.com.guiacistore.sem_conexao.ConexaoComInternet
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.jsbarbearia_promocoes.*
import java.util.ArrayList

class JsBarbeariaPromocoesActivity : AppCompatActivity(),  IFirebase, IConexaoComInternet {

    override fun  conecta() {

        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetworkInfo = cm.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) jsbarbearia_progressBar?.visibility = View.VISIBLE

        else {
            exibirMensagem("sem conexão com a internet")
            startActivity(Intent(this, ConexaoComInternet::class.java ))
        }

    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jsbarbearia_promocoes)

        supportActionBar?.title = "Promoções"

        doDatabaseInstance(1)
        conecta()
    }


    override fun doDatabaseInstance(id: Int): Boolean {

        jsbarbearia_progressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {


                val listView = findViewById<ListView>(R.id.listView)

                val listaModel: ArrayList<ListaModel> = ArrayList()

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDados::class.java)
                    with(listaModel) {
                        add(br.com.guiacistore.model.dados.ListaModel(br.com.guiacistore.funcional.mostrarPromocao(cliente?.jsbarbearia_promocoes1.toString()), "", "", br.com.guiacistore.R.drawable.ok_promocao))

                        add(br.com.guiacistore.model.dados.ListaModel(br.com.guiacistore.funcional.mostrarPromocao(cliente?.jsbarbearia_promocoes2.toString()), "", "", br.com.guiacistore.R.drawable.ok_promocao))

                        add(br.com.guiacistore.model.dados.ListaModel(br.com.guiacistore.funcional.mostrarPromocao(cliente?.jsbarbearia_promocoes3.toString()), "", "", br.com.guiacistore.R.drawable.ok_promocao))

                        add(br.com.guiacistore.model.dados.ListaModel(br.com.guiacistore.funcional.mostrarPromocao(cliente?.jsbarbearia_promocoes4.toString()), "", "", br.com.guiacistore.R.drawable.ok_promocao))
                        add(br.com.guiacistore.model.dados.ListaModel(br.com.guiacistore.funcional.mostrarPromocao(cliente?.jsbarbearia_promocoes5.toString()), "", "", br.com.guiacistore.R.drawable.ok_promocao))

                        listView.adapter = br.com.guiacistore.adapter.ListaPromocoesImagemTextoSimplesAdapter(applicationContext, listaModel)
                    }

                    jsbarbearia_progressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

}