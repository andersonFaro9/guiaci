package br.com.guiacistore.lojas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import br.com.guiacistore.utils.ITextIsSelectable
import br.com.guiacistore.utils.Invisible
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_speednet.*

/**
 * Created by faro on 12/14/17.
 */

class IgrejaQuadrangularActivity : AppCompatActivity() , IFirebase, Invisible, ITextIsSelectable {

    override fun implementTextSelectable() {
        speednet_historia_da_empresa.setTextIsSelectable(true)
        speednet_conteudo_de_promocoes.setTextIsSelectable(true)
        speednet_conteudo_de_servicos.setTextIsSelectable(true)
    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_quadrangular)

        doDatabaseInstance(1)

        implementTextSelectable()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {



        }


        return super.onOptionsItemSelected(item)
    }


    override fun doDatabaseInstance(id: Int): Boolean {

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    speednet_empresa.text = cliente?.speednet_empresa
                    speednet_historia_da_empresa.text = cliente?.speednet_historia_da_empresa

                    speednet_promocoes.text = cliente?.speednet_promocoes
                    speednet_conteudo_de_promocoes.text = cliente?.speednet_conteudo_de_promocoes

                    speednet_servicos.text = cliente?.speednet_servicos
                    speednet_conteudo_de_servicos.text = cliente?.speednet_conteudo_de_servicos
                }

                speednetProgressBar.visibility = transformProgressBarInvisible()

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())

            }

        })

        return true
    }

}
