Android Sensors Demo App
===

Description
---

This is a sample Android app that displays raws sensor values for various sensors available on most smartphones. Currently, this app suppports the accelerometer, ambient light sensor, GPS, magnetometer, pressure sensor, and proximity sensor.   

Upon launch, the user is greeted with a menu displaying each sensor. If the user's phone does not support a sensor, the button will appear disabled.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/mainActivity.jpg" width="400" height="650" title="Main Activity"> 

The proximity sensor measures the distance of an object relative to the screen of a device. This measurement is in centimeters. The proximity sensor is typically used to check whether a user is placing their phone onto their ear during a call.  
<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/proximity_sensor.jpg" width="400" height="650" title="Proximity Sensor"> 

The accelerometer measures the accelation forces applied to a device. This is measured in m/s^2. This sensor returns three measurements, one for each axis (x, y, and z). This sensor is mostly used to detect in motion of the device for various application features and games.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/accelerometer.jpg" width="400" height="650" title="accelerometer"> 


The ambient light sensor is used to measure the illumination of the outside environment. This is measured in lx. This sensor is predominantly used to control screen brightness.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/light_sensor.jpg" width="400" height="650" title="Ambient Light Sensor"> 

The GPS is used to determine a user's location. This sensor returns two values, the latitude and the longitude. The GPS is used for various location-specific features like driving directions. When using the GPS on this app, the user must have the locations permission enabled and then press the "GET COORDINATES" button to get their current GPS coordinates.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/gps.jpg" width="400" height="650" title="GPS"> 

The magnetometer returns the ambient mangetic field of a device. The measurements are returned in three values for each axis (x, y, and z). Each value is returned in micro-Teslas. This app is used for various compass related compass related tasks.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/magnetometer.jpg" width="400" height="650" title="Magnetometer"> 

The Pressure sensor measures the ambient air pressure in hPa or mBar. This sensor is not as common as the rest and therefore might not be available on certain devices. This sensor is part of the environment sensor group that are used to measure weather and atmospheric properties of a phone's environment.  

<img src="https://github.com/hrazo7/smartphone-sensors-app/blob/master/screenshots/proximity_sensor.jpg" width="400" height="650" title="Proximity Sensor">  


Sources and Helpful Links
---
https://developer.android.com/guide/topics/sensors/sensors_overview  
https://developer.android.com/guide/topics/sensors/sensors_environment