package br.com.guiacistore.lojas.dinei_barber
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.auto_escola_franca.extensions.mostrarRedesSociais
import br.com.guiacistore.lojas.dinei_barber.extensions.mostrarRedesSociais


class DineiBarberRedesSociaisActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinei_redesocial)

        supportActionBar?.title = "Redes sociais"

        mostrarRedesSociais()



    }



}