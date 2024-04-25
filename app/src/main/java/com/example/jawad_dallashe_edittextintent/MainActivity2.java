package com.example.jawad_dallashe_edittextintent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
    ImageView start_parabola;
    Button back;
    private float AX,BX,CX;
    float firstSum ;
    String solution1,solution2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Intent GH = getIntent();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            display=findViewById(R.id.display);
            start_parabola=findViewById(R.id.start_parabola);
            back=findViewById(R.id.back);

            AX=GH.getFloatExtra("a",0);
            BX=GH.getFloatExtra("b",0);
            CX=GH.getFloatExtra("c",0);

            firstSum=BX*BX-4*AX*CX;

            back.setBackgroundColor(Color.rgb(3, 252, 207));

            if (firstSum==0 && AX>0)
            {
                start_parabola.setImageResource(R.drawable.s);
            }
            if (firstSum>0 && AX>0)
            {
                start_parabola.setImageResource(R.drawable.sminos);
            }
            if (firstSum<0 && AX>0)
            {
                start_parabola.setImageResource(R.drawable.splus);
            }
            if (firstSum==0 && AX<0)
            {
                start_parabola.setImageResource(R.drawable.ans);
            }
            if (firstSum>0 && AX<0)
            {
                start_parabola.setImageResource(R.drawable.ansplus);
            }
            if (firstSum<0 && AX<0)
            {
                start_parabola.setImageResource(R.drawable.ansminos);
            }
            if (firstSum==0)
            {
                solution1=(Float.valueOf(-BX)+Math.sqrt(firstSum))/(2*AX)+"";
                solution2="no solution";
            }
            if (firstSum>0)
            {
                solution1=(Float.valueOf(-BX)+Math.sqrt(firstSum))/(2*AX)+"";
                solution2=(Float.valueOf(-BX)-Math.sqrt(firstSum))/(2*AX)+"";
            }
            if (firstSum<0)
            {
                solution1="no solution";
                solution2="no solution";
            }
            display.setText("X1="+solution1+" , "+"X2="+solution2);
        }
    }