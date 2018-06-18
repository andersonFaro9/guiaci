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
import kotlinx.android.synthetic.main.loja_chocolate.*



/**
 * Created by faro on 12/14/17.
 */

class ChocolateActivity : AppCompatActivity(), IFirebase, Invisible, ITextIsSelectable{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_chocolate)
        doDatabaseInstance(1)
        implementTextSelectable()

    }


    override fun implementTextSelectable() {
        resumo_promocoes_alfajor.setTextIsSelectable(true)
        resumo_novidades_alfajor.setTextIsSelectable(true)
        resumo_historia.setTextIsSelectable(true)


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

                    titulo_promocoes_alfajor.text = cliente?.titulo_promocoes_alfajor
                    resumo_promocoes_alfajor.text = cliente?.resumo_promocoes_alfajor

                    novidades_alfajor.text = cliente?.novidades_alfajor
                    resumo_novidades_alfajor.text = cliente?.resumo_novidades_alfajor

                }

                chocolateProgressBar?.visibility = transformProgressBarInvisible()


        }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())

            }

        })



        return true


    }







}



