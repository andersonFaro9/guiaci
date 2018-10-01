package br.com.guiacistore.lojas
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
import br.com.guiacistore.fragments.CursosBlueWayFragment
import br.com.guiacistore.fragments.HistoriaBlueWayFragment
import br.com.guiacistore.fragments.NovidadesBlueWayFragment
import br.com.guiacistore.interfaces.ICheckPermission
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.model.IFirebase
import br.com.guiacistore.model.LojasModel
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_servicos_da_inove.*


class BlueWayActivity : AppCompatActivity(),  Invisible, IFirebase,ICheckPermission {

    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")



    override fun doDatabaseInstance(id: Int): Boolean {

        inoveServicosProgressBar?.visibility = View.VISIBLE

        referenciaFirebase?.child(id.toString())

        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModel::class.java)

                    val listaApp  = listOf(

                            cliente?.inove_servico1,cliente?.inove_servico2,
                            cliente?.inove_servico3,cliente?.inove_servico4,
                            cliente?.inove_servico5, cliente?.inove_servico6,
                            cliente?.inove_servico7, cliente?.inove_servico8,
                            cliente?.inove_servico9, cliente?.inove_servico10,
                            cliente?.inove_servico11
                    )

                    val arrayAdapter : ArrayAdapter<String?> = ArrayAdapter(this@BlueWayActivity, android.R.layout.simple_list_item_1, listaApp)
                    inove_servicos?.adapter = arrayAdapter //<- com as extensions

                    inoveServicosProgressBar?.visibility = View.INVISIBLE

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

        setContentView(R.layout.loja_inove)

        supportActionBar?.title = "Inove"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA",  HistoriaBlueWayFragment::class.java)
                .add("CURSOS", CursosBlueWayFragment::class.java)
                .add("NOVIDADES", NovidadesBlueWayFragment::class.java)

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

//            R.id.ic_menu-> {
//
//                val intent = Intent(this@InoveActivity, InoveRedesSociaisActivity::class.java)
//
//                startActivity (intent)
//                return true
//            }

            R.id.ic_phone -> {

                checkPermissionForCallPhone()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }



    override fun checkPermissionForCallPhone() {
        when {
            ContextCompat.checkSelfPermission(InoveActivity@ this,
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
        callIntent.data = Uri.parse("tel:996629466")
        startActivity(callIntent)
    }



}