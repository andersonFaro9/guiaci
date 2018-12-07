package br.com.guiacistore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.guiacistore.R
import br.com.guiacistore.model.dados.ListaModel

open class ListaImagemTextoSimplesAdapter(var context: Context, var listaModel:ArrayList<ListaModel>)

    : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View?
        val viewHolder: ViewHolder

        when (convertView) {
            null -> {
                val layout = LayoutInflater.from(context)
                view = layout.inflate(R.layout.lista_layout_imagem_texto, parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder

            }
            else -> {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
        }

        val lista: ListaModel = getItem(position) as ListaModel
        viewHolder.textName?.text = lista.titulo
        viewHolder.subtitulo?.text = lista.subTitulo
        viewHolder.imageView?.setImageResource(lista.imagem)


        return view as View
    }

    override fun getItem(position: Int): Any {

        return listaModel.get(position)
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {

        return listaModel.count()

    }

}