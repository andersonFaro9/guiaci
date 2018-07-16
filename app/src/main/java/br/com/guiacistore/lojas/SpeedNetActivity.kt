package br.com.guiacistore.lojas
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.*
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_speednet.*

class SpeedNetActivity : AppCompatActivity() , IFirebase, Invisible, ITextIsSelectable,
        IRedeSocial, IConexaoComAInternet, ILigaParaLoja, ITelefone{

    override fun adicionaContatoELigaParaALoja() {

        ic_phone.setOnClickListener {

            val callIntent = Intent(ContactsContract.Intents.Insert.ACTION)
            callIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
            callIntent.putExtra(ContactsContract.Intents.Insert.NAME, "Speednet")

            callIntent.putExtra(ContactsContract.Intents.Insert.PHONE, "36455134")
            startActivityForResult(callIntent, 1)
        }
    }

    override fun verificaConexaoDaInternet(): Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun adicionaContatoNaListaDeContatosELigaParaLoja() {

        val callIntent = Intent(ContactsContract.Intents.Insert.ACTION)
        callIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
        callIntent.putExtra(ContactsContract.Intents.Insert.NAME, "Speednet")

        callIntent.putExtra(ContactsContract.Intents.Insert.PHONE, "36455134")
        startActivityForResult(callIntent, 1)

    }

    override fun configuraFacebook(context: Context): Intent {
        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/speednetalliance/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/speednetalliance/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/speednetalliance/"))
        }
    }

    override fun abrirFacebook() {
        ic_facebook?.setOnClickListener {

            val facebookIntent = configuraFacebook(this@SpeedNetActivity)
            startActivity(facebookIntent)
        }
    }

    override fun configurarInstagram(context: Context): Intent {
        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/speednetalliance/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/speednetalliance/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/speednetalliance/"))
        }
    }

    override fun abrirInstagram() {
        ic_instagram?.setOnClickListener {

            val instagramIntent = configurarInstagram(this)
            startActivity(instagramIntent)
        }
    }



    override fun implementTextSelectable() {
            speednet_historia_da_empresa.setTextIsSelectable(true)
          //speednet_conteudo_de_promocoes.setTextIsSelectable(true)
            speednet_conteudo_de_servicos.setTextIsSelectable(true)
    }

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_speednet)

        doDatabaseInstance(1)

        implementTextSelectable()
        verificaConexaoDaInternet()

        if (!verificaConexaoDaInternet()) {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ops... sem conexão com a internet")
            builder.setMessage("Saia um pouco, tome um café e conecte sua internet.")
            builder.setIcon(R.drawable.emoji_triste)
            builder.setPositiveButton("tentar novamente") { dialog, which -> finish() }
            speednetProgressBar?.visibility = View.INVISIBLE
            builder.show()

        }

        adicionaContatoELigaParaALoja()
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
                    speednet_empresa.text = cliente?.speednet_empresa
                    speednet_historia_da_empresa.text = cliente?.speednet_historia_da_empresa

//                    speednet_promocoes.text = cliente?.speednet_promocoes
//                    speednet_conteudo_de_promocoes.text = cliente?.speednet_conteudo_de_promocoes

                    speednet_servicos.text = cliente?.speednet_servicos
                    speednet_conteudo_de_servicos.text = cliente?.speednet_conteudo_de_servicos
                }


                speednetProgressBar.visibility = transformProgressBarInvisible()


            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
