package br.com.guiacistore.lojas.epg
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import br.com.guiacistore.R


class EpgHistoriaActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epg_historia_activity)

        supportActionBar?.title = "História"

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
        return true
    }




}