package br.com.guiacistore.adapter.blueway

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaSimplesCustomModel


class BlueWayIdiomasParceirosAdapter(private val listaFilmes: List<ListaSimplesCustomModel>) : RecyclerView.Adapter<BlueWayIdiomasParceirosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemLista = LayoutInflater.from(parent.context)
                .inflate(R.layout.blue_way_adapter_lista, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val filme = listaFilmes[position]
        holder.titulo.text = filme.titulo
        holder.genero.text = filme.subTitulo
        holder.ano.text = filme.detalhes

    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var titulo: TextView
        internal var ano: TextView
        internal var genero: TextView

        init {

            titulo = itemView.findViewById(R.id.tituloBlueWay)
            ano = itemView.findViewById(R.id.detalheBlueWay)
            genero = itemView.findViewById(R.id.subTituloBlueWay)

        }
    }

}