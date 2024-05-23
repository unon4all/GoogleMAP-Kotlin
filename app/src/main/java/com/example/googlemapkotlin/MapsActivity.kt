package com.example.googlemapkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.googlemapkotlin.databinding.ActivityMapsBinding
import com.example.googlemapkotlin.misc.CameraAndViewPort
import com.example.googlemapkotlin.misc.OverLays
import com.example.googlemapkotlin.misc.Shapes
import com.example.googlemapkotlin.misc.TypeAndStyle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.TileOverlayOptions
import com.google.maps.android.heatmaps.Gradient
import com.google.maps.android.heatmaps.HeatmapTileProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val pune = LatLng(18.5204, 73.8567)

    private val shapes by lazy { Shapes() }
    private val overlays by lazy { OverLays() }

    private val typeAndStyle by lazy { TypeAndStyle() }

    private val cameraAndViewPort by lazy { CameraAndViewPort() }


    private val locationList = listOf(
        LatLng(18.5204, 73.8515),
        LatLng(18.5205, 73.8520),
        LatLng(18.5210, 73.8525),
        LatLng(18.5224, 73.8530),
        LatLng(18.5245, 73.8566),
        LatLng(18.5256, 73.8579),
        LatLng(18.5278, 73.8588),
        LatLng(18.5289, 73.8599),
    )


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

    @SuppressLint("PotentialBehaviorOverride")
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
            isMyLocationButtonEnabled = true
        }


        //Map Style
        typeAndStyle.setMapStyle(googleMap = googleMap, context = this)

        addHeatMap()

    }

    private fun addHeatMap() {

        val colors = intArrayOf(
            Color.rgb(255, 0, 0),
            Color.rgb(0, 255, 0),
            Color.rgb(0, 0, 255)
        )

        val startPoints = floatArrayOf(0.2f, 0.4f, 0.6f)

        val gradient = Gradient(colors, startPoints)

        val provider = HeatmapTileProvider.Builder()
            .data(locationList)
            .build()


        val overlay = map.addTileOverlay(TileOverlayOptions().tileProvider(provider))

        lifecycleScope.launch {
            delay(5000)
            overlay?.clearTileCache()
            provider.setGradient(gradient)
            provider.setRadius(50)
            provider.setOpacity(0.6)
        }
    }


}


