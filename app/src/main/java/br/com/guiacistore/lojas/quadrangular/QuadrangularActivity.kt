package br.com.guiacistore.lojas.quadrangular
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.extensions_geral.exibirMensagem
import br.com.guiacistore.lojas.evolution.*
import br.com.guiacistore.lojas.quadrangular.extensions.mostrarServicosOferecidos
import kotlinx.android.synthetic.main.evolution_activity.*


class QuadrangularActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.quadrangular_activity)

        supportActionBar?.title = "Igreja Quadrangular"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicosOferecidos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, QuadrangularHistoriaActivity::class.java))
                position == 1 ->  startActivity(Intent(this, QuadrangularCultoCelulasActivity::class.java))
                position == 2 ->  exibirMensagem("Em breve")
                position == 3 ->  exibirMensagem("Em breve")
                position == 4 ->  startActivity(Intent(this, QuadrangularRedeSocialActivity::class.java))

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_igreja_quadrangular, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_mapa -> {
                startActivity(Intent(this, QuadrangularEnderecoActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}


