package br.com.guiacistore.lojas.evolution
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.lojas.evolution.fotos.EvolutionPrimeiraFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionQuartaFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionSegundaFotoActivity
import br.com.guiacistore.lojas.evolution.fotos.EvolutionTerceiraFotoActivity
import br.com.guiacistore.model.fotos.ListaDeFotosModel
import kotlinx.android.synthetic.main.activity_recycleview.*



open class EvolutionFotosActivity : AppCompatActivity() {


    class ListaDeFotosAdapter(private val context: Context, private var list: List<ListaDeFotosModel>) :

            RecyclerView.Adapter<ListaDeFotosAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var titulo: TextView? = null
            var foto: ImageView? = null
            var subTitulo: TextView? = null

            init {
                titulo = itemView.findViewById(R.id.titulo)
                subTitulo = itemView.findViewById(R.id.subTitulo)
                foto = itemView.findViewById(R.id.foto)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {


            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lista_layout_fotos, parent, false);
            val card = view.findViewById<CardView>(R.id.card_view) as CardView

            card.maxCardElevation = 1.0F;
            card.radius = 1.0F;

            return ViewHolder(view)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val listaDeFotosModel: ListaDeFotosModel = list.get(position)

            holder.titulo?.text = listaDeFotosModel.tituloDaFoto
            holder.subTitulo?.text = listaDeFotosModel.subTitulo
            holder.foto?.setImageResource(listaDeFotosModel.imagem)

            holder.foto?.setOnClickListener{

                //Envia para as telas de fotos de serviços dos clientes

                when (position) {
                    0 ->  context.startActivity(Intent(context, EvolutionPrimeiraFotoActivity::class.java ))
                    1 ->  context.startActivity(Intent(context, EvolutionSegundaFotoActivity::class.java ))
                    2 ->  context.startActivity(Intent(context, EvolutionTerceiraFotoActivity::class.java ))
                    3 ->  context.startActivity(Intent(context, EvolutionQuartaFotoActivity::class.java ))
                }
            }

        }


        override fun getItemCount(): Int = list.size

    }



    var list = ArrayList<ListaDeFotosModel>()
    var adapter = ListaDeFotosAdapter(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Fotos"

    }


    //Responsável por criar as categorias e mostrar as fotos
    private fun  prepareList(list: ArrayList<ListaDeFotosModel>) {

        list.add(ListaDeFotosModel("", "", "Nossa galera!!",
                R.drawable.evolution_primeira_foto))

        list.add(ListaDeFotosModel("", "", "você sairá daqui campeão!!!",
                R.drawable.evolution_segunda_foto))

        list.add(ListaDeFotosModel("", "", "Deixa os ossos fortes! ",
                R.drawable.evolution_terceira_foto))


        list.add(ListaDeFotosModel(" ", "", " Exercicios diários",
                R.drawable.evolution_quarta_foto))

    }



}