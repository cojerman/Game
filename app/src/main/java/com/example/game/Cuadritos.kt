package com.example.game

import java.io.Serializable

class Cuadritos : Serializable {
    var name: String? = null
    var image: Int? = null

    constructor(name: String, image: Int) {
        this.name = name
        this.image = image
    }
}