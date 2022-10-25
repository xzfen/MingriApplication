package com.example.p7p6_bankservicedemo.interfaces;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p7p6_bankservicedemo.interfaces
 * @作者：FENG
 * @类名：IBankWorker
 * @创建时间：2022/9/28:57
 * @描述：
 **/
public interface IBankWorkerAction extends INormalUserAction{
    //查询用户信用
    void queryUserCredit();
    //冻结用户账号
    void freezeUserAccount();
}
