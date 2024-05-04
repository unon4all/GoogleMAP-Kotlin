package com.example.googlemapkotlin.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.example.googlemapkotlin.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class TypeAndStyle {


    fun setMapStyle(googleMap: GoogleMap, context: Context) {
        try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context, R.raw.style
                )
            )
            if (!success) {
                Log.d("Maps", "Failed to Add Styles")
            }
        } catch (e: Exception) {
            Log.d("Maps", e.toString())
        }
    }


    fun setMapType(map: GoogleMap, item: MenuItem) {
        when (item.itemId) {
            R.id.map -> map.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.hybrid_map -> map.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.none_map -> map.mapType = GoogleMap.MAP_TYPE_NONE
            R.id.normal_map -> map.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.satellite_map -> map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.terrain_map -> map.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }
    }


}