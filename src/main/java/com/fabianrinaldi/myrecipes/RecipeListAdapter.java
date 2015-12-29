package com.fabianrinaldi.myrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecipeListAdapter extends BaseAdapter {

    private  Context context;
    private  ArrayList<Recipe> recipes;

    public RecipeListAdapter(Context context,ArrayList<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }
    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recipe recipe = recipes.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.recipes_row,null);
        }
        TextView recipeName = (TextView) convertView.findViewById(R.id.recipeName);
        recipeName.setText(recipe.getName());
        return convertView;
    }
}