package br.com.guiacistore.lojas.blueway

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R

class BlueWayContatosActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.blue_way_activity_contatos)
        supportActionBar?.title = "Contatos Blue Way"
    }


}