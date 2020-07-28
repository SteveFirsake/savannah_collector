package com.glenwell.savannahcollector.utils;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.glenwell.savannahcollector.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class Constantori {

    //DATABASE//////////////////////////////////////////////////////////////

    public static final String APP_ERROR_PREFIX = "SC";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SCDB";
    public static  final Context DATABASE_Context = ApplicationContextor.getAppContext();

        //Tables
        public static final String TABLE_DAT_RL = "datRlTBL";
        public static final String TABLE_DAT_WAT = "datWatTBL";
        public static final String TABLE_DAT_DEG = "datDegTBL";
        public static final String TABLE_REGISTER = "userTBL";
        public static final String TABLE_PIC = "picTBL";

        //Fields - Register table
        public static final String KEY_USERREF = "_userid";
        public static final String KEY_USERACTIVE = "_useractive";
        public static final String KEY_USERNEM = "_username";
        public static final String KEY_USERTEL = "_usertel";
        public static final String KEY_USERCNTRY = "_usercntry";
        public static final String KEY_USEREMAIL = "_useremail";
        public static final String KEY_USERPASS  = "_userpass";
        public static final String KEY_USERLAT = "_userlat";
        public static final String KEY_USERLON = "_userlon";

        //KOLEK
        public static final String KEY_DATNO = "_datno";
        public static final String KEY_DATSTATUS = "_datstatus";

        //Fields - KOLEK-RL Dat table
        public static final String KEY_RID_RL = "_datindex";
        public static final String KEY_DATFEATURE_RL = "_datftrname";
        public static final String KEY_DATCOMMENT_RL = "_datcom";
        public static final String KEY_DATLON_RL = "_datlon";
        public static final String KEY_DATLAT_RL = "_datlat";
        public static final String KEY_DATPICNAME_RL = "_datpicnm";

        //Fields - KOLEK-DEG Dat table
        public static final String KEY_RID_DEG = "_datindex";
        public static final String KEY_DATFEATURE_DEG = "_datftrname";
        public static final String KEY_DATCOMMENT_DEG = "_datcom";
        public static final String KEY_DATLON_DEG = "_datlon";
        public static final String KEY_DATLAT_DEG = "_datlat";
        public static final String KEY_DATPICNAME_DEG = "_datpicnm";

        //Fields - KOLEK-WAT Dat table
        public static final String KEY_RID_WAT = "_datindex";
        public static final String KEY_DATFEATURE_WAT = "_datftrname";
        public static final String KEY_DATSEASONAL_WAT = "_datseasonal";
        public static final String KEY_DATCOMMENT_WAT = "_datcom";
        public static final String KEY_DATLON_WAT = "_datlon";
        public static final String KEY_DATLAT_WAT = "_datlat";
        public static final String KEY_DATPICNAME_WAT = "_datpicnm";

        //Fields - Pic table
        public static final String KEY_USERPIC = "_userpic";
        public static final String KEY_USERPICPATH = "_userpicpath";
        public static final String KEY_SENDSTAT = "_sendstat";

        //For user status
        public static final String USERACTIVE = "1";
        public static final String USERINACTIVE = "0";
        public static final String USERREFNULL = "None";
        public static final String USERUNREG = "unreg";
        public static final String POST_RESPONSEKEY = "resp";
        public static final String POST_RESPONSEVAL = "success";
        public static final String POST_DATSTATUS = "1";
        public static final String SAVE_DATSTATUS = "0";
        public static final String SAVE_PICSTATUS = "pending";

    //////////////////////////////////////////////////////////////////////////////

    public static final String URL_GEN = "http://mobiledata.rcmrd.org/rlc/rlc_gen.php";


    /////////////////////////////////////////////////////////////////////////////
    public static final String ERROR_USER_EXISTS = "You are already registered.";
    public static final String ERROR_SERVER_ISSUE = "Server updating, please wait and try again";
    public static final String ERROR_NO_INTERNET = "No internet connection, please connect and try again.";
    public static final String ERROR_APPROVAL = "You have not been approved yet by the administrator.";
    public static final String ERROR_PASSWORD = "Please use correct password";

    public final static int REQUEST_CODE_RECOVER_PLAY_SERVICES = 200;
    public final static int REQUEST_LOCATION = 2;
    public final static int REQUEST_CHECK_SETTINGS = 12;
    public static final String PIC_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SC";


    public static JSONArray getJSON(Map<String, String> x){

        JSONArray allData_multi = new JSONArray();
        JSONObject allData_single = new JSONObject(x);
        allData_multi.put(allData_single);
        Log.e(APP_ERROR_PREFIX + "_SendJSON", allData_multi.toString());

        return allData_multi;
    }



    public static void diambaidno(View v, Context context) {
        final Dialog mbott = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
        mbott.setContentView(R.layout.mbaind_nonet3);
        mbott.setCanceledOnTouchOutside(false);
        mbott.setCancelable(false);
        WindowManager.LayoutParams lp = mbott.getWindow().getAttributes();
        lp.dimAmount=0.85f;
        mbott.getWindow().setAttributes(lp);
        mbott.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mbott.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Button mbaok = (Button) mbott.findViewById(R.id.mbabtn1);
        mbaok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mbott.dismiss();
            }
        });
        mbott.show();
    }

    public static void diambaidsent(View v, Context context) {
        final Dialog mbott = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
        mbott.setContentView(R.layout.mbaind_sent);
        mbott.setCanceledOnTouchOutside(false);
        mbott.setCancelable(false);
        WindowManager.LayoutParams lp = mbott.getWindow().getAttributes();
        lp.dimAmount=0.85f;
        mbott.getWindow().setAttributes(lp);
        mbott.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mbott.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Button mbaok = (Button) mbott.findViewById(R.id.mbabtn1);
        mbaok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                mbott.dismiss();
            }
        });
        mbott.show();
    }


    public static boolean isConnectedToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager)ApplicationContextor.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }

        }
        return false;
    }


    public static boolean isgpsa(Activity activity) {
        // TODO Auto-generated method stub
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if(status != ConnectionResult.SUCCESS) {
            if(googleApiAvailability.isUserResolvableError(status)) {
                googleApiAvailability.getErrorDialog(activity, status, 2404).show();
            }
            return false;
        }
        return true;
    }

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }



    public static boolean allPermissionsGranted(Context context){
        if (
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED

                ) {

            return true;
        }else{
            return false;
        }
    }


    public static void displayLocationSettingsRequest(final Context context, final Activity activity) {
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API).build();
        googleApiClient.connect();

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(10000 / 2);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        Log.i(Constantori.APP_ERROR_PREFIX+"_Loc", "All location settings are satisfied.");
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        Log.i(Constantori.APP_ERROR_PREFIX+"_Loc", "Location settings are not satisfied. Show the user a dialog to upgrade location settings ");

                        try {
                            // Show the dialog by calling startResolutionForResult(), and check the result
                            // in onActivityResult().
                            status.startResolutionForResult(activity, Constantori.REQUEST_CHECK_SETTINGS);
                        } catch (IntentSender.SendIntentException e) {
                            Log.i(Constantori.APP_ERROR_PREFIX+"_Loc", "PendingIntent unable to execute request.");
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Log.i(Constantori.APP_ERROR_PREFIX+"_Loc", "Location settings are inadequate, and cannot be fixed here. Dialog not created.");
                        break;
                }
            }
        });
    }

}
