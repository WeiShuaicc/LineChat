package com.demo.demo.demo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.demo.demo.demo.units.SQData;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/27/027.
 */

public class DataDb {

    private static Context context;

    private static DatabaseHelper databaseHelper ;

    private static DataDb dataDb = new DataDb();

    public static DataDb instance() {
        return dataDb;
    }

    public static void init(Context mcontext){
        context = mcontext;
        databaseHelper = new DatabaseHelper(context);

    }

    public void insert(String date,String value,int num){
        SQLiteDatabase writableDatabase=databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("strDiary",value);
        contentValues.put("num",num);
        writableDatabase.insert(databaseHelper.getDatabaseName(),null,contentValues);
        writableDatabase.close();
    }

    public int delete(int position){
        Log.e("DataDb",position+"");
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        int i= writableDatabase.delete(databaseHelper.getDatabaseName(), "personid=(?)", new String[]{position+""});
        writableDatabase.close();
        return i;
    }

    public void update(){
        SQLiteDatabase writableDatabase=databaseHelper.getWritableDatabase();
//        writableDatabase.update();
    }

    public List<SQData> query() {
        List<SQData> list=new ArrayList<SQData>();
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.query(databaseHelper.getDatabaseName(), null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);//key
            String date=cursor.getString(1);//date
            String str=cursor.getString(2);//content
            int num =cursor.getInt(3);//字数
            list.add(new SQData(id,date,num,str));
//            Log.e("DataDb",id+"----"+date+"----"+str+"----"+num+"----");
        }
        cursor.close();
        readableDatabase.close();
        return list;
    }


}
