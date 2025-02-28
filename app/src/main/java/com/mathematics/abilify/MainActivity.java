package com.mathematics.abilify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String passcode_of_parent = "harshsoni";

        View parentProfile = findViewById(R.id.view_parentProfile);
        LinearLayout passcodeLayout = findViewById(R.id.passcode_layout);
        View card = findViewById(R.id.Cardview);
        View childProfile = findViewById(R.id.view_childProfile);
        ImageView ci=findViewById(R.id.childImage);
        ImageView pi = findViewById(R.id.parentImage);
        TextView t1 = findViewById(R.id.textView);
        TextView t2 = findViewById(R.id.text3);
        TextView t3 = findViewById(R.id.txt2);
        ImageButton cancel = findViewById(R.id.cancelButton);
        EditText passcode_id = findViewById(R.id.Passcode);
        Button parentLogin = findViewById(R.id.ParentloginButton);

        passcodeLayout.setVisibility(View.GONE);

        parentProfile.setOnClickListener(v -> {
            passcodeLayout.setVisibility(View.VISIBLE);
            card.setVisibility(View.GONE);
            parentProfile.setVisibility(View.GONE);
            childProfile.setVisibility(View.GONE);
            ci.setVisibility(View.GONE);
            pi.setVisibility(View.GONE);
            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);
            t3.setVisibility(View.GONE);
        });

        parentLogin.setOnClickListener(v -> {
            String passcode=passcode_id.getText().toString();
            if(passcode.isEmpty()){
                Toast.makeText(getApplicationContext(), "Enter a passcode to continue", Toast.LENGTH_SHORT).show();
            }
            else {

                if(!passcode.equals(passcode_of_parent)){
                    Toast.makeText(getApplicationContext(),"Enter correct passcode",Toast.LENGTH_SHORT).show();
                }
//                else {
//
//                }
            }
        });


        cancel.setOnClickListener(v -> {
            passcodeLayout.setVisibility(View.GONE);
            card.setVisibility(View.VISIBLE);
            parentProfile.setVisibility(View.VISIBLE);
            childProfile.setVisibility(View.VISIBLE);
            pi.setVisibility(View.VISIBLE);
            ci.setVisibility(View.VISIBLE);
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
            passcode_id.setText("");

        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}