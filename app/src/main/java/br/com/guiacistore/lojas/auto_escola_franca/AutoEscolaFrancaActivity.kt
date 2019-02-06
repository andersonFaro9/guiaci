package br.com.guiacistore.lojas.auto_escola_franca
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.auto_escola_franca.extensions.mostrarServicosOferecidos
import br.com.guiacistore.lojas.evolution.EvolutionFotosActivity
import kotlinx.android.synthetic.main.evolution_activity.*

class AutoEscolaFrancaActivity : AppCompatActivity(), ICallNumber{

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.auto_escola_franca_activity)

        supportActionBar?.title = "Auto Escola França"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, AutoEscolaFrancaHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, AutoEscolaFrancaServicosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, AutoEscolaFrancaPromocoesActivity::class.java))
                position == 3 ->  startActivity(Intent(this, AutoEscolaFrancaFotosActivity::class.java))
                position == 4 ->  startActivity(Intent(this, AutoEscolaFrancaEnderecoActivity::class.java))
                position == 5 ->  startActivity(Intent(this, AutoEscolaFrancaRedesSociaisActivity::class.java))

            }
        }
    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_auto_escola_franca, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, AutoEscolaFrancaEnderecoActivity::class.java))
                return true
            }

            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }
        }



        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 999819741")
        startActivity(callIntent)
    }



}