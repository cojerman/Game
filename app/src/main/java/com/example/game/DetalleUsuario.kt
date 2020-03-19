package com.example.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetalleUsuario : AppCompatActivity() {

    var people : Cuadritos? = null
    var imagen : ImageView? = null
    var detalle: TextView?=null
    var descripcion : TextView?=null
    var fondo : ImageView? = null
    var imagenDinamica :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_usuario)
        imagen = findViewById<ImageView>(R.id.imageUsu)
        descripcion =findViewById<TextView>(R.id.descripcion)
        detalle =findViewById<TextView>(R.id.detalle)
        fondo = findViewById<ImageView>(R.id.imagenFondo)
        people = intent.getSerializableExtra("DetalleUsuario"  ) as? Cuadritos
        //Toast.makeText(this, "Numero de imagen" +people?.image.toString(),
          //   Toast.LENGTH_SHORT).show()
        mostrarUsuario(people?.name as String)
    }

    fun mostrarUsuario(nombre:String){

        if (nombre == "El usuario empresario") {
            imagenDinamica = R.drawable.empresario100
            imagen?.setImageResource(imagenDinamica)
            //fondo?.imageAlpha=10
            fondo?.alpha=0.7f
            detalle?.text="El usuario empresario"
            descripcion?.text= "Es una usuario que busca un dispositivo con mucha memoria RAM y espacio de almacenamiento para instalar programas de la oficina. Viaja mucho asi que necesita conectividad 3G, 4G y Bluetooth."
        }


    }
}
