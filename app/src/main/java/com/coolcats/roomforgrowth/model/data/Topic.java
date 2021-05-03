package com.coolcats.roomforgrowth.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "topics")
public class Topic implements Parcelable {

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "difficulty")
    private int difficulty;

    //To be used by the Room Database
    public Topic(int id, String name, int difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }

    //To be used by Data Entry Specialist
    @Ignore //Room database will ignore this
    public Topic(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    protected Topic(Parcel in) {
        id = in.readInt();
        name = in.readString();
        difficulty = in.readInt();
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        @Override
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        @Override
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(difficulty);
    }
}
