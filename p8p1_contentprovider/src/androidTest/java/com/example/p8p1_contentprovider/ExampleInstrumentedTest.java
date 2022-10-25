package com.example.p8p1_contentprovider;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.p8p1_contentprovider.dao.IUserDao;
import com.example.p8p1_contentprovider.dao.UserDaoImpl;
import com.example.p8p1_contentprovider.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String TAG = "ExampleInstrumentedTest";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.p8p1_contentprovider", appContext.getPackageName());
    }

    @Test
    public void testAddUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao=new UserDaoImpl(appContext);
        User user=new User();
        user.setName("刘若英");
        user.setPassword("123456");
        user.setGender("female");
        user.setAge(40);
        long result = userDao.addUser(user);
        Log.d(TAG, "testAddUser: "+result);
    }

    @Test
    public void testDeleteUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao=new UserDaoImpl(appContext);
        int result = userDao.deleteUserById(10);
        Log.d(TAG, "testDeleteUser: "+result);
        //TODO
    }

    @Test
    public void testGetUserById(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao=new UserDaoImpl(appContext);
        User user = userDao.getUserById(10);
        Log.d(TAG, "testGetUserById: "+user);
    }

    @Test
    public void testListAllUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        IUserDao userDao=new UserDaoImpl(appContext);
        List<User> users=userDao.listAllUser();
        for (User user : users) {
            Log.d(TAG, "testListAllUser: "+user);
        }
    }
}