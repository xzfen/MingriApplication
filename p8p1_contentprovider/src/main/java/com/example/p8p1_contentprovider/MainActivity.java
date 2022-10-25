package com.example.p8p1_contentprovider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.p8p1_contentprovider.pojo.UserInfo;
import com.example.p8p1_contentprovider.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取电话本数据权限
        checkContactReadPermission();
        //观察user数据是否发生变化
        //userDataObserver();
    }

    private void checkContactReadPermission() {
        int readPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
        if(readPermission!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            //判断结果
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "has permissions..");
                //有权限
            } else {
                Log.d(TAG, "no permissionS...");
                //没权限
                finish();
            }
        }
    }

    private void userDataObserver() {
        ContentResolver contentResolver = getContentResolver();
        Uri uri=Uri.parse("content://com.example.p8p1_contentprovider/user");
        contentResolver.registerContentObserver(uri, true, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Log.d(TAG, "onChange: 用户数据发生变化");
            }
        });
    }

    public void getUserData(View view) {
        ContentResolver contentResolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.p8p1_contentprovider/user");
        Cursor cursor = contentResolver.query(uri, null, "id=? or id=?", new String[]{8+"",9+""}, null);
        String[] columnNames = cursor.getColumnNames();
        while(cursor.moveToNext()) {
            for (String columnName : columnNames) {
                @SuppressLint("Range") String value = cursor.getString(cursor.getColumnIndex(columnName));
                Log.d(TAG, columnName+"----> "+value);
            }
            Log.d(TAG, "getUserData: ============================");
        }
        cursor.close();
    }

    public void insertUserData(View view) {
        ContentResolver contentResolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.p8p1_contentprovider/user");
        ContentValues values=new ContentValues();
        values.put(Constants.FIELD_NAME,"马云");
        values.put(Constants.FIELD_AGE,58);
        values.put(Constants.FIELD_PSSWORD,"123456");
        values.put(Constants.FIELD_GENDER,"male");
        Uri rowUri = contentResolver.insert(uri, values);
    }

    @SuppressLint("Range")
    public void getPhoneContactData(View view) {
        ContentResolver resolver=getContentResolver();
        //获取用户id和name
        Uri rawContactUri= Uri.parse("content://"+ContactsContract.AUTHORITY+"/raw_contacts");
        Cursor rawContactCursor = resolver.query(rawContactUri, new String[]{"contact_id","display_name"}, null, null, null);
        List<UserInfo> userInfos=new ArrayList<>();
        while (rawContactCursor.moveToNext()){
            UserInfo userInfo=new UserInfo();
            userInfo.setId(rawContactCursor.getString(rawContactCursor.getColumnIndex("contact_id")));
            userInfo.setName(rawContactCursor.getString(rawContactCursor.getColumnIndex("display_name")));
            userInfos.add(userInfo);
        }
        rawContactCursor.close();

        //获取手机号码
        Uri numberUri = Uri.parse("content://"+ContactsContract.AUTHORITY+"/data/phones");
        for(UserInfo userInfo : userInfos) {
            Cursor phoneCursor = resolver.query(numberUri,new String[]{"data1"},"raw_contact_id=?",new String[]{userInfo.getId()},null);
            if(phoneCursor.moveToNext()) {
                userInfo.setNumber(phoneCursor.getString(0).replaceAll("[\\s-: ]",""));
            }
            phoneCursor.close();
        }
        //获取email
        Uri emailUri = Uri.parse("content://"+ContactsContract.AUTHORITY+"/data/emails");
        for(UserInfo userInfo : userInfos) {
            Cursor emailCursor = resolver.query(emailUri,new String[]{"data1"},"raw_contact_id=?",new String[]{userInfo.getId()},null);
            if(emailCursor.moveToNext()) {
                userInfo.setEmail(emailCursor.getString(0));
            }
            emailCursor.close();
        }

        for(UserInfo userInfo : userInfos) {
            Log.d(TAG,"--ID-->" + userInfo.getId() + " -- NAME --> " + userInfo.getName() + " -- PHONE --> " + userInfo.getNumber() + "--EMAIL-->" + userInfo.getEmail());
        }
    }
}