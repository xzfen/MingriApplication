package com.example.b3p1_qqlogindemo;

import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "fengxz";
    private EditText mAccount;
    private EditText mPassword;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一步：找到控件
        initView();
        //第二步：给登录按钮设置点击事件
        initListener();
    }

    //Activivy恢复是回显用户名和密码

    @Override
    protected void onResume() {
        super.onResume();
        //获取保存的文件
        try {
            //FileInputStream fis = this.openFileInput("info.txt");//获取文件输入流
            File file = this.getFileStreamPath("info.txt");
            Log.d(TAG, "onResume: " + file.toString());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String info = bufferedReader.readLine();
            Log.d(TAG, "onResume: " + info);
            String[] infos = info.split("\\*\\*\\*");
            for (int i = 0; i < infos.length; i++) {
                Log.d(TAG, "onResume: " + infos[i]);
            }
            mAccount.setText(infos[0]);
            mPassword.setText(infos[1]);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 设置点击事件点击监听
    * */
    private void initListener() {
        mButton.setOnClickListener(this);
    }

    /*
    * 这个方法用来找到对应的控件
    * */
    private void initView() {
        mAccount = findViewById(R.id.et_account);
        mPassword = findViewById(R.id.et_password);
        mButton = findViewById(R.id.bt_login);
    }

    @Override
    public void onClick(View view) {
        //处理登录事件
        handleLoginEvent(view);
    }

    /*
    * 处理登录事件
    * */
    private void handleLoginEvent(View view) {
        //第三步：获取activity的内容
        String accountText = mAccount.getText().toString();
        String passwordText = mPassword.getText().toString();

        //对账号进行检查，在实际开发中，我们需要对用户的账号进行合法性检查，比如账号的长度，账号有没有敏感词等。
        //密码的检查也是，一般来说需要对密码的复杂度进行检查
        //这里我们只对账号和密码进行判空处理
//        if (accountText.length()==0) {
//            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (passwordText.length()==0) {
//            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
//            return;
//        }
        if (TextUtils.isEmpty(accountText)) {
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //把账号和密码保存到手机上
        saveUserInfo(accountText,passwordText);
    }

    private void saveUserInfo(String accountText, String passwordText) {
        Log.d(TAG, "saveUserInfo: ");
        //获取文件保存路径
        /*
        * file dir = /data/user/0/com.example.b3p1_qqlogindemo/files
        * 保存文件的路径，怎么才能删除呢？我们可以用代码删除，也可以用设置里的应用列表的选项进行清理
        * */
        //获取内部应用的数据存储路径
        File filesDir = this.getFilesDir();
        Log.d(TAG, "saveUserInfo: " + filesDir.toString());
        //获取SD卡的数据存储路径
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            File exFile = Environment.getExternalStorageDirectory();
            //获取SD卡总容量
            long totalSpace = exFile.getTotalSpace();
            //格式化总容量
            String size = Formatter.formatFileSize(this, totalSpace);
            Log.d(TAG, "saveUserInfo: TotalSpace is" + size);
            long freeSpace = exFile.getFreeSpace();
            size = Formatter.formatFileSize(this,freeSpace);
            Log.d(TAG, "saveUserInfo: FreeSpace is " + size);
        }
        //创建文件对象
        File file = new File(filesDir, "info.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();//创建文件“info.txt”
            }
            //FileOutputStream fos = new FileOutputStream(file);
            //创建Filewriter对象
            FileWriter fileWriter = new FileWriter(file);
            //fos.write((accountText+"***"+passwordText).getBytes());
            //将账号和密码写入FileWriter对象的file文件中
            fileWriter.write(accountText+"***"+passwordText);
            //fos.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}