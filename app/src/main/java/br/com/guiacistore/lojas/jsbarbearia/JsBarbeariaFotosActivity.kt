package br.com.guiacistore.lojas.jsbarbearia
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.lojas.jsbarbearia.fotos.JsBarbeariaPrimeiraFotoActivity
import br.com.guiacistore.lojas.jsbarbearia.fotos.JsBarbeariaQuartaFotoActivity
import br.com.guiacistore.lojas.jsbarbearia.fotos.JsBarbeariaSegundaFotoActivity
import br.com.guiacistore.lojas.jsbarbearia.fotos.JsBarbeariaTerceiraFotoActivity
import br.com.guiacistore.model.fotos.ListaDeFotosModel
import kotlinx.android.synthetic.main.activity_recycleview.*



open class JsBarbeariaFotosActivity : AppCompatActivity() {

    var list = ArrayList<ListaDeFotosModel>()
    var adapter = ListaDeNovidadesFotosAdapter(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        mostraFotos(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Fotos"

    }


    //Responsável por criar as categorias e mostrar as fotos
    private fun  mostraFotos(list: ArrayList<ListaDeFotosModel>) {

        list.add(ListaDeFotosModel("", "", "Corte Social",
                R.drawable.jsbarbearia_primeira_foto))

        list.add(ListaDeFotosModel("", "", "Social Clássico Longo! ",
                R.drawable.jsbarbearia_segunda_foto))

        list.add(ListaDeFotosModel("", "", "Corte Degradê! ",
                R.drawable.jsbarbearia_terceira_foto))

        list.add(ListaDeFotosModel(" ", "", "Corte Social! ",
                R.drawable.jsbarbearia_quarta_foto))

    }

     class ListaDeNovidadesFotosAdapter(private val context: Context, private var list: List<ListaDeFotosModel>) :

            RecyclerView.Adapter<ListaDeNovidadesFotosAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var tituloTop: TextView? = null
            var thumbImageView: ImageView? = null
            var subTitulo: TextView? = null

            init {
                tituloTop = itemView.findViewById(R.id.titulo)
                subTitulo = itemView.findViewById(R.id.subTitulo)
                thumbImageView = itemView.findViewById(R.id.foto)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {


            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lista_layout_fotos, parent, false);
            val card = view.findViewById<CardView>(R.id.card_view)

            card.maxCardElevation = 1.0F;
            card.radius = 1.0F;

            return ViewHolder(view)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val listaDeFotosModel: ListaDeFotosModel = list.get(position)

            holder.tituloTop?.text = listaDeFotosModel.tituloDaFoto
            holder.subTitulo?.text = listaDeFotosModel.subTitulo
            holder.thumbImageView?.setImageResource(listaDeFotosModel.imagem)

            holder.thumbImageView?.setOnClickListener{

                //Envia para as telas de fotos de serviços dos clientes

                when (position) {
                    0 ->  context.startActivity(Intent(context, JsBarbeariaPrimeiraFotoActivity::class.java ))
                    1 ->  context.startActivity(Intent(context, JsBarbeariaSegundaFotoActivity::class.java ))
                    2 ->  context.startActivity(Intent(context, JsBarbeariaTerceiraFotoActivity::class.java ))
                    3 ->  context.startActivity(Intent(context, JsBarbeariaQuartaFotoActivity::class.java ))
                }
            }

        }


        override fun getItemCount(): Int = list.size

    }





}