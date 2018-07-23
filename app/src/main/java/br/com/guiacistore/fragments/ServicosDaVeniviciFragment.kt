package br.com.guiacistore.fragments


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IConexaoComAInternet
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_promocoes_da_venivici.*
import kotlinx.android.synthetic.main.fragment_servicos_da_venivici.*


class ServicosDaVeniviciFragment : Fragment(), Invisible, IFirebase,  IConexaoComAInternet {

    override fun verificaConexaoComAInternet(): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        doDatabaseInstance(1)
        return inflater.inflate(R.layout.fragment_servicos_da_venivici, container, false)
    }
    override fun doDatabaseInstance(id: Int): Boolean {

        if (!verificaConexaoComAInternet()) {

            veniviciPromocoesProgressBar.visibility = View.VISIBLE
        }


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(
                            //Mostra a lista de serviços da venivici
                            cliente?.venivici_produto_1,cliente?.venivici_produto_2,
                            cliente?.venivici_produto_3,cliente?.venivici_produto_4,
                            cliente?.venivici_produto_5,cliente?.venivici_produto_6,
                            cliente?.venivici_produto_7,cliente?.venivici_produto_8

                    )
                    veniviciPromocoesProgressBar?.visibility = View.INVISIBLE

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(context, android.R.layout.simple_list_item_1, listaApp)
                    venivici_servicos?.adapter = arrayAdapter //<- com as extensions


                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

}
