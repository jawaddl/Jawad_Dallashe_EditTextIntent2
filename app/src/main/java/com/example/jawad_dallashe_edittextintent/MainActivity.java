package com.example.jawad_dallashe_edittextintent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Random rnd=new Random();
    private Button Randomer, calculation, Delete;
    private EditText AX, BX, CX;
    double numA, numB, numC;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }
        );
        Randomer = findViewById(R.id.Randomer);
        calculation = findViewById(R.id.calculation);
        Delete = findViewById(R.id.Delete);
        AX = findViewById(R.id.AX);
        BX = findViewById(R.id.BX);
        CX = findViewById(R.id.CX);
        title = findViewById(R.id.title);


        Randomer.setBackgroundColor(Color.rgb(126, 133, 131));
        calculation.setBackgroundColor(Color.rgb(126, 133, 131));
        Delete.setBackgroundColor(Color.rgb(200, 207, 204));
    }
    public static int get_randNum()
    {
        Random randomNumber = new Random();
        return (int)(Math.random() * 199 + -111);
    }

    public void random_nun(View view)
            {
                numA = get_randNum();
                numB = get_randNum();
                numC = get_randNum();
                AX.setText("" + numA);
                BX.setText("" + numB);
                CX.setText("" + numC);
            }


    public void calculation(View view)
            {
                Intent GH=new Intent(MainActivity.this, MainActivity2.class);
                numA = Double.parseDouble(AX.getText().toString());
                numB = Double.parseDouble(BX.getText().toString());
                numC = Double.parseDouble(CX.getText().toString());

                GH.putExtra("a", numA);
                GH.putExtra("b", numB);
                GH.putExtra("c", numC);

                startActivity(GH);
           }


    public void Delete(View view)
            {
                AX.setText("");
                BX.setText("");
                CX.setText("");
                title.setText("");
            }

  }