package com.example.p8p1_contentprovider.pojo;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p8p1_contentprovider.pojo
 * @作者：FENG
 * @类名：User
 * @创建时间：2022/9/412:43
 * @描述：bean类
 **/
public class User {
    private int id;
    private String name;
    private String password;
    private String gender;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
