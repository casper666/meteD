package edu.dartmouth.cs.meted;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by libinjie on 4/16/16.
 */
public class ParkSlot implements ClusterItem {
    private final LatLng mPosition;

    public ParkSlot(double lat, double lng, Long endTime) {
        mPosition = new LatLng(lat, lng);
        mOccupiedEndTime = endTime;
    }

    public ParkSlot(double _longitude, double _latitude, String _streetName,
                    int _dailyFreeParkingStartTime, int _dailyFreeParkingEndTime,
                    double _hourlyFee, String _freeDays, boolean _isOccupied,
                    int _occupiedStartTime, Long _occupiedEndTime) {
        mLongitude = _longitude;
        mLatitude = _latitude;
        mPosition = new LatLng(_latitude,_longitude);
        mStreetName = _streetName;
        mDailyFreeParkingStartTime = _dailyFreeParkingStartTime;
        mDailyFreeParkingEndTime = _dailyFreeParkingEndTime;
        mHourlyFee = _hourlyFee;
        mFreeDays = _freeDays;
        mIsOccupied = _isOccupied;
        mOccupiedStartTime = _occupiedStartTime;
        mOccupiedEndTime = _occupiedEndTime;
    }

    public static final String PARKINGSPOT_PARENT_ENTITY_NAME = "ParkingSpotParent";
    public static final String PARKINGSPOT_PARENT_KEY_NAME = "ParkingSpotParent";

    public static final String PARKINGSPOT_ENTITY_NAME = "ParkingSpot";
    public static final String FIELD_NAME_LONGITUDE = "longitude";
    public static final String FIELD_NAME_LATITUDE = "latitude";
    public static final String FIELD_NAME_STREETNAME = "streetName";
    public static final String FIELD_NAME_DAILYFREEPARKINGSTARTTIME = "dailyFreeParkingStartTime";
    public static final String FIELD_NAME_DAILYFREEPARKINGENDTIME = "dailyFreeParkingEndTime";
    public static final String FIELD_NAME_HOURLYFEE = "hourlyFee";
    public static final String FIELD_NAME_FREEDAYS = "freeDays";
    public static final String FIELD_NAME_ISOCCUPIED = "isOccupied";
    public static final String FIELD_NAME_OCCUPIEDSTARTTIME = "occupiedStartTime";
    public static final String FIELD_NAME_OCCUPIEDENDTIME = "occupiedEndTime";

    public double mLongitude;
    public double mLatitude;
    public String mStreetName;
    public int mDailyFreeParkingStartTime;
    public int mDailyFreeParkingEndTime;
    public double mHourlyFee;
    public String mFreeDays;
    public Boolean mIsOccupied;
    public int mOccupiedStartTime;

    public Long getmOccupiedEndTime() {
        return mOccupiedEndTime;
    }

    public Long mOccupiedEndTime;

    public String getCoordInString () {
        return Double.toString(this.mLongitude)
                + "+" +
                Double.toString(this.mLatitude);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
