package com.mathematics.abilify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class therapist_and_counselors_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_therapist_and_counselors_page);

        Button online = findViewById(R.id.showOnline);
        Button inPlace = findViewById(R.id.showInPerson);
        TextView availablePlace = findViewById(R.id.js_place_text);
        Button bookedTherapist = findViewById(R.id.bookedTherapist);
        ImageButton homeIcon = findViewById(R.id.parentHomeIcon);
        ImageButton localDirectory = findViewById(R.id.parentLocalServiceDirectoryIcon);
        ImageButton communityPage = findViewById(R.id.parentCommunityForumIcon);

        homeIcon.setOnClickListener(v -> {
            startActivity(new Intent(therapist_and_counselors_page.this,parent_home_page.class));
            finish();
        });
        communityPage.setOnClickListener(v -> {
            startActivity(new Intent(therapist_and_counselors_page.this,CommunityPage.class));
            finish();
        });

        localDirectory.setOnClickListener(v -> {
            startActivity(new Intent(therapist_and_counselors_page.this,LocalServiceDirectory.class));
            finish();
        });

        bookedTherapist.setOnClickListener(v -> {
            String txt = bookedTherapist.getText().toString();
            if(txt.equals("Book")) {
                bookedTherapist.setText("Booked");
            }else {
                bookedTherapist.setText("Book");
            }
        });

        online.setOnClickListener(v -> {
            availablePlace.setText("Chat");
        });

        inPlace.setOnClickListener(v -> {
            availablePlace.setText("Delhi");
        });
        

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}