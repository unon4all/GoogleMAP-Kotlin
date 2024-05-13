package com.example.googlemapkotlin.misc

import android.graphics.Color
import com.example.googlemapkotlin.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.CustomCap
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Dot
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap
import com.google.android.gms.maps.model.SquareCap
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

    suspend fun addPolyLine(map: GoogleMap) {

//        val pattern = listOf(Dot(), Gap(30f), Dash(50f), Gap(30f))

        val polyLine = map.addPolyline(PolylineOptions().apply {
            add(pune, mumbai)
            width(40f)
            color(Color.BLUE)
            geodesic(true)
            clickable(true)
            jointType(2)
            startCap(CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker),100f))
            endCap(SquareCap())
//            pattern(pattern)
        })

//        delay(5000)
//
//        val newList = listOf(pune, mumbai, delhi, agra, chennai)
//
//        polyLine.points = newList

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

    fun addCircle(map: GoogleMap) {

        val circle = map.addCircle(
            CircleOptions().apply {
                center(pune)
                radius(2000.0)
                fillColor(Color.RED)
                strokeColor(Color.BLACK)
                strokeWidth(10f)
            }
        )

    }

}