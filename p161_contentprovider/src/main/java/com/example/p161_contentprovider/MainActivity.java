package com.example.p161_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //希望获得姓名
    private String columns= ContactsContract.Contacts.DISPLAY_NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.result);
        //显示获取的通讯录信息
        textView.setText(getQueryData());
    }

    private CharSequence getQueryData(){
        //用于保存获取的联系人
        StringBuilder stringBuilder=new StringBuilder();
        ContentResolver resolver=getContentResolver();
        //查询记录
        Cursor cursor=resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        int displayNameIndex=cursor.getColumnIndex(columns);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            String displayName=cursor.getString(displayNameIndex);
            stringBuilder.append(displayName+"\n");
        }
        cursor.close();//关闭记录集
        return stringBuilder.toString();//返回查询记录
    }
}