package com.example.assignmentmad_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAddContact;
    private final int reqCodeCon = 1;
    private RecyclerView mRecyclerView;
    private ContactAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Contact> mContactList;
    Contact myContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddContact = findViewById(R.id.btnMoveToNextActivity);
        mContactList = new ArrayList<>();
        buildRecyclerView();
       // createContactList();
        btnListener();
    }

//    public void createContactList() {
//
//       // mContactList.add(myContact);
//        mContactList.add(new Contact("Name1", "Line 1name", "11222"));
//        mContactList.add(new Contact("Name2", "Line 3name", "12121"));
//        mContactList.add(new Contact("Name3", "Line 6", "12211"));
//    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ContactAdapter(mContactList) ;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((int position) -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            intent.putExtra("Example Item", mContactList.get(position));
            startActivity(intent);
        });

    }

    public void btnListener() {
        btnAddContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivityForResult(intent, reqCodeCon);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == reqCodeCon) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                mContactList.add(data.getParcelableExtra("Information"));

                //mContactList.add(myContact);
            }
        }
    }
}