package com.glenwell.savannahcollector.utils;

import android.location.Location;

/**
 * Created by Steve on 3/23/2018.
 */

public interface OnLocationUpdateListener {

        void onLocationChange(Location location);
        //void onError(EnumUtil.ErrorType errorType);

}
