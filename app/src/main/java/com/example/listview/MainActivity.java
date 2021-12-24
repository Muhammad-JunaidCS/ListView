package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    ListView listView;
    ArrayList<String> toDoList;
    String task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDoList=new ArrayList<>();

        //binding
        editText=findViewById(R.id.editTextTask);
        listView=findViewById(R.id.listView);
        button=findViewById(R.id.addBtn);

        //setting adpater
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,toDoList);
        listView.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task=editText.getText().toString();
                if(task.equals("")){
                    Toast.makeText(MainActivity.this, "Task Can not be Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    toDoList.add(task);
                    editText.setText("");
                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                    arrayAdapter.notifyDataSetChanged();
                }
            }

        });
    }
}