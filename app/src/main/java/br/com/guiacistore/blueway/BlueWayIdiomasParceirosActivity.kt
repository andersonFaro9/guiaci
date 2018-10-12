package br.com.guiacistore.blueway
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import br.com.guiacistore.R
import br.com.guiacistore.lojas.RecyclerItemClickListener
import br.com.guiacistore.model.BlueWayIdiomasParceirosAdapter
import br.com.guiacistore.model.BlueWayModel


class BlueWayIdiomasParceirosActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    private val listaDeParceiros = ArrayList<BlueWayModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_way)

        recyclerView = findViewById(R.id.recyclerView)

        this.mostrarListaDeParceiros()

        //Configurar adapter
        val adapter = BlueWayIdiomasParceirosAdapter(listaDeParceiros)

        supportActionBar?.title = "Parceiros Blue Way"

        //Configurar Recyclerview
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerView?.adapter = adapter


        recyclerView?.addOnItemTouchListener(
                RecyclerItemClickListener(
                        applicationContext,
                        recyclerView!!,
                        object : RecyclerItemClickListener.OnItemClickListener {
                            override fun onLongItemClick(view: View?, position: Int) { }

                            override fun onItemClick(view: View, position: Int) {
                                when {/*Aqui vc pode direcionar todas as activitys com os clicks*/  }
                            }

                            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {}
                        }
                )
        )

    }

    fun mostrarListaDeParceiros() {

        // Lista dos parceiros em Pojuca

        var parceirosDaBlueWay = BlueWayModel("Unidade de Pojuca", "Tel: 99628-7958", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Academia Evolution", "")
        listaDeParceiros.add(parceirosDaBlueWay)

        parceirosDaBlueWay = BlueWayModel("", "Escola Surpresa", "")
        listaDeParceiros.add(parceirosDaBlueWay)

        parceirosDaBlueWay = BlueWayModel("", "Colégio 29 de Julho", "")
        listaDeParceiros.add(parceirosDaBlueWay)

        parceirosDaBlueWay = BlueWayModel("", "Escola Betel", "")
        listaDeParceiros.add(parceirosDaBlueWay)


//        Lista dos parceiros em Catu
         parceirosDaBlueWay = BlueWayModel("Unidade de Catu", "Tel: 99694-6672", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Halliburton", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Escola Ágappe", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Escola Traços e Letras", "")
        listaDeParceiros.add(parceirosDaBlueWay)

        parceirosDaBlueWay = BlueWayModel("", "Escola da Tia Lia", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Escola da Tia Margô", "")
        listaDeParceiros.add(parceirosDaBlueWay)

        parceirosDaBlueWay = BlueWayModel("", "Colégio Athena", "")
        listaDeParceiros.add(parceirosDaBlueWay)
        parceirosDaBlueWay = BlueWayModel("", "Filhote de Ogro", "")
        listaDeParceiros.add(parceirosDaBlueWay)







    }

}