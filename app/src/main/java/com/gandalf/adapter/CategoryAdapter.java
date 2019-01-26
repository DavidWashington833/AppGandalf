package com.gandalf.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gandalf.R;
import com.gandalf.activitys.MainActivity;
import com.gandalf.models.Categoria;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private final List<Categoria> categories;
    private final Context context;

    public CategoryAdapter(Context context, List<Categoria> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(categories.get(position).getIdCategoria());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Categoria category = categories.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.cardview_category, parent, false);
        }

        final TextView nameCategory = (TextView) view.findViewById(R.id.cardview_category_name);
        nameCategory.setText(category.getNomeCategoria());

        return view;
    }

    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.activity_main_tabs, fragment);
//        transaction.addToBackStack(backStateName);
//        transaction.commit();
    }
}
