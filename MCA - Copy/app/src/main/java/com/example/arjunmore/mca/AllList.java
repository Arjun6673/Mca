package com.example.arjunmore.mca;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AllList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_list);

        //showing subject fragment here
        //Subject Adapter class used for listeners of subect
        Intent intent = getIntent();
        String thiss = intent.getStringExtra("SemId");
        Toast.makeText(this, "Passed value is "+ thiss, Toast.LENGTH_SHORT).show();


        SubjectFragment subjectFragment = new SubjectFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containlist,subjectFragment,"done");
        fragmentTransaction.commit();

        Bundle data = new Bundle();//create bundle instance
        data.putString("key_value", "" + thiss);//put string to pass with a key value
        subjectFragment.setArguments(data);//Set bundle data to fragment

    }
}
