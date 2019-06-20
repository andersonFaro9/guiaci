package br.com.guiacistore.lojas.doterra

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import br.com.guiacistore.R
import br.com.guiacistore.adapter.ListaDoTerraNossosOleosAdapter
import br.com.guiacistore.interfaces.ICallNumber
import br.com.guiacistore.model.dados.ListaModel
import kotlinx.android.synthetic.main.activity_recycleview.*

class DoTerraNossosOleosActivity : AppCompatActivity(), ICallNumber {

    var list = ArrayList<ListaModel>()
    var adapter = ListaDoTerraNossosOleosAdapter( this,list)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycleview)

        supportActionBar?.title = "Nossos óleos"

        supportActionBar?.elevation = 0F

        //mostrarServicos()
        prepareList(list)

        recView.adapter = adapter
        recView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

    }

    private fun  prepareList(list: ArrayList<ListaModel>) {

        list.add(ListaModel("Alecrim", "Utilizado em aromaterapia", 0, R.drawable.ic_alecrim_doterra) )
        list.add(ListaModel("Cravo", "Para massagens confortantes", 0, R.drawable.ic_cravo_doterra) )
        list.add(ListaModel("Eucalipto", "Inspira vitalidade.", 0, R.drawable.ic_eucalipto_doterra) )
        list.add(ListaModel("Gengibre", "Inale, aplique no abdômen, massageie", 0, R.drawable.ic_gengibre_doterra) )
        list.add(ListaModel("Lavanda", "Noites agradáveis", 0, R.drawable.ic_lavanda_doterra) )
        list.add(ListaModel("Capim-limão", "Sensação de nova perspectiva.", 0, R.drawable.ic_capim_limao_doterra) )
        list.add(ListaModel("Hortelã-pimenta", "Relaxa os músculos e reduz tensão", 0, R.drawable.hortela_pimenta_doterra) )
        list.add(ListaModel("Patchouli", "Deixa a pele macia e radiante", 0, R.drawable.ic_patchuli_doterra) )
        list.add(ListaModel("Nardo", "Calma e relaxamento.", 0, R.drawable.ic_nardo_doterra) )
        list.add(ListaModel("Toranja", "Revigorante e melhora a aparência da pele.", 0, R.drawable.ic_toranja_doterra) )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_loja_doterra, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when  {

            item.itemId == R.id.ic_telefone -> {
                callNumber()
                return true
            }

            item.itemId == R.id.ic_zap -> {
                callZap()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun callNumber() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99619-8678")
        startActivity(callIntent)
    }

    fun callZap() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse( "tel: 71 99169-7422")
        startActivity(callIntent)
    }

}
