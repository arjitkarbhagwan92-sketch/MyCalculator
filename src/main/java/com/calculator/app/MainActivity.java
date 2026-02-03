package com.calculator.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 1. Define the variables
    EditText display;
    Button btnAdd;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. Link this Java file to your XML layout
        setContentView(R.layout.activity_main);

        // 3. Connect the variables to the XML IDs
        display = findViewById(R.id.display);
        btnAdd = findViewById(R.id.btn_add);
        resultText = findViewById(R.id.result);

        // 4. Set the "Click" listener for the button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = display.getText().toString();

                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        double sum = number + number; // Simple logic: doubles the input
                        resultText.setText("Result: " + sum);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Enter a valid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
