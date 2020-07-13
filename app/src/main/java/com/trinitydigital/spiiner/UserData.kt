package com.trinitydigital.spiiner

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    val fullName: String,
    val gender: String,
    val userName: String,
    var password: String,
    val code: Int,
    val phone: String,
    var email: String
) : Parcelable