package com.geermank.todoapp.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.geermank.todoapp.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView tvTitle, tvDescription;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_task_title);
        tvDescription = itemView.findViewById(R.id.tv_task_description);
    }

    public void onBindTask(Task task) {
        tvTitle.setText(task.getTitle());
        tvDescription.setText(task.getDescription());
    }
}
