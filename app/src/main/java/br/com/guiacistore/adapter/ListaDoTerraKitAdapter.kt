package br.com.guiacistore.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.lojas.doterra.*
import br.com.guiacistore.model.dados.ListaModel

class ListaDoTerraKitAdapter(private val context: Context, private var list: List<ListaModel>) :
        RecyclerView.Adapter<ListaDoTerraKitAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleTextView: TextView? = null
        var thumbImageView: ImageView? = null
        var subtitleTextView: TextView? = null


        init {
            titleTextView = itemView.findViewById(R.id.title)
            subtitleTextView = itemView.findViewById(R.id.subtituloItem)
            thumbImageView = itemView.findViewById(R.id.foto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row_kit_doterra, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        //card.maxCardElevation = 2.0F;
        //card.radius = 5.0F;
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val album: ListaModel = list.get(position)

        holder.titleTextView?.text = album.titulo

        holder.subtitleTextView?.text = album.subTitulo

        holder.thumbImageView?.setImageResource(album.imagem)

        holder.thumbImageView?.setOnClickListener {

            when (position) {

                0 ->  context.startActivity(Intent(context, AlecrimDoTerraActivity::class.java))
                1 ->  context.startActivity(Intent(context, CravoDoTerraActivity::class.java))
                2 ->  context.startActivity(Intent(context, EucaliptoDoTerraActivity::class.java))
                3 ->  context.startActivity(Intent(context, GengibreDoTerraActivity::class.java))
                4 ->  context.startActivity(Intent(context, LavandaDoTerraActivity::class.java))
                5 ->  context.startActivity(Intent(context, CapimLimaoDoTerraActivity::class.java))
                6 ->  context.startActivity(Intent(context, HortelaPimentaDoTerraActivity::class.java))
                7 ->  context.startActivity(Intent(context, PatchouliDoTerraActivity::class.java))
                8 ->  context.startActivity(Intent(context, NardoDoTerraActivity::class.java))
                9 ->  context.startActivity(Intent(context, ToranjaDoTerraActivity::class.java))

            }

        }

    }


    override fun getItemCount(): Int = list.size


}
