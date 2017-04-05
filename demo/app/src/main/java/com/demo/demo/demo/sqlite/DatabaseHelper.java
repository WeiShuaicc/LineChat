package com.demo.demo.demo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/2/25/025.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String name="Diary";

    private final static int version=1;

    private final static String setup="CREATE TABLE IF NOT EXISTS Diary (personid integer primary key autoincrement, date varchar(20), strDiary string ,num INTEGER)";


    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(setup);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
