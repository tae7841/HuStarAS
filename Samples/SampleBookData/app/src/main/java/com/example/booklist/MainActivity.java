package com.example.booklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private BookAdapter adapter;
    private EditText editTextTitle;
    private TextView textViewCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookDBHelper dbHelper = new BookDBHelper(this);
        database = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter(this, getAllItems());
        recyclerView.setAdapter(adapter);

        editTextTitle = findViewById(R.id.edittext_title);
        textViewCount = findViewById(R.id.textview_count);
        Button buttonIncrease = findViewById(R.id.button_increase);
        Button buttonDecrease = findViewById(R.id.button_decrease);
        Button buttonAdd = findViewById(R.id.button_add);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void increase() {
        count++;
        textViewCount.setText("" + count);
    }

    private void decrease() {
        if (count > 0) {
            count--;
            textViewCount.setText(String.valueOf(count));
        }
    }

    private void addItem() {
        if (editTextTitle.getText().toString().trim().length() == 0 || count == 0) {
            return;
        }
        String title = editTextTitle.getText().toString().trim();
        ContentValues cv = new ContentValues();
        cv.put(BookContract.BookEntry.COLUMN_TITLE, title);
        cv.put(BookContract.BookEntry.COLUMN_AMOUNT, count);

        database.insert(BookContract.BookEntry.TABLE_NAME, null, cv);
        adapter.swapCursor(getAllItems());

        editTextTitle.getText().clear();
    }

    private Cursor getAllItems() {
        return database.query(
                BookContract.BookEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BookContract.BookEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }
}
