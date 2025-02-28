package com.mathematics.abilify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class login_page extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        EditText edit_user_txt = findViewById(R.id.username);
        EditText edit_password_txt = findViewById(R.id.password);
        Button login = findViewById(R.id.loginButton);
        ProgressBar progress = findViewById(R.id.progress);

        progress.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(v -> {

            login.setText("");
            progress.setVisibility(View.VISIBLE);
            String username = edit_user_txt.getText().toString();
            String password = edit_password_txt.getText().toString();
            edit_user_txt.setEnabled(false);
            edit_password_txt.setEnabled(false);
            login.setEnabled(false);
            if(username.isEmpty()||password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill all login credentials", Toast.LENGTH_SHORT).show();
                progress.setVisibility(View.GONE);
                login.setText("Login");
                edit_user_txt.setEnabled(true);
                edit_password_txt.setEnabled(true);
                login.setEnabled(true);

                return;
            }

            mAuth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener(task -> {
                           if(task.isSuccessful()) {
                                startActivity(new Intent(login_page.this,MainActivity.class));
                                finish();
                           }
                           else {
                               Toast.makeText(getApplicationContext(), "Login Failed! \nTry Again.", Toast.LENGTH_SHORT).show();
                               progress.setVisibility(View.GONE);
                               login.setText("Login");
                               login.setEnabled(true);
                               edit_user_txt.setEnabled(true);
                               edit_password_txt.setEnabled(true);
                           }

                    });



        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}