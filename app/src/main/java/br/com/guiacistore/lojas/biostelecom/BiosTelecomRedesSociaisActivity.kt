package br.com.guiacistore.lojas.biostelecom
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biostelecom.extensions.mostraRedesSociais


class BiosTelecomRedesSociaisActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biostelecom_redes_sociais_activity)

        supportActionBar?.title = "Redes sociais"

              mostraRedesSociais()

    }


}