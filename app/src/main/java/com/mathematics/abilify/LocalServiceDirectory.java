package com.mathematics.abilify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocalServiceDirectory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.local_service_directory);

        CardView seeTherapist = findViewById(R.id.seeTherapist);
        CardView specialSchool = findViewById(R.id.specialSchool);
        ImageButton homeIcon = findViewById(R.id.parentHomeIcon);
        ImageButton communityPage = findViewById(R.id.parentCommunityForumIcon);
        communityPage.setOnClickListener(v -> {
            startActivity(new Intent(LocalServiceDirectory.this,CommunityPage.class));
            finish();
        });
        homeIcon.setOnClickListener(v -> {
            startActivity(new Intent(LocalServiceDirectory.this,parent_home_page.class));
            finish();
        });
        specialSchool.setOnClickListener(v -> {
            startActivity(new Intent(LocalServiceDirectory.this, special_ed_schools_page.class));
            finish();
        });

        seeTherapist.setOnClickListener(v -> {
            startActivity(new Intent(LocalServiceDirectory.this, therapist_and_counselors_page.class));
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}