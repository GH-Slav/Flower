import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.tms.flower.MainActivity
import by.tms.flower.MyViewModel
import by.tms.flower.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_top_layout.*

class FragmentTop : Fragment() {

    interface CountListener{
        fun countClick()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model = activity?.run { ViewModelProvider(this).get(MyViewModel::class.java) }

        nameTop.text = model?.name

        buttonCounter.setOnClickListener {


            val countListener = context as CountListener

            countListener.countClick()
        }

    }
}