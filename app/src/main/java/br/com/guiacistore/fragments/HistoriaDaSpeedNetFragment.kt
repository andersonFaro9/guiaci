package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasModelFireBase
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_historia_da_speednet.*



class HistoriaDaSpeedNetFragment : Fragment(), IFirebase {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)

        return inflater.inflate(R.layout.fragment_historia_da_speednet, container, false)

    }



    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")





    override fun doDatabaseInstance(id: Int): Boolean {


            speednetHistoriaProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModelFireBase::class.java)

                    speednet_historia_da_empresa?.text = cliente?.speednet_historia_da_empresa



                }
                speednetHistoriaProgressBar?.visibility = View.INVISIBLE


            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())
            }

        })

        return true
    }


}