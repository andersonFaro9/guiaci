package br.com.guiacistore.lojas.epg
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import br.com.guiacistore.R
import br.com.guiacistore.lojas.epg.extensions.mostraRedesSociais


class EpgRedesSociaisActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epg_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

        mostraRedesSociais()



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
        return true
    }


}