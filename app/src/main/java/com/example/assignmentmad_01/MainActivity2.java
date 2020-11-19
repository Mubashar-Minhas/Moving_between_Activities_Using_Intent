
package com.example.assignmentmad_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText etName, etEmail, etPhone;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadViews();
        sendDataBack();
    }

    void loadViews() {

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);

    }

    private void sendDataBack() {
        btnSubmit.setOnClickListener(view -> {
            String name_str = etName.getText().toString();
            String mail_str = etEmail.getText().toString();
            String phone_str = etPhone.getText().toString();
            if ((name_str.matches("")) || (mail_str.matches("")) || (phone_str.matches(""))) {
                Toast.makeText(MainActivity2.this, "You must fill all the field (Name, age, Phone)",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Contact contact = new Contact(name_str, mail_str, phone_str);
                Intent intent = new Intent();
                intent.putExtra("Information", contact);
                setResult(RESULT_OK, intent);
                finish();
            }



        });
    }
}