package com.example.game

import java.io.Serializable

class Cartas: Serializable {
    var name: String? = null
    var image: Int? = null

    constructor(name: String, image: Int) {
        this.name = name
        this.image = image
    }
    //fun getName : String{return this.name}
}