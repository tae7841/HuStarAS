package org.joy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        final PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수0", "010-1000-1000"));
        adapter.addItem(new Person("김하늘1", "010-2000-2000"));
        adapter.addItem(new Person("홍길동2", "010-3000-3000"));
        adapter.addItem(new Person("김민수3", "010-1000-1000"));
        adapter.addItem(new Person("김하늘4", "010-2000-2000"));
        adapter.addItem(new Person("홍길동5", "010-3000-3000"));
        adapter.addItem(new Person("김민수6", "010-1000-1000"));
        adapter.addItem(new Person("김하늘7", "010-2000-2000"));
        adapter.addItem(new Person("홍길동8", "010-3000-3000"));
        adapter.addItem(new Person("김민수9", "010-1000-1000"));
        adapter.addItem(new Person("김하늘10", "010-2000-2000"));
        adapter.addItem(new Person("홍길동11", "010-3000-3000"));
        adapter.addItem(new Person("김민수12", "010-1000-1000"));
        adapter.addItem(new Person("김하늘13", "010-2000-2000"));
        adapter.addItem(new Person("홍길동14", "010-3000-3000"));
        adapter.addItem(new Person("김민수15", "010-1000-1000"));
        adapter.addItem(new Person("김하늘16", "010-2000-2000"));
        adapter.addItem(new Person("홍길동17", "010-3000-3000"));
        adapter.addItem(new Person("홍길동18", "010-3000-3000"));
        adapter.addItem(new Person("김민수19", "010-1000-1000"));
        adapter.addItem(new Person("김하늘20", "010-2000-2000"));
        adapter.addItem(new Person("홍길동21", "010-3000-3000"));
        adapter.addItem(new Person("김민수22", "010-1000-1000"));
        adapter.addItem(new Person("김하늘23", "010-2000-2000"));
        adapter.addItem(new Person("홍길동24", "010-3000-3000"));
        adapter.addItem(new Person("김민수25", "010-1000-1000"));
        adapter.addItem(new Person("김하늘26", "010-2000-2000"));
        adapter.addItem(new Person("홍길동27", "010-3000-3000"));
        adapter.addItem(new Person("김민수28", "010-1000-1000"));
        adapter.addItem(new Person("김하늘29", "010-2000-2000"));
        adapter.addItem(new Person("홍길동30", "010-3000-3000"));
        adapter.addItem(new Person("김민수0", "010-1000-1000"));
        adapter.addItem(new Person("김하늘1", "010-2000-2000"));
        adapter.addItem(new Person("홍길동2", "010-3000-3000"));
        adapter.addItem(new Person("김민수3", "010-1000-1000"));
        adapter.addItem(new Person("김하늘4", "010-2000-2000"));
        adapter.addItem(new Person("홍길동5", "010-3000-3000"));
        adapter.addItem(new Person("김민수6", "010-1000-1000"));
        adapter.addItem(new Person("김하늘7", "010-2000-2000"));
        adapter.addItem(new Person("홍길동8", "010-3000-3000"));
        adapter.addItem(new Person("김민수9", "010-1000-1000"));
        adapter.addItem(new Person("김하늘10", "010-2000-2000"));
        adapter.addItem(new Person("홍길동11", "010-3000-3000"));
        adapter.addItem(new Person("김민수12", "010-1000-1000"));
        adapter.addItem(new Person("김하늘13", "010-2000-2000"));
        adapter.addItem(new Person("홍길동14", "010-3000-3000"));
        adapter.addItem(new Person("김민수15", "010-1000-1000"));
        adapter.addItem(new Person("김하늘16", "010-2000-2000"));
        adapter.addItem(new Person("홍길동17", "010-3000-3000"));
        adapter.addItem(new Person("홍길동18", "010-3000-3000"));
        adapter.addItem(new Person("김민수19", "010-1000-1000"));
        adapter.addItem(new Person("김하늘20", "010-2000-2000"));
        adapter.addItem(new Person("홍길동21", "010-3000-3000"));
        adapter.addItem(new Person("김민수22", "010-1000-1000"));
        adapter.addItem(new Person("김하늘23", "010-2000-2000"));
        adapter.addItem(new Person("홍길동24", "010-3000-3000"));
        adapter.addItem(new Person("김민수25", "010-1000-1000"));
        adapter.addItem(new Person("김하늘26", "010-2000-2000"));
        adapter.addItem(new Person("홍길동27", "010-3000-3000"));
        adapter.addItem(new Person("김민수28", "010-1000-1000"));
        adapter.addItem(new Person("김하늘29", "010-2000-2000"));
        adapter.addItem(new Person("홍길동30", "010-3000-3000"));

        recyclerView.setAdapter(adapter);
        // int count = adapter.getItemCount();

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Log.d(TAG, "Position: " + position);
                adapter.toggleItemsSelected(position);

                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        item.getName() + " " + item.getMobile(), Toast.LENGTH_LONG).show();

                Snackbar.make(view, adapter.getItemsSelected().toString(), Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }
}