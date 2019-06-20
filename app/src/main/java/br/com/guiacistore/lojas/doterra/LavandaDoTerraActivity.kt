package br.com.guiacistore.lojas.doterra

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber

class LavandaDoTerraActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.doterra_lavanda_activity)

        supportActionBar?.title = "Lavanda"

        supportActionBar?.elevation = 0F
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_doterra, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_zap -> {
                callZap()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99619-8678")
        startActivity(callIntent)
    }

    fun callZap() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99169-7422")
        startActivity(callIntent)
    }

}
