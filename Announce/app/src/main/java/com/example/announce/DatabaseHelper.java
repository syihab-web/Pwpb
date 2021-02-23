package com.example.announce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper	extends SQLiteOpenHelper{

    private	static final int DB_VERSION = 1;
    private	static final String DB_NAME = "Announce";
    private	static final String TABLE_NAME = "tbl_post";
    private	static final String KEY_TITLE = "title";
    private	static final String KEY_DESC = "description";
    private static final String KEY_DATE = "datetime";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPostTable ="Create Table "+TABLE_NAME+"("+KEY_TITLE+" TEXT PRIMARY KEY,"+KEY_DESC+" TEXT"+"," +
                ""+KEY_DATE+" DATE "+")";
        db.execSQL(createPostTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void	insert(Post post){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, post.getTitle());
        values.put(KEY_DESC, post.getDesc());
        values.put(KEY_DATE, post.getDatetime());

        db.insert(TABLE_NAME, null,values);
    }

    public List<Post> selectPostData(){
        ArrayList<Post> postList=new ArrayList<Post>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_TITLE, KEY_DESC, KEY_DATE};

        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while (c.moveToNext()){
            String title = c.getString(0);
            String desc = c.getString(1);
            String date = c.getString(2);

            Post announce = new Post();
            announce.setTitle(title);
            announce.setDesc(desc);
            announce.setDatetime(date);
            postList.add(announce);
        }

        return	postList;
    }

    public void delete(String title){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_TITLE+"='"+title+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }

    public void update(Post curentPost){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESC, curentPost.getDesc());
        values.put(KEY_DATE, curentPost.getDatetime());
        String whereClause = KEY_TITLE+"='"+curentPost.getTitle()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
}

