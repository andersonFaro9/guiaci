package br.com.guiacistore.lojas.speednet
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.speednet.extensions.mostraRedesSociais


class SpeednetRedesSociaisActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speednet_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

              mostraRedesSociais()

    }


}