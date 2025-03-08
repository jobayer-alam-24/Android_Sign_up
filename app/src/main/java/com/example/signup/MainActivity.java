package com.example.signup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, emailInput, passwordInput, dobInput;
    Button submitBtn;
    LinearLayout resultContainer;
    TextView nameOutput, emailOutput, passwordOutput, dobOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Initializing all
        nameInput = findViewById(R.id.name);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        dobInput = findViewById(R.id.dob);
        submitBtn = findViewById(R.id.submit);
        resultContainer = findViewById(R.id.resultContainer);
        nameOutput = findViewById(R.id.nameOutput);
        emailOutput = findViewById(R.id.emailOutput);
        passwordOutput = findViewById(R.id.passwordOutput);
        dobOutput = findViewById(R.id.dobOutput);

        //handle submit click even
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String dob = dobInput.getText().toString().trim();

                nameOutput.setText("Name: " + name);
                emailOutput.setText("Email: " + email);
                passwordOutput.setText("Password: " + password);
                dobOutput.setText("Date of Birth: " + dob);
                resultContainer.setVisibility(View.VISIBLE);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}