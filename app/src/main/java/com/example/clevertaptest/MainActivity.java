package com.example.clevertaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
// each of the below mentioned fields are optional
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//        profileUpdate.put("Name", "Jack Montana");    // String
        profileUpdate.put("Identity", 58965422);  //61026032);      // String or number
//        profileUpdate.put("Email", "jack@gmail.com"); // Email address of the user
//        profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
//        profileUpdate.put("Gender", "M");             // Can be either M or F
//        profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
//// optional fields. controls whether the user will be sent email, push etc.
//        profileUpdate.put("MSG-email", false);        // Disable email notifications
//        profileUpdate.put("MSG-push", true);          // Enable push notifications
//        profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
//        profileUpdate.put("MSG-whatsapp", true);      // Enable WhatsApp notifications
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("bag");
        stuff.add("shoes");
        profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
        String[] otherStuff = {"Jeans","Perfume"};
        profileUpdate.put("MyStuff", otherStuff);                   //String Array
        CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"test","PN Test","TESTING",NotificationManager.IMPORTANCE_MAX,true);
    }
}