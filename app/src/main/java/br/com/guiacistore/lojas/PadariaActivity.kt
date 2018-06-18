package br.com.guiacistore.lojas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.R.id.*
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import br.com.guiacistore.utils.ITextIsSelectable
import br.com.guiacistore.utils.Invisible
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_padaria.*

/**
 * Created by faro on 12/14/17.
 */

class PadariaActivity : AppCompatActivity() , IFirebase, Invisible, ITextIsSelectable {

    override fun implementTextSelectable() {
            resumo_promocoes_padaria.setTextIsSelectable(true)
            resumo_novidades_padaria.setTextIsSelectable(true)
            resumo_historia.setTextIsSelectable(true)
    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_padaria)

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

                    titulo_promocoes_padaria.text = cliente?.titulo_promocoes_padaria
                    resumo_promocoes_padaria.text = cliente?.resumo_promocoes_padaria

                    novidades_padaria.text = cliente?.novidades_padaria
                    resumo_novidades_padaria.text = cliente?.resumo_novidades_padaria
                }


                padariaProgressBar.visibility = transformProgressBarInvisible()


            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
