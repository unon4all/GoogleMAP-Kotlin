package com.example.googlemapkotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
import com.google.maps.android.data.geojson.GeoJsonLayer

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val pune = LatLng(18.5204, 73.8567)

    private val shapes by lazy { Shapes() }
    private val overlays by lazy { OverLays() }

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
            isMyLocationButtonEnabled = true
        }


        //Map Style
        typeAndStyle.setMapStyle(googleMap = googleMap, context = this)

//        checkLocationPermission()


        val layer = GeoJsonLayer(
            map, R.raw.map, this
        )

        layer.addLayerToMap()

        val polygonStyle = layer.defaultPolygonStyle
        polygonStyle.apply {
            polygonStyle.fillColor = ContextCompat.getColor(this@MapsActivity, R.color.purple_200)
            polygonStyle.strokeColor = ContextCompat.getColor(this@MapsActivity, R.color.purple_700)
            polygonStyle.strokeWidth = 5f
        }

        layer.setOnFeatureClickListener {
            Log.d("TAG", "onFeatureClick: ${it.id}")
        }

        for (feature in layer.features) {
            Log.d("TAG", "onMapReady: ${feature.id}")
        }

    }

    private fun checkLocationPermission() {

        //Location Permission
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
            Toast.makeText(this, "Already Enabled", Toast.LENGTH_SHORT).show()
        } else {
            requestPermissions()
        }
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
        )
    }

    @SuppressLint("MissingPermission", "MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        if (requestCode != 100) {
            return
        }

        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show()
            map.isMyLocationEnabled = true
        } else {
            Toast.makeText(this, "Permission Needed !!!", Toast.LENGTH_SHORT).show()
        }
    }
}


