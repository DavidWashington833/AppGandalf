package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import com.gandalf.Fragments.CategoriesFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.adapter.CategoryAdapter;
import com.gandalf.models.Categoria;
import com.google.gson.Gson;

import java.util.Arrays;


public class GetCategoriesTask extends AsyncTask<Void, Void, String> {

    private CategoriesFragment context;
    private ProgressDialog dialog;

    public GetCategoriesTask(CategoriesFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(
                context.getContext(),
                context.getString(R.string.get_categories_task_progress_title),
                context.getString(R.string.get_categories_task_progress_message),
                true,
                false);
    }

    @Override
    protected String doInBackground(Void... params) {
        String response = new WebClient().get("/gandalf/rest/categoria/");
        dialog.dismiss();
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        Categoria[] categories = new Gson().fromJson(response, Categoria[].class);
        CategoryAdapter adapter = new CategoryAdapter(context.getContext(), Arrays.asList(categories));
        ListView listView = (ListView) context.getActivity().findViewById(R.id.fragment_category_list);
        listView.setAdapter(adapter);
    }
}