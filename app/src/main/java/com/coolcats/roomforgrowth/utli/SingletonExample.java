package com.coolcats.roomforgrowth.utli;

import android.util.Log;

import com.coolcats.roomforgrowth.model.data.Topic;

public class SingletonExample {

    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    private static SingletonExample instance = null;
    private SingletonExample() {
    }

    public static SingletonExample getInstance(){
        if(instance == null)
            instance = new SingletonExample();
        return instance;
    }

    public void sayHello(){
        Log.d("TAG_X", "Hello :~)");
    }
}
