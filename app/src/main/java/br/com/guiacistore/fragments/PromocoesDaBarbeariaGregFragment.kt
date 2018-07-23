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
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_promocoes_da_barbearia_greg.*


class PromocoesDaBarbeariaGregFragment : Fragment(), IFirebase, IConexaoComAInternet {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        doDatabaseInstance(1)
        return inflater.inflate(R.layout.fragment_promocoes_da_barbearia_greg, container, false)
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

        if (!verificaConexaoComAInternet()) {
            gregBarbeariaProgressBar?.visibility = View.VISIBLE

        }


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    gregbarbearia_promocoes?.text =  cliente?.gregbarbearia_promocoes

                    gregBarbeariaProgressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
