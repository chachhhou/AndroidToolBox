package fr.isen.suarez.androidtoolbox

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_life_cycle.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [lifeCycleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [lifeCycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class lifeCycleFragment : Fragment() {

    private var listener: OnFragmentListenerInteraction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    override fun onStart(){
        super.onStart()
        button.setOnClickListener{
            listener?.swipeFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListenerInteraction) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }



    override fun onDetach() {
        super.onDetach()
        listener = null
    }



    override fun onPause (){
        super.onPause()
        Log.d("message","Fragment en fond")
    }
}
