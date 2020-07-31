package org.joy.view;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static org.joy.view.R.color.colorAccent;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
                                   implements OnPersonItemClickListener {
    private ArrayList<Person> items = new ArrayList<>();
    private OnPersonItemClickListener listener;

    private ArrayList<Integer> itemsSelected = new ArrayList<>();  ///////////////
    public static final String TAG = "HuStar";   //////////////////////////////////

    public ArrayList<Integer> getItemsSelected() {
        return itemsSelected;
    }

    public void toggleItemsSelected(int position) {
        if (itemsSelected.contains(position)) {
            itemsSelected.remove((Integer)position);
        }
        else {
            itemsSelected.add(position);
        }
    }

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

        /*
        if (itemsSelected.contains(position)) {
            viewHolder.itemView.setBackgroundColor(Color.YELLOW);
        }
        else {
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
        }
        */

        Log.d(TAG, "PersonAdapter: onBindViewHolder: " + position);
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

    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    public int getItemsSelectedCount() {    // only for one item needed
        return this.itemsSelected.size();
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            Log.d(TAG, "PersonAdapter: onItemClick listener: " + position);
            listener.onItemClick(holder, view, position);

            /*
            if (itemsSelected.contains(position)) {
                holder.itemView.setBackgroundColor(Color.YELLOW);
            }
            else {
                holder.itemView.setBackgroundColor(Color.WHITE);
            }
            */
            Log.d(TAG, "Selected: " + itemsSelected.toString());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
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
