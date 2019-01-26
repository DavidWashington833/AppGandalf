package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gandalf.Fragments.CategoryFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.adapter.CategoryAdapter;
import com.gandalf.models.Categoria;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Gabriel_Montibeller on 15/11/2017.
 */

public class getCategoriesTask extends AsyncTask<Void, Void, String> {
    private CategoryFragment context;
    private ViewGroup container;
    private ProgressDialog dialog;
    private Resources resources;

    public getCategoriesTask(CategoryFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
        this.resources = context.getContext().getResources();
    }

    @Override
    protected void onPreExecute() {
        String title = resources.getString(R.string.get_categories_task_progress_title);
        String message = resources.getString(R.string.get_categories_task_progress_message);
        dialog = ProgressDialog.show(context.getContext(), title, message, true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String response = client.get("/gandalf/rest/categoria/");
        dialog.dismiss();
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        if (!response.equals("null")) {
            Categoria[] categories = new Gson().fromJson(response, Categoria[].class);
            final CategoryAdapter adapter = new CategoryAdapter(context.getContext(), Arrays.asList(categories));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.fragment_product_listlist);

            listView.setAdapter(adapter);
        }
//        Categoria[] categories = new Gson().fromJson(response, Categoria[].class);
//        final CategoryAdapter adapter = new CategoryAdapter(context.getContext(), Arrays.asList(categories));
//        final ListView listView = (ListView) context.getActivity().findViewById(R.id.fragment_category_list);

//        TODO: refactoring
//        if (listView != null) {
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                    //Toast t = Toast.makeText(context.getActivity(), id.toString() , Toast.LENGTH_LONG);
//                   // t.show();
//
//                    Categoria c = adapter.getItem(i);
//
//                    EditText id = (EditText) context.getActivity().findViewById(R.id.hiddenIdCat);
//                    id.setText(c.getIdCategoria().toString());
//                    new PegaProdutosCategoriaTask(context, container).execute();
//            }
//
//            });
//        }

//        listView.setAdapter(adapter);
    }
}