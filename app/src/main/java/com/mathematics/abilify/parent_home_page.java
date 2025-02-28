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

public class parent_home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent_home_page);

        CardView checkProgressButton = findViewById(R.id.checkProgressButton);
        ImageButton localServiceDirectory = findViewById(R.id.parentLocalServiceDirectoryIcon);

        localServiceDirectory.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,LocalServiceDirectory.class));
        });

        checkProgressButton.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,coming_soon_page.class));

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}