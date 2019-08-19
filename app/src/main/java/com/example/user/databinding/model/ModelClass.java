package com.example.user.databinding.model;

import android.os.Parcel;
import android.os.Parcelable;


public class ModelClass implements Parcelable {

    public String first_name;
    public String last_name;
    public String email;
    public String image;

    public ModelClass() {

    }

    public ModelClass(String first_name, String last_name, String email, String image) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.image = image;
    }

    protected ModelClass(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        image = in.readString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

       public static final Creator<ModelClass> CREATOR = new Creator<ModelClass>() {
        @Override
        public ModelClass createFromParcel(Parcel in) {
            return new ModelClass(in);
        }

        @Override
        public ModelClass[] newArray(int size) {
            return new ModelClass[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(email);
        parcel.writeString(image);
    }
}
