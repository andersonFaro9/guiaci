package br.com.guiacistore.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaSimplesCustomModel


class PubliCartParceirosAdapter(private val listaPublicartModel: List<ListaSimplesCustomModel>) :
        RecyclerView.Adapter<PubliCartParceirosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemLista = LayoutInflater.from(parent.context).inflate(R.layout.publi_cart_adapter_lista, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val listaPubliCart = listaPublicartModel[position]
        holder.tituloPublicart.text = listaPubliCart.titulo
        holder.subTituloPublicart.text = listaPubliCart.subTitulo
        holder.detalhePublicart.text = listaPubliCart.detalhes

    }

    override fun getItemCount(): Int {
        return listaPublicartModel.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tituloPublicart:  TextView = itemView.findViewById(R.id.tituloPublicart)
        internal var detalhePublicart: TextView = itemView.findViewById(R.id.detalhePublicart)
        internal var subTituloPublicart: TextView = itemView.findViewById(R.id.subTituloPublicart)

    }

}