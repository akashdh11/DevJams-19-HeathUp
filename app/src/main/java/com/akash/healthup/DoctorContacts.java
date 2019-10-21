package com.akash.healthup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorContacts extends AppCompatActivity {

    String[] listviewTitle = new String[]{
            "Doctor 1", "Doctor 2", "Doctor 3", "Doctor 4",
            "Doctor 5", "Doctor 6", "Doctor 7", "Doctor 8",
    };


    int[] listviewImage = new int[]{
            R.drawable.ma, R.drawable.fe, R.drawable.ma, R.drawable.fe,
            R.drawable.ma, R.drawable.fe, R.drawable.ma, R.drawable.fe,
    };

    String[] listviewShortDescription = new String[]{
            "Short Description", "Short Description", "Short Description", "Short Description",
            "Short Description", "Short Description", "Short Description", "Short Description",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_contacts);


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.doctor_contacts);
        androidListView.setAdapter(simpleAdapter);

        ListView listView = (ListView) findViewById(R.id.doctor_contacts);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent doctorDetailsIntent=new Intent(DoctorContacts.this,DoctorDetails.class);
                startActivity(doctorDetailsIntent);
            }
        });
    }

    public void doctorDetails(View view){
        Intent numbersIntent=new Intent(DoctorContacts.this,DoctorDetails.class);
        startActivity(numbersIntent);
    }


}
