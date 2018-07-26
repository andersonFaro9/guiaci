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
import br.com.guiacistore.R
import br.com.guiacistore.fragments.HistoriaDaVeniviciFragment
import br.com.guiacistore.fragments.PromocoesDaVeniviciFragment
import br.com.guiacistore.fragments.ServicosDaVeniviciFragment
import br.com.guiacistore.interfaces.IRedeSocial
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_promocoes_da_venivici.*
import kotlinx.android.synthetic.main.fragment_servicos_da_venivici.*


class VeniviciActivity : AppCompatActivity(), IRedeSocial, Invisible, IFirebase {


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {


        veniviciPromocoesProgressBar?.visibility = View.VISIBLE


        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {



                    /*

                    Venha com seu filho na semana dos pais e ganhe um mega desconto de 10% no seu corte!!. Ligue para o telefone
                    99648-1470 e fique por dentro, "paizão"
                     */


                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(
                            //Mostra a lista de serviços da venivici
                            cliente?.venivici_produto_1.toString(),cliente?.venivici_produto_2.toString(),
                            cliente?.venivici_produto_3.toString(),cliente?.venivici_produto_4.toString(),
                            cliente?.venivici_produto_5.toString(),cliente?.venivici_produto_6.toString(),
                            cliente?.venivici_produto_7.toString(),cliente?.venivici_produto_8.toString(),
                            cliente?.venivici_produto_9.toString(),cliente?.venivici_produto_10.toString(),
                            cliente?.venivici_produto_11.toString(),cliente?.venivici_produto_12.toString(),
                            cliente?.venivici_produto_13.toString(),cliente?.venivici_produto_14.toString(),
                            cliente?.venivici_produto_15.toString(),cliente?.venivici_produto_16.toString(),
                            cliente?.venivici_produto_17.toString(),cliente?.venivici_produto_18.toString(),
                            cliente?.venivici_produto_19.toString(),cliente?.venivici_produto_20.toString(),
                            cliente?.venivici_produto_21.toString(),cliente?.venivici_produto_22.toString()

                    )
                    veniviciPromocoesProgressBar?.visibility = View.INVISIBLE

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@VeniviciActivity, android.R.layout.simple_list_item_1, listaApp)
                    venivici_servicos?.adapter = arrayAdapter //<- com as extensions


                }

            }



            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }


    /*
    face de greg https://www.facebook.com/GregBarber88/
     */
    override fun abrirFacebook(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/venivici.almeida", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/venivici.almeida"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/venivici.almeida"))
        }
    }

    override fun abrirInstagram(context: Context): Intent {

        return try {
            context.packageManager.getPackageInfo("https://www.facebook.com/venivici.almeida", 0)
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/venivici.almeida"))
        }

        catch (e: Exception) {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/venivici.almeida"))
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_venivici)
        doDatabaseInstance(1)

        supportActionBar?.title = "Venivici"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("PROMOÇÕES", PromocoesDaVeniviciFragment::class.java)
                .add("SERVIÇOS", ServicosDaVeniviciFragment::class.java)
                .add("HISTÓRIA", HistoriaDaVeniviciFragment::class.java)

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



