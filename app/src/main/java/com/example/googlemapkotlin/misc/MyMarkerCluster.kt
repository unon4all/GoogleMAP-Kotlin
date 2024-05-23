package com.example.googlemapkotlin.misc

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterManager

class MyMarkerCluster {


    private lateinit var clusterManager: ClusterManager<MyItem>

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

    private val titleList = listOf(
        "Pune",
        "Pune",
        "Pune",
        "Pune",
        "Pune",
        "Pune",
        "Pune",
        "Pune",
    )

    private val snippetsList = listOf(
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
        "This is a Marker in Pune",
    )



//    clusterManager = ClusterManager(this, map)
//    map.setOnCameraIdleListener(clusterManager)
//    map.setOnMarkerClickListener(clusterManager)
//
//    addMarkers()
//
//    private fun addMarkers() {
//        locationList.zip(titleList).zip(snippetsList).forEach { pair ->
//            val myItem =
//                MyItem(pair.first.first, "title: ${pair.first.second}", "Snippet: ${pair.second}")
//            clusterManager.addItem(myItem)
//        }
//    }

}