package com.coolcats.roomforgrowth.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolcats.roomforgrowth.databinding.InputFragmentBinding;
import com.coolcats.roomforgrowth.model.data.Topic;

public class InputFragment extends Fragment {

    private InputFragmentBinding binding;

    public interface TopicDelegate {
        void insertTopic(Topic topic);
    }
    private TopicDelegate topicDelegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = InputFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.insertButton.setOnClickListener(v -> {

            String name = binding.topicEdittext.getText().toString().trim();
            String level = binding.difficultyEdittext.getText().toString().trim();
            int difficulty = Integer.parseInt(level);

            Topic nTopic = new Topic(name, difficulty);
            topicDelegate.insertTopic(nTopic);
            binding.topicEdittext.setText("");
            binding.difficultyEdittext.setText("");

        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        topicDelegate = (TopicDelegate)context;
    }
}
