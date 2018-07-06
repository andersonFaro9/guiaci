package br.com.guiacistore

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.lojas.QuadrangularActivity
import br.com.guiacistore.lojas.SpeedNetActivity
import br.com.guiacistore.lojas.VeniviciActvity
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by faro on 9/22/17.
 */


class ListaDeClientesAdapter(private val context: Context, private var list: List<ListaDeClientes>, private var baseList: List<ListaDeClientes>) :
        RecyclerView.Adapter<ListaDeClientesAdapter.ViewHolder>(), Filterable {

    override fun getFilter(): Filter {
        return object : Filter() {
            var listShop = ArrayList<ListaDeClientes>()

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val results = Filter.FilterResults()

                if (charSequence == null || charSequence.isEmpty()) {
                    results.values = baseList
                    results.count = baseList.size
                } else {

                    getBaseList().filterTo(listShop) {
                        it.name.toLowerCase(Locale.getDefault()).contains(charSequence)

                    }

                    results.count = listShop.size
                    results.values = listShop
                }

                return results
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                setList(list = filterResults?.values as List<ListaDeClientes>)
                notifyDataSetChanged()
            }

        }
    }

    fun getBaseList(): List<ListaDeClientes> = baseList

    fun setList(list: List<ListaDeClientes>) {
        this.list = list
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView: TextView? = null
        var thumbImageView: ImageView? = null
        var subtitleTextView: TextView? = null


        init {
            titleTextView = itemView.findViewById<TextView>(R.id.title)
            subtitleTextView = itemView.findViewById<TextView>(R.id.subtituloItem)
            thumbImageView = itemView.findViewById<ImageView>(R.id.thumbnail)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ListaDeClientesAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        card.maxCardElevation = 2.0F;
        card.radius = 5.0F;
        return ViewHolder(view);
    }


    override fun onBindViewHolder(holder: ListaDeClientesAdapter.ViewHolder, position: Int) {

        val album: ListaDeClientes = list.get(position)

        holder.titleTextView?.text = album.name

        holder.subtitleTextView?.text = album.subTitle

        holder.thumbImageView?.setImageResource(album.thumbnail)

        holder.thumbImageView?.setOnClickListener {

            when (position) {
                0 ->  context.startActivity(Intent(context, SpeedNetActivity::class.java))
                1 -> context.startActivity(Intent(context,VeniviciActvity::class.java ))
                2 -> context.startActivity(Intent(context,SpeedNetActivity::class.java ))
                3 -> context.startActivity(Intent(context,QuadrangularActivity::class.java ))
            }

        }

    }


    override fun getItemCount(): Int = list.size


}




