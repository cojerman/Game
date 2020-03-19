package com.example.game

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_usuarios.*
import kotlinx.android.synthetic.main.cuadr_item.view.*


class usuarios : AppCompatActivity() {
    private var gestureDetectorCompat: GestureDetectorCompat? = null
    var adapter: FoodAdapter? = null
    var foodsList = ArrayList<Cuadritos>()
   // val gridUsuario : GridView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)

        gestureDetectorCompat = GestureDetectorCompat(this, MyGestureListener(this))

        foodsList.add(Cuadritos("El usuario empresario", R.drawable.empresario_m))
        foodsList.add(Cuadritos("El usuario a la moda", R.drawable.fashion_m))
        foodsList.add(Cuadritos("El usuario fotógrafo", R.drawable.fotografa_m))
        foodsList.add(Cuadritos("El usuario gamer", R.drawable.game_m))
        foodsList.add(Cuadritos("El usuario hiperconectado", R.drawable.hiperconectado_m))
        foodsList.add(Cuadritos("El usuario descuidado", R.drawable.mecanico_m))
        foodsList.add(Cuadritos("El usuaro mayor", R.drawable.personamayor_m))
        foodsList.add(Cuadritos("El usuario sin presupuesto", R.drawable.sinpresupuesto_m))
        foodsList.add(Cuadritos("El usuario viajero", R.drawable.viajera_m))

        adapter = FoodAdapter(this, foodsList)

        gvUsuarios.adapter = adapter

        gvUsuarios.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            //Toast.makeText(this, " Clicked Position: " + (position + 1),
            //    Toast.LENGTH_SHORT).show()
            //Toast.makeText(this,  foodsList[position].name,
           //     Toast.LENGTH_SHORT).show()
            clickDetalleUsuarios(foodsList[position])
        }

    }

    fun clickDetalleUsuarios(cuad: Cuadritos ){
        val intent = Intent(this, DetalleUsuario::class.java)
        intent.putExtra("DetalleUsuario", cuad )
       // intent.putExtra()
        startActivity(intent)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gestureDetectorCompat?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    internal class MyGestureListener(content : Activity) : GestureDetector.SimpleOnGestureListener() {



        //Manejar el slice

        var content_1 : Activity = content

        override fun onFling(
            event1: MotionEvent, event2: MotionEvent,
            velocityX: Float, velocityY: Float
        ): Boolean {
            if (event2.x < event1.x) {
                Toast.makeText( content_1, "Swipe left - startActivity()", Toast.LENGTH_SHORT).show()
                //switch another activity
                val intent = Intent(content_1, MainActivity::class.java)
                (content_1 as Activity).startActivity(intent)
            }
            if (event2.x > event1.x) {
                Toast.makeText( content_1, "Swipe right - startActivity()", Toast.LENGTH_SHORT).show()
                val intent = Intent(content_1, MainActivity::class.java)
                (content_1 as Activity).startActivity(intent)
            }

            return true
        }


    }
///// adaptador
    class FoodAdapter : BaseAdapter {
        var foodsList = ArrayList<Cuadritos>()
        var context: Context? = null

        constructor(context: Context, foodsList: ArrayList<Cuadritos>) : super() {
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



            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.cuadr_item, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!


            return foodView
        }


    }
}


