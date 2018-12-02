package br.com.guiacistore.lojas.epg.fotos
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IButtonOfCloseActivity
import kotlinx.android.synthetic.main.epg_quarta_foto.*
import uk.co.senab.photoview.PhotoViewAttacher


class EpgQuartaFotoActivity : AppCompatActivity(), IButtonOfCloseActivity {

    override fun closeActivity() { finish() }

    var atacher: PhotoViewAttacher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epg_quarta_foto)

        val imageViewEpg = findViewById<View>(R.id.epg_quarta_foto)

        atacher = PhotoViewAttacher(imageViewEpg as ImageView?)

        ic_botao_fechar.setOnClickListener { closeActivity()  }

        supportActionBar?.title = "Fotos"

    }

}



