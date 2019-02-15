package br.com.guiacistore.lojas.dinei_barber

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.auto_escola_franca.*

import br.com.guiacistore.lojas.dinei_barber.extensions.mostrarServicosOferecidos
import kotlinx.android.synthetic.main.evolution_activity.*

class DineiBarberActivity : AppCompatActivity() , ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.diney_barber_activity)

        supportActionBar?.title = "Dinei Barber"

        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, DineiBarberHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, DineiBarberServicosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, DineiBarberFotosActivity::class.java))
                position == 3 ->  startActivity(Intent(this, DineiBarberPromocoesActivity::class.java))
                position == 4 ->  startActivity(Intent(this, DineiBarberEnderecoActivity::class.java))
                position == 5 ->  startActivity(Intent(this, DineiBarberRedesSociaisActivity::class.java))

            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_dinei, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_mapa -> {
                startActivity(Intent(this, DineiBarberEnderecoActivity::class.java))
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
        callIntent.data = Uri.parse( "tel: 999994927")
        startActivity(callIntent)
    }
}