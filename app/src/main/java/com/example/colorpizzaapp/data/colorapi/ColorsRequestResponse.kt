package com.example.colorpizzaapp.data.colorapi

data class ColorsRequestResponse(val paletteTitle: String, val colors: List<ColorRequestItem> ) {

}

data class ColorRequestItem(
    val name: String,
    val hex: String,
    val rgb: Rgb,
    val hsl: Hsl,
    val luminance: Double,
    val requestedHex: String,
    val distance: Double
)

data class Rgb(val r: Int, val g: Int, val b: Int)

data class Hsl(val h: Double, val s: Double, val l: Double)
