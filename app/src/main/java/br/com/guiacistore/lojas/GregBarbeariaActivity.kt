package br.com.guiacistore.lojas
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.guiacistore.R
import br.com.guiacistore.fragments.HistoriaDaBarbeariaGregFragment
import br.com.guiacistore.fragments.PromocoesDaBarbeariaGregFragment
import br.com.guiacistore.fragments.ServicosDaBarbeariaGregFragment
import br.com.guiacistore.interfaces.IRedeSocial
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_servicos_da_barbearia_greg.*


class GregBarbeariaActivity : AppCompatActivity(), IRedeSocial, Invisible, IFirebase {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {

        gregBarbeariaServicosProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(
                            //Mostra a lista de serviços da  Barbearia do Greg
                            cliente?.gregbarbearia_servico1,cliente?.gregbarbearia_servico2,
                            cliente?.gregbarbearia_servico3,cliente?.gregbarbearia_servico4,
                            cliente?.gregbarbearia_servico5, cliente?.gregbarbearia_servico6
                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@GregBarbeariaActivity, android.R.layout.simple_list_item_1, listaApp)
                    barbearia_do_greg_servicos?.adapter = arrayAdapter //<- com as extensions

                    gregBarbeariaServicosProgressBar?.visibility = View.INVISIBLE

                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }
    override fun abrirFacebook(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/GregBarber88/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/erivan.lokau"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/GregBarber88/"))
        }
    }

    override fun abrirInstagram(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.instagram.com/gregbarber88/", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gregbarber88/"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gregbarber88/"))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doDatabaseInstance(1)

        setContentView(R.layout.loja_greg_barbearia)
        Toast.makeText(this,"Atendemos pedidos de corte ao gosto do cliente e com Desenhos específicos", Toast.LENGTH_LONG).show()

        supportActionBar?.title = "Barbearia do Greg"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("PROMOÇÕES", PromocoesDaBarbeariaGregFragment::class.java)
                .add("SERVIÇOS", ServicosDaBarbeariaGregFragment::class.java)
                .add("HISTÓRIA", HistoriaDaBarbeariaGregFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)

        abrirInstagram(this)
        abrirFacebook(this)



    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_speednet, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_instagram -> {

                val instagramIntent = abrirInstagram(this)
                startActivity(instagramIntent)

                return true
            }

            R.id.ic_facebook-> {

                val facebookIntent = abrirFacebook(this)
                startActivity(facebookIntent )

                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


}