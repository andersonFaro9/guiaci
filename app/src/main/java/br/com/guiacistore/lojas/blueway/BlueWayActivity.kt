package br.com.guiacistore.lojas.blueway
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import br.com.guiacistore.R
import br.com.guiacistore.adapter.CustomListaSimplesBlueWayAdapter
import br.com.guiacistore.interfaces.CallNumber
import br.com.guiacistore.interfaces.IMapa
import br.com.guiacistore.model.ListaCustomizadaModel


class BlueWayActivity : AppCompatActivity(), CallNumber, IMapa {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blue_way_activity)

        val listView = findViewById<ListView>(R.id.listView)
        val listaCustomizadaModel: ArrayList<ListaCustomizadaModel> = ArrayList()

        listaCustomizadaModel.add(ListaCustomizadaModel("Blue Way Idiomas", R.drawable.ic_a_blue_way))
        listaCustomizadaModel.add(ListaCustomizadaModel("Matrícule-se", R.drawable.ic_matricula_blue_way))
        listaCustomizadaModel.add(ListaCustomizadaModel("Nossos parceiros", R.drawable.ic_parceiros_blue_way))
        listaCustomizadaModel.add(ListaCustomizadaModel("Promoções", R.drawable.ic_promocao))
        listaCustomizadaModel.add(ListaCustomizadaModel("Contatos", R.drawable.ic_contatos_blue_way))
        listaCustomizadaModel.add(ListaCustomizadaModel("Redes Sociais", R.drawable.ic_redes_sociais_blue_way))

        listView.adapter = CustomListaSimplesBlueWayAdapter(applicationContext, listaCustomizadaModel)

        supportActionBar?.title = "Blue Way Idiomas"

        listView.setOnItemClickListener { adapterView, view, position, l ->

            when (position) {
                0 ->  startActivity(Intent(this, BlueWayFragmentsActivity::class.java))
                1 ->  startActivity(Intent(this, BlueWayMatriculasActivity::class.java))
                2 ->  startActivity(Intent(this, BlueWayParceirosActivity::class.java))
                3 ->  startActivity(Intent(this, BlueWayPromocoesActivity::class.java))
                4 ->  startActivity(Intent(this, BlueWayContatosActivity::class.java))
                5 ->  startActivity(Intent(this, BlueWayRedesSociaisActivity::class.java))

            }
        }


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main_blue_way, menu)
        return true

    }

    override fun verNoMapa() {
        val uri = Uri.parse("https://goo.gl/maps/YKqrLs5QE6H2")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.ic_phone -> {

                callNumber()
                return true
            }

            R.id.ic_mapa_blue_way -> {

                verNoMapa()

                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }



    override fun callNumber() {
        when {
            ContextCompat.checkSelfPermission(BlueWayIdiomasActivity@ this,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED -> if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CALL_PHONE)) {

            } else {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 42)
            }
            else -> callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {

        when { requestCode == 42 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> callPhone() }

    }

    @SuppressLint("MissingPermission")
    fun callPhone(){

        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:996287958")
        startActivity(callIntent)
    }










}