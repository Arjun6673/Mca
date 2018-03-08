package com.example.arjunmore.mca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class DatabaseClass extends SQLiteOpenHelper {
    public Context context;

    private static String DATABASENAME ="NOTES";

//CREATE TABLE "Subject" ( `SubId` INTEGER PRIMARY KEY AUTOINCREMENT, `SemId` TEXT, `Subname` TEXT, `Weightage` TEXT )
    ///////////////////////////////////////////////////
    // SUBJECT TABLE

    private static String TABLESUBJECT = "SUBJECT";
    private static String COLUMNSEMID="SemId";
    private static String COLUMNSUBID="SubId";
    private static String COLUMNSUBNAME="Subname";
    private static String COLUMNSUBCHAPTERS = "CHAPTERS";

    String CREATE_TABLE_SUBJECT =
            "CREATE TABLE " +
                    TABLESUBJECT
                    + "("
                    + COLUMNSUBID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMNSEMID + " TEXT,"
                    + COLUMNSUBNAME + " TEXT,"
                    + COLUMNSUBCHAPTERS + " TEXT"
                    + ")";
    /////////////////////////////////////////////
    //    CREATE TABLE CHAPTER
    ///////////////////////////////////////////

    private static String TABLE_CHAPTER = "CHAPTER";
    private static String COLUMN_CHAPTER_ID = "CHAPTER_ID";
    private static String COLUMN_CHAPTER_NAME ="CHAPTER_NAME";
    private static String COLUMN_WEIGHTAGE ="WEIGHTAGE";


    String CREATE_TABLE_CHAPTER
            ="CREATE TABLE " +
            TABLE_CHAPTER
            + "("
            + COLUMN_CHAPTER_ID + " TEXT PRIMARY KEY,"
            + COLUMNSUBID + " TEXT, "
            + COLUMN_CHAPTER_NAME + " TEXT,"
            + COLUMN_WEIGHTAGE + " TEXT,"
            + "FOREIGN KEY " + "(" + COLUMNSUBID + ")" + "REFERENCES " + TABLESUBJECT + "(" + COLUMNSUBID +")"
            + ")";

//////////////////////////////////////////////////////
    ///////////////////////////
    //    CREATE TABLE TOPIC
    ////////////////////////////////

    private static String TABLE_TOPIC = "TOPIC";
    private static String COLUMN_TOPIC_ID = "TOPIC_ID";
    private static String COLUMN_TOPIC_TITLE ="TOPIC_TITLE";

    String CREATE_TABLE_TOPIC
            ="CREATE TABLE " +
            TABLE_TOPIC
            + "("
            + COLUMN_TOPIC_ID + " TEXT PRIMARY KEY,"
            + COLUMN_TOPIC_TITLE + " TEXT,"
            + COLUMN_CHAPTER_ID + " TEXT ," +
            "FOREIGN KEY " + "(" + COLUMN_CHAPTER_ID + ")" + "REFERENCES " + TABLE_CHAPTER + "(" + COLUMN_CHAPTER_ID +")"
            + ")";



///////////////////////////////////////////////////////////
    ////////////////////////////////
    //    CREATE TABLE TOPIC_DATA
    ////////////////////////////////

    private static String TABLE_TOPIC_DATA = "TOPIC_DATA";

    private static String COLUMN_POINTS = "TOPIC_POINTS";

    String CREATE_TABLE_TOPICDATA
            ="CREATE TABLE " +
            TABLE_TOPIC_DATA
            + "("
            + COLUMN_TOPIC_ID + " TEXT,"
            + COLUMN_POINTS + " TEXT, "
            + "FOREIGN KEY " + "(" + COLUMN_TOPIC_ID + ")" + "REFERENCES " + TABLE_TOPIC + "(" + COLUMN_TOPIC_ID +")"
            + ")";


////////////////////////////////////////////////////////

    ///////////////////////////
    //    CREATE TABLE Login
    ////////////////////////////////

    private static String TABLE_LOGIN = "Login";
    private static String COLUMN_USERNAME = "USER_NAME";
    private static String COLUMN_PASSWORD ="PASSWORD";

    String CREATE_TABLE_LOGIN
            ="CREATE TABLE " +
            TABLE_LOGIN
            + "("
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT"
            + ")";
    ///////////////////////////////////////////////////////////////////////////////////////


    public DatabaseClass(Context context) {
        super(context, DATABASENAME,null, 2);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_SUBJECT);
        sqLiteDatabase.execSQL(CREATE_TABLE_CHAPTER);
        sqLiteDatabase.execSQL(CREATE_TABLE_TOPIC);
        sqLiteDatabase.execSQL(CREATE_TABLE_TOPICDATA);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOGIN);

        Toast.makeText(context, "All Database created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    /////////////////////methods

    void insertInLoin(Login login)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,login.getUsername());
        contentValues.put(COLUMN_PASSWORD,login.getPassward());
        sqLiteDatabase.insert(TABLE_LOGIN,null,contentValues);
        Log.i("TAG", "insert: ");
        Toast.makeText(context, "inserted in Login", Toast.LENGTH_SHORT).show();
    }

    void insertinsub(Subject subject)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMNSUBID,subject.getSubId());
        contentValues.put(COLUMNSEMID,subject.getSemId());
        contentValues.put(COLUMNSUBNAME,subject.getSubname());
        contentValues.put(COLUMNSUBCHAPTERS,subject.getSubchptrs());

        sqLiteDatabase.insert(TABLESUBJECT,null,contentValues);
        Log.i("TAG", "Inserted ");
        Toast.makeText(context, "inserted in Subject", Toast.LENGTH_SHORT).show();
    }

    void insertchapter(Chapter chapter)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CHAPTER_ID,chapter.getChapterId());
        contentValues.put(COLUMNSUBID,chapter.getSubId());
        contentValues.put(COLUMN_CHAPTER_NAME,chapter.getChapterName());
        contentValues.put(COLUMN_WEIGHTAGE,chapter.getWeightage());
        sqLiteDatabase.insert(TABLE_CHAPTER,null,contentValues);
        Log.i("TAG", "insert: ");
        Toast.makeText(context, "inserted in Chapter", Toast.LENGTH_SHORT).show();
    }

    void insertTopic(Topic topic)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TOPIC_ID,topic.getTopicid());
        contentValues.put(COLUMN_CHAPTER_ID,topic.getChapterId());
        contentValues.put(COLUMN_TOPIC_TITLE,topic.getTopictitle());
        sqLiteDatabase.insert(TABLE_TOPIC,null,contentValues);
        Log.i("TAG", "insert: ");
        Toast.makeText(context, "inserted in Topic Table", Toast.LENGTH_SHORT).show();
    }


    void insertTopicdata(TopicData TopicData)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TOPIC_ID,TopicData.getTopicid());
        contentValues.put(COLUMN_POINTS,TopicData.getTopicpoints());
        sqLiteDatabase.insert(TABLE_TOPIC_DATA,null,contentValues);
        Log.i("TAG", "insert: ");
        Toast.makeText(context, "inserted into Topic data table", Toast.LENGTH_SHORT).show();
    }
    //////getting data
    List<Subject> GetSubjectData()
    {
        List<Subject> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLESUBJECT;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {

                Subject subject = new Subject();
                subject.setSubId(cursor.getString(0));
                subject.setSemId(cursor.getString(1));
                subject.setSubname(cursor.getString(2));
                subject.setSubchptrs(cursor.getString(3));

                Log.i("TAG", "successed subject: ");
                mylist.add(subject);

            }while (cursor.moveToNext());
        }
        return mylist;
    }
    ////getting chapter
    List<Chapter> GetChapterData()
    {
        List<Chapter> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CHAPTER;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                Chapter chapter = new Chapter();
                chapter.setChapterId(cursor.getString(0));
                chapter.setChapterId(cursor.getString(1));
                chapter.setChapterName(cursor.getString(2));
                chapter.setWeightage(cursor.getString(3));
                Log.i("TAG", "successed subject: ");
                mylist.add(chapter);

            }while (cursor.moveToNext());
        }
        return mylist;
    }

    List<Topic> GetTopic()
    {
        List<Topic> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_TOPIC;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Topic topic = new Topic();
                topic.setTopicid(cursor.getString(0));
                topic.setChapterId(cursor.getString(1));
                topic.setTopictitle(cursor.getString(2));
                Log.i("TAG", "successed subject: ");
                mylist.add(topic);

            }while (cursor.moveToNext());
        }
        return mylist;
    }
    //////////topic data
    List<TopicData> GetTopicData()
    {
        List<TopicData> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLESUBJECT;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                TopicData topicData = new TopicData();
                topicData.setTopicid(cursor.getString(0));
                topicData.setTopicpoints(cursor.getString(1));

                Log.i("TAG", "successed subject: ");
                mylist.add(topicData);

            }while (cursor.moveToNext());
        }
        return mylist;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    List<Topic_And_Data> GetTopicDataTopic()
    {
        List<Topic_And_Data> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT " + TABLE_TOPIC +"."+COLUMN_TOPIC_ID + ", "+ TABLE_TOPIC + "." +
                COLUMN_TOPIC_TITLE + ", "+ TABLE_TOPIC_DATA + "." + COLUMN_POINTS +
                " FROM " + TABLE_TOPIC + "," + TABLE_TOPIC_DATA + " WHERE "
                + TABLE_TOPIC + "."+ COLUMN_TOPIC_ID +"" + " = "
                + TABLE_TOPIC_DATA + "." + COLUMN_TOPIC_ID + "" ;


        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Topic_And_Data topicData = new Topic_And_Data();
                topicData.setTopicId(cursor.getString(0));
                topicData.setTopicName(cursor.getString(1));
                topicData.setTopicData(cursor.getString(2));
                Log.i("TAG", "successed subject: ");
                mylist.add(topicData);

            }while (cursor.moveToNext());
        }
        return mylist;
    }
    //////////////////////////////////////////////////
    ///selecting specific subject
    List<Subject> GetSpecificSubject(String a)
    {
        Integer ab = Integer.valueOf(a);
        List<Subject> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLESUBJECT + " WHERE " + COLUMNSEMID + " = " + "'"+ab+"'" ;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Subject subject = new Subject();

                subject.setSubId(cursor.getString(0));
                subject.setSemId(cursor.getString(1));
                subject.setSubname(cursor.getString(2));
                subject.setSubchptrs(cursor.getString(3));
                Log.i("TAG", "successed subject: ");
                mylist.add(subject);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return mylist;
    }


    List<Chapter> GetSpecificChapter(String a)
    {
        List<Chapter> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CHAPTER + " WHERE " + COLUMNSUBID + " = " + a ;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Chapter chapter = new Chapter();
//
                chapter.setChapterId(cursor.getString(0));
                chapter.setSubId(cursor.getString(1));
                chapter.setChapterName(cursor.getString(2));
                chapter.setWeightage(cursor.getString(3));


                Log.i("TAG", "successed CHAPTER: ");
                mylist.add(chapter);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return mylist;
    }


    List<Topic_And_Data> GetSpecificTopicDataTopic()
    {
        List<Topic_And_Data> mylist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        String query = "SELECT " + TABLE_TOPIC +"."+COLUMN_TOPIC_ID + ", "+ TABLE_TOPIC + "." +
                COLUMN_TOPIC_TITLE + ", "+ TABLE_TOPIC_DATA + "." + COLUMN_POINTS +
                " FROM " + TABLE_TOPIC + "," + TABLE_TOPIC_DATA + " " +
                "WHERE "
                + TABLE_CHAPTER + "." + COLUMN_CHAPTER_ID + " = "
                + TABLE_TOPIC + "." + COLUMN_CHAPTER_ID + " AND "

                + TABLE_TOPIC + "."+ COLUMN_TOPIC_ID +"" + " = "
                + TABLE_TOPIC_DATA + "." + COLUMN_TOPIC_ID + ""  ;


        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Topic_And_Data topicData = new Topic_And_Data();
                topicData.setTopicId(cursor.getString(0));
                topicData.setTopicName(cursor.getString(1));
                topicData.setTopicData(cursor.getString(2));
                Log.i("TAG", "successed subject: ");
                mylist.add(topicData);

            }while (cursor.moveToNext());
        }
        return mylist;
    }








    /////Login data
    Login Checkuser()
    {
        Login login= new Login();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String queryy = "SELECT * FROM " + TABLE_LOGIN;

        Cursor cursor = sqLiteDatabase.rawQuery(queryy,null);
        if(cursor.moveToFirst())
        {
            do {
                login.setUsername(cursor.getString(0));
                login.setPassward(cursor.getString(1));
            }
            while (cursor.moveToNext());
        }
        return login;
    }


    //////////////////////


}
