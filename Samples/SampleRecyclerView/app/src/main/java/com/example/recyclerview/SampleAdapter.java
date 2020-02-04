package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewwHolder> {
    private ArrayList<SampleItem> sampleList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        // void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class SampleViewwHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public SampleViewwHolder(View itemView, final OnItemClickListener xlistener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            // deleteImage = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (xlistener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            xlistener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public SampleAdapter(ArrayList<SampleItem> sampleList) {
        this.sampleList = sampleList;
    }

    @NonNull
    @Override
    public SampleViewwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item, parent, false);
        SampleViewwHolder svh = new SampleViewwHolder(v, listener);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewwHolder holder, int position) {
        SampleItem currentItem = sampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }
}
