package com.coolcats.roomforgrowth.model.db;


import android.content.ContentValues;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;

import com.coolcats.roomforgrowth.model.data.Topic;

@Database(version = 1, entities = {Topic.class})
public abstract class RFGDatabase extends RoomDatabase {

    private static RFGDatabase database;
    public abstract TopicDAO getDAO();

    public static RFGDatabase getDatabase(Context context){
        if(database == null)
            database = Room.databaseBuilder(
                    context,
                    RFGDatabase.class,
                    "rfg.db"
            ).build();

        return database;
    }
}