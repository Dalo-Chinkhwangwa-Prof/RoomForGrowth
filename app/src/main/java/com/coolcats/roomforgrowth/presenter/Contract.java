package com.coolcats.roomforgrowth.presenter;

import android.content.Context;

import com.coolcats.roomforgrowth.model.data.Topic;

import java.util.List;

public interface Contract {

    interface Presenter {
        void readFromDatabase();
        void addTopic(Topic topic);
    }

    interface View {
        void displayTopics(List<Topic> topicList);
        void displayError(String error);
        Context getContext();
    }

}
