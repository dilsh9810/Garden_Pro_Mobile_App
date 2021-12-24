package com.example.plant_suggestion_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class System_Dashboard extends AppCompatActivity {

    ImageView plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_dashboard);

        plant = findViewById(R.id.plant_img);

        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(System_Dashboard.this,Plant_Suggestion.class);
                startActivity(i);
            }
        });



    }




}
