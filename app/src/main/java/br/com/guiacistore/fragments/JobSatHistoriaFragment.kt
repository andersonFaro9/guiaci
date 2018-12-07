package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDadosFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.greg_barbearia_fragment_historia.*
import kotlinx.android.synthetic.main.jobsat_fragment_historia.*


class JobSatHistoriaFragment : Fragment(), IFirebase {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)


        return inflater.inflate(R.layout.jobsat_fragment_historia, container, false)
    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {

            barbeariaGregHistoriaProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDadosFireBaseModel::class.java)

                    jobsat_historia_da_empresa?.text = cliente?.jobsat_historia_da_empresa

                    jobSatHistoriaProgressBar?.visibility = View.INVISIBLE
                }



            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())
            }

        })

        return true
    }


}


