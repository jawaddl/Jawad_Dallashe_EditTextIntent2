package com.example.jawad_dallashe_edittextintent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity
{
    TextView display;
    ImageView xxx;
    Button Back, Exit ;
    Double AX,BX,CX;
    float firstSum ;
    String solution1,solution2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Intent GH = getIntent();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        }
        );

            display=findViewById(R.id.display);
            xxx=findViewById(R.id.xxx);
            Back = findViewById(R.id.Back);
            Exit = findViewById(R.id.Exit);

            AX=GH.getDoubleExtra("a",0);
            BX=GH.getDoubleExtra("b",0);
            CX=GH.getDoubleExtra("c",0);
            Back.setBackgroundColor(Color.rgb(3, 252, 207));
            Exit.setBackgroundColor(Color.rgb(3, 252, 207));

            firstSum=(float) (BX*BX-4*AX*CX);
            if (firstSum==0 && AX>0)
            {
                xxx.setImageResource(R.drawable.s);
            }
            if (firstSum>0 && AX>0)
            {
                xxx.setImageResource(R.drawable.sminos);
            }
            if (firstSum<0 && AX>0)
            {
                xxx.setImageResource(R.drawable.splus);
            }
            if (firstSum==0 && AX<0)
            {
                xxx.setImageResource(R.drawable.ans);
            }
            if (firstSum>0 && AX<0)
            {
                xxx.setImageResource(R.drawable.ansplus);
            }
            if (firstSum<0 && AX<0)
            {
                xxx.setImageResource(R.drawable.ansminos);
            }


            if (firstSum==0)
            {
               solution1 = (Double.valueOf(-BX)+Math.sqrt(firstSum))/(2*AX)+"";
               solution2="no solution";
            }
            if (AX == 0)
            {
                xxx.setImageResource(R.drawable.line);
            }


            if(firstSum>0)
            {
               solution1 = (Double.valueOf(-BX)+Math.sqrt(firstSum))/(2*AX)+"";
               solution2 = (Double.valueOf(-BX)-Math.sqrt(firstSum))/(2*AX)+"";
            }
            else if (firstSum < 0)
            {
                xxx.setImageResource(R.drawable.xxx);
                solution1 = "Error";
                solution2 = "Error";
            }
            if (AX==null && BX==null && CX==null)
            {
                solution1 = "Error";
                solution2 = "Error";
            }
            display.setText("X1="+solution1+" , "+"X2="+solution2);
    }

    public void back(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Exit(View view) {
        display.setText(hashCode());
    }
}