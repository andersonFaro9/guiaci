package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R


class ServicosDaBarbeariaGregFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_servicos_da_barbearia_greg, container, false)
    }
//    override fun doDatabaseInstance(id: Int): Boolean {
//
//           gregBarbeariaProgressBar?.visibility = View.VISIBLE
//
//        referenciaFirebase?.child(id.toString())
//
//        referenciaFirebase?.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot?) {
//
//                for (d in dataSnapshot?.children!!) {
//
//                    val cliente = d.getValue(LojasModel::class.java)
//
//                    val listaApp  = listOf(
//                            //Mostra a lista de serviços da  Barbearia do Greg
//                            cliente?.gregbarbearia_servico1,cliente?.gregbarbearia_servico2,
//                            cliente?.gregbarbearia_servico3,cliente?.gregbarbearia_servico4,
//                            cliente?.gregbarbearia_servico5, cliente?.gregbarbearia_servico6
//                    )
//
//                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listaApp)
//                    barbearia_do_greg_servicos?.adapter = arrayAdapter //<- com as extensions
//
//                    gregBarbeariaProgressBar?.visibility = View.INVISIBLE
//
//                }
//
//            }
//
//
//
//            override fun onCancelled(databaseError: DatabaseError?) {
//                Log.d("onCancelled", "error...", databaseError?.toException())
//
//
//            }
//
//        })
//
//        return true
//    }

}
