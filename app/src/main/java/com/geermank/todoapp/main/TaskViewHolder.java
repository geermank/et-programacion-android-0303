package com.geermank.todoapp.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.geermank.todoapp.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView tvTitle, tvDescription;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_task_title);
        tvDescription = itemView.findViewById(R.id.tv_task_description);
    }

    public void onBindTask(@NonNull Task task, int position, @Nullable OnTaskClickListener listener) {
        tvTitle.setText(task.getTitle());
        tvDescription.setText(task.getDescription());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTaskClick(task);
                }
            }
        });
    }
}
