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
    String strA,strB,strC;
    float A_number,B_number,C_number;
    TextView tv, title;
    private final int REQUEST_CODE=100;


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
        tv = findViewById(R.id.tv);
        title = findViewById(R.id.title);


        Randomer.setBackgroundColor(Color.rgb(33, 128, 82));
        calculation.setBackgroundColor(Color.rgb(33, 128, 82));
        Delete.setBackgroundColor(Color.rgb(200, 207, 204));
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE)
            {
                if (resultCode == Activity.RESULT_OK)
                {
                    if (data != null)
                    {
                        String str1 = data.getStringExtra("answer1");
                        String str2 = data.getStringExtra("answer2");
                        tv.setText("X1=" + str1 + "X2=" + str2);

                    }
                    else
                    {
                        Log.i("MainActivity", "NO data returned");
                    }
                }
                else
                {
                    Log.i("MainActivity", "Bad return code");
                }

            }

        }
    public void random_nun(View view)
            {
                AX.setText(String.valueOf(rnd.nextInt(301) - 100));
                BX.setText(String.valueOf(rnd.nextInt(301) - 100));
                CX.setText(String.valueOf(rnd.nextInt(301) - 100));
            }


    public void calculation(View view)
            {
                strA=AX.getText().toString();
                strB=BX.getText().toString();
                strC=CX.getText().toString();
                if(!strA.isEmpty() && !strB.isEmpty() && !strC.isEmpty())
                {
                    A_number=Float.parseFloat(strA);
                    B_number=Float.parseFloat(strB);
                    C_number=Float.parseFloat(strC);

                    Intent si=new Intent(MainActivity.this, MainActivity2.class);
                    si.putExtra("a",A_number);
                    si.putExtra("b",B_number);
                    si.putExtra("c",C_number);
                    startActivityForResult(si,REQUEST_CODE);
                }

           }


    public void Delete(View view)
            {
                AX.setText("");
                BX.setText("");
                CX.setText("");
                tv.setText("");
            }

  }