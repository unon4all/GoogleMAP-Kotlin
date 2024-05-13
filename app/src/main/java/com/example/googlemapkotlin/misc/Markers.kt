package com.example.googlemapkotlin.misc

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class Markers {

    // Vector to Bitmap
//    private fun fromVectorToBitmap(id: Int, color: Int): BitmapDescriptor {
//
//        val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(resources, id, null)
//        if (vectorDrawable == null) {
//            Log.d("Bitmap", "Null")
//            return BitmapDescriptorFactory.defaultMarker()
//        }
//
//        val bitmap = Bitmap.createBitmap(
//            vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
//        )
//
//        val canvas = android.graphics.Canvas(bitmap)
//        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
//        vectorDrawable.setTint(color)
//        vectorDrawable.draw(canvas)
//
//        return BitmapDescriptorFactory.fromBitmap(bitmap)
//    }

}