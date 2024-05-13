package com.example.googlemapkotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.googlemapkotlin.databinding.ActivityMapsBinding
import com.example.googlemapkotlin.misc.CameraAndViewPort
import com.example.googlemapkotlin.misc.CustomInfoAdapter
import com.example.googlemapkotlin.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, OnMarkerClickListener {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

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
        val pune = LatLng(18.5204, 73.8567)
        val pune2 = LatLng(18.457872, 73.857959)
        val newYork = LatLng(40.7128, -74.0060)

        val puneMarker = map.addMarker(
            MarkerOptions().position(pune).title("Marker in Pune")
                .snippet("This is a Marker in Pune")
        )

        val puneMarker2 = map.addMarker(
            MarkerOptions().position(pune2).title("Marker in Pune2").zIndex(1f)
                .snippet("This is a Marker in Pune2")
        )

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pune, 10f))

        //UI Settings
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        //Map Style
        typeAndStyle.setMapStyle(googleMap = googleMap, context = this)

        lifecycleScope.launch {
            delay(4000L)

        }

        map.setOnMarkerClickListener(this)

        map.setInfoWindowAdapter(CustomInfoAdapter(this))

    }

    override fun onMarkerClick(marker: Marker): Boolean {
        map.animateCamera(CameraUpdateFactory.zoomTo(10f), 2000, null)
        marker.showInfoWindow()
        return true
    }


}


