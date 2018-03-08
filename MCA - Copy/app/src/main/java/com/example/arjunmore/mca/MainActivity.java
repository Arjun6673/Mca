package com.example.arjunmore.mca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnupdate;
    Button btnDelete;

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;

    RadioButton redSub;
    RadioButton redChapter;
    RadioButton redTopic;
    RadioButton redData;
    TextView txtCheckStatus;

//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btninsert);
        btnupdate = findViewById(R.id.btnupdate);
        btnDelete = findViewById(R.id.btnDelete);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        edit4 = (EditText) findViewById(R.id.edit4);

        final RadioButton redSub= findViewById(R.id.rediosub);
        final RadioButton redChapter= findViewById(R.id.redChap);
        final RadioButton redTopic= findViewById(R.id.redtopic);
        final RadioButton redData= findViewById(R.id.redData);

        txtCheckStatus = findViewById(R.id.txtCheckSelected);

        RadioGroup redgroup= findViewById(R.id.RedioGroup);
        RadioSubject();

        final DatabaseClass databaseClass = new DatabaseClass(this);

        redgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.redData:
                        RadioTopicData();
                        clearTxt();
                        break;

                    case R.id.redtopic:
                        RadioTopic();
                        clearTxt();
                        break;

                    case R.id.redChap:
                        RadioChapter();
                        clearTxt();
                        break;

                    case R.id.rediosub:
                        RadioSubject();
                        clearTxt();
                        break;

                }
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(redSub.isChecked()) {
                    Subject subject = new Subject(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString(),edit4.getText().toString());
                    databaseClass.insertinsub(subject);
                   // insertintofirebaseSubject();
                }
                else if (redChapter.isChecked()){
                    Chapter chapter = new Chapter(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString(),edit4.getText().toString());
                    databaseClass.insertchapter(chapter);
                   // insertintofirebaseChapter();
                }
                else if(redTopic.isChecked()){
                    Topic topic = new Topic(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString());
                    databaseClass.insertTopic(topic);
                 //   insertintofirebaseTopic();
                }
                else if (redData.isChecked()) {
                    TopicData topic1 = new TopicData(edit1.getText().toString(),edit2.getText().toString());
                    databaseClass.insertTopicdata(topic1);
                  //  insertintofirebaseData();
                }
                else {
                    Toast.makeText(MainActivity.this,"Please Check any Option",Toast.LENGTH_LONG).show();
                }
                clearTxt();
            }
        });

//        firebaseDatabase = FirebaseDatabase.getInstance();


    }


//    void insertintofirebaseSubject() {
//
//        databaseReference =firebaseDatabase.getReference("Notes");
//        Subject subject = new Subject(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString(),edit4.getText().toString());
//        databaseReference.child("Subject").child(edit1.getText().toString()).setValue(subject);
//    }
//
//    void insertintofirebaseData()
//    {
//        databaseReference = firebaseDatabase.getReference("Notes");
//        TopicData topicData = new TopicData(edit1.getText().toString(),edit2.getText().toString());
//        databaseReference.child("Topic Data").child(edit1.getText().toString()).setValue(topicData);
//    }
//
//    void insertintofirebaseChapter()
//    {
//        databaseReference =firebaseDatabase.getReference("Notes");
//        Chapter chapter = new Chapter(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString(),edit4.getText().toString());
//        databaseReference.child("Chapter").child(edit1.getText().toString()).setValue(chapter);
//    }
//
//    void insertintofirebaseTopic()
//    {
//        databaseReference =firebaseDatabase.getReference("Notes");
//        Topic topic = new Topic(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString());
//        databaseReference.child("Topic").child(edit1.getText().toString()).setValue(topic);
//    }

    void SetCheckStatus(String msg)
    {
        txtCheckStatus.setText(msg);
    }
    void RadioSubject()
    {
        edit1.setVisibility(View.VISIBLE);
        edit2.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit4.setVisibility(View.VISIBLE);
        edit1.setHint("Enter Subject id");
        edit2.setHint("Enter Semester id");
        edit3.setHint("Enter Subject Name");
        edit4.setHint("Enter Chapter Numbers");

        SetCheckStatus("Insert Into Subject Table");

    }
    void RadioChapter()
    {
        edit1.setVisibility(View.VISIBLE);
        edit2.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit4.setVisibility(View.VISIBLE);
        edit1.setHint("Enter Chapter id");
        edit2.setHint("Enter Subject Id");
        edit3.setHint("Enter Chapter Name");
        edit4.setHint("Enter Chapter Weightage");

        SetCheckStatus("Insert into Chapter Table");

    }
    void RadioTopic()
    {
        edit4.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit1.setHint("Enter Topic Id");
        edit2.setHint("Enter Chapter id");
        edit3.setHint("Enter Topic Details");
        edit4.setVisibility(View.INVISIBLE);

        SetCheckStatus("Insert Into Topic Table");
    }

    void RadioTopicData()
    {
        edit1.setVisibility(View.VISIBLE);
        edit2.setVisibility(View.VISIBLE);
        edit1.setHint("Enter Topic id");
        edit2.setHint("Enter Topic Data");

        edit3.setVisibility(View.INVISIBLE);
        edit4.setVisibility(View.INVISIBLE);
        SetCheckStatus("Insert Into Data Table");
    }
    void RadioLogin()
    {

    }


    void clearTxt()
    {
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
    }

}
