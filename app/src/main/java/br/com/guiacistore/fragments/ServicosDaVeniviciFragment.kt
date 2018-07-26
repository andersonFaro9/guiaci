package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R


class ServicosDaVeniviciFragment : Fragment() {

//    override val databaseInstance: FirebaseDatabase?
//        get() = FirebaseDatabase.getInstance()
//
//    override val referenciaFirebase: DatabaseReference?
//        get() = databaseInstance?.getReference("clientes")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //doDatabaseInstance(1)
        return inflater.inflate(R.layout.fragment_servicos_da_venivici, container, false)
    }
//    override fun doDatabaseInstance(id: Int): Boolean {
//
//
//            veniviciPromocoesProgressBar?.visibility = View.VISIBLE
//
//
//        referenciaFirebase?.child(id.toString())
//
//        referenciaFirebase?.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(dataSnapshot: DataSnapshot?) {
//
//                for (d in dataSnapshot?.children!!) {
//
//
//
//                    /*
//
//                    Venha com seu filho na semana dos pais e ganhe um mega desconto de 10% no seu corte!!. Ligue para o telefone
//                    99648-1470 e fique por dentro, "paizão"
//                     */
//
//
//                    val cliente = d.getValue(LojasModel::class.java)
//
//                    val listaApp  = listOf(
//                            //Mostra a lista de serviços da venivici
//                            cliente?.venivici_produto_1.toString(),cliente?.venivici_produto_2.toString(),
//                            cliente?.venivici_produto_3.toString(),cliente?.venivici_produto_4.toString(),
//                            cliente?.venivici_produto_5.toString(),cliente?.venivici_produto_6.toString(),
//                            cliente?.venivici_produto_7.toString(),cliente?.venivici_produto_8.toString(),
//                            cliente?.venivici_produto_9.toString(),cliente?.venivici_produto_10.toString(),
//                            cliente?.venivici_produto_11.toString(),cliente?.venivici_produto_12.toString(),
//                            cliente?.venivici_produto_13.toString(),cliente?.venivici_produto_14.toString(),
//                            cliente?.venivici_produto_15.toString(),cliente?.venivici_produto_16.toString(),
//                            cliente?.venivici_produto_17.toString(),cliente?.venivici_produto_18.toString(),
//                            cliente?.venivici_produto_19.toString(),cliente?.venivici_produto_20.toString(),
//                            cliente?.venivici_produto_21.toString(),cliente?.venivici_produto_22.toString()
//
//                    )
//                    veniviciPromocoesProgressBar?.visibility = View.INVISIBLE
//
//                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(activity, android.R.layout.simple_list_item_1, listaApp)
//                    venivici_servicos?.adapter = arrayAdapter //<- com as extensions
//
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