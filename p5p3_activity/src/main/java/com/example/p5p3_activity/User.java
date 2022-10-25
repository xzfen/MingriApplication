package com.example.p5p3_activity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @项目名称：MingriApplication
 * @包名：com.example.p5p3_activity
 * @作者：FENG
 * @类名：User
 * @创建时间：2022/8/2116:17
 * @描述：User类
 **/
public class User implements Parcelable {
    private String name;
    private int age;
    private float tall;

    public User() {
    }

    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        tall = in.readFloat();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getTall() {
        return tall;
    }

    public void setTall(float tall) {
        this.tall = tall;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeFloat(tall);
    }
}
