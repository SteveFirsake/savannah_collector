package com.glenwell.savannahcollector;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import com.glenwell.savannahcollector.utils.ApplicationContextor;
import com.glenwell.savannahcollector.utils.AsyncTaskCompleteListener;
import com.glenwell.savannahcollector.utils.Constantori;
import com.glenwell.savannahcollector.utils.DatabaseHandler;
import com.glenwell.savannahcollector.utils.NetPost;
import com.google.android.material.textfield.TextInputLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.glenwell.savannahcollector.utils.Constantori.allPermissionsGranted;
import static com.glenwell.savannahcollector.utils.Constantori.displayLocationSettingsRequest;
import static com.glenwell.savannahcollector.utils.Constantori.isgpsa;


public class Loginno extends AppCompatActivity implements AsyncTaskCompleteListener {

    TextInputLayout TlogemailA, TlogpassA;
    EditText logemailA, logpassA;
    TextView logsignupA, logforgotA;
    Button logsigninA;
    View View;
    String mail="";
    public Context context = this;
    String pass="";
    DatabaseHandler db = DatabaseHandler.getInstance(this);
    String statt = "";
    String ET_pass = "";
    String ET_mail = "";
    String refo = "";
    String sax = "0.0";
    String say = "0.0";
    String REQUEST_PERM4 = "";
    private final static int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 13;
    Timer timer = null;
    GoogleApiClient client;
    Context mContext;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggah);
        mContext = this;

        overridePendingTransition(0,0);

        if (!isgpsa(this)) {
            Toast.makeText(this, "Google Play Services is out-of-date/disabled on your phone", Toast.LENGTH_LONG).show();
        }

        if (Build.VERSION.SDK_INT < 23) {

        }else {
            reqPermission("top");
        }

        displayLocationSettingsRequest(mContext, this);

        TlogemailA = (TextInputLayout)  findViewById(R.id.textILemail);
        TlogpassA = (TextInputLayout)  findViewById(R.id.textILpass);
        logsigninA = (Button) findViewById(R.id.logingia);
        logpassA = (EditText) findViewById(R.id.logpass);
        logemailA = (EditText) findViewById(R.id.logemail);
        logsignupA = (TextView) findViewById(R.id.logreg);
        logforgotA = (TextView) findViewById(R.id.logforgot);

        logemailA.addTextChangedListener(new MyTextWatcher(TlogemailA));
        logpassA.addTextChangedListener(new MyTextWatcher(TlogpassA));

        //this.deleteDatabase(db.getDatabaseName());
        //db.resetAllTables();
        //db.emptyTable(Constantori.TABLE_DAT);

        if (db.CheckIsDataAlreadyInDBorNot(Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Constantori.USERACTIVE) && !db.CheckIsDataAlreadyInDBorNot(Constantori.TABLE_REGISTER, Constantori.KEY_USERREF, Constantori.USERREFNULL)) {

            List<HashMap<String, String>> regData = db.GetAllData(Constantori.TABLE_REGISTER,"","");
            HashMap<String, String> UserDetails = regData.get(0);

            mail = UserDetails.get(Constantori.KEY_USEREMAIL);
            pass = UserDetails.get(Constantori.KEY_USERPASS);
            refo = UserDetails.get(Constantori.KEY_USERREF);

            logemailA.setText(mail);

        } else {
            statt = Constantori.USERUNREG;
        }


        /*

        ALTERMATIVE ACCESS METHOD

        App.getGoogleApiHelper().setConnectionListener(new GoogleApiHelper.ConnectionListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }

            @Override
            public void onConnectionSuspended(int i) {

            }

            @Override
            public void onConnected(Bundle bundle, GoogleApiClient googleApiClient) {
                //this function will call whenever google api connected or already connected when setting listener
                //You are connected do what ever you want
                //Like i get last known location
                Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            }
        });*/




        timer = new Timer("swcha");
        timer.schedule(new TimerTask() {

            public void run() {

                runOnUiThread(new Runnable() {


                    @Override
                    public void run() {


                        if(ApplicationContextor.getGoogleApiHelper().isConnected())
                        {

                            if ( Build.VERSION.SDK_INT >= 23 &&
                                    ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                                    ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                                ActivityCompat.requestPermissions(Loginno.this,
                                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                        Constantori.REQUEST_LOCATION);

                                ActivityCompat.requestPermissions(Loginno.this,
                                        new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                                        Constantori.REQUEST_LOCATION);
                            } else {

                                client = ApplicationContextor.getGoogleApiHelper().getGoogleApiClient();

                                Location ll = LocationServices.FusedLocationApi.getLastLocation(client);

                                if (ll != null) {
                                    sax = String.valueOf(ll.getLongitude());
                                    say = String.valueOf(ll.getLatitude());
                                }
                            }

                        }



                        Log.e("wapi", String.format("LAT : %s \n LON : %s", say, sax));


                    }

                });

            }

        }, 0, 2000);


        if (Build.VERSION.SDK_INT >= 23 && !allPermissionsGranted(context)) {

            reqPermission("loginnoTOP");


        }else{

            createImageFolder();
        }




        logsigninA.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                if (!validateEmail()) {
                    return;
                }

                if (!validatePass()) {
                    return;
                }

                if (Build.VERSION.SDK_INT < 23) {

                    loginnoINGIA();

                } else {

                    if (allPermissionsGranted(context)) {
                        loginnoINGIA();
                    } else {
                        reqPermission("loginnoINGIA");
                    }


                }

            }

        });

    }



    public void onClick_su(View v)
    {


        if (Build.VERSION.SDK_INT < 23) {
            loginnoREG();
        }else {

            if (allPermissionsGranted(context)) {
                loginnoREG();
            }else{
                reqPermission("loginnoREG");
            }
        }

    }


    public void onClick_fd(View v)
    {
     //
    }




    public void diambaid_newuser(View v) {
        final Dialog ingia = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        ingia.setContentView(R.layout.mbaind_newuser);
        ingia.setCanceledOnTouchOutside(false);
        ingia.setCancelable(false);
        WindowManager.LayoutParams lp = ingia.getWindow().getAttributes();
        lp.dimAmount=0.85f;
        ingia.getWindow().setAttributes(lp);
        ingia.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        ingia.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ingia.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        Button regno = (Button) ingia.findViewById(R.id.sawa);
        Button regyes = (Button) ingia.findViewById(R.id.rback);

        regyes.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(View v){

                ingia.dismiss();


                Map<String,String> map = new HashMap<String, String>();
                map.put("pswd", ET_pass);
                map.put("mail", ET_mail);

                if (Constantori.isConnectedToInternet()) {
                    new NetPost(context, "login_CheckJSON", Constantori.getJSON(map), "Authenticating. Make sure internet connection is active", Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Loginno.this).execute(new String[]{Constantori.URL_GEN});
                }else{
                    Toast.makeText(context,Constantori.ERROR_NO_INTERNET,Toast.LENGTH_LONG).show();
                }



            }
        });
        regno.setOnClickListener(new android.view.View.OnClickListener(){
            @Override
            public void onClick(View v){

                Toast.makeText(context, "No active user account exists on the phone. Please Sign Up first ", Toast.LENGTH_LONG).show();
                ingia.dismiss();
            }
        });
        ingia.show();
    }

    private void loginnoINGIA(){

        if (logemailA.getText().toString().equals("") || logpassA.getText().toString().equals("")) {

            Toast.makeText(context, "Please fill in the login detail", Toast.LENGTH_LONG).show();

        } else {

            ET_pass = logpassA.getText().toString().trim();
            ET_mail = logemailA.getText().toString().trim();

            if (statt.equals(Constantori.USERUNREG)){
                diambaid_newuser(View);
            }else{

                if (ET_pass.equals(pass) && ET_mail.equals(mail)) {
                    timer.cancel();
                    finish();
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                } else if (!ET_pass.equals(pass) && ET_mail.equals(mail)) {
                    Toast.makeText(context, "Please insert the right password for the user account.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "New user? If registered, click on Yes.", Toast.LENGTH_LONG).show();
                    diambaid_newuser(View);

                }



            }
        }

    }

    private void loginnoREG(){
        finish();

        Intent intent = new Intent(context, Regista.class);
        intent.putExtra("reggo","login");
        intent.putExtra("lattt", say);
        intent.putExtra("lonnn", sax);
        startActivity(intent);

    }


    @SuppressLint("NewApi")
    private void reqPermission(final String nini) {

        REQUEST_PERM4 = nini;

        List<String> permissionsNeeded = new ArrayList<String>();
        final List<String> permissionsList = new ArrayList<String>();

        if (!addPermission(permissionsList, android.Manifest.permission.ACCESS_FINE_LOCATION))
            permissionsNeeded.add("Location");
        if (!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
            permissionsNeeded.add("Storage");
        if (!addPermission(permissionsList, android.Manifest.permission.CAMERA))
            permissionsNeeded.add("Camera");
        if (!addPermission(permissionsList, android.Manifest.permission.READ_PHONE_STATE))
            permissionsNeeded.add("Cell Network");

        if (permissionsList.size() > 0) {
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "This application needs to access your " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);
                showMessageOKCancel(message,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                            }
                        });
                return;
            }
            requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            return;
        }

        return;

    }

    @SuppressLint("NewApi")
    private boolean addPermission(List<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!shouldShowRequestPermissionRationale(permission))
                return false;
        }
        return true;
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS:
            {
                Map<String, Integer> perms = new HashMap<String, Integer>();
                // Initial
                perms.put(android.Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(android.Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION
                if (perms.get(
                        android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                        && perms.get(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        ) {
                    // All Permissions Granted
                    if (REQUEST_PERM4.equals("loginnoINGIA")) {
                        loginnoINGIA();
                    }

                    if (REQUEST_PERM4.equals("loginnoREG")) {
                        loginnoREG();
                    }

                    createImageFolder();


                    Toast.makeText(context, "All permissions enabled.", Toast.LENGTH_LONG).show();

                } else {
                    // Permission Denied
                    Toast.makeText(context, "ome permission(s) denied.", Toast.LENGTH_SHORT)
                            .show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    @Override
    public void AsyncTaskCompleteListener(String result, String sender, String TableName, String FieldName)
    {
        switch (sender){
            case "login_CheckJSON":

                if (result.equals("202")) {
                    Toast.makeText(context, Constantori.ERROR_APPROVAL, Toast.LENGTH_LONG).show();
                }else if(result.equals("101")) {
                    Toast.makeText(context, Constantori.ERROR_PASSWORD, Toast.LENGTH_LONG).show();
                }else if(result.equals(null)) {
                    Toast.makeText(context, Constantori.ERROR_SERVER_ISSUE, Toast.LENGTH_LONG).show();
                 }else if(result.equals("Issue")) {
                    Constantori.diambaidno(View, context);

                }else{

                    try {
                        JSONArray storesArray = new JSONArray(result);
                        storesArray.getJSONObject(0).put(Constantori.KEY_USERPASS, ET_pass);
                        storesArray.getJSONObject(0).put(Constantori.KEY_USERACTIVE, Constantori.USERACTIVE);

                        if (db.CheckIsDataAlreadyInDBorNot(Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Constantori.USERACTIVE)) {
                            db.RegisterUser_Update(storesArray);
                        }else {
                            db.RegisterUser_Insert(storesArray);
                        }

                        timer.cancel();
                        finish();

                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);


                    }catch (Exception xx){
                        Log.e(Constantori.APP_ERROR_PREFIX + "_LoginnoJSON", xx.getMessage());
                        xx.printStackTrace();
                    }

                }

                break;

            default:

                break;

        }

    }

    public void createImageFolder(){

        if(Constantori.isExternalStorageWritable()) {

            File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    File.separator + Constantori.PIC_PATH);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                Log.e(Constantori.APP_ERROR_PREFIX + "_ImageFolder", "Done");
            } else {
                Log.e(Constantori.APP_ERROR_PREFIX + "_ImageFolder", "Not Done");
            }

        }else{
            Log.e(Constantori.APP_ERROR_PREFIX + "_ImageFolder", "Not Readable");
        }
    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.textILemail:
                    validateEmail();
                    break;
                case R.id.textILpass:
                    validatePass();
                    break;
            }
        }
    }

    private boolean validateEmail() {
        String email = logemailA.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            TlogemailA.setError(getString(R.string.err_msg_email));
            requestFocus(TlogemailA);
            return false;
        } else {
            TlogemailA.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePass() {
        if (logpassA.getText().toString().trim().isEmpty()) {
            TlogpassA.setError(getString(R.string.err_msg_password));
            requestFocus(logpassA);
            return false;
        } else {
            TlogpassA.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }




}
