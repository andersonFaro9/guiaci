package br.com.guiacistore.extensions_geral

import android.content.Context
import android.widget.Toast

fun Context.exibirMensagem(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()