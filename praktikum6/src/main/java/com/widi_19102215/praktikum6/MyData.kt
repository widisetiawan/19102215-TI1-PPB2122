package com.widi_19102215.praktikum6

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class MyData(s: String, s1: String, s2: String) {
    @Parcelize
    data class MyData(
        var name: String,
        var description: String,
        var photo: String,
        val lat: Double,
        val lang: Double

    ) : Parcelable

}