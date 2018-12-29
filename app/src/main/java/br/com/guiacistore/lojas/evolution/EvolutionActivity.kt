package br.com.guiacistore.lojas.evolution
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import kotlinx.android.synthetic.main.evolution_activity.*

class AcademiaEvolutionActivity : AppCompatActivity(), ICallNumber{

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.evolution_activity)

        supportActionBar?.title = "Evolution Fitness"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, EvolutionHistoriaAcvity::class.java))
                position == 1 ->  startActivity(Intent(this, EvolutionServicosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, EvolutionPromocoesActivity::class.java))
                position == 3 ->  startActivity(Intent(this, EvolutionNovidadeActivity::class.java))
                position == 4 ->  startActivity(Intent(this, EvolutionRedesSociaisActivity::class.java))

            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_evolution, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_phone -> {
                callNumber()
                return true
            }

            R.id.ic_mapa -> {
                startActivity(Intent(this, EvolutionEnderecoActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99709-7427")
        startActivity(callIntent)
    }



}