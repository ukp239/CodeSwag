package com.example.codeswag.Model

import android.os.Parcel
import android.os.Parcelable

class Item(var product: Product?, var descr: String): Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("product"),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descr)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}