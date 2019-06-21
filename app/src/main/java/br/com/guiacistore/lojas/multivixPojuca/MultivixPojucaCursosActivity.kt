package br.com.guiacistore.lojas.multivixPojuca

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biosinfopaper.BiosInfoPaperFotosActivity
import br.com.guiacistore.lojas.biosinfopaper.BiosInfoPaperPromocoesActivity
import br.com.guiacistore.lojas.biosinfopaper.BiosInfoPaperRedesSociaisActivity
import br.com.guiacistore.lojas.biosinfopaper.BiosInfoPaperServicosActivity
import br.com.guiacistore.lojas.biosinfopaper.extensions.mostrarServicosOferecidos
import br.com.guiacistore.lojas.multivixPojuca.extensions.mostrarServicos
import kotlinx.android.synthetic.main.multivix_activity.*

class MultivixPojucaCursosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.multivix_listview_activity)

        supportActionBar?.title = "Multivix - Polo Pojuca"

        // tira elevação da borda da actionbar
        supportActionBar?.elevation = 0F

        mostrarServicos()

        listView.setOnItemClickListener { adapterView, view, position, l ->
            when  {
                position == 0 ->  startActivity(Intent(this, BiosInfoPaperServicosActivity::class.java))
                position == 1 ->  startActivity(Intent(this, BiosInfoPaperPromocoesActivity::class.java))
                position == 2 ->  startActivity(Intent(this, BiosInfoPaperFotosActivity::class.java))
                position == 3 ->  startActivity(Intent(this, BiosInfoPaperRedesSociaisActivity::class.java))
            }
        }
    }

}
