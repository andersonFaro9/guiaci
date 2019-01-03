package br.com.guiacistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import kotlinx.android.synthetic.main.activity_sobre.*

class SobreActivity : AppCompatActivity(), IButtonOfCloseActivity {

    override fun closeActivity() {
        close.setOnClickListener { finish() }
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        closeActivity()

    }

}
