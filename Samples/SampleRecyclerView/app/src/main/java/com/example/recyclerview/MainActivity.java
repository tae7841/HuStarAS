package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SampleItem> sampleList;

    private RecyclerView recyclerView;
    private SampleAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    public void insertItem(int position) {
        sampleList.add(position,
                new SampleItem(R.drawable.ic_android, "New Item at position " +
                        position, "This is line ??"));
        adapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        sampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        sampleList.get(position).changeText1(text);
        adapter.notifyItemChanged(position);
    }

    public void createSampleList() {
        sampleList = new ArrayList<>();
        sampleList.add(new SampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        sampleList.add(new SampleItem(R.drawable.face1, "Line 3", "Line 4"));
        sampleList.add(new SampleItem(R.drawable.face2, "Line 5", "Line 6"));
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);       // increase performance, whole purpose

        layoutManager = new LinearLayoutManager(this);
        adapter = new SampleAdapter(sampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new SampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }
        });
    }
}
