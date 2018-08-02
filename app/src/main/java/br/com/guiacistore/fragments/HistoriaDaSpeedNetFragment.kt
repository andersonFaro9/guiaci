package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFabFloatingAction
import br.com.guiacistore.interfaces.ITextIsSelectable
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_historia_da_speednet.*

class HistoriaDaSpeedNetFragment : Fragment(), IFirebase, ITextIsSelectable, IFabFloatingAction {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)
        //flutuarBotaoDeContato()
        return inflater.inflate(R.layout.fragment_historia_da_speednet, container, false)

    }

    override fun flutuarBotaoDeContato() {

//        floatingActionButton?.setOnClickListener { view ->
//
//            val context:Context? = null
//            Toast.makeText(context, "teste", Toast.LENGTH_SHORT).show()
//            val intent = Intent(context, VeniviciActivity::class.java)
//            startActivity(intent)
//        }

    }


    override fun implementTextSelectable() {
        speednet_historia_da_empresa?.setTextIsSelectable(true)
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

                    val cliente = d.getValue(LojasModel::class.java)

                    speednet_historia_da_empresa?.text = cliente?.speednet_historia_da_empresa


                }
                speednetHistoriaProgressBar?.visibility = View.INVISIBLE
                implementTextSelectable()

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())
            }

        })

        return true
    }


}