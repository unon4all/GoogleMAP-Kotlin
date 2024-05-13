package com.example.googlemapkotlin.misc

import com.example.googlemapkotlin.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlay
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class OverLays {

    private val pune = LatLng(18.5204, 73.8567)
    private val mumbai = LatLng(19.0760, 72.8777)
    private val puneBounds = LatLngBounds(pune, mumbai)

    fun addGroundOverlay(map: GoogleMap): GroundOverlay? {
        return map.addGroundOverlay(
            GroundOverlayOptions().apply {
//                position(pune, 10000f)
                positionFromBounds(puneBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
            }
        )
    }

    fun addGroundOverlayWithTag(map: GoogleMap): GroundOverlay? {
        val groundOverlay = map.addGroundOverlay(
            GroundOverlayOptions().apply {
//                position(pune, 10000f)
                positionFromBounds(puneBounds)
                image(BitmapDescriptorFactory.fromResource(R.drawable.custom_marker))
            }
        )

        groundOverlay?.tag = "pune"

        return groundOverlay
    }

}