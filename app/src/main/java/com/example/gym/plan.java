package com.example.gym;

import android.os.Parcel;
import android.os.Parcelable;

public class plan implements Parcelable {
    private Training trainingplan;
    private String day;
    private int minutes;

    public plan() {
    }


    protected plan(Parcel in) {
        trainingplan = in.readParcelable(Training.class.getClassLoader());
        day = in.readString();
        minutes = in.readInt();
    }

    public static final Creator<plan> CREATOR = new Creator<plan>() {
        @Override
        public plan createFromParcel(Parcel in) {
            return new plan(in);
        }

        @Override
        public plan[] newArray(int size) {
            return new plan[size];
        }
    };

    public Training getTrainingplan() {
        return trainingplan;
    }

    public void setTrainingplan(Training trainingplan) {
        this.trainingplan = trainingplan;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(trainingplan, i);
        parcel.writeString(day);
        parcel.writeInt(minutes);
    }
}
