package com.example.booklist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.booklist.BookContract.*;

import androidx.annotation.Nullable;

public class BookDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "booklist.db";
    public static final int DATABASE_VERSION = 1;

    public BookDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_BOOKLIST_TABLE = "CREATE TABLE " +
                BookEntry.TABLE_NAME + " (" +
                BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BookEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                BookEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                BookEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_BOOKLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BookEntry.TABLE_NAME);
        onCreate(db);
    }
}
