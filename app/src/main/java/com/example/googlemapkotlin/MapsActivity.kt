package com.example.googlemapkotlin

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.googlemapkotlin.databinding.ActivityMapsBinding
import com.example.googlemapkotlin.misc.CameraAndViewPort
import com.example.googlemapkotlin.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, OnPolylineClickListener {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val pune = LatLng(18.5204, 73.8567)
    private val mumbai = LatLng(19.0760, 72.8777)
    private val delhi = LatLng(28.7041, 77.1025)
    private val agra = LatLng(27.1766, 78.0422)
    private val chennai = LatLng(13.0827, 80.2707)

    private val typeAndStyle by lazy { TypeAndStyle() }

    private val cameraAndViewPort by lazy { CameraAndViewPort() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(map, item)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera


        val puneMarker = map.addMarker(
            MarkerOptions().position(pune).title("Marker in Pune")
                .snippet("This is a Marker in Pune")
        )


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pune, 5f))

        //UI Settings
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        //Map Style
        typeAndStyle.setMapStyle(googleMap = googleMap, context = this)

        lifecycleScope.launch {
            addPolyLine()
        }
    }


    private suspend fun addPolyLine() {

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

    override fun onPolylineClick(p0: Polyline) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }

}


