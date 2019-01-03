package br.com.guiacistore.extensions_geral
import android.content.Context
import android.content.Intent
import android.net.Uri


fun Context.verMapa(uri: Uri) {

    val intent = Intent(Intent.ACTION_VIEW, uri)
    val ii = startActivity(intent)

    return ii

}


