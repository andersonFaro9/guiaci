package br.com.guiacistore.redesocial

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import kotlinx.android.synthetic.main.activity_speednet_redesocial.*

class LiliDocesCakesRedesSociaisActivity : AppCompatActivity(), IButtonOfCloseActivity {

    override fun closeActivity() {
        close.setOnClickListener { finish() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lili_doces_cake_redesocial)
        closeActivity()
    }




}