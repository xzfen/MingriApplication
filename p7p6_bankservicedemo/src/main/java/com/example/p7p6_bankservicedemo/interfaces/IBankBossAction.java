package com.example.p7p6_bankservicedemo.interfaces;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p7p6_bankservicedemo.interfaces
 * @作者：FENG
 * @类名：IBankBossAction
 * @创建时间：2022/9/29:21
 * @描述：
 **/
public interface IBankBossAction extends IBankWorkerAction{
    //修改账号金额
    void modifyUserAccountMoney(float money);
}
