package br.com.guiacistore.lojas.lilidoces.fotos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import kotlinx.android.synthetic.main.lili_segunda_foto.*

import uk.co.senab.photoview.PhotoViewAttacher

class LiliSegundaFotoActivity : AppCompatActivity(), IButtonOfCloseActivity {

    override fun closeActivity() { finish() }
    var atacher: PhotoViewAttacher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lili_segunda_foto)

        val imageViewEpg1 = findViewById<View>(R.id.lili_segunda_foto)

        atacher = PhotoViewAttacher(imageViewEpg1 as ImageView?)

        ic_botao_fechar.setOnClickListener { closeActivity()  }

        supportActionBar?.title = "Fotos"

    }
}