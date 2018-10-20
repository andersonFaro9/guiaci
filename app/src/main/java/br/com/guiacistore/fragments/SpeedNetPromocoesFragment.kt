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
import kotlinx.android.synthetic.main.speednet_fragment_promocoes.*

class SpeedNetPromocoesFragment : Fragment(), IFirebase {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {


        speednetPromocoesProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModelFireBase::class.java)
                    speednet_promocoes?.text =  cliente?.speednet_promocoes


                }

                speednetPromocoesProgressBar?.visibility = View.INVISIBLE

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        doDatabaseInstance(1)

        ///speednet_promocoes?.justificationMode = JUSTIFICATION_MODE_INTER_WORD

        return inflater.inflate(R.layout.speednet_fragment_promocoes, container, false)
    }
}
