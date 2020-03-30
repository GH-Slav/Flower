package by.tms.flower

import FragmentTop
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

const val NAME = "NAME"
const val PRICE = "PRICE"
const val URL = "URL"

class MainActivity : AppCompatActivity(), FragmentTop.CountListener {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProvider(this).get(MyViewModel::class.java)

        model.name = "main activity name"

        val flower = Flower("rose", "http://", 7.5)

        topFragment.setOnClickListener {
            val intent = Intent(this, FlowerDetailsActivity::class.java)
            intent.putExtra(NAME, flower.name)
            intent.putExtra(PRICE, flower.price)
            intent.putExtra(URL, flower.url)


            startActivity(intent)
        }

        addTopFragment.setOnClickListener {
            val fragmentTop = FragmentTop()
            supportFragmentManager.beginTransaction().replace(R.id.topFragment, fragmentTop)
                .commit()
        }
        removeTopFragment.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.topFragment)
            currentFragment?.let { etotFragment -> supportFragmentManager.beginTransaction().remove(etotFragment).commit() }
        }

    }

    override fun countClick() {
        counter.text = (counter.text.toString().toInt() + 1).toString()
    }
}
