package com.mathematics.abilify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class special_ed_schools_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_special_ed_schools_page);

        ImageButton homePage=findViewById(R.id.parentHomeIcon);
        ImageButton localDirectory = findViewById(R.id.parentLocalServiceDirectoryIcon);
        homePage.setOnClickListener(v -> {
            startActivity(new Intent(special_ed_schools_page.this,parent_home_page.class));
            finish();
        });
        localDirectory.setOnClickListener(v -> {
            startActivity(new Intent(special_ed_schools_page.this,LocalServiceDirectory.class));
            finish();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}