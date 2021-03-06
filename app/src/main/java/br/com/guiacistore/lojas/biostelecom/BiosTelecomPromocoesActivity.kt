package br.com.guiacistore.lojas.biostelecom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDados
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.biostelecom_activity_promocoes.*

class BiosTelecomPromocoesActivity : AppCompatActivity(), IFirebase {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("lojas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doDatabaseInstance(1)
        setContentView(R.layout.biostelecom_activity_promocoes)
        supportActionBar?.title = "Promoções"
    }

    override fun doDatabaseInstance(id: Int): Boolean {

        biostelecom_progressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDados::class.java)

                            biostelecom_promocoes?.text = cliente?.speednet_promocoes


                    biostelecom_progressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }





}