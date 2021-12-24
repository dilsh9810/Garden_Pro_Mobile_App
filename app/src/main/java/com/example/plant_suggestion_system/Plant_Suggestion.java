package com.example.plant_suggestion_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class Plant_Suggestion extends AppCompatActivity {

    Spinner sunspinner,waterspinner,soilspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sunspinner = findViewById(R.id.sunspin);
        waterspinner = findViewById(R.id.waterdensityspin);
        soilspinner = findViewById(R.id.soilspin);

        String[] value = {"Full Sun", "Partial Sun", "No Sun"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.st_spinner,arrayList);
        sunspinner.setAdapter(arrayAdapter);

        String[] value1 = {"High", "Moderate", "Low"};
        ArrayList<String>arrayList1 = new ArrayList<>(Arrays.asList(value1));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.st_spinner,arrayList1);
        waterspinner.setAdapter(arrayAdapter1);

        String[] value2 = {"Well drained Sandy Soil",
                           "Well drained Carbonic Soil",
                            "Loamy Sandy Soil","Well ",
                            "drained Loamy Sandy Soil",
                            "Well drained Carbonic Loamy Sandy Soil",
                            "Well drained Carbonic Loamy Clay Soil",
                            "Well drained acidic soil"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,R.layout.st_spinner,arrayList2);
        soilspinner.setAdapter(arrayAdapter2);


    }

}