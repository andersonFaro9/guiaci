package br.com.guiacistore.lojas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.guiacistore.R
import uk.co.senab.photoview.PhotoViewAttacher




class BlueWayMapasActivity : AppCompatActivity() {

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mapa_blue_way)

        supportActionBar?.title = "Endereço de Pojuca"
        daZoomNaImagem()

    }


    private fun daZoomNaImagem() {

        imageView = (findViewById<View>(R.id.mapaBlueWay) as ImageView)
        val photoView = PhotoViewAttacher(imageView)
        photoView.update()

    }


}