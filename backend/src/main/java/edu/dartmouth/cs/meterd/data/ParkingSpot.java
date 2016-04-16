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
    public Long mDailyFreeParkingStartTime;
    public Long mDailyFreeParkingEndTime;
    public double mHourlyFee;
    public String mFreeDays;
    public Boolean mIsOccupied;
    public Long mOccupiedStartTime;
    public Long mOccupiedEndTime;

    public ParkingSpot(double _longitude, double _latitude, String _streetName,
                       Long _dailyFreeParkingStartTime, Long _dailyFreeParkingEndTime,
                       double _hourlyFee, String _freeDays, boolean _isOccupied,
                       Long _occupiedStartTime, Long _occupiedEndTime) {
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

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public Long getmDailyFreeParkingStartTime() {
        return mDailyFreeParkingStartTime;
    }

    public void setmDailyFreeParkingStartTime(Long mDailyFreeParkingStartTime) {
        this.mDailyFreeParkingStartTime = mDailyFreeParkingStartTime;
    }

    public Long getmDailyFreeParkingEndTime() {
        return mDailyFreeParkingEndTime;
    }

    public void setmDailyFreeParkingEndTime(Long mDailyFreeParkingEndTime) {
        this.mDailyFreeParkingEndTime = mDailyFreeParkingEndTime;
    }

    public Long getmOccupiedStartTime() {
        return mOccupiedStartTime;
    }

    public void setmOccupiedStartTime(Long mOccupiedStartTime) {
        this.mOccupiedStartTime = mOccupiedStartTime;
    }

    public Long getmOccupiedEndTime() {
        return mOccupiedEndTime;
    }

    public void setmOccupiedEndTime(Long mOccupiedEndTime) {
        this.mOccupiedEndTime = mOccupiedEndTime;
    }
}
