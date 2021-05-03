package com.coolcats.roomforgrowth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.coolcats.roomforgrowth.model.data.Topic;
import com.coolcats.roomforgrowth.model.db.RFGDatabase;
import com.coolcats.roomforgrowth.utli.SingletonExample;
import com.coolcats.roomforgrowth.view.InfoFragment;
import com.coolcats.roomforgrowth.view.InputFragment;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements InputFragment.TopicDelegate {

    private InputFragment inputFragment;
    private InfoFragment infoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.input_fragment);
        infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.info_fragment);
        readDatabase();
    }

    @Override
    public void insertTopic(Topic topic) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                Log.d("TAG_X", "inserting topic");
                RFGDatabase.getDatabase(MainActivity.this).getDAO().insertTopics(topic);
                Log.d("TAG_X", "reading all...");
                readDatabase();
            }
        }.start();
    }

    private void readDatabase() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                List<Topic> topics = RFGDatabase.getDatabase(MainActivity.this).getDAO().getAllTopics();

                runOnUiThread(() -> {
                    infoFragment.updateList(topics);
                });
            }
        }.start();
    }
}