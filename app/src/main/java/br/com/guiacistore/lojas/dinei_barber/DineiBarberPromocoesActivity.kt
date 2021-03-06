package br.com.guiacistore.lojas.dinei_barber

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
import kotlinx.android.synthetic.main.auto_escola_franca_activity_promocoes.*
import kotlinx.android.synthetic.main.dinei_activity_promocoes.*
import java.util.*

class DineiBarberPromocoesActivity: AppCompatActivity(), IFirebase, IConexaoComInternet {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("lojas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Promoções"

        setContentView(R.layout.dinei_activity_promocoes)

        doDatabaseInstance(1)
        conecta()

    }

    override fun  conecta() {
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetworkInfo = cm.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected){
            dinei_progressBar?.visibility = View.VISIBLE
        }

        else {
            exibirMensagem("sem conexão com a internet")
            startActivity(Intent(this, ConexaoComInternet::class.java ))
        }


    }



    override fun doDatabaseInstance(id: Int): Boolean {

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                val listView = findViewById<ListView>(R.id.listView)

                val listaModel: ArrayList<ListaModel> = ArrayList()

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDados::class.java)

                    with(listaModel){
                        dinei_promocoes?.text = cliente?.dinei_promocoes
                    }

                    dinei_progressBar?.visibility = View.INVISIBLE

                }
           }




            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }




}
