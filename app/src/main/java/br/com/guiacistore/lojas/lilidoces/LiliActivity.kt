package br.com.guiacistore.lojas.lilidoces
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.lilidoces.extensions.mostrarServicosOferecidos
import kotlinx.android.synthetic.main.lili_activity.*

class LiliDocesCakesActivity : AppCompatActivity(), ICallNumber{


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.lili_activity)

        supportActionBar?.title = "Lili Doces e Cakes"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this,LiliHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, LiliDocesTortasServicosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, LiliPromocoesActivity::class.java))
                position == 3 ->  startActivity(Intent(this, LiliFotosActivity::class.java))
                position == 4 ->  startActivity(Intent(this, LiliContatosRedesSociaisActivity::class.java))

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_lili, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_mapa -> {
                callNumber()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 98810-4762")
        startActivity(callIntent)
    }



}