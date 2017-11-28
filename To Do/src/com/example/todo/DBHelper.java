package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 28/11/17.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "TodoDb";

    public static final String TABLE_NAME = "TODO";
    public static final String COLUMN_TASK_ID = "task_id";
    public static final String COLUMN_TODO = "todo";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (" + COLUMN_TASK_ID + " int PRIMARY KEY," + COLUMN_TODO + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
