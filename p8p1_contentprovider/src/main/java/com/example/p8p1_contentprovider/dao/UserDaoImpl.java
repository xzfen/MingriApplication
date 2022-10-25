package com.example.p8p1_contentprovider.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.p8p1_contentprovider.db.UserDatabaseHelper;
import com.example.p8p1_contentprovider.pojo.User;
import com.example.p8p1_contentprovider.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.dao
 * @作者：FENG
 * @类名：UserDaoImpl
 * @创建时间：2022/9/610:39
 * @描述：
 **/
public class UserDaoImpl implements IUserDao{


    private UserDatabaseHelper mUserDatabaseHelper;

    public UserDaoImpl(Context context) {
        mUserDatabaseHelper = new UserDatabaseHelper(context);
    }

    @Override
    public long addUser(User user) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.FIELD_NAME,user.getName());
        values.put(Constants.FIELD_PSSWORD,user.getPassword());
        values.put(Constants.FIELD_GENDER,user.getGender());
        values.put(Constants.FIELD_AGE,user.getAge());
        long result = db.insert(Constants.TABLE_NAME, null, values);
        db.close();
        return result;
    }

    @Override
    public int deleteUserById(int id) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        int result = db.delete(Constants.TABLE_NAME, Constants.FIELD_ID+"=?", new String[]{id+""});
        db.close();
        return result;
    }

    @Override
    public int updateUser(User user) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        //根据ID更新内容
        values.put(Constants.FIELD_NAME,user.getName());
        values.put(Constants.FIELD_PSSWORD,user.getPassword());
        values.put(Constants.FIELD_GENDER,user.getGender());
        values.put(Constants.FIELD_AGE,user.getAge());
        int result = db.update(Constants.TABLE_NAME, values, Constants.FIELD_ID+"=?", new String[]{user.getId()+""});
        db.close();
        return result;
    }

    @Override
    public User getUserById(int id) {
        SQLiteDatabase db = mUserDatabaseHelper.getWritableDatabase();
        //使用sql语句
        String sql="select * from "+Constants.TABLE_NAME+" where "+Constants.FIELD_ID+"=?";
        Cursor cursor = db.rawQuery(sql, new String[]{id + ""});
        User user=null;
        if (cursor.moveToNext()) {
            user = cursor2User(cursor);
        }
        db.close();
        return user;
    }

    @Override
    public List<User> listAllUser() {
        SQLiteDatabase db = mUserDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);
        List<User> users=new ArrayList<>();
        while (cursor.moveToNext()) {
            User user=cursor2User(cursor);
            users.add(user);
        }
        db.close();
        return users;
    }

    private User cursor2User(Cursor cursor) {
        User user=new User();
        @SuppressLint("Range") int userId= cursor.getInt(cursor.getColumnIndex(Constants.FIELD_ID));
        user.setId(userId);
        @SuppressLint("Range") String userName= cursor.getString(cursor.getColumnIndex(Constants.FIELD_NAME));
        user.setName(userName);
        @SuppressLint("Range") String userPassword= cursor.getString(cursor.getColumnIndex(Constants.FIELD_PSSWORD));
        user.setPassword(userPassword);
        @SuppressLint("Range") String userGender= cursor.getString(cursor.getColumnIndex(Constants.FIELD_GENDER));
        user.setGender(userGender);
        @SuppressLint("Range") int userAge= cursor.getInt(cursor.getColumnIndex(Constants.FIELD_AGE));
        user.setAge(userAge);
        return user;
    }
}
