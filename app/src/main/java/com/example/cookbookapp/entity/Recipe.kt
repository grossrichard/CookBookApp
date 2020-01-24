package com.example.cookbookapp.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Richard Gross on 2020-01-15
 */
data class Recipe(
    var name: String? = null,
    var description: String? = null,
    var duration: Int? = null,
    var ingredients: List<String>? = null,
    var info: String? = null,
    var id: String? = null,
    var score: Float? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createStringArrayList() as List<String>?,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeValue(duration)
        parcel.writeStringList(ingredients)
        parcel.writeString(info)
        parcel.writeString(id)
        parcel.writeValue(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}