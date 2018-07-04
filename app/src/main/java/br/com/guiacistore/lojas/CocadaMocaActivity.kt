package br.com.guiacistore.lojas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.guiacistore.R
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import br.com.guiacistore.utils.ITextIsSelectable
import br.com.guiacistore.utils.Invisible
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_carros.*

/**
 * Created by faro on 12/14/17.
 */

class CocadaMocaActivity : AppCompatActivity() , IFirebase, Invisible, ITextIsSelectable {

    override fun implementTextSelectable() {

        resumo_promocoes_carros.setTextIsSelectable(true)
        resumo_novidades_carros.setTextIsSelectable(true)
        resumo_carros.setTextIsSelectable(true)
    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_carros)

        doDatabaseInstance(1)
        implementTextSelectable()

    }

    override fun doDatabaseInstance(id: Int): Boolean {

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    titulo_promocoes_carros.text = cliente?.titulo_promocoes_carros
                    resumo_promocoes_carros.text = cliente?.resumo_promocoes_carros

                    novidades_carros.text = cliente?.novidades_carros
                    resumo_novidades_carros.text = cliente?.resumo_novidades_carros
                }


                carrosProgressBar.visibility = transformProgressBarInvisible()


            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
