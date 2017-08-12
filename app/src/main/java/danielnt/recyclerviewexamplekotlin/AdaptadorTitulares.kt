package danielnt.recyclerviewexamplekotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.danwe.pruebastutorial.Titular

/**
 * Created by DanielNT on 12/08/2017.
 */
class AdaptadorTitulares(val datos: ArrayList<Titular>)
    : RecyclerView.Adapter<AdaptadorTitulares.TitularesViewHolder>(), View.OnClickListener {

    private var listener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TitularesViewHolder {
        val itemView = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.listitem_titular, parent, false)

        itemView.setOnClickListener(this)
        return TitularesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TitularesViewHolder?, position: Int) {
        holder?.bindTitular(datos[position])
    }

    override fun getItemCount(): Int = datos.size


    //ViewHolder
    class TitularesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //obtaining elements for modyfing
        val txtTitulo: TextView = itemView.findViewById<TextView>(R.id.lblTitulo)
        val txtSubtitulo: TextView = itemView.findViewById<TextView>(R.id.lblSubTitulo)

        fun bindTitular(t: Titular) {
            txtTitulo.text = t.titulo
            txtSubtitulo.text = t.subtitulo
        }
    }

    fun setOnClickListener(listener: View.OnClickListener) {
        this.listener = listener
    }

    override fun onClick(view: View) {
        if (listener != null) {
            listener!!.onClick(view)
        }
    }

}