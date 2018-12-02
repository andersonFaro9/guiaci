package br.com.guiacistore.adapter.blueway

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaCustomizadaModel

//Lista adapter simples com imagem e texto

class CustomListaSimplesBlueWayAdapter(var context: Context, var listaCustomizadaModel:ArrayList<ListaCustomizadaModel>) : BaseAdapter() {

    private class ViewHolder(row: View?) {

        var textName: TextView? = null
        var imageView: ImageView? = null


        init {
            this.textName = row?.findViewById(R.id.titulo) as TextView
            this.imageView = row?.findViewById(R.id.images) as ImageView
        }

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view:View?
        var viewHolder : ViewHolder

        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.blue_way_list, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder= view.tag as ViewHolder
        }

        var listaCustomizada : ListaCustomizadaModel = getItem(position) as ListaCustomizadaModel
        viewHolder.textName?.text = listaCustomizada.nome
        viewHolder.imageView?.setImageResource(listaCustomizada.image)



        return view as View
    }

    override fun getItem(position: Int): Any {


        return listaCustomizadaModel.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {

        return listaCustomizadaModel.count()

    }


}