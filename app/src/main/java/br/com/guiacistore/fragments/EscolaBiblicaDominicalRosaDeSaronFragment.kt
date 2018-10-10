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
import kotlinx.android.synthetic.main.fragment_escola_biblica_rosa_de_saron.*


class EscolaBiblicaDominicalRosaDeSaronFragment : Fragment(), IFirebase {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun doDatabaseInstance(id: Int): Boolean {

        rosaDeSaronEscolaBiblicaProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    rosa_saron_escola_biblica_dominical?.text =  cliente?.rosa_saron_escola_biblica_dominical

                    rosaDeSaronEscolaBiblicaProgressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)
        return inflater.inflate(R.layout.fragment_escola_biblica_rosa_de_saron, container, false)
    }









}


