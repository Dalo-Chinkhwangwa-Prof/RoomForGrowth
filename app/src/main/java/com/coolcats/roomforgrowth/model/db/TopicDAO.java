package com.coolcats.roomforgrowth.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.coolcats.roomforgrowth.model.data.Topic;

import java.util.List;

@Dao
public interface TopicDAO {

    @Query("SELECT * FROM topics")
    List<Topic> getAllTopics();

    @Query("SELECT * FROM topics WHERE id = :id")
    List<Topic> getSingleTopic(int id);

    @Insert
    void insertTopics(Topic... topic); //iT(t1), iT(t2, t3)

    @Delete
    void deleteTopic(Topic topic);
}
