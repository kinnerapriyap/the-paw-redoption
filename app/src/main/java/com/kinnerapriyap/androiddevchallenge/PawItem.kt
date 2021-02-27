package com.kinnerapriyap.androiddevchallenge

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PawItem(
    val imageUrl: String,
    val name: String
) : Parcelable