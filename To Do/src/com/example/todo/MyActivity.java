package com.example.todo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SQLiteDatabase sqLiteDatabase = new DBHelper(this,DBHelper.DB_NAME,null,1).getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + DBHelper.TABLE_NAME, null);
        cursor.moveToLast();
        int id = cursor.getPosition()+1;
        Toast.makeText(this,id+"",Toast.LENGTH_LONG).show();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_TASK_ID,id);
        contentValues.put(DBHelper.COLUMN_TODO, "Assignment at 6pm");

        long r= sqLiteDatabase.insert(DBHelper.TABLE_NAME, null, contentValues);

        Toast.makeText(this,r+"sucess",Toast.LENGTH_LONG).show();

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(DBHelper.COLUMN_TASK_ID,id+1);
        contentValues2.put(DBHelper.COLUMN_TODO,"project at 8pm");

        sqLiteDatabase.insert(DBHelper.TABLE_NAME,null,contentValues2);






    }
}
