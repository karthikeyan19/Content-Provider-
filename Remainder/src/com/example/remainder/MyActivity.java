package com.example.remainder;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    TextView todo ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        todo = (TextView) findViewById(R.id.todo);
        todo.setText("Todo list\n");
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.example.todo/LIST_TODO"),
                null,
                null,
                null,
                null
                );

        if(cursor.moveToFirst()){

            do{

                todo.setText(todo.getText()+cursor.getString(1)+"\n");

            }while (cursor.moveToNext());


        }


    }
}
