package by.tms.flower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_flower_layout.*
import kotlinx.android.synthetic.main.fragment_bottom_layout.*

class FlowerDetailsActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bottom_layout)

        val flowers = FlowerCollection.instance.list

        nameBottom.text= intent.getStringExtra(NAME)
        priceBottom.text= intent.getDoubleExtra(PRICE,0.0).toString()


    }
}