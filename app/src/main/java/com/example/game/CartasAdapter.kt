package com.example.game

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView



class CartasAdapter(listaUsuarios: List<Cartas>) : RecyclerView.Adapter<CartasAdapter.CartasViewHolder>() {
    private val listaUsuarios: List<Cartas>

    override fun onCreateViewHolder( viewGroup: ViewGroup, i: Int): CartasViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.carta_item, viewGroup, false)
        return CartasViewHolder(v)
    }

    override fun onBindViewHolder( cartasViewHolder: CartasViewHolder, i: Int) {

        cartasViewHolder.ivImagen!!.setImageResource(listaUsuarios[i].image as Int)
        //Log.d("onBHolder  ",cartasViewHolder.ivImagen.toString())
        cartasViewHolder.tvNombre!!.setText(listaUsuarios[i].name)
    }

    override fun getItemCount() : Int
    {
       return listaUsuarios.size
    }
    init {
        this.listaUsuarios = listaUsuarios
    }

    inner class CartasViewHolder( itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ivImagen: ImageView? = null
        var tvNombre: TextView? = null

        init {
            ivImagen = itemView.findViewById(R.id.imagenCelu)
            tvNombre = itemView.findViewById(R.id.nomCelu)
        }

    }


}

/*
    var foodsList = ArrayList<Cartas>()
    var context: Context? = null

    constructor(context: Context, foodsList: ArrayList<Cartas>) : super() {
        this.context = context
        this.foodsList = foodsList
    }

    override fun getCount(): Int {
        return foodsList.size
    }

    override fun getItem(position: Int): Any {
        return foodsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.foodsList[position]
        Log.d("getView  ",position.toString())
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.carta_item, null)
        foodView.nomCelu.text  =food.name!!
        foodView.imagenCelu.setImageResource(food.image!!)

        return foodView
    }


}*/