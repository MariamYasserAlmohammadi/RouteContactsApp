package com.route.routecontactsapp

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.parcelize.Parcelize

// no logic in data class
// data class have for free 4 functions
// 1.toString , 2.equals , 3.hash , 4.copy
// diff between plugin and library
// plugin is a software make auto generated to files  not all plugins make auto generated
//software generate code
// libraries code files add to our code base
@Parcelize
data class Contact(
    val name: String ,
    val phone:String,
    val description:String,

):Parcelable