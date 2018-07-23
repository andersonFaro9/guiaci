package br.com.guiacistore.interfaces

import android.content.Context
import android.content.Intent

interface IRedeSocial {

    fun abrirFacebook(context: Context): Intent

    fun abrirInstagram(context: Context): Intent


}