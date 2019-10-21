package com.akash.healthup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MedicineList extends AppCompatActivity {

    ListView medicineList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);

        medicineList = (ListView) findViewById(R.id.medicine_list);
        medicineList.setEnabled(true);

        String[] values = new String[] { "Aspirin", "Benadryl", "Calciferol",
                "Dapsone", "Efudex", "Ferumoxytol", "Gantanol", "HepatAmine",
                "Ilotycin", "Jantoven", "Kineret", "Lactulose", "Malathion", "Naftifine" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);

        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                list);
        medicineList.setAdapter(adapter);
    }
}
