package com.akash.healthup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button doctorContacts = (Button) findViewById(R.id.doctor_contacts);
        doctorContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(), "Opening the Contact list", Toast.LENGTH_SHORT).show();
                Intent doctorContactsIntent=new Intent(MainActivity.this,DoctorContacts.class);
                startActivity(doctorContactsIntent);
            }
        });

        final Button medicine = (Button) findViewById(R.id.medicineButton);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(), "Opening the Contact list", Toast.LENGTH_SHORT).show();
                Intent medicineListIntent=new Intent(MainActivity.this,MedicineList.class);
                startActivity(medicineListIntent);
            }
        });
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void locationFun(View view)
    {
        String loc;
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        loc="https://www.google.com/maps/search/medical+stores/@"+latitude+","+longitude+",15z";
        goToUrl (loc);
    }

    public void emergency(View view)
    {
        String locsms;
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        locsms="Logitude="+longitude+"\nLatitude="+latitude+"\nhttps://www.google.com/maps/@"+latitude+","+longitude+",15z";
        sendSMS("9113852050",locsms);
        Toast.makeText(view.getContext(), "Location Sent", Toast.LENGTH_SHORT).show();
    }

    private void sendSMS(String phoneNumber, String message)
    {
        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, pi, null);

    }

}
