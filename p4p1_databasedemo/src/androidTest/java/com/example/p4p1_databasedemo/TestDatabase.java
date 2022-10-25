package com.example.p4p1_databasedemo;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p4p1_databasedemo
 * @作者：FENG
 * @类名：TestDatabase
 * @创建时间：2022/8/1719:41
 * @描述：数据库测试类
 **/
@RunWith(AndroidJUnit4.class)
public class TestDatabase {
    @Test
    public void testCreate() {

    }
    @Test
    public void testInsert() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(appContext);
        dao.insert();
    }
    @Test
    public void testDelete() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(appContext);
        dao.delete();
    }
    @Test
    public void testUpdate() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(appContext);
        dao.update();
    }
    @Test
    public void testQuery() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(appContext);
        dao.query();
    }
}
