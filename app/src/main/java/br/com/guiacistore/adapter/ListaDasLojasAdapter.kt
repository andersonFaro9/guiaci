package br.com.guiacistore.adapter

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
import br.com.guiacistore.R
import br.com.guiacistore.lojas.biosinformatica.BiosInformaticaActivity
import br.com.guiacistore.lojas.blueway.BlueWayActivity
import br.com.guiacistore.lojas.epg.EpgActivity
import br.com.guiacistore.lojas.evolution.AcademiaEvolutionActivity
import br.com.guiacistore.lojas.greg.GregBarbeariaActivity
import br.com.guiacistore.lojas.inove.InoveActivity
import br.com.guiacistore.lojas.jobsat.JobSatActivity
import br.com.guiacistore.lojas.lilidoces.LiliDocesCakesActivity
import br.com.guiacistore.lojas.publicart.PubliCartActivity
import br.com.guiacistore.lojas.quadrangular.QuadrangularActivity
import br.com.guiacistore.lojas.rosasaron.RosaDeSaronActivity
import br.com.guiacistore.lojas.speednet.SpeedNetActivity
import br.com.guiacistore.lojas.studioesound.StudioESoundActivity
import br.com.guiacistore.model.ListaDasLojasModel
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by faro on 9/22/17.
 */


class ListaDasLojasAdapter(private val context: Context, private var list: List<ListaDasLojasModel>, private var baseList: List<ListaDasLojasModel>) :
        RecyclerView.Adapter<ListaDasLojasAdapter.ViewHolder>(), Filterable {

    override fun getFilter(): Filter {
        return object : Filter() {
            var listShop = ArrayList<ListaDasLojasModel>()

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
                setList(list = filterResults?.values as List<ListaDasLojasModel>)
                notifyDataSetChanged()
            }

        }
    }

    fun getBaseList(): List<ListaDasLojasModel> = baseList

    fun setList(list: List<ListaDasLojasModel>) {
        this.list = list
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView: TextView? = null
        var thumbImageView: ImageView? = null
        var subtitleTextView: TextView? = null


        init {
            titleTextView = itemView.findViewById(R.id.title)
            subtitleTextView = itemView.findViewById(R.id.subtituloItem)
            thumbImageView = itemView.findViewById(R.id.imagemCardView)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        card.maxCardElevation = 2.0F;
        card.radius = 5.0F;
        return ViewHolder(view);
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val album: ListaDasLojasModel = list.get(position)

        holder.titleTextView?.text = album.name

        holder.subtitleTextView?.text = album.subTitle

        holder.thumbImageView?.setImageResource(album.thumbnail)

        holder.thumbImageView?.setOnClickListener {

            when (position) {
                0 ->  context.startActivity(Intent(context, SpeedNetActivity::class.java))
                1 ->  context.startActivity(Intent(context, GregBarbeariaActivity::class.java ))
                2 ->  context.startActivity(Intent(context, JobSatActivity::class.java ))
                3 ->  context.startActivity(Intent(context, LiliDocesCakesActivity::class.java ))
                4 ->  context.startActivity(Intent(context, BiosInformaticaActivity::class.java ))
                5 ->  context.startActivity(Intent(context, PubliCartActivity::class.java ))
                6 ->  context.startActivity(Intent(context, AcademiaEvolutionActivity::class.java ))
                7 ->  context.startActivity(Intent(context, QuadrangularActivity::class.java ))
                8 ->  context.startActivity(Intent(context, BlueWayActivity::class.java ))
                9 ->  context.startActivity(Intent(context, StudioESoundActivity::class.java))
                10 -> context.startActivity(Intent(context, RosaDeSaronActivity::class.java))
                11 -> context.startActivity(Intent(context, EpgActivity::class.java))
                12 -> context.startActivity(Intent(context, InoveActivity::class.java))

            }

        }

    }


    override fun getItemCount(): Int = list.size


}



