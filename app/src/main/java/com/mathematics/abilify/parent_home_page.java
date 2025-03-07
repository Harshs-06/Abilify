package com.mathematics.abilify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class parent_home_page extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent_home_page);

        CardView checkProgressButton = findViewById(R.id.checkProgressButton);
        CardView checkEventButton = findViewById(R.id.checkEventButton);
        CardView checkPollsButton = findViewById(R.id.checkPollsButton);
        CardView checkBuddyProgramButton = findViewById(R.id.checkBuddyProgramButton);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        CardView account_profile=findViewById(R.id.profile_navigation_drawer_button);

        ImageButton localServiceDirectory = findViewById(R.id.parentLocalServiceDirectoryIcon);
        ImageButton communityPage = findViewById(R.id.parentCommunityForumIcon);
        communityPage.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,CommunityPage.class));
            finish();
        });
        localServiceDirectory.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,LocalServiceDirectory.class));
            finish();
        });


        checkProgressButton.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,coming_soon_page.class));
            finish();

        });

        checkEventButton.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,coming_soon_page.class));
            finish();

        });
        checkPollsButton.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,coming_soon_page.class));
            finish();

        });
        checkBuddyProgramButton.setOnClickListener(v -> {
            startActivity(new Intent(parent_home_page.this,coming_soon_page.class));
            finish();

        });

        account_profile.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                            account_profile.setAlpha(1-slideOffset);
//                account_profile.setScaleX(1 - (slideOffset * 0.2f));
//                account_profile.setScaleY(1 - (slideOffset * 0.2f));
                account_profile.setRotation(slideOffset * 180);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                   drawerLayout.setClickable(true);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                if(newState==DrawerLayout.STATE_IDLE && drawerLayout.isDrawerOpen(GravityCompat.START)){
                    InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(drawerLayout.getWindowToken(),0);
                }
            }


        });


        if(drawerLayout !=null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}