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
import kotlinx.android.synthetic.main.fragment_planos_links_dedicado.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LinkDedicadoSpeedNetFragment : Fragment(), IFirebase, IConexaoComAInternet {

    override fun verificaConexaoComAInternet(): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        doDatabaseInstance(1)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planos_links_dedicado, container, false)
    }

    override fun doDatabaseInstance(id: Int): Boolean {

        if (!verificaConexaoComAInternet()) {
            speednetPlanoDedicadoProgressBar?.visibility = View.VISIBLE

        }

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    speednet_link_dedicado?.text = cliente?.speednet_link_dedicado

                }

                speednetPlanoDedicadoProgressBar?.visibility = View.INVISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }


}
