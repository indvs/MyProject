package com.study.contest.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.study.contest.R;
import com.study.contest.adapter.RowAdapter;
import com.study.contest.db.UserRecordsHelper;
import com.study.contest.model.ColumEnum;
import com.study.contest.model.UserRecord;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RowAdapter rowAdapter;
    private Intent addNewRecord;
    private List<UserRecord> userRecords = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        addNewRecord = new Intent(this, AddNewRecord.class);
        floatingActionButton.setOnClickListener(v -> startActivity(addNewRecord));

        recyclerView = findViewById(R.id.mainPageRV);
        updateContent();

    }

    private void updateContent() {
        userRecordList();
        rowAdapter = new RowAdapter(userRecords, MainPage.this, this);
        recyclerView.setAdapter(rowAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainPage.this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateContent();
    }

    private void userRecordList() {
        try (UserRecordsHelper userRecordsHelper = new UserRecordsHelper(MainPage.this)) {
            Cursor cursor = userRecordsHelper.readAllData();
            userRecords.clear();
            while (cursor.moveToNext()) {
                UserRecord userRecord = new UserRecord();
                userRecord.setId(cursor.getString(ColumEnum.ID.getColumnIndex()));
                userRecord.setTitle(cursor.getString(ColumEnum.TITLE.getColumnIndex()));
                userRecord.setContent(cursor.getString(ColumEnum.CONTENT.getColumnIndex()));
                userRecord.setDate(cursor.getString(ColumEnum.DATE.getColumnIndex()));
                userRecords.add(userRecord);
            }
        }

    }


}