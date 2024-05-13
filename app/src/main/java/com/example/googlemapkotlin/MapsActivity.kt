package com.example.googlemapkotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.googlemapkotlin.databinding.ActivityMapsBinding
import com.example.googlemapkotlin.misc.CameraAndViewPort
import com.example.googlemapkotlin.misc.Shapes
import com.example.googlemapkotlin.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val pune = LatLng(18.5204, 73.8567)

    private val shapes by lazy { Shapes() }

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

        //Shapes
        shapes.addCircle(map)

        lifecycleScope.launch {}
    }


}


