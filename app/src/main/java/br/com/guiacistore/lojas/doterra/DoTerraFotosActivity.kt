package br.com.guiacistore.lojas.doterra
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.doterra.extensions.mostrarServicosOferecidos
import br.com.guiacistore.lojas.evolution.fotos.EvolutionPrimeiraFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionQuartaFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionSegundaFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionTerceiraFotoActivity
import br.com.guiacistore.model.fotos.ListaDeFotosModel
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide

open class DoTerraFotosActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Fotos"

        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(FragmentSlide.Builder()
                .background(android.R.color.background_light)
                .fragment(R.layout.intro_1)
                .build()
        )


        addSlide(FragmentSlide.Builder()
                .background(android.R.color.background_light)
                .fragment(R.layout.intro_2)
                .build()
        )

        addSlide(FragmentSlide.Builder()
                .background(android.R.color.background_light)
                .fragment(R.layout.intro_3)
                .build()
        )


        addSlide(FragmentSlide.Builder()
                .background(android.R.color.background_light)
                .fragment(R.layout.intro_4)
                .build()
        )


    }




}