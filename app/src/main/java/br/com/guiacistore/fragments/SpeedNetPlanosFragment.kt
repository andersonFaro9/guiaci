package br.com.guiacistore.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R
import br.com.guiacistore.interfaces.IFirebase
import br.com.guiacistore.model.LojasModelFireBase
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.speednet_fragment_planos.*




class SpeedNetPlanosFragment : Fragment() , IFirebase {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        doDatabaseInstance(1)
        return inflater.inflate(R.layout.speednet_fragment_planos, container, false)

    }


    override val databaseInstance: FirebaseDatabase?
        get() = FirebaseDatabase.getInstance()

    override val referenciaFirebase: DatabaseReference?
        get() = databaseInstance?.getReference("clientes")

    override fun doDatabaseInstance(id: Int): Boolean {
        referenciaFirebase?.child(id.toString())


            planoSpeednetprogressBar?.visibility = View.VISIBLE



        referenciaFirebase?.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                for (d in dataSnapshot?.children!!) {

                    val cliente = d.getValue(LojasModelFireBase::class.java)
                    speednet_download_5_megas?.text = cliente?.speednet_download_5_megas
                    speednet_download_5_megas_speedZap?.text = cliente?.speednet_download_5_megas_speedZap

                    speednet_download_7_megas?.text = cliente?.speednet_download_7_megas
                    speednet_download_7_megas_speedFace?.text = cliente?.speednet_download_7_megas_speedFace

                    speednet_download_10_megas?.text = cliente?.speednet_download_10_megas
                    speednet_download_10_megas_speedFlix?.text = cliente?.speednet_download_10_megas_speedFlix

                    speednet_download_15_megas?.text = cliente?.speednet_download_15_megas
                    speednet_download_15_megas_speedUltra?.text = cliente?.speednet_download_15_megas_speedUltra

                    speednet_download_20_megas?.text = cliente?.speednet_download_20_megas
                    speednet_download_20_megas_speedFull?.text = cliente?.speednet_download_20_megas_speedFull


                }

                planoSpeednetprogressBar?.visibility = View.INVISIBLE
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                Log.d("onCancelled", "error...", databaseError?.toException())


            }

        })

        return true
    }



}
