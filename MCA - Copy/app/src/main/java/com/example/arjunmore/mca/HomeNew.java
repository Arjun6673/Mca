package com.example.arjunmore.mca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeNew extends AppCompatActivity {
    CardView Firstsem,SecondSem,ThidSem,ForthSem,FifthSem,SixthSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_new);

        TextView txt = findViewById(R.id.txtfirst);
        ImageButton imgbtn =  findViewById(R.id.btnadd);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });


        Firstsem = findViewById(R.id.Firtsem);
        SecondSem = findViewById(R.id.SecndSem);
        ThidSem = findViewById(R.id.ThrdSem);
        ForthSem = findViewById(R.id.ForthSem);
        FifthSem= findViewById(R.id.FifthSem);
        SixthSem = findViewById(R.id.SixthSem);


        Firstsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("1");
            }
        });

        SecondSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("2");
            }
        });

        ThidSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("3");
            }
        });
        ForthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("4");
            }
        });
        FifthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("5");
            }
        });
        SixthSem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAllist("6");
            }
        });


    }

    void CallAllist(String value)
    {
        String a = value;
        Intent intent = new Intent(this,AllList.class);
        intent.putExtra("SemId",""+ a);
        startActivity(intent);
    }

}

