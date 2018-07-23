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
import android.widget.Toast
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IConexaoComAInternet
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_historia_da_venivici.*
import kotlinx.android.synthetic.main.fragment_servicos_da_barbearia_greg.*

class ServicosDaBarbeariaGregFragment : Fragment(), Invisible, IFirebase,  IConexaoComAInternet {

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
        return inflater.inflate(R.layout.fragment_servicos_da_barbearia_greg, container, false)
    }
    override fun doDatabaseInstance(id: Int): Boolean {

        if (!verificaConexaoComAInternet()) {
            veniviciHistoriaProgressBar?.visibility = View.VISIBLE
            Toast.makeText(context,"Sem internet, toma um café e volte depois", Toast.LENGTH_SHORT).show()
        }


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(
                            //Mostra a lista de serviços da  Barbearia do Greg
                            cliente?.gregbarbearia_servico1,cliente?.gregbarbearia_servico2,
                            cliente?.gregbarbearia_servico3,cliente?.gregbarbearia_servico4,
                            cliente?.gregbarbearia_servico5, cliente?.gregbarbearia_servico6
                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(context, android.R.layout.simple_list_item_1, listaApp)
                    barbearia_do_greg_servicos?.adapter = arrayAdapter //<- com as extensions

                    veniviciHistoriaProgressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

}
