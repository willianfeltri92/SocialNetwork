package com.example.socialnetwork.socialnetwork;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String city;
    private String photo;
    private String username;
    private String gender;
    private String sexualOrientation;
    private int age;


    protected User(Parcel in) {
        city = in.readString();
        photo = in.readString();
        username = in.readString();
        gender = in.readString();
        sexualOrientation = in.readString();
        age = in.readInt();
    }

    public User() {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(photo);
        dest.writeString(username);
        dest.writeString(gender);
        dest.writeString(sexualOrientation);
        dest.writeInt(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotoUrl() {
        return photo;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photo = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
