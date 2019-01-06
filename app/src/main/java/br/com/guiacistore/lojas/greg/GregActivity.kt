package br.com.guiacistore.lojas.greg
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.greg.extensions.mostrarServicosOferecidos
import kotlinx.android.synthetic.main.greg_activity.*



class GregActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.greg_activity)

        supportActionBar?.title = "Barbearia do Greg"

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when  {
                position ==  0 ->  startActivity(Intent(this, GregHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, GregCortesValoresActivity::class.java))
                position ==  2 ->  startActivity(Intent(this, GregCartaoFidelidadeActivity::class.java))
                position == 3 ->  startActivity(Intent(this, GregNovidadeActivity::class.java))
                position == 4 ->  startActivity(Intent(this, GregPromocoesActivity::class.java))
                position == 5 ->  startActivity(Intent(this, GregRedesSociaisActivity::class.java))

            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_greg, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_mapa -> {
                callNumber()
                return true
            }

            R.id.ic_mapa -> {
                startActivity(Intent(this, GregBarbeariaEnderecoActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99648-1470")
        startActivity(callIntent)
    }
}
