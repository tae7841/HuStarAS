package com.example.booklist;

import android.provider.BaseColumns;

public class BookContract {

    private BookContract() {}

    public static final class BookEntry implements BaseColumns{
        public static final String TABLE_NAME = "bookList";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
