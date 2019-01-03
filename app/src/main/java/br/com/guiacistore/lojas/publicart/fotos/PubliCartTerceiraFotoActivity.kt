package br.com.guiacistore.lojas.publicart.fotos
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import kotlinx.android.synthetic.main.publicart_primeira_foto.*
import uk.co.senab.photoview.PhotoViewAttacher


class PubliCartTerceiraFotoActivity : AppCompatActivity(), IButtonOfCloseActivity {

    override fun closeActivity() { finish() }

    var atacher: PhotoViewAttacher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.publicart_terceira_foto)

        val imageViewPublicart = findViewById<View>(R.id.publicart_terceira_foto)

        atacher = PhotoViewAttacher(imageViewPublicart as ImageView?)

        ic_botao_fechar.setOnClickListener { closeActivity()  }

        supportActionBar?.title = "Fotos"

    }

}



