package br.com.guiacistore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.dados.ListaModel

open class ListaSimplesTextoSemImagemAdapter(var context: Context, var listaModel:ArrayList<ListaModel>)

    : BaseAdapter() {

    class ViewHolder(row: View?) {

        var textName: TextView? = row?.findViewById(R.id.titulo) as TextView
        var subTitulo : TextView? =  row?.findViewById(R.id.subTitulo) as TextView


    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View?
        val viewHolder: ViewHolder

        when (convertView) {
            null -> {
                val layout = LayoutInflater.from(context)
                view = layout.inflate(R.layout.layout_lista_simples_texto_sem_imagem_adapter, parent, false)
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
        viewHolder.subTitulo?.text = lista.subTitulo


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