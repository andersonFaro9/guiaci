package br.com.guiacistore.lojas
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IConexaoComAInternet
import br.com.guiacistore.interfaces.IRedeSocial
import br.com.guiacistore.interfaces.ITextIsSelectable
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_quadrangular.*

/**
 * Created by faro on 12/14/17.
 */

class QuadrangularActivity : AppCompatActivity() , IFirebase, Invisible,
        ITextIsSelectable, IRedeSocial,
        IConexaoComAInternet  {

    override fun configuraFacebook(context: Context): Intent {
        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Igreja-do-Evangelho-Quadrangular-em-Pojuca-562024450639074/"))
        }
    }

    override fun abrirFacebook() {
        ic_facebook?.setOnClickListener {

            val facebookIntent = configuraFacebook(this@QuadrangularActivity)
            startActivity(facebookIntent)
        }
    }

    override fun configurarInstagram(context: Context): Intent {
        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/ieq_pojuca/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ieq_pojuca/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ieq_pojuca/"))
        }
    }

    override fun abrirInstagram() {
        ic_instagram?.setOnClickListener {

            val instagramIntent = configurarInstagram(this)
            startActivity(instagramIntent)
        }
    }

    override fun verificaConexaoDaInternet(): Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }



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

        verificaConexaoDaInternet()
        implementTextSelectable()

        if (!verificaConexaoDaInternet()) {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ops... sem conexão com a internet")
            builder.setMessage("Saia um pouco, tome um café e conecte sua internet.")
            builder.setIcon(R.drawable.emoji_triste)
            builder.setPositiveButton("tentar novamente") { dialog, which -> finish() }
            quadrangularProgressBar?.visibility = View.INVISIBLE
            builder.show()

        }

        abrirInstagram()
        abrirFacebook()

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
