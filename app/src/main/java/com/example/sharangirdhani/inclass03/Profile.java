package com.example.sharangirdhani.inclass03;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KashishSyeda on 9/11/2017.
 */

public class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
    String name, department, email, mood, image;

    public Profile(String name, String department, String email, String mood, String image) {
        this.name = name;
        this.department = department;
        this.email = email;
//        this.account_state = account_state;
        this.mood = mood;
        this.image = image;
    }

    protected Profile(Parcel in) {
        this.name = in.readString();
        this.department = in.readString();
        this.email = in.readString();
//        this.account_state = in.readString();
        this.mood = in.readString();
        this.image = in.readString();
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(department);
        dest.writeString(email);
        dest.writeString(mood);
        dest.writeString(image);
    }
}
