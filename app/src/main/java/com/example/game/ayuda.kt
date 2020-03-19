package com.example.game

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class ayuda : AppCompatActivity() {
    private var gestureDetectorCompat: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        gestureDetectorCompat = GestureDetectorCompat(this, ayuda.MyGestureListener(this))
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
                val intent = Intent(content_1,  MainActivity::class.java)
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
}
