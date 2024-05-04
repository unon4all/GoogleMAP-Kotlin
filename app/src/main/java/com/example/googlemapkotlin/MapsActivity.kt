package com.example.googlemapkotlin

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
import com.google.android.gms.maps.GoogleMap.CancelableCallback
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

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
        val sydney = LatLng(34.0522, -118.2437)
        val newYork = LatLng(40.7128, -74.0060)
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
//        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewPort.losAngles))

        //UI Settings
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }

        //Map Style
        typeAndStyle.setMapStyle(googleMap = googleMap, context = this)

//        googleMap.setMinZoomPreference(15f)
//        googleMap.setMaxZoomPreference(20f)

//        lifecycleScope.launch {
//            delay(4000L)
////            map.moveCamera(CameraUpdateFactory.zoomBy(3f))
////            map.moveCamera(CameraUpdateFactory.newLatLng(newYork))
////            map.moveCamera(CameraUpdateFactory.scrollBy(0f, 100f))
////            map.moveCamera(
////                CameraUpdateFactory.newLatLngBounds(
////                    cameraAndViewPort.melbourneBounds, 100
////                )
////            )
//
////            map.animateCamera(
////                CameraUpdateFactory.newLatLngBounds(
////                    cameraAndViewPort.melbourneBounds, 100
////                ), 5000, null
////            )
//
//
////            map.setLatLngBoundsForCameraTarget(cameraAndViewPort.melbourneBounds)
//
////            map.animateCamera(CameraUpdateFactory.zoomTo(15f), 2000, null)
//
//            map.animateCamera(
//                CameraUpdateFactory.newCameraPosition(cameraAndViewPort.losAngles), 2000, null
//            )
//
//            //CallBack method
//
//            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewPort.losAngles),
//                2000,
//                object : CancelableCallback {
//                    override fun onFinish() {
//                        Toast.makeText(this@MapsActivity, "Finished", Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onCancel() {
//                        Toast.makeText(this@MapsActivity, "Cancelled", Toast.LENGTH_SHORT).show()
//                    }
//
//                })
//        }

        onMapClicked()
        onMapLongClicked()
    }


    private fun onMapClicked() {

        map.setOnMapClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

    }


    private fun onMapLongClicked() {
        map.setOnMapLongClickListener {
            Toast.makeText(this, "${it.latitude}, ${it.longitude}", Toast.LENGTH_SHORT).show()
            map.addMarker(MarkerOptions().position(it).title("New Marker"))
        }


    }

}