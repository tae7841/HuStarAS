package com.example.booklist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Context context;
    private Cursor cursor;

    public BookAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;
        public TextView countText;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.textview_title_item);
            countText = itemView.findViewById(R.id.textview_amount_item);
        }
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }

        String title = cursor.getString(cursor.getColumnIndex(BookContract.BookEntry.COLUMN_TITLE));
        int amount = cursor.getInt(cursor.getColumnIndex(BookContract.BookEntry.COLUMN_AMOUNT));
        long id = cursor.getLong(cursor.getColumnIndex(BookContract.BookEntry._ID));

        holder.titleText.setText(title);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

}
