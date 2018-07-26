package br.com.guiacistore.fragments


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IConexaoComAInternet
import br.com.guiacistore.interfaces.ITextIsSelectable
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_historia_da_barbearia_greg.*


class HistoriaDaBarbeariaGregFragment : Fragment(), IFirebase, IConexaoComAInternet, ITextIsSelectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)


        return inflater.inflate(R.layout.fragment_historia_da_barbearia_greg, container, false)
    }

    override fun implementTextSelectable() {
        gregbarbearia_historia_da_empresa?.setTextIsSelectable(true)
    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun verificaConexaoComAInternet(): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun doDatabaseInstance(id: Int): Boolean {




            barbeariaGregHistoriaProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    gregbarbearia_historia_da_empresa?.text = cliente?.gregbarbearia_historia_da_empresa

                    barbeariaGregHistoriaProgressBar?.visibility = View.INVISIBLE
                }

                implementTextSelectable()

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())
            }

        })

        return true
    }


}


