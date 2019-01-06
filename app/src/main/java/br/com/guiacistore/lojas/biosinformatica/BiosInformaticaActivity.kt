package br.com.guiacistore.lojas.biosinformatica
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
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.fragments.BiosInformaticaPromocoesFragment
import br.com.guiacistore.fragments.BiosInformaticaServicosFragment
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.interfaces.Invisible
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.lojas.biosinformatica.extensions.mostrarServicosOferecidos
import br.com.guiacistore.model.banco.BancoDeDados
import com.google.firebase.database.*
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.bios_activity.*
import kotlinx.android.synthetic.main.bios_informatica_fragment_servicos.*

class BiosInformaticaActivity : AppCompatActivity(), ICallNumber{

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.bios_activity)

        supportActionBar?.title = "Bios Informática"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, BiosInformaticaServicosActivity::class.java))
                position == 1 ->  startActivity(Intent(this, BiosInformaticaPromocoesActivity::class.java))
                position == 2 ->  exibirMensagem("Em breve")
                position == 3 ->  startActivity(Intent(this, BiosInformaticaRedesSociaisActivity::class.java))

            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_bios, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_tel -> {

                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, BiosInformaticaEnderecoActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 3645-5134")
        startActivity(callIntent)
    }



}