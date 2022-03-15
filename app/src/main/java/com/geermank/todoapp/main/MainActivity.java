package com.geermank.todoapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geermank.todoapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Task task1 = new Task(1, "Pasear al perro", "No te olvides de darle de comer tmb");
        Task task2 = new Task(2, "Estudiar", "El final es esta semana!");
        Task task3 = new Task(3, "Visitar a la abuela", "Llamarla antes de ir");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
    }
}