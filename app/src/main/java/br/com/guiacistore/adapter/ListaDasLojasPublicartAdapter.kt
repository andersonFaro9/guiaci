package br.com.guiacistore.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaDasLojasPublicartModel


/**
 * Created by faro on 9/22/17.
 */


class ListaDasLojasPublicartAdapter(private val context: Context, private var list: List<ListaDasLojasPublicartModel>, private var baseList: List<ListaDasLojasPublicartModel>) :
        RecyclerView.Adapter<ListaDasLojasPublicartAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var tituloTop: TextView? = null
        var thumbImageView: ImageView? = null
        var subTitulo: TextView? = null


        init {

            tituloTop = itemView.findViewById(R.id.titleTop)
            subTitulo = itemView.findViewById(R.id.subTitulo)
            thumbImageView = itemView.findViewById(R.id.imagemCardView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row_publicart, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        card.maxCardElevation = 1.0F;
        card.radius = 1.0F;
        return ViewHolder(view);
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val modelPublicart: ListaDasLojasPublicartModel = list.get(position)

        holder.tituloTop?.text = modelPublicart.tituloTop
        holder.subTitulo?.text = modelPublicart.subTitle
        holder.thumbImageView?.setImageResource(modelPublicart.imagem)


    }


    override fun getItemCount(): Int = list.size

}




