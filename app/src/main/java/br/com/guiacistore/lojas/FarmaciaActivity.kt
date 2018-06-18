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
import kotlinx.android.synthetic.main.loja_farmacia.*

/**
 * Created by faro on 12/14/17.
 */

class FarmaciaActivity : AppCompatActivity(), IFirebase, Invisible, ITextIsSelectable {

    override fun implementTextSelectable() {
        resumo_promocoes_farmacia.setTextIsSelectable(true)
        resumo_novidades_farmacia.setTextIsSelectable(true)
        resumo_historia.setTextIsSelectable(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_farmacia)
        doDatabaseInstance(1)
        implementTextSelectable()


    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun doDatabaseInstance(id: Int): Boolean {

        val detalhes = LojasModel()

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    titulo_promocoes_farmacia.text = cliente?.titulo_promocoes_farmacia
                    resumo_promocoes_farmacia.text = cliente?.resumo_promocoes_farmacia

                    novidades_farmacia.text = cliente?.novidades_farmacia
                    resumo_novidades_farmacia.text = cliente?.resumo_novidades_farmacia

                }

                farmaciaProgressBar?.visibility = transformProgressBarInvisible()

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())

            }

        })

        return true
    }





}



