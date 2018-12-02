package br.com.guiacistore.adapter.epg

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
import br.com.guiacistore.lojas.epg.fotos.EpgPrimeiraFotoActivity
import br.com.guiacistore.lojas.epg.fotos.EpgQuartaFotoActivity
import br.com.guiacistore.lojas.epg.fotos.EpgSegundaFotoActivity
import br.com.guiacistore.lojas.epg.fotos.EpgTerceiraFotoActivity
import br.com.guiacistore.model.ListaDeFotosModel


/**
 * Created by faro on 9/22/17.
 */

/*Lista criada para mostrar imagem, titulo e subtitulo das fotos de
demonstração dos serviços ajudando a classe PubliCartServicosActivity
 dos clientes
 */

class ListaEpgServicosAdapter(private val context: Context, private var list: List<ListaDeFotosModel>, private var baseList: List<ListaDeFotosModel>) :
        RecyclerView.Adapter<ListaEpgServicosAdapter.ViewHolder>() {

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

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_row_epg, parent, false);
        val card = view.findViewById<CardView>(R.id.card_view) as CardView

        card.maxCardElevation = 1.0F;
        card.radius = 1.0F;
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val epgFotosModel: ListaDeFotosModel = list.get(position)

        holder.tituloTop?.text = epgFotosModel.tituloTop
        holder.subTitulo?.text = epgFotosModel.subTitle
        holder.thumbImageView?.setImageResource(epgFotosModel.imagem)

        holder.thumbImageView?.setOnClickListener{

               //Envia para as telas de fotos de serviços dos clientes

            when (position) {
                0 ->  context.startActivity(Intent(context, EpgPrimeiraFotoActivity::class.java ))
                1 ->  context.startActivity(Intent(context, EpgSegundaFotoActivity::class.java ))
                2 ->  context.startActivity(Intent(context, EpgTerceiraFotoActivity::class.java ))
                3 ->  context.startActivity(Intent(context, EpgQuartaFotoActivity::class.java ))
            }
        }

    }


    override fun getItemCount(): Int = list.size

}




