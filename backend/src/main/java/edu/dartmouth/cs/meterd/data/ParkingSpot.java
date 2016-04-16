package edu.dartmouth.cs.meterd.data;

import java.util.Date;

/**
 * Created by JaySha on 4/15/16.
 */
public class ParkingSpot {
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

    public Float mLongitude;
    public Float mLatitude;
    public String mStreetName;
    public Date mDailyFreeParkingStartTime;
    public Date mDailyFreeParkingEndTime;
    public Float mHourlyFee;
    public String mFreeDays;
    public Boolean mIsOccupied;
    public Date mOccupiedStartTime;
    public Date mOccupiedEndTime;

    public ParkingSpot(float _longitude, float _latitude, String _streetName,
                       Date _dailyFreeParkingStartTime, Date _dailyFreeParkingEndTime,
                       float _hourlyFee, String _freeDays, boolean _isOccupied,
                       Date _occupiedStartTime, Date _occupiedEndTime) {
        mLongitude = _longitude;
        mLatitude = _latitude;
        mStreetName = _streetName;
        mDailyFreeParkingStartTime = _dailyFreeParkingStartTime;
        mDailyFreeParkingEndTime = _dailyFreeParkingEndTime;
        mHourlyFee = _hourlyFee;
        mFreeDays = _freeDays;
        mIsOccupied = _isOccupied;
        mOccupiedStartTime = _occupiedStartTime;
        mOccupiedEndTime = _occupiedEndTime;
    }

    public String getCoordInString () {
        return Float.toString(this.mLongitude)
                + "+" +
                Float.toString(this.mLatitude);
    }
}
