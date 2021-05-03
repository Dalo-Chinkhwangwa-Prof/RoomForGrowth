package com.coolcats.roomforgrowth.presenter;

import com.coolcats.roomforgrowth.model.data.Topic;
import com.coolcats.roomforgrowth.model.db.RFGDatabase;

import java.util.List;

public class TopicPresenter implements Contract.Presenter {
    private Contract.View view;

    public TopicPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void readFromDatabase() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                List<Topic> topics = RFGDatabase.getDatabase(view.getContext()).getDAO().getAllTopics();
                view.displayTopics(topics);
            }
        }.start();
    }

    @Override
    public void addTopic(Topic topic) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                RFGDatabase.getDatabase(view.getContext()).getDAO().insertTopics(topic);
                TopicPresenter.this.readFromDatabase();
            }
        }.start();
    }
}
