package danielnt.recyclerviewexamplekotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by DanielNT on 12/08/2017.
 */
class MainActivity : AppCompatActivity() {

    private var datos: ArrayList<Titular>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init list of data
        datos = ArrayList<Titular>()
        for (i in 0..50) {
            datos?.add(Titular("Título $i", "Subtítulo largo $i"))
        }

        //init RecyclerView
        recView.setHasFixedSize(true)
        val adaptador =  AdaptadorTitulares(datos!!)

        //assign onClick action with lambda
        adaptador.setOnClickListener(View.OnClickListener { v ->   Snackbar.make(v,"Pulsado el elemento " + recView.getChildAdapterPosition(v),Snackbar.LENGTH_SHORT).show()})
        recView.adapter = adaptador

        //assign layoutManager
        recView.layoutManager = GridLayoutManager(this,3)

        //adding ItemDecoration and ItemAnimator
        recView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recView.itemAnimator= DefaultItemAnimator()

        //buttons
        BtnMover.setOnClickListener({
            val aux = datos?.get(1)
            datos?.set(1, datos!!.get(2))
            datos?.set(2, aux!!)
            adaptador.notifyItemMoved(1, 2)

        })

        BtnEliminar.setOnClickListener({
            if (datos?.size!! >= 2) {
                datos?.removeAt(1)
                adaptador.notifyItemRemoved(1)
            }
        })

        BtnInsertar.setOnClickListener({
            datos?.add(1, Titular("Nuevo titular", "Subtitulo nuevo titular"))
            adaptador.notifyItemInserted(1)
        })

    }
}
