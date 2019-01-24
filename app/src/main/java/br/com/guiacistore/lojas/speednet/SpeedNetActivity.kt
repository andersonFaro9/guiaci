package br.com.guiacistore.lojas.speednet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.speednet.extensions.mostraServicosOferecidos
import kotlinx.android.synthetic.main.speednet_activity.*


class SpeedNetActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speednet_activity)

        supportActionBar?.title = "Speednet Alliance"

        mostraServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when  {
                position == 0 ->  startActivity(Intent(this, SpeednetHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, SpeednetPlanosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, SpeednetPromocoesActivity::class.java))
                position == 4 ->  startActivity(Intent(this, SpeednetRedesSociaisActivity::class.java))

            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_speednet, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {
            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {

                startActivity(Intent(this, SpeedNetEnderecoActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel: 35120908")
        startActivity(callIntent)
    }
}
