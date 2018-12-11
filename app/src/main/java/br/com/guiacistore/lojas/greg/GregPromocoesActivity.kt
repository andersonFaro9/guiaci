package br.com.guiacistore.lojas.greg


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDadosFireBaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.greg_promocoes.*


class GregPromocoesActivity : AppCompatActivity(), IFirebase, ICallNumber {


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.greg_promocoes)
        doDatabaseInstance(1)

        supportActionBar?.title = "Promoções"


    }



    override fun doDatabaseInstance(id: Int): Boolean {


            jsbarbeariaProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDadosFireBaseModel::class.java)
                    jsbarbearia_promocoes?.text =  cliente?.gregbarbearia_promocoes

                    jsbarbeariaProgressBar?.visibility = View.INVISIBLE
                }

            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_greg, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }
            R.id.ic_mapa -> {
                verMapa(Uri.parse("https://her.is/2G4so27"))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99648-1470")
        startActivity(callIntent)
    }



}
