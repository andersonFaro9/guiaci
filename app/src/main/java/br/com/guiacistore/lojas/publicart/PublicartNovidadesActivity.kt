package br.com.guiacistore.lojas.publicart
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.publicart_novidades.*


class PublicartNovidadesActivity : AppCompatActivity(), IFirebase{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_novidades)
        doDatabaseInstance(1)
        supportActionBar?.title = "Publicart"

    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun doDatabaseInstance(id: Int): Boolean {
        publicart_progressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasFireBaseModel::class.java)

                    publicartNovidades?.text = cliente?.publicartNovidades


                    publicart_progressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}



