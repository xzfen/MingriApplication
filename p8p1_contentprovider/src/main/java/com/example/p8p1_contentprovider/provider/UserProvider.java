package com.example.p8p1_contentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.p8p1_contentprovider.db.UserDatabaseHelper;
import com.example.p8p1_contentprovider.utils.Constants;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.provider
 * @作者：FENG
 * @类名：UserProvider
 * @创建时间：2022/9/617:00
 * @描述：
 **/
public class UserProvider extends ContentProvider {

    private static final int CODE_MATCH = 1;
    private static final String TAG = "UserProvider";
    private UserDatabaseHelper mDatabaseHelper;
    //定义一个Uri匹配器
    private static UriMatcher mUriMatcher=new UriMatcher(CODE_MATCH);

    static {
        //添加匹配规则，前面是authority，这个其实就是我们在配置文件里配置的那个认证字符串
        //第二个参数是path,一般表示表名
        //第三个表示the code that is returned when a URI is matched，也就是说规则匹配则会返回后面那个code
        mUriMatcher.addURI("com.example.p8p1_contentprovider","user",CODE_MATCH);
    }

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new UserDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int match = mUriMatcher.match(uri);
        if (match==CODE_MATCH) {
            SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query(Constants.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            return cursor;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        int match= mUriMatcher.match(uri);
        if (match==CODE_MATCH) {
            SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
            long rowId = db.insert(Constants.TABLE_NAME, null, values);
            Uri resultUri=Uri.parse("content://com.example.p8p1_contentprovider/user"+rowId);
            Log.d(TAG, "insert:插入成功 "+resultUri);
            //插入数据成功,数据已经变化，通知其他地方
            if (rowId!=-1) {
                getContext().getContentResolver().notifyChange(resultUri,null);
            }
            return resultUri;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
