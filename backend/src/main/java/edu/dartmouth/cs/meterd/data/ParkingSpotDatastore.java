package edu.dartmouth.cs.meterd.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Transaction;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by JaySha on 4/15/16.
 */
public class ParkingSpotDatastore {

    private static final Logger mLogger = Logger
            .getLogger(ParkingSpotDatastore.class.getName());
    private static final DatastoreService mDatastore = DatastoreServiceFactory
            .getDatastoreService();

    private static Key getKey() {
        return KeyFactory.createKey(ParkingSpot.PARKINGSPOT_PARENT_ENTITY_NAME,
                ParkingSpot.PARKINGSPOT_PARENT_KEY_NAME);
    }


    public static boolean add(ParkingSpot parkingSpot) {
        if (getParkingSpotByCoord(parkingSpot.mLongitude, parkingSpot.mLatitude, null) != null) {
            mLogger.log(Level.INFO, "parkingSpot exits");
            return false;
        }

        Key parentKey = getKey();

        Entity entity = new Entity(ParkingSpot.PARKINGSPOT_ENTITY_NAME,
                parkingSpot.getCoordInString(),
                parentKey);
        entity.setProperty(ParkingSpot.FIELD_NAME_LONGITUDE, parkingSpot.mLongitude);
        entity.setProperty(ParkingSpot.FIELD_NAME_LATITUDE, parkingSpot.mLatitude);
        entity.setProperty(ParkingSpot.FIELD_NAME_STREETNAME, parkingSpot.mStreetName);
        entity.setProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGSTARTTIME, parkingSpot.mDailyFreeParkingStartTime);
        entity.setProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGENDTIME, parkingSpot.mDailyFreeParkingEndTime);
        entity.setProperty(ParkingSpot.FIELD_NAME_HOURLYFEE, parkingSpot.mHourlyFee);
        entity.setProperty(ParkingSpot.FIELD_NAME_FREEDAYS, parkingSpot.mFreeDays);
        entity.setProperty(ParkingSpot.FIELD_NAME_ISOCCUPIED, parkingSpot.mIsOccupied);
        entity.setProperty(ParkingSpot.FIELD_NAME_OCCUPIEDSTARTTIME, parkingSpot.mOccupiedStartTime);
        entity.setProperty(ParkingSpot.FIELD_NAME_OCCUPIEDENDTIME, parkingSpot.mOccupiedEndTime);

        mDatastore.put(entity);

        return true;
    }

    public static boolean update(ParkingSpot parkingSpot) {
        Entity result = null;
        try {
            result = mDatastore.get(KeyFactory.createKey(getKey(),
                    ParkingSpot.PARKINGSPOT_ENTITY_NAME,
                    parkingSpot.getCoordInString()));
            result.setProperty(ParkingSpot.FIELD_NAME_LONGITUDE, parkingSpot.mLongitude);
            result.setProperty(ParkingSpot.FIELD_NAME_LATITUDE, parkingSpot.mLatitude);
            result.setProperty(ParkingSpot.FIELD_NAME_STREETNAME, parkingSpot.mStreetName);
            result.setProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGSTARTTIME, parkingSpot.mDailyFreeParkingStartTime);
            result.setProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGENDTIME, parkingSpot.mDailyFreeParkingEndTime);
            result.setProperty(ParkingSpot.FIELD_NAME_HOURLYFEE, parkingSpot.mHourlyFee);
            result.setProperty(ParkingSpot.FIELD_NAME_FREEDAYS, parkingSpot.mFreeDays);
            result.setProperty(ParkingSpot.FIELD_NAME_ISOCCUPIED, parkingSpot.mIsOccupied);
            result.setProperty(ParkingSpot.FIELD_NAME_OCCUPIEDSTARTTIME, parkingSpot.mOccupiedStartTime);
            result.setProperty(ParkingSpot.FIELD_NAME_OCCUPIEDENDTIME, parkingSpot.mOccupiedEndTime);

            mDatastore.put(result);
        } catch (Exception ex) {

        }

        return false;
    }

    public static boolean delete(ParkingSpot parkingSpot) {
        //set up filter
        Filter longitudeFilter = new FilterPredicate(ParkingSpot.FIELD_NAME_LONGITUDE,
                FilterOperator.EQUAL, parkingSpot.mLongitude);

        Filter latitudeFilter = new FilterPredicate(ParkingSpot.FIELD_NAME_LATITUDE,
                FilterOperator.EQUAL, parkingSpot.mLatitude);

        Filter coordFilter = Query.CompositeFilterOperator.and(longitudeFilter, latitudeFilter);

        //query
        Query query = new Query(ParkingSpot.PARKINGSPOT_ENTITY_NAME);
        query.setFilter(coordFilter);

        //receive results
        PreparedQuery pq = mDatastore.prepare(query);

        Entity result = pq.asSingleEntity();
        boolean ret = false;
        if (result != null) {
            //delete
            mDatastore.delete(result.getKey());
            ret = true;
        }

        return ret;
    }

//        TODO: define parameters for query
//    public static ArrayList<ParkingSpot> query() {
//
//    }

    public static ParkingSpot getParkingSpotByCoord(Float longitude, Float latitude, Transaction txn) {
        Entity result = null;
        try {
            result = mDatastore.get(KeyFactory.createKey(getKey(),
                    ParkingSpot.PARKINGSPOT_ENTITY_NAME,
                    Float.toString(longitude)+"+"+Float.toString(latitude)));
        } catch (Exception ex) {

        }

        return getParkingSpotFromEntity(result);
    }

    public static ParkingSpot getParkingSpotFromEntity(Entity entity) {
        if (entity == null) {
            return null;
        }

        return new ParkingSpot(
                (float) entity.getProperty(ParkingSpot.FIELD_NAME_LONGITUDE),
                (float) entity.getProperty(ParkingSpot.FIELD_NAME_LATITUDE),
                (String) entity.getProperty(ParkingSpot.FIELD_NAME_STREETNAME),
                (Date) entity.getProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGSTARTTIME),
                (Date) entity.getProperty(ParkingSpot.FIELD_NAME_DAILYFREEPARKINGENDTIME),
                (float) entity.getProperty(ParkingSpot.FIELD_NAME_HOURLYFEE),
                (String) entity.getProperty(ParkingSpot.FIELD_NAME_FREEDAYS),
                (boolean) entity.getProperty(ParkingSpot.FIELD_NAME_ISOCCUPIED),
                (Date) entity.getProperty(ParkingSpot.FIELD_NAME_OCCUPIEDSTARTTIME),
                (Date) entity.getProperty(ParkingSpot.FIELD_NAME_OCCUPIEDENDTIME));
    }


}
