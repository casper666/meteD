package edu.dartmouth.cs.meted;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by libinjie on 4/16/16.
 */
public class ParkSlot implements ClusterItem {
    private final LatLng mPosition;

    public ParkSlot(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
