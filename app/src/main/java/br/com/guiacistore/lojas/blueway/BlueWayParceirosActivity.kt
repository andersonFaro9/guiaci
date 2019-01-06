package br.com.guiacistore.lojas.blueway
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.blueway.extensions.exibirParceiros


class BlueWayParceirosActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Parceiros"

        setContentView(R.layout.blue_way_activity)

        exibirParceiros()



    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when {

            item.itemId == R.id.ic_mapa -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_mapa -> {
                verMapa(Uri.parse("https://bit.ly/2QBoTVg"))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:71 3645-1028")
        startActivity(callIntent)
    }
}