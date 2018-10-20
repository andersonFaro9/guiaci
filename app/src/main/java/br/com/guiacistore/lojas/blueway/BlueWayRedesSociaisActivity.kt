package br.com.guiacistore.lojas.blueway

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class BlueWayRedesSociaisActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blue_way_activity_redes_sociais)
        supportActionBar?.title = "Redes sociais Blue Way"
    }

}