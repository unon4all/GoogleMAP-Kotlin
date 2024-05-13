package com.example.googlemapkotlin.misc

import android.graphics.Color
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay

class Shapes {

    private val pune = LatLng(18.5204, 73.8567)
    private val mumbai = LatLng(19.0760, 72.8777)
    private val delhi = LatLng(28.7041, 77.1025)
    private val agra = LatLng(27.1766, 78.0422)
    private val chennai = LatLng(13.0827, 80.2707)

    private val nasik = LatLng(20.9043, 72.8311)
    private val malegaon = LatLng(19.0760, 72.8777)
    private val ahmednagar = LatLng(22.1987, 70.0543)
    private val auranabad = LatLng(22.1987, 70.0543)

    private suspend fun addPolyLine(map: GoogleMap) {

        val polyLine = map.addPolyline(PolylineOptions().apply {
            add(pune, mumbai)
            width(10f)
            color(Color.BLUE)
            geodesic(true)
            clickable(true)
        })

        delay(5000)

        val newList = listOf(pune, mumbai, delhi, agra, chennai)

        polyLine.points = newList

    }


     fun addPolygon(map: GoogleMap) {

        val polygonOptions = map.addPolygon(PolygonOptions().apply {
            add(mumbai, agra, chennai,pune)
            fillColor(Color.RED)
            strokeColor(Color.BLACK)
            strokeWidth(10f)
            addHole(listOf(nasik, malegaon, ahmednagar, auranabad))
            zIndex(1f)
        })

         val polygonOptions2 = map.addPolygon(PolygonOptions().apply {
             add(mumbai,chennai)
             strokeWidth(10f)
         })

    }

}