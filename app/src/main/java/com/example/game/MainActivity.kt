package com.example.game

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var gestureDetectorCompat: GestureDetectorCompat? = null
    private var imageModelArrayList: ArrayList<Cartas>? = null
    //var adapter: CartasAdapter? = null
    private val cartasRV: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<CartasAdapter.CartasViewHolder>? = null
    private var lManager: RecyclerView.LayoutManager? = null

    //lateinit

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        btnAyuda.setOnClickListener{ clickAyuda() }
        btnUsuarios.setOnClickListener{clickUsuarios()}
        gestureDetectorCompat = GestureDetectorCompat(this, MyGestureListener(this))
        imageModelArrayList=cargarMazo()

        rcCartas.setHasFixedSize(true)
        lManager = LinearLayoutManager(this, HORIZONTAL, false)
        rcCartas.setLayoutManager(lManager)

        adapter = CartasAdapter(imageModelArrayList as ArrayList<Cartas>)
        rcCartas.setAdapter(adapter)

        //adapter = CartasAdapter(this, imageModelArrayList as ArrayList<Cartas>)
        //Log.d("oncreate  ",imageModelArrayList.toString())
        //listMazo.adapter=adapter


    }
   override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gestureDetectorCompat?.onTouchEvent(event)
        return super.onTouchEvent(event) }

    fun clickAyuda(){
        val intent = Intent(this, ayuda::class.java)
        startActivity(intent)
    }

    fun clickUsuarios(){
        val intent = Intent(this, usuarios::class.java)
        startActivity(intent)
    }

    private fun cargarMazo(): ArrayList<Cartas> {

        val list = ArrayList<Cartas>()



        //for (i in 0..7) {
            val imageModel = Cartas("Sin Carta", R.drawable.no_celu)
        val imageModel2 = Cartas("Sin Carta2", R.drawable.no_celu)

        Log.d("DentroCargarM:  ",imageModel.name)
            //Buscar de la base de datos y cargar

            //imageModel.setNames(myImageNameList[i])
            //imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        list.add(imageModel2)
        //}

        return list
    }


    internal class MyGestureListener(content : Activity) : SimpleOnGestureListener() {
        //Manejar el slice

        var content_1 : Activity = content

        override fun onFling(
            event1: MotionEvent, event2: MotionEvent,
            velocityX: Float, velocityY: Float
        ): Boolean {
            if (event2.x < event1.x) {
                Toast.makeText( content_1, "Swipe left - startActivity()", Toast.LENGTH_SHORT).show()
                //switch another activity
                val intent = Intent(content_1, ayuda::class.java)
                (content_1 as Activity).startActivity(intent)
            }
            if (event2.x > event1.x) {
                Toast.makeText( content_1, "Swipe right - startActivity()", Toast.LENGTH_SHORT).show()
                val intent = Intent(content_1, usuarios::class.java)
                (content_1 as Activity).startActivity(intent)
            }

            return true
        }
    }

}


