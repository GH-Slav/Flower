package by.tms.flower

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize


 class Flower(
    val name:String,
    val url:String,
    val price:Double
)