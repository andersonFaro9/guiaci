package br.com.guiacistore.lojas.publicart
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import br.com.guiacistore.R
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.lojas.publicart.fotos.PubliCartPrimeiraFotoActivity
import br.com.guiacistore.lojas.publicart.fotos.PubliCartQuartaFotoActivity
import br.com.guiacistore.lojas.publicart.fotos.PubliCartSegundaFotoActivity
import br.com.guiacistore.lojas.publicart.fotos.PubliCartTerceiraFotoActivity
import br.com.guiacistore.model.fotos.ListaDeFotosModel
import kotlinx.android.synthetic.main.activity_recycleview.*



open class PubliCartNovidadesActivity : AppCompatActivity() , ICallNumber {



    class ListaDeNovidadesFotosAdapter(private val context: Context, private var list: List<ListaDeFotosModel>,

          private var baseList: List<ListaDeFotosModel>) : RecyclerView.Adapter<ListaDeNovidadesFotosAdapter.ViewHolder>() {

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


            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.lista_layout_novidades, parent, false);
            val card = view.findViewById<CardView>(R.id.card_view) as CardView

            card.maxCardElevation = 1.0F;
            card.radius = 1.0F;

            return ViewHolder(view)



        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val epgFotosModel: ListaDeFotosModel = list.get(position)

            holder.tituloTop?.text = epgFotosModel.tituloDoTopo
            holder.subTitulo?.text = epgFotosModel.subTitulo
            holder.thumbImageView?.setImageResource(epgFotosModel.imagem)

            holder.thumbImageView?.setOnClickListener{

                //Envia para as telas de fotos de serviços dos clientes

                when (position) {
                    0 ->  context.startActivity(Intent(context, PubliCartPrimeiraFotoActivity::class.java ))
                    1 ->  context.startActivity(Intent(context, PubliCartSegundaFotoActivity::class.java ))
                    2 ->  context.startActivity(Intent(context, PubliCartTerceiraFotoActivity::class.java ))
                    3 ->  context.startActivity(Intent(context, PubliCartQuartaFotoActivity::class.java ))
                }
            }

        }


        override fun getItemCount(): Int = list.size

    }







    var list = ArrayList<ListaDeFotosModel>()
    var adapter = ListaDeNovidadesFotosAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Publicart"

    }


    //Responsável por criar as categorias e mostrar as fotos
    private fun  prepareList(list: ArrayList<ListaDeFotosModel>) {

        list.add(ListaDeFotosModel("", "", " Autoescola Caarapó ", R.drawable.publicart_primeira_foto))
        list.add(ListaDeFotosModel("", "", "Outubro Rosa na Caarapó", R.drawable.publicart_segunda_foto))
        list.add(ListaDeFotosModel("Bar", "", "Colchões Ortobom", R.drawable.publicart_terceira_foto))
        list.add(ListaDeFotosModel("", "", "Welson Saxofonista", R.drawable.publicart_quarta_foto))

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_publicart, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.ic_phone -> {
                callNumber()
                return true
            }
            R.id.ic_mapa -> {
                verMapa(Uri.parse("https://goo.gl/maps/kByyFXc2kQA2"))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {

        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:75 9 99672401")
        startActivity(callIntent)
    }


}



