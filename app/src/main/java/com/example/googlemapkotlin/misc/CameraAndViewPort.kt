package com.example.googlemapkotlin.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewPort {

    val losAngles: CameraPosition =
        CameraPosition.builder().target(LatLng(34.0522, -118.2437)).zoom(17f).bearing(100f).tilt(30f)
            .build()


    val melbourneBounds = LatLngBounds(
        LatLng(-37.8136, 144.9631),
        LatLng(-37.8128, 144.9641)
    )
}