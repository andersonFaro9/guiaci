package br.com.guiacistore.lojas
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import br.com.guiacistore.utils.ITextIsSelectable
import br.com.guiacistore.utils.Invisible
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_venivici.*


/**
 * Created by faro on 12/14/17.
 */

class VeniviciActvity : AppCompatActivity(), IFirebase, Invisible, ITextIsSelectable{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_venivici)
        doDatabaseInstance(1)
        implementTextSelectable()

        verificaConexaoDaInternet()

        if (!verificaConexaoDaInternet()) {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ops... sem conexão com a internet")
            builder.setMessage("Saia um pouco, tome um café e conecte sua internet.")
            builder.setIcon(R.drawable.emoji_triste)
            builder.setPositiveButton("tentar novamente") { dialog, which -> finish() }
            veniviciProgressBar?.visibility = View.INVISIBLE
            builder.show()

        }


    }


    private fun verificaConexaoDaInternet(): Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    override fun implementTextSelectable() {
        venivici_historia_da_empresa?.setTextIsSelectable(true)
        venivici_conteudo_de_promocoes?.setTextIsSelectable(true)
        venivici_conteudo_de_servicos?.setTextIsSelectable(true)


    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?

        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {

        //val detalhes = LojasModel()

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                    for (d in dataSnapshot?.children!!) {

                        val cliente = d.getValue(LojasModel::class.java)

                        venivici_empresa.text = cliente?.venivici_empresa
                        venivici_historia_da_empresa.text = cliente?.venivici_historia_da_empresa

                        venivici_promocoes.text = cliente?.venivici_promocoes
                        venivici_conteudo_de_promocoes.text = cliente?.venivici_conteudo_de_promocoes

                        venivici_servicos.text = cliente?.venivici_servicos
                        venivici_conteudo_de_servicos.text = cliente?.venivici_conteudo_de_servicos

                        veniviciProgressBar?.visibility = View.INVISIBLE

                    }

            }


            override fun onCancelled(databaseError: DatabaseError?) {

                Log.d("onCancelled", "error...", databaseError?.toException())

            }

        })

        return true

    }


}



