package danielnt.recyclerviewexamplekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.danwe.pruebastutorial.Titular
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var datos: ArrayList<Titular>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init list of data
        datos = ArrayList<Titular>()
        for (i in 0..50) {
            datos?.add(Titular("Título ${i + 1}", "Subtítulo largo ${i + 1}"))
        }

        //init RecyclerView
        recView.setHasFixedSize(true)
        recView.adapter = AdaptadorTitulares(datos!!)

        //assign layoutManager
        recView.layoutManager = GridLayoutManager(this,3)
    }
}
