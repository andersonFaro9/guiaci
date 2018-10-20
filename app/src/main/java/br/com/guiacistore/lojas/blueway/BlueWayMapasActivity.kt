package br.com.guiacistore.lojas.blueway
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

        setContentView(R.layout.blue_way_activity_mapa)

        supportActionBar?.title = "Endereço de Pojuca"
        daZoomNaImagem()

    }


    private fun daZoomNaImagem() {

        imageView = (findViewById<View>(R.id.mapaBlueWay) as ImageView)
        val photoView = PhotoViewAttacher(imageView)
        photoView.update()

    }


}