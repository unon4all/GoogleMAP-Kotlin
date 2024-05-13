package com.example.googlemapkotlin.misc

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.googlemapkotlin.R
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker

class CustomInfoAdapter(context: Context) : InfoWindowAdapter {


    private val contents: View =
        (context as Activity).layoutInflater.inflate(R.layout.custom_info_window, null)

    override fun getInfoContents(marker: Marker): View? {

        renderViews(marker, contents)
        return contents
    }

    override fun getInfoWindow(marker: Marker): View? {
        renderViews(marker, contents)
        return contents
    }


    private fun renderViews(markers: Marker?, contents: View) {
        val title = markers?.title
        val description = markers?.snippet


        val titleTextView = contents.findViewById<TextView>(R.id.title_textView)
        titleTextView.text = title

        val descriptionTextView = contents.findViewById<TextView>(R.id.desc_textView2)
        descriptionTextView.text = description
    }


}