package com.example.todo;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by android on 28/11/17.
 */
public class ToDoProvider extends ContentProvider {


    public static final String AUTHORITY = "com.example.todo";
    public static final String PATHTOOD="LIST_TODO";


    public static final String CONTENT_URI = "content://"+AUTHORITY+"/"+PATHTOOD;

    public static final int TODO=1;
    public static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    public static final String MIME_TYPE_1 = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ "vnd.com.example.todo."+DBHelper.TABLE_NAME;

    SQLiteDatabase sqLiteDatabase;
    static {

        matcher.addURI(AUTHORITY,PATHTOOD,TODO);
    }


    @Override
    public boolean onCreate() {
        sqLiteDatabase = new DBHelper(getContext(),DBHelper.DB_NAME,null,1).getWritableDatabase();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor = null;
        switch (matcher.match(uri)){

            case TODO:
                cursor=sqLiteDatabase.query(DBHelper.TABLE_NAME,strings,null,null,null,null,null);
                break;
        }

        return cursor;
    }

    @Override
    public String getType(Uri uri) {

        switch (matcher.match(uri)){
            case TODO:return MIME_TYPE_1;
            default: return null;

        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = sqLiteDatabase.insert(DBHelper.TABLE_NAME,null,contentValues);
        return Uri.parse(CONTENT_URI+"/"+id);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {


        return sqLiteDatabase.delete(DBHelper.TABLE_NAME,s,strings);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return sqLiteDatabase.update(DBHelper.TABLE_NAME,contentValues,s,strings);
    }
}
