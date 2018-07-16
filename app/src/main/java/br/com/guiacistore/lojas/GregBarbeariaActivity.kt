package br.com.guiacistore.lojas
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.*
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loja_greg_barbearia.*


class GregBarbeariaActivity : AppCompatActivity(), IFirebase, Invisible,IRedeSocial,
        ITextIsSelectable,
        IConexaoComAInternet, IChat{

//    https://www.facebook.com/GregBarber88/

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?

        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)
                    gregbarbearia_empresa?.text = cliente?.gregbarbearia_empresa
                    gregbarbearia_historia_da_empresa?.text = cliente?.gregbarbearia_historia_da_empresa

                    gregbarbearia_promocoes?.text = cliente?.gregbarbearia_promocoes
                    gregbarbearia_conteudo_de_promocoes?.text = cliente?.gregbarbearia_conteudo_de_promocoes

                    gregbarbearia_servicos?.text = cliente?.gregbarbearia_servicos
                    gregbarbearia_conteudo_de_servicos.text = cliente?.gregbarbearia_conteudo_de_servicos

                    gregbarbearia_ProgressBar?.visibility = View.INVISIBLE

                }

            }


            override fun onCancelled(databaseError: DatabaseError?) {

                Log.d("onCancelled", "error...", databaseError?.toException())

            }

        })

        return true

    }

    val REQUEST_PHONE_CALL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_greg_barbearia)
        doDatabaseInstance(1)
        implementTextSelectable()

        verificaConexaoDaInternet()

        if (!verificaConexaoDaInternet()) {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ops... sem conexão com a internet")
            builder.setMessage("Saia um pouco, tome um café e conecte sua internet.")
            builder.setIcon(R.drawable.emoji_triste)
            builder.setPositiveButton("tentar novamente") { dialog, which -> finish() }
            gregbarbearia_ProgressBar?.visibility = View.INVISIBLE
            builder.show()

        }

        checaPermissaoDoTelefoneEAdicionaZap()
        abrirInstagram()
        abrirFacebook()

    }



    override fun checaPermissaoDoTelefoneEAdicionaZap() {

        ic_whatsapp?.setOnClickListener { it ->

            when {
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED -> ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
                else -> adicionaContatoNaListaDeContatosEConversaNoZap()
            }

        };
    }

    @SuppressLint("MissingPermission")

    override fun adicionaContatoNaListaDeContatosEConversaNoZap() {

        val callIntent = Intent(ContactsContract.Intents.Insert.ACTION)
        callIntent.type = ContactsContract.RawContacts.CONTENT_TYPE
        callIntent.putExtra(ContactsContract.Intents.Insert.NAME, "Barbearia do Greg")

        callIntent.putExtra(ContactsContract.Intents.Insert.PHONE, " 996481470")
        startActivityForResult(callIntent, 1)

    }


    override fun configuraFacebook(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/GregBarber88/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/GregBarber88/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/GregBarber88/"))
        }
    }


    override fun abrirFacebook() {

        ic_facebook?.setOnClickListener {

            val facebookIntent = configuraFacebook(this@GregBarbeariaActivity)
            startActivity(facebookIntent)
        }
    }

    override fun configurarInstagram(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/gregbarber88/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gregbarber88/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gregbarber88/"))
        }
    }

    override fun abrirInstagram() {

        ic_instagram?.setOnClickListener {

            val instagramIntent = configurarInstagram(this)
            startActivity(instagramIntent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) { REQUEST_PHONE_CALL -> adicionaContatoNaListaDeContatosEConversaNoZap() }
    }

    override fun verificaConexaoDaInternet(): Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    override fun implementTextSelectable() {
        gregbarbearia_historia_da_empresa?.setTextIsSelectable(true)
        gregbarbearia_conteudo_de_promocoes?.setTextIsSelectable(true)
        gregbarbearia_conteudo_de_servicos?.setTextIsSelectable(true)

    }

}



