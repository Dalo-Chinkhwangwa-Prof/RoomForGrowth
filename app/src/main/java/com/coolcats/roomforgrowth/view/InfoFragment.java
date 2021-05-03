package com.coolcats.roomforgrowth.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.coolcats.roomforgrowth.databinding.InfoFragmentBinding;
import com.coolcats.roomforgrowth.model.data.Topic;

import java.util.LinkedList;
import java.util.List;

public class InfoFragment extends Fragment {

    private InfoFragmentBinding binding;
    private TopicAdapter topicAdapter = new TopicAdapter(new LinkedList<>());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = InfoFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.topicRecyclerview.setAdapter(topicAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.topicRecyclerview);

    }

    public void updateList(List<Topic> topics){
        topicAdapter.setTopics(topics);
    }
}
