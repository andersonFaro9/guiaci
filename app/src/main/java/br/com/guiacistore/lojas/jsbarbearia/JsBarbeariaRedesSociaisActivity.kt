package br.com.guiacistore.lojas.jsbarbearia
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber


class JsBarbeariaRedesSociaisActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jsbarbearia_redesocial)

        supportActionBar?.title = "Redes sociais"

        mostraRedesSociais()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_jsbarbearia, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_mapa -> {
                callNumber()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71  99628-2113")
        startActivity(callIntent)
    }
}
