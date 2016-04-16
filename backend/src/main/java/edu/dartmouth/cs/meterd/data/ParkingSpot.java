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

    public double mLongitude;
    public double mLatitude;
    public String mStreetName;
    public int mDailyFreeParkingStartTime;
    public int mDailyFreeParkingEndTime;
    public double mHourlyFee;
    public String mFreeDays;
    public Boolean mIsOccupied;
    public int mOccupiedStartTime;
    public int mOccupiedEndTime;

    public ParkingSpot(double _longitude, double _latitude, String _streetName,
                       int _dailyFreeParkingStartTime, int _dailyFreeParkingEndTime,
                       double _hourlyFee, String _freeDays, boolean _isOccupied,
                       int _occupiedStartTime, int _occupiedEndTime) {
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
        return Double.toString(this.mLongitude)
                + "+" +
                Double.toString(this.mLatitude);
    }
}
