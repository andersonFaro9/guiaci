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
import br.com.guiacistore.lojas.VeniviciActvity
import br.com.guiacistore.lojas.FarmaciaActivity
import br.com.guiacistore.lojas.LocadoraDeCarrosActivity
import br.com.guiacistore.lojas.PadariaActivity
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by faro on 9/22/17.
 */


class GuiaCityAdapter(private val context: Context, private var list: List<GuiaCity>, private var baseList: List<GuiaCity>) :
        RecyclerView.Adapter<GuiaCityAdapter.ViewHolder>(), Filterable {

    override fun getFilter(): Filter {
        return object : Filter() {
            var listShop = ArrayList<GuiaCity>()

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
                setList(list = filterResults?.values as List<GuiaCity>)
                notifyDataSetChanged()
            }

        }
    }

    fun getBaseList(): List<GuiaCity> = baseList

    fun setList(list: List<GuiaCity>) {
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


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): GuiaCityAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        card.maxCardElevation = 2.0F;
        card.radius = 5.0F;
        return ViewHolder(view);
    }


    override fun onBindViewHolder(holder: GuiaCityAdapter.ViewHolder, position: Int) {

        val album: GuiaCity = list.get(position)

        holder.titleTextView?.text = album.name

        holder.subtitleTextView?.text = album.subTitle

        holder.thumbImageView?.setImageResource(album.thumbnail)

        holder.thumbImageView?.setOnClickListener {

            when (position) {
                0 ->  context.startActivity(Intent(context, VeniviciActvity::class.java))
                1 -> context.startActivity(Intent(context,PadariaActivity::class.java ))
                2 -> context.startActivity(Intent(context,LocadoraDeCarrosActivity::class.java ))
                3 -> context.startActivity(Intent(context,FarmaciaActivity::class.java ))
            }

        }

    }


    override fun getItemCount(): Int = list.size


}




