package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBUser extends SQLiteOpenHelper {

    public DBUser( Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table User(name TEXT primary key,detail TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists User");
    }

    public Boolean insertuserdata(String name,String detail){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("detail",detail);
        long result=DB.insert("User",null,contentValues);
        if(result==-1)
            return false;
        else{
            return true;
        }
    }

    public Boolean cleardata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("Delete from User");
        return true;

    }

    public Cursor getdata (String tag)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select detail from User where name='"+tag+"'", null);
        return cursor;

    }
}
