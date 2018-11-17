package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.academia_evolution_fragment_promocoes.*


class AcademiaEvolutionPromocoesFragment : Fragment(), IFirebase {


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        doDatabaseInstance(1)


        return inflater.inflate(R.layout.academia_evolution_fragment_promocoes, container, false)
    }



    override fun doDatabaseInstance(id: Int): Boolean {


        promocoesAcademiaEvolutionProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasFireBaseModel::class.java)

                    val listaApp  = listOf(

                             cliente?.academia_evolution_promocao_1,  cliente?.academia_evolution_promocao_2,
                            cliente?.academia_evolution_promocao_3, cliente?.academia_evolution_promocao_4,
                            cliente?.academia_evolution_promocao_5
                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(context, android.R.layout.simple_list_item_1, listaApp)
                    academia_evolution_servicos?.adapter = arrayAdapter //<- com as extensions


                    promocoesAcademiaEvolutionProgressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
