package com.geermank.todoapp.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geermank.todoapp.R;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private List<Task> tasks;
    private OnTaskClickListener listener;

    public TasksAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setOnTaskClickListener(OnTaskClickListener listener) {
        this.listener = listener;
    }

    public void addNewTask(Task newTask) {
        tasks.add(newTask);
        notifyItemInserted(tasks.size() - 1);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.onBindTask(task, position, listener);
    }
}
