package br.com.guiacistore.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.dados.ListaModel

 class ParceirosAdapter(private val listaSimples: List<ListaModel>) :

         RecyclerView.Adapter<ParceirosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemLista = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_lista_adapter_parceiros, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val lista = listaSimples[position]
        holder.titulo.text = lista.titulo
        holder.genero.text = lista.subTitulo
        holder.ano.text = lista.detalhes

    }

    override fun getItemCount(): Int { return listaSimples.size }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var titulo: TextView =  itemView.findViewById(R.id.tituloBlueWay)
        internal var ano: TextView = itemView.findViewById(R.id.detalheBlueWay)
        internal var genero: TextView = itemView.findViewById(R.id.subTituloBlueWay)

    }

}
