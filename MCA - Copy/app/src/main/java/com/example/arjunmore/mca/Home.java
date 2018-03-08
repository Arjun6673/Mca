package com.example.arjunmore.mca;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Home extends AppCompatActivity {

    TextView Firstsem,SecondSem,ThidSem,ForthSem,FifthSem,SixthSem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DatabaseClass databaseClass = new DatabaseClass(this);

        TextView txt = findViewById(R.id.txtfirst);
        ImageButton btnlogin = (ImageButton) findViewById(R.id.btnlogin);


        Firstsem = findViewById(R.id.Firsst);
        SecondSem = findViewById(R.id.SecndSem);
        ThidSem = findViewById(R.id.ThrdSem);
        ForthSem = findViewById(R.id.ForthSem);
        FifthSem= findViewById(R.id.FifthSem);
        SixthSem = findViewById(R.id.SixthSem);







        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);

            }
        });



        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentLogin fragmentLogin = new FragmentLogin();
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.containerlogin,fragmentLogin,"login");
                fragmentTransaction.commit();
            }
        });



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
        Intent intent = new Intent(Home.this,AllList.class);
        intent.putExtra("SemId",""+ a);
        startActivity(intent);
    }



}
