package br.com.guiacistore.lojas.lilidoces
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import br.com.guiacistore.R
import br.com.guiacistore.fragments.LiliDocesCakesHistoriaFragment
import br.com.guiacistore.fragments.LiliDocesCakesPromocoesFragment
import br.com.guiacistore.fragments.LiliDocesCakesServicosFragment
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.banco.BancoDeDadosFireBaseModel
import br.com.guiacistore.redesocial.LiliDocesCakesRedesSociaisActivity
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.lili_doces_cakes_fragment_servicos.*

class LiliDocesCakesActivity : AppCompatActivity(),  Invisible, IFirebase,ICallNumber {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {

        servicosDocesCakesProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(BancoDeDadosFireBaseModel::class.java)

                    val listaApp  = listOf(

                            cliente?.lili_doces_cakes_produto_1, cliente?.lili_doces_cakes_produto_2,
                            cliente?.lili_doces_cakes_produto_3, cliente?.lili_doces_cakes_produto_4,
                            cliente?.lili_doces_cakes_produto_5, cliente?.lili_doces_cakes_produto_6,
                            cliente?.lili_doces_cakes_produto_7, cliente?.lili_doces_cakes_produto_8,
                            cliente?.lili_doces_cakes_produto_9

                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@LiliDocesCakesActivity, android.R.layout.simple_list_item_1, listaApp)
                    servicos_lili_doces_cakes?.adapter = arrayAdapter //<- com as extensions


                }

                servicosDocesCakesProgressBar?.visibility = View.INVISIBLE


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

        setContentView(R.layout.loja_lili_doces_cakes)

        supportActionBar?.title = "Lili Doces & Cakes"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA", LiliDocesCakesHistoriaFragment::class.java)
                .add("DOCES", LiliDocesCakesServicosFragment::class.java)
                .add("PROMOÇÕES", LiliDocesCakesPromocoesFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)



    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_lojas, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_menu-> {

                val intent = Intent(this@LiliDocesCakesActivity, LiliDocesCakesRedesSociaisActivity::class.java)

                startActivity (intent)
                return true
            }

            R.id.ic_phone -> {

                callNumber()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {
        when {
            ContextCompat.checkSelfPermission(SpeedNetActivity@ this,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED -> if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CALL_PHONE)) {

            } else {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 42)
            }
            else -> callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when { requestCode == 42 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> callPhone() }

    }

    @SuppressLint("MissingPermission")
    fun callPhone(){

        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel: 988104762")
        startActivity(callIntent)
    }



}