package com.geermank.todoapp.main;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.geermank.todoapp.AddTaskActivity;
import com.geermank.todoapp.Constants;
import com.geermank.todoapp.LoginActivity;
import com.geermank.todoapp.R;
import com.geermank.todoapp.settings.UserCredentials;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTaskClickListener, View.OnClickListener {

    private Button btnAddTask;
    private TasksAdapter tasksAdapter;

    private ActivityResultLauncher<Intent> addTaskLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent data = result.getData();
            if (result.getResultCode() == RESULT_OK && data != null) {
                String title = data.getStringExtra(Constants.TASK_TITLE);
                String description = data.getStringExtra(Constants.TASK_DESC);
                tasksAdapter.addNewTask(new Task(0, title, description));
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddTask = findViewById(R.id.btn_add_item);
        btnAddTask.setOnClickListener(this);
        btnAddTask.setVisibility(View.GONE);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_task) {
            navigateToAddTaskActivity();
        } else {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        new UserCredentials(this).delete();
        navigateToLoginActivity();
    }

    private void navigateToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToAddTaskActivity() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        addTaskLauncher.launch(intent);
        //startActivityForResult(intent, 1001);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            if (resultCode == RESULT_OK && data != null) {
                String title = data.getStringExtra(Constants.TASK_TITLE);
                String description = data.getStringExtra(Constants.TASK_DESC);
                tasksAdapter.addNewTask(new Task(0, title, description));
            }
        } else if (requestCode == 1002) {
            // TODO implementar
        }
    }*/
}
