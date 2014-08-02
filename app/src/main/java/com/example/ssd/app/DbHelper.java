package com.example.ssd.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 0_o on 2014/7/6.
 */
public class DbHelper extends SQLiteOpenHelper{

    public DbHelper(Context context, String name, CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE pic(_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , fileName VARCHAR, description VARCHAR)";
        db.execSQL();
    }

}
