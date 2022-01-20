package com.example.madclassassignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText marks;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marks = findViewById(R.id.marks);
        info = findViewById(R.id.textView);
        //for textview invisible at this time
        info.setVisibility(View.GONE);
    }

    public void save(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("loginInformation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("marks", Integer.parseInt(marks.getText().toString()));
        editor.commit();
        //password editText clear the text from field
        marks.setVisibility(View.GONE);
        Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_SHORT).show();
    }

    public void display(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("loginInformation", Context.MODE_PRIVATE);
        int s1 = sharedPreferences.getInt("marks", 0);
        info.setText(String.valueOf(s1));
        info.setVisibility(View.VISIBLE);
    }
}