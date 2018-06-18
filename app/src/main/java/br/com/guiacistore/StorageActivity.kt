package br.com.guiacistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class StorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        show()
    }

    fun show() {
        if (intent.extras != null) {
            val nome = intent.extras.get("promocao_nome").toString()
            val valor = intent.extras.get("promocao_valor").toString()
            val validade = intent.extras.get("promocao_validade").toString()
            val textview = findViewById<TextView>(R.id.textView)
            textview.text = "Aproveite a promoção $nome com $valor  até dia $validade"

        }
    }
}