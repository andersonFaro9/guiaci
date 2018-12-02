package br.com.guiacistore.adapter.epg

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.model.ListaSimplesCustomModel

//Responsável pela lista de parceiros da epg... lista simples com texto e subtitulo

class EpgServicosOferecidosAdapter(private val listaEpgtModel: List<ListaSimplesCustomModel>) :
        RecyclerView.Adapter<EpgServicosOferecidosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemLista = LayoutInflater.from(parent.context).inflate(R.layout.epg_adapter_lista, parent, false)

        return MyViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val listaEpg = listaEpgtModel[position]
        holder.tituloEpg.text = listaEpg.titulo
        holder.subTituloEpg.text = listaEpg.subTitulo
        holder.detalheEpg.text = listaEpg.detalhes

    }

    override fun getItemCount(): Int {
        return listaEpgtModel.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tituloEpg:  TextView = itemView.findViewById(R.id.tituloEpg)
        internal var detalheEpg: TextView = itemView.findViewById(R.id.detalheEpg)
        internal var subTituloEpg: TextView = itemView.findViewById(R.id.subTituloEpg)

    }

}