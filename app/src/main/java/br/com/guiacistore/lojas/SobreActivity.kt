package br.com.guiacistore.lojas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import br.com.guiacistore.interfaces.ITextIsSelectable
import kotlinx.android.synthetic.main.activity_sobre.*

class SobreActivity : AppCompatActivity(), ITextIsSelectable, IButtonOfCloseActivity {

    override fun closeActivity() {
        close.setOnClickListener { finish() }
    }

    override fun implementTextSelectable() {

        text_telefone.setTextIsSelectable(true)

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)
        implementTextSelectable()
        closeActivity()

    }

}
