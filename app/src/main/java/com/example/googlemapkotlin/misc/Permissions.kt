package com.example.googlemapkotlin.misc

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permissions {

//    private fun checkLocationPermission() {
//
//        //Location Permission
//        if (ContextCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            map.isMyLocationEnabled = true
//            Toast.makeText(this, "Already Enabled", Toast.LENGTH_SHORT).show()
//        } else {
//            requestPermissions()
//        }
//    }
//
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(
//            this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
//        )
//    }
//
//    @SuppressLint("MissingPermission", "MissingSuperCall")
//    override fun onRequestPermissionsResult(
//        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
//    ) {
//        if (requestCode != 100) {
//            return
//        }
//
//        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "Granted", Toast.LENGTH_SHORT).show()
//            map.isMyLocationEnabled = true
//        } else {
//            Toast.makeText(this, "Permission Needed !!!", Toast.LENGTH_SHORT).show()
//        }
//    }

}