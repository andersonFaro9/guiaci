package br.com.guiacistore.lojas.epg
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import br.com.guiacistore.R
import br.com.guiacistore.adapter.epg.ListaEpgServicosAdapter
import br.com.guiacistore.extensions.verMapa
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.ListaDeFotosModel
import kotlinx.android.synthetic.main.activity_recycleview.*


open class EpgNovidadeActivity : AppCompatActivity(), ICallNumber {

    var list = ArrayList<ListaDeFotosModel>()
    var adapter = ListaEpgServicosAdapter(this, list, list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)

        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        supportActionBar?.title = "Novidades"

    }


    //Responsável por criar as categorias e mostrar as fotos
    private fun  prepareList(list: ArrayList<ListaDeFotosModel>) {

        list.add(ListaDeFotosModel("", ""," Long Drink Degradê",
                R.drawable.epg_primeira_foto))

        list.add(ListaDeFotosModel("", ""," Linda camiseta do colégio 29 de Julho! ",
                R.drawable.epg_segunda_foto))

        list.add(ListaDeFotosModel("" , ""," Caneca mágica! ",
                R.drawable.epg_terceira_foto))


        list.add(ListaDeFotosModel(" " , ""," Caneca de cerâmica! ",
                R.drawable.epg_quarta_foto))





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_epg, menu)
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
        callIntent.data = Uri.parse("tel:71 3645-1028")
        startActivity(callIntent)
    }

}