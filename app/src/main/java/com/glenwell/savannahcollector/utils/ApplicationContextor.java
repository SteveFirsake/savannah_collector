package com.glenwell.savannahcollector.utils;

import android.app.Application;
import android.content.Context;

public class ApplicationContextor extends Application {

    private static Context context;
    private GoogleApiHelper googleApiHelper;

    private static ApplicationContextor mInstance;

    public void onCreate() {
        super.onCreate();
        ApplicationContextor.context = getApplicationContext();
        googleApiHelper = new GoogleApiHelper(getApplicationContext());
        mInstance = this;

    }

    public static Context getAppContext() {
        return ApplicationContextor.context;
    }

    public static synchronized ApplicationContextor getInstance() {
        return mInstance;
    }

    public GoogleApiHelper getGoogleApiHelperInstance() {
        return this.googleApiHelper;
    }
    public static GoogleApiHelper getGoogleApiHelper() {
        return getInstance().getGoogleApiHelperInstance();
    }

}