package com.example.p7p6_bankservicedemo.interfaces;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p7p6_bankservicedemo.interfaces
 * @作者：FENG
 * @类名：INormalUserAction
 * @创建时间：2022/9/28:52
 * @描述：
 **/
public interface INormalUserAction {
    //存钱
    void saveMoney(float money);
    //取钱
    float getMoney();
    //贷款
    float loanMoney();
}
