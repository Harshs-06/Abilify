package com.mathematics.abilify;

import android.content.Intent;

import android.os.Build;
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
import androidx.biometric.BiometricManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Executors;

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
        CardView passcode_cardView = findViewById(R.id.passcode_cardView);

        passcodeLayout.setVisibility(View.GONE);
        Intent to_parentHomePage_intent = new Intent(MainActivity.this,parent_home_page.class);
        parentProfile.setOnClickListener(v -> {
            passcodeLayout.setVisibility(View.VISIBLE);
            passcode_cardView.setVisibility(View.GONE);
            card.setVisibility(View.GONE);
            parentProfile.setVisibility(View.GONE);
            childProfile.setVisibility(View.GONE);
            ci.setVisibility(View.GONE);
            pi.setVisibility(View.GONE);
            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);
            t3.setVisibility(View.GONE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                BiometricManager biometricManager=BiometricManager.from(MainActivity.this);
                if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)==BiometricManager.BIOMETRIC_SUCCESS) {
                    BiometricPrompt biometricPrompt = new BiometricPrompt(this, Executors.newSingleThreadExecutor(),new BiometricPrompt.AuthenticationCallback(){
                        @Override
                        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result){
                            super.onAuthenticationSucceeded(result);
                            startActivity(to_parentHomePage_intent);
                            finish();
                        }
                        @Override
                        public void onAuthenticationFailed(){
                            super.onAuthenticationFailed();
                            Toast.makeText(getApplicationContext(), "Fingerprint not recognized! Try Again...", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onAuthenticationError(int errorCode, CharSequence errString){
                            super.onAuthenticationError(errorCode,errString);
                            if (errorCode==BiometricPrompt.ERROR_NEGATIVE_BUTTON){
                                runOnUiThread(()->passcode_cardView.setVisibility(View.VISIBLE));
                            }
                        }
                    });
                    BiometricPrompt.PromptInfo promptInfo = new androidx.biometric.BiometricPrompt.PromptInfo.Builder()
                            .setTitle("Authentication")
                            .setNegativeButtonText("Using Passcode")
                            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
                            .build();

                    biometricPrompt.authenticate(promptInfo);
                }else {
                    passcode_cardView.setVisibility(View.VISIBLE);
                }


            }


        });









        parentLogin.setOnClickListener(v -> {
            String passcode=passcode_id.getText().toString();
            if(passcode.isEmpty()){
                Toast.makeText(getApplicationContext(), "Enter a passcode to continue", Toast.LENGTH_SHORT).show();
                return;
            }
            else {

                if(!passcode.equals(passcode_of_parent)){
                    Toast.makeText(getApplicationContext(),"Enter correct passcode",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                     startActivity(to_parentHomePage_intent);
                     finish();
                }
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