package br.com.guiacistore.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R

class CustomAdapterBlueWay(var context: Context, var blueWay:ArrayList<BlueWayDetalhesModel>) : BaseAdapter() {

    private class ViewHolder(row: View?) {

        var textName: TextView? = null
        var imageViewBlue: ImageView? = null


        init {
            this.textName = row?.findViewById(R.id.titulo_blue_way) as TextView
            this.imageViewBlue = row?.findViewById(R.id.imageView_blue_way) as ImageView
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

        var blueWayDetalhes : BlueWayDetalhesModel = getItem(position) as BlueWayDetalhesModel
        viewHolder.textName?.text = blueWayDetalhes.nome
        viewHolder.imageViewBlue?.setImageResource(blueWayDetalhes.image)



        return view as View
    }




    override fun getItem(position: Int): Any {


        return blueWay.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {

        return blueWay.count()

    }


}