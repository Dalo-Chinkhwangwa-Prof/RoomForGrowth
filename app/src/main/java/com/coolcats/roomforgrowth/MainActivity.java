package com.coolcats.roomforgrowth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.coolcats.roomforgrowth.model.data.Topic;
import com.coolcats.roomforgrowth.model.db.RFGDatabase;
import com.coolcats.roomforgrowth.presenter.Contract;
import com.coolcats.roomforgrowth.presenter.TopicPresenter;
import com.coolcats.roomforgrowth.utli.SingletonExample;
import com.coolcats.roomforgrowth.view.InfoFragment;
import com.coolcats.roomforgrowth.view.InputFragment;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements InputFragment.TopicDelegate, Contract.View {

    private InputFragment inputFragment;
    private InfoFragment infoFragment;

    private Contract.Presenter presenter = new TopicPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.input_fragment);
        infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.info_fragment);

        presenter.readFromDatabase();
    }

    @Override
    public void insertTopic(Topic topic) {
        presenter.addTopic(topic);
    }

    @Override
    public void displayTopics(List<Topic> topicList) {
        runOnUiThread(()->{
            infoFragment.updateList(topicList);
        });
    }

    @Override
    public void displayError(String error) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}