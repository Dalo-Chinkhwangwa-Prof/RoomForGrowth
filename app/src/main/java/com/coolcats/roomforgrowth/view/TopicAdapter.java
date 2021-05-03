package com.coolcats.roomforgrowth.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolcats.roomforgrowth.databinding.TopicItemLayoutBinding;
import com.coolcats.roomforgrowth.model.data.Topic;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {

    private List<Topic> topics;

    public TopicAdapter(List<Topic> topics) {
        this.topics = topics;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TopicItemLayoutBinding binding = TopicItemLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new TopicViewHolder(binding);
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic topic = topics.get(position);

        holder.binding.difficultyTextview.setText(topic.getDifficulty()+"/10");
        holder.binding.topicTextview.setText(topic.getName());
        holder.binding.idTextview.setText("#ID00"+topic.getId());
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    class TopicViewHolder extends RecyclerView.ViewHolder{
        TopicItemLayoutBinding binding;
        public TopicViewHolder(TopicItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
