package com.fabianrinaldi.myrecipes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "recipes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";

    private static final String DB_NAME = "recipes.db";
    private static final int DB_VERSION = 1;

    private static final String DB_CREATE = "CREATE TABLE "
            + TABLE_NAME + " ( " + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null);";

    private static final String ADD_DATA_SEED = "INSERT INTO "
            + TABLE_NAME + " (" + COLUMN_NAME + ")"
            + " VALUES ('Nasi Goreng Pete');";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        db.execSQL(ADD_DATA_SEED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}