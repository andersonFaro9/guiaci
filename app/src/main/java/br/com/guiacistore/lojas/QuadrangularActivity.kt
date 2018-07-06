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
import kotlinx.android.synthetic.main.loja_quadrangular.*

/**
 * Created by faro on 12/14/17.
 */

class QuadrangularActivity : AppCompatActivity() , IFirebase, Invisible, ITextIsSelectable {

    override fun implementTextSelectable() {
        quadrangular_historia_da_igreja.setTextIsSelectable(true)
        quadrangular_conteudo_dos_cultos.setTextIsSelectable(true)
        quadrangular_conteudo_das_celulas.setTextIsSelectable(true)
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
                    quadrangular_igreja.text = cliente?.quadrangular_igreja
                    quadrangular_historia_da_igreja.text = cliente?.quadrangular_historia_da_igreja

                    quadrangular_celulas.text = cliente?.quadrangular_celulas
                    quadrangular_conteudo_das_celulas.text = cliente?.quadrangular_conteudo_das_celulas

                    quadrangular_cultos.text = cliente?.quadrangular_cultos
                    quadrangular_conteudo_dos_cultos.text = cliente?.quadrangular_conteudo_dos_cultos
                }


                quadrangularProgressBar.visibility = transformProgressBarInvisible()


            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
