package com.geermank.todoapp.main;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.geermank.todoapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTaskClickListener, View.OnClickListener {

    private Button btnAddTask;
    private TasksAdapter tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddTask = findViewById(R.id.btn_add_item);
        btnAddTask.setOnClickListener(this);

        Task task1 = new Task(1, "Pasear al perro", "No te olvides de darle de comer tmb");
        Task task2 = new Task(2, "Estudiar", "El final es esta semana!");
        Task task3 = new Task(3, "Visitar a la abuela", "Llamarla antes de ir");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        RecyclerView tasksRecyclerView = findViewById(R.id.rv_tasks);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tasksAdapter = new TasksAdapter(tasks);
        tasksAdapter.setOnTaskClickListener(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Mis tareas");
        }
    }

    @Override
    public void onTaskClick(Task task) {
        Toast.makeText(this, task.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Task task = new Task(4, "Ir al médico", "Hace rato no voy");
        tasksAdapter.addNewTask(task);
        Toast.makeText(this, "Tarea agregada!", Toast.LENGTH_SHORT).show();
    }
}
