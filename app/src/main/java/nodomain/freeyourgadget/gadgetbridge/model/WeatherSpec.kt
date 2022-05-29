package nodomain.freeyourgadget.gadgetbridge.model

import android.os.Parcel
import android.os.Parcelable
import wangdaye.com.geometricweather.gadgetbridge.OpenWeatherContract

/*For gadgetbridge*/
class WeatherSpec() : Parcelable {
    val VERSION = 2
    var timestamp = 0
    var location: String? = null
    var currentTemp = 0
    var currentConditionCode = OpenWeatherContract.UNKNOWN
    var currentCondition: String? = null
    var currentHumidity = 0
    var todayMaxTemp = 0
    var todayMinTemp = 0
    var windSpeed = 0f
    var windDirection = 0
    var forecasts = ArrayList<Forecast>()

    constructor(parcel: Parcel) : this() {
        // There is no need to implement this because we only need to create it
        // instead of reading it.
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(VERSION)
        parcel.writeInt(timestamp)
        parcel.writeString(location)
        parcel.writeInt(currentTemp)
        parcel.writeInt(currentConditionCode)
        parcel.writeString(currentCondition)
        parcel.writeInt(currentHumidity)
        parcel.writeInt(todayMaxTemp)
        parcel.writeInt(todayMinTemp)
        parcel.writeFloat(windSpeed)
        parcel.writeInt(windDirection)
        parcel.writeList(forecasts)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherSpec> {
        override fun createFromParcel(parcel: Parcel): WeatherSpec {
            return WeatherSpec(parcel)
        }

        override fun newArray(size: Int): Array<WeatherSpec?> {
            return arrayOfNulls(size)
        }
    }

    class Forecast() : Parcelable {
        var minTemp = 0
        var maxTemp = 0
        var conditionCode = 0
        var humidity = 0

        constructor(parcel: Parcel) : this() {
            // There is no need to implement this because we only need to create it
            // instead of reading it.
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(minTemp)
            parcel.writeInt(maxTemp)
            parcel.writeInt(conditionCode)
            parcel.writeInt(humidity)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Forecast> {
            override fun createFromParcel(parcel: Parcel): Forecast {
                return Forecast(parcel)
            }

            override fun newArray(size: Int): Array<Forecast?> {
                return arrayOfNulls(size)
            }
        }
    }
}