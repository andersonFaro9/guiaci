package br.com.guiacistore.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R

class ViewHolder(row: View?) {

    var textName: TextView? = row?.findViewById(R.id.titulo) as TextView
    var imageView: ImageView? =  row?.findViewById(R.id.imagem) as ImageView
    var subtitulo : TextView? =  row?.findViewById(R.id.subtitulo) as TextView


}