package br.com.guiacistore.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.guiacistore.R


class BlueWayIdiomasAdapter(private val listaFilmes: List<BlueWayModel>) : RecyclerView.Adapter<BlueWayIdiomasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemLista = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_lista, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val filme = listaFilmes[position]
        holder.titulo.text = filme.tituloBlueWay
        holder.genero.text = filme.subTituloBlueWay
        holder.ano.text = filme.detalheBlueWay

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