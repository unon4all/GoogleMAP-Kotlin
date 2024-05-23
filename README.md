# Google Maps SDK Project

This project is a comprehensive implementation of the Google Maps SDK for Android, following the guidance provided in the Udemy course "Learn Google Maps SDK for Android. And also Create Distance Tracker App for tracking users location from a background". This README file outlines the features implemented in the project and provides an overview of the project's structure and functionality.

## Table of Contents
- [Features](#features)
  - [Section 1: Introduction and Setup](#section-1-introduction-and-setup)
  - [Section 2: Basic Map Features](#section-2-basic-map-features)
  - [Section 3: Map Markers](#section-3-map-markers)
  - [Section 4: Map Types and Styles](#section-4-map-types-and-styles)
  - [Section 5: Camera and Views](#section-5-camera-and-views)
  - [Section 6: Drawing on the Map](#section-6-drawing-on-the-map)
  - [Section 7: User Location](#section-7-user-location)
  - [Section 9: Maps SDK Utility Library](#section-9-maps-sdk-utility-library)
- [Installation](#installation)
- [Usage](#usage)
- [References](#references)

## Features

### Section 1: Introduction and Setup
- **Project setup**: Configured the initial Android project and integrated the Google Maps SDK.
- **API Key configuration**: Set up the Google Maps API key for accessing map services.

### Section 2: Basic Map Features
- **Displaying a map**: Implemented a basic Google Map in the Android app.
- **Map fragments**: Utilized MapFragment to display the map within the app's layout.

### Section 3: Map Markers
- **Adding markers**: Placed markers on the map at specific locations.
- **Custom markers**: Customized marker icons and added info windows for markers.
- **Marker events**: Handled marker click events to provide interactivity.

### Section 4: Map Types and Styles
- **Map types**: Implemented different map types such as Normal, Satellite, Terrain, and Hybrid.
- **Custom map styles**: Applied custom styling to the map for a unique look and feel.

### Section 5: Camera and Views
- **Camera positioning**: Controlled the camera's position and movement on the map.
- **Camera animations**: Implemented smooth camera animations for map transitions.

### Section 6: Drawing on the Map
- **Polylines and polygons**: Drew polylines and polygons to highlight specific areas on the map.
- **Circles**: Added circles to represent areas around specific points on the map.

### Section 7: User Location
- **Current location**: Enabled the app to display the user's current location on the map.
- **Location permissions**: Managed location permissions and handled cases where permissions are denied.
- **Location updates**: Implemented continuous location updates to track the user's movement.

### Section 9: Maps SDK Utility Library
- **Marker clustering**: Implemented marker clustering to manage large numbers of markers efficiently.
- **Heatmaps**: Added heatmaps to represent data density on the map.
- **GeoJSON and KML layers**: Integrated GeoJSON and KML layers to display complex geographical data.
- **Custom tile overlays**: Added custom tile overlays for additional map customization.

## Installation

To run this project on your local machine, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/unon4all/GoogleMAP-Kotlin.git
   cd google-maps-sdk-project
   ```

2. **Open the project in Android Studio.**

3. **Add your Google Maps API key:**
   - Obtain an API key from the [Google Cloud Console](https://console.cloud.google.com/).
   - Add your API key to the `google_maps_api.xml` file in the `res/values` directory:
     ```xml
     <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">YOUR_API_KEY_HERE</string>
     ```

4. **Build and run the project on an Android device or emulator.**

## Usage

Once the project is set up and running, you can explore the different features by navigating through the app. The app showcases various capabilities of the Google Maps SDK, including map customization, user location tracking, and advanced features using the Maps SDK Utility Library.

## References

- [Udemy Course: Learn Google Maps SDK for Android](https://www.udemy.com/course/google-maps-sdk-for-android-with-kotlin-masterclass/)
- [Google Maps SDK for Android Documentation](https://developers.google.com/maps/documentation/android-sdk/overview)
- [Google Maps Android Utility Library](https://developers.google.com/maps/documentation/android-sdk/utility/overview)

Feel free to explore the code and modify it to suit your needs. If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request.

---

Thank you for checking out this project! Happy mapping!
