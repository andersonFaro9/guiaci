package br.com.guiacistore.lojas.jsbarbearia
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.interfaces.ICallNumber
import kotlinx.android.synthetic.main.js_barbearia_activity.*


class JsBarbeariaActivity: AppCompatActivity(), ICallNumber {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.js_barbearia_activity)

        supportActionBar?.title = "JS Barbearia à Domicílio"

        mostraServicosOferecidos()

        exibirMensagem("Atendimento especial para idosos e pessoas com mobilidade fisíca reduzida!")

        listView.setOnItemClickListener { adapterView, view, position, l ->


            when {
                position == 0 ->  startActivity(Intent(this, JsBarbeariaHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, JsBarbeariaServicosActivity::class.java))
                position == 2 ->  startActivity(Intent(this, JsBarbeariaNovidadeActivity::class.java))
                position == 3 ->  startActivity(Intent(this, JsBarbeariaPromocoesActivity::class.java))
                position == 4 ->  startActivity(Intent(this, JsBarbeariaRedesSociaisActivity::class.java))

            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_jsbarbearia, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_telefone -> {
                callNumber()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }


    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99628-2113")
        startActivity(callIntent)
    }
}
