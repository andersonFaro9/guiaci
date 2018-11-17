package br.com.guiacistore.lojas.publicart

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaDasLojasPublicartAdapter
import br.com.guiacistore.model.ListaDasLojasPublicartModel


open class PublicartContatosActivity : AppCompatActivity() {

    var list = ArrayList<ListaDasLojasPublicartModel>()
    var adapter = ListaDasLojasPublicartAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Publicart"

    }

}