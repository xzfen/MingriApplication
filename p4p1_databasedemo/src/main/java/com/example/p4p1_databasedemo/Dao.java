package com.example.p4p1_databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/*
* 这个类用于操作数据库的增删改查
* */
public class Dao {

    private static final String TAG = "Dao";
    private DatabaseHelper mHelper;

    public Dao(Context context){
        //创建数据库
        mHelper = new DatabaseHelper(context);

    }

    public void insert(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "insert into "+Constants.TABLE_NAME+" (id,name,age,salary,phone) values(?,?,?,?,?)";
        db.execSQL(sql,new Object[]{2, "扎克伯格",40,2,120});*/

        //sqlite数据库事务处理
        /*db.beginTransaction();
        db.setTransactionSuccessful();
        db.endTransaction();*/

        ContentValues values = new ContentValues();
        values.put("id",2);
        values.put("name","BillGates");
        values.put("age","60");
        values.put("salary","1");
        values.put("phone","11110");
        db.insert(Constants.TABLE_NAME,null,values);

        Log.d(TAG, "插入一条数据：==BillGates");
        db.close();
    }
    public void delete(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "delete from "+Constants.TABLE_NAME+" where id=2";
        db.execSQL(sql);*/

        int rows = db.delete(Constants.TABLE_NAME, "id=2", null);

        Log.d(TAG, "受影响的行数：=="+rows);
        db.close();
    }
    public void update(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "update "+Constants.TABLE_NAME+" set salary=10 where id=1";
        db.execSQL(sql);*/

        ContentValues values = new ContentValues();
        values.put("name","扎克伯格");
        values.put("age",40);
        db.update(Constants.TABLE_NAME,values,"id=1",null);

        Log.d(TAG, "更新一条数据，修改id=1的name和age");
        db.close();
    }
    public void query(){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        /*String sql = "select * from "+Constants.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);*/

        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("name");
            String name = cursor.getString(index);
            Log.d(TAG, "name===: "+name);
        }
        cursor.close();


        db.close();
    }
}
