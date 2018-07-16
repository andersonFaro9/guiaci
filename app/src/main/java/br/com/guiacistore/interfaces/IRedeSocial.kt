package br.com.guiacistore.interfaces

import android.content.Context
import android.content.Intent

interface IRedeSocial {

    fun configuraFacebook(context: Context): Intent
    fun abrirFacebook()
    fun configurarInstagram(context: Context): Intent
    fun abrirInstagram()

}