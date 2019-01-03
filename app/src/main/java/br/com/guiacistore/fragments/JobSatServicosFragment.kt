package br.com.guiacistore.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.guiacistore.R


class JobSatServicosFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {




        return inflater.inflate(R.layout.jobsat_fragment_servicos, container, false)
    }


}
