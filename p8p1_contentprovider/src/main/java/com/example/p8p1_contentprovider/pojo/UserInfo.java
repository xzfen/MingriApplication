package com.example.p8p1_contentprovider.pojo;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.pojo
 * @作者：FENG
 * @类名：UserInfo
 * @创建时间：2022/9/910:48
 * @描述：
 **/
public class UserInfo {
    private String id;
    private String name;
    private String number;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
