package br.com.guiacistore.lojas.speednet

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import br.com.guiacistore.R
import br.com.guiacistore.fragments.SpeedNetHistoriaFragment
import br.com.guiacistore.fragments.SpeedNetLinkDedicadoFragment
import br.com.guiacistore.fragments.SpeedNetPlanosFragment
import br.com.guiacistore.fragments.SpeedNetPromocoesFragment
import br.com.guiacistore.interfaces.CallNumber
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasFireBaseModel
import br.com.guiacistore.redesocial.SpeednetRedesSociaisActivity
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.speednet_fragment_planos.*




class SpeedNetActivity : AppCompatActivity(),
           Invisible, IFirebase, CallNumber {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loja_speednet)
        supportActionBar?.title = "Speednet Alliance"

        // tira elevação da borda da actionbar

        supportActionBar?.elevation = 0F
        doDatabaseInstance(1)

        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager, FragmentPagerItems.with(this)
                .add("HISTÓRIA", SpeedNetHistoriaFragment::class.java)
                .add("PROMOÇÕES", SpeedNetPromocoesFragment::class.java)
                .add("PLANOS", SpeedNetPlanosFragment::class.java)
                .add("LINK DEDICADO", SpeedNetLinkDedicadoFragment::class.java)

                .create())

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        val viewPagerTab = findViewById<SmartTabLayout>(R.id.viewPagerTab)

        viewPagerTab.setViewPager(viewPager)

        viewPager.adapter = adapter

        viewPagerTab.setViewPager(viewPager)


    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")


    override fun doDatabaseInstance(id: Int): Boolean {
        referenciaFirebase?.child(id.toString())


            planoSpeednetprogressBar?.visibility = View.VISIBLE



        referenciaFirebase?.addValueEventListener(object: ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasFireBaseModel::class.java)

                    speednet_download_5_megas?.text = cliente?.speednet_download_5_megas
                    //speednet_download_5_megas.justificationMode = JUSTIFICATION_MODE_INTER_WORD;

                    speednet_download_5_megas_speedZap?.text = cliente?.speednet_download_5_megas_speedZap

                    speednet_download_7_megas?.text = cliente?.speednet_download_7_megas
                    speednet_download_7_megas_speedFace?.text = cliente?.speednet_download_7_megas_speedFace

                    speednet_download_10_megas?.text = cliente?.speednet_download_10_megas
                    speednet_download_10_megas_speedFlix?.text = cliente?.speednet_download_10_megas_speedFlix

                    speednet_download_15_megas?.text = cliente?.speednet_download_15_megas
                    speednet_download_15_megas_speedUltra?.text = cliente?.speednet_download_15_megas_speedUltra

                    speednet_download_20_megas?.text = cliente?.speednet_download_20_megas
                    speednet_download_20_megas_speedFull?.text = cliente?.speednet_download_20_megas_speedFull


                }

                planoSpeednetprogressBar?.visibility = View.INVISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_lojas, menu)
        return true

    }



    @SuppressLint("MissingPermission")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_phone -> {

                callNumber()
                return true
            }

            R.id.ic_menu -> {

                val intent = Intent(this@SpeedNetActivity, SpeednetRedesSociaisActivity::class.java)

                startActivity (intent)

                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }


    override fun callNumber() {
        when {
            checkSelfPermission(SpeedNetActivity@this,
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
                callIntent.data = Uri.parse("tel:36455134")
                startActivity(callIntent)
    }




}