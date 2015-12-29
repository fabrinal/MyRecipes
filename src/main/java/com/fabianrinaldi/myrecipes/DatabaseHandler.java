package com.fabianrinaldi.myrecipes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {DatabaseHelper.COLUMN_ID,DatabaseHelper.COLUMN_NAME};

    public DatabaseHandler(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void dbOpen() {
        db = dbHelper.getWritableDatabase();
    }

    public void dbClose() {
        db.close();
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        dbOpen();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            recipes.add(cursorToList(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        dbClose();
        return recipes;
    }

    private Recipe cursorToList(Cursor cursor) {
        Recipe recipe = new Recipe();
        recipe.setId(cursor.getLong(0));
        recipe.setName(cursor.getString(1));
        return recipe;
    }
}