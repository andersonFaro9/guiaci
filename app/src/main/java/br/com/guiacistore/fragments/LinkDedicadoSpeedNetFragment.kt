package br.com.guiacistore.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_planos_links_dedicado.*


/**
 * A simple [Fragment] subclass.
 *
 */
class LinkDedicadoSpeedNetFragment : Fragment(), IFirebase {



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


            speednetPlanoDedicadoProgressBar?.visibility = View.VISIBLE



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