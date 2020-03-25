package com.example.gym;

import android.os.Parcel;
import android.os.Parcelable;

public class Training implements Parcelable {

    private int id;
    private String name;
   private String shortdesc;
   private  String longdesc;
   private String imageurl;

    public Training(int id, String name, String shortdesc, String longdesc, String imageurl) {
        this.id = id;
        this.name = name;
        this.shortdesc = shortdesc;
        this.longdesc = longdesc;
        this.imageurl = imageurl;
    }

    public Training() {
    }

    protected Training(Parcel in) {
        id = in.readInt();
        name = in.readString();
        shortdesc = in.readString();
        longdesc = in.readString();
        imageurl = in.readString();
    }

    public static final Creator<Training> CREATOR = new Creator<Training>() {
        @Override
        public Training createFromParcel(Parcel in) {
            return new Training(in);
        }

        @Override
        public Training[] newArray(int size) {
            return new Training[size];
        }
    };

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

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(shortdesc);
        parcel.writeString(longdesc);
        parcel.writeString(imageurl);
    }
}
