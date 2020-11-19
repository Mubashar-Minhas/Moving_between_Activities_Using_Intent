package com.example.assignmentmad_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView1 = findViewById(R.id.tvName);
        TextView textView2 = findViewById(R.id.tvMail);
        TextView textView3 = findViewById(R.id.tvPhone);

        Intent intent = getIntent();
        Contact exampleItem = intent.getParcelableExtra("Example Item");
        String line0 = exampleItem.getName();
        textView1.setText(line0);
        String line1 = exampleItem.getMail();
        textView2.setText(line1);
        String line2 = exampleItem.getPhone();
        textView3.setText(line2);








    }
}