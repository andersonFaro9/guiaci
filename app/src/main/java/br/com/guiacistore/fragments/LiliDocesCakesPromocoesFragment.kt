package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.lili_doces_cakes_fragment_promocoes.*


class LiliDocesCakesPromocoesFragment : Fragment(), IFirebase {


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)
        return inflater.inflate(R.layout.lili_doces_cakes_fragment_promocoes, container, false)
    }



    override fun doDatabaseInstance(id: Int): Boolean {


        promocoesLiliDocesCakesProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasFireBaseModel::class.java)
                    lili_doces_cakes_promocoes?.text =  cliente?.lili_doces_cakes_promocoes

                    promocoesLiliDocesCakesProgressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}