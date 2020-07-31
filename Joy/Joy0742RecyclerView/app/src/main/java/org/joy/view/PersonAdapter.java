package org.joy.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
                                   implements OnPersonItemClickListener {
    public static final String TAG = "HuStar";
    private ArrayList<Person> items = new ArrayList<>();
    private OnPersonItemClickListener listener;     // use an interface like a class
                                                    // use to save the listener object

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.person_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person item = items.get(position);
        viewHolder.setItem(item);
        Log.d(TAG, "onBindViewHolder:" + position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item) {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Person item) {
        items.set(position, item);
    }

    // registration step
    // click event interface object를 즉 저장해 두었다가 이벤트가 일어나면, Listener 메소드 호출
    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        Log.d(TAG, "Saving setOnItemClickListener's listener");
        this.listener = listener;
    }

    // onClick event listener으로부터 호출됨.
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            Log.d(TAG, "onItemClick() calling listener:" + position);
            Log.d(TAG, "class:" + listener.getClass().getSimpleName());
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            // adapter가 ClickEvent를 Listener를 등록하고, 이벤트 발생시 호출함.
            // (안스가 리스너 obj를 저장하고 있다가 click 이벤트 시에 호출함)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {  // 이벤트 리스너가 등록되어 있다면,
                        // listener - OnPersonItemClickListener interface 구현한 클래스의 obj

                        Log.d(TAG, "static calling listener onItemClick:" + position);
                        Log.d(TAG, "class:" + listener.getClass().getSimpleName());
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }
}
