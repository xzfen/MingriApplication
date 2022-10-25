package com.example.p4p1_databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    /*
    * @param: context   上下文
    * @param: name      数据库名称
    * @param: factory   游标工厂
    * @param: version   版本号
     * */
    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库时的回调
        Log.d(TAG, "创建数据库。。。");
        //创建表
        //sql: create table table_name(id integer,name varchar,age int,salary int);
        String sql = "create table "+Constants.TABLE_NAME+"(id int,name varchar,age int,salary int)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库时的回调
        Log.d(TAG, "升级数据库。。。");
        //sql: alter table table_name add phone int
        String sql = "alter table "+Constants.TABLE_NAME+" add phone int";
        db.execSQL(sql);
    }
}
