package com.example.mc_ca.data

import android.os.Parcel
import com.example.mc_ca.NEW_TEAM_ID
import java.util.*
import android.os.Parcelable

// data means the class is going to have some properties, will have at least one primary constructor, and have functions such as equals() toString...
// See https://www.javatpoint.com/kotlin-data-class for a comparison of Java and Kotlin classes
data class TeamEntity(
    var idTeam: Int,
    var strTeam: String?,
    var strLeague: String?,
    var strStadium: String?
) : Parcelable
{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    // no arguments constructor - if no values are passed in this one is executed.
    //constructor() : this(NEW_TEAM_ID, "", "", "")
    // New Plant - this constructor is called when ther eis a name, date and description, but no plant ID yet
    //constructor(name: String, league: String, stadium: String) : this(NEW_TEAM_ID, name, league, stadium)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idTeam)
        parcel.writeString(strTeam)
        parcel.writeString(strLeague)
        parcel.writeString(strStadium)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamEntity> {
        override fun createFromParcel(parcel: Parcel): TeamEntity {
            return TeamEntity(parcel)
        }

        override fun newArray(size: Int): Array<TeamEntity?> {
            return arrayOfNulls(size)
        }
    }



}