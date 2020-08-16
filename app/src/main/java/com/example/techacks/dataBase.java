package com.example.techacks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "perscriptionsApp.db";

    public dataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE OLDER_PERSCRIPTIONS "
                + "(PERSCRIPTION TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS OLDER_PERSCRITIONS");
        onCreate(db);
    }
    public void insertPerscription(String perscription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PERSCRIPTION", perscription);
        db.insert("OLDER_PERSCRIPTIONS", null, contentValues);
        db.close();
    }

    public Cursor getPerscriptions() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM OLDER_PERSCRIPTIONS",null);
    }
}
