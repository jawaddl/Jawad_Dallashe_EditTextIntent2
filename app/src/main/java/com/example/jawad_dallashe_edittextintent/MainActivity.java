package com.example.jawad_dallashe_edittextintent;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button Randomer, calculation, Delete ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Randomer = findViewById(R.id.Randomer);
        calculation = findViewById(R.id.calculation);
        Delete = findViewById(R.id.Delete);

        Randomer.setBackgroundColor(Color.rgb(33, 128, 82));
        calculation.setBackgroundColor(Color.rgb(33, 128, 82));
        Delete.setBackgroundColor(Color.rgb(200, 207, 204));
    }
}