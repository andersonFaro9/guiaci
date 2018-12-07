package br.com.guiacistore.lojas.blueway

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDadosFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.blue_way_activity_promocoes.*

class BlueWayPromocoesActivity : AppCompatActivity(), IFirebase {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")




    override fun doDatabaseInstance(id: Int): Boolean {

        blue_way_progressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDadosFireBaseModel::class.java)



                            blue_way_promocoes?.text = cliente?.blue_way_promocoes


                    blue_way_progressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doDatabaseInstance(1)
        setContentView(R.layout.blue_way_activity_promocoes)
        supportActionBar?.title = "Promoções Blue Way"
    }
}