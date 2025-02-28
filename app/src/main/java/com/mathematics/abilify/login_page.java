package com.mathematics.abilify;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        EditText edit_user_txt = findViewById(R.id.username);
        EditText edit_password_txt = findViewById(R.id.password);
        Button login = findViewById(R.id.loginButton);


        login.setOnClickListener(v -> {
            String username = edit_user_txt.getText().toString();
            String password = edit_password_txt.getText().toString();

            if(username.isEmpty()||password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill all login credentials", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}