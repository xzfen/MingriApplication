package com.example.p8p1_contentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.p8p1_contentprovider.utils.Constants;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.db
 * @作者：FENG
 * @类名：UserDatabaseHelper
 * @创建时间：2022/9/412:48
 * @描述：
 **/
public class UserDatabaseHelper extends SQLiteOpenHelper {
    public UserDatabaseHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        //创建表
        String createSQL="create table " +
                Constants.TABLE_NAME + "("+
                Constants.FIELD_ID+ " integer primary key autoincrement, "+
                Constants.FIELD_NAME+ " varchar(20), "+
                Constants.FIELD_PSSWORD+" varchar(20), "+
                Constants.FIELD_GENDER+" varchar(6), "+
                Constants.FIELD_AGE+" integer)";
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级数据库
    }
}
