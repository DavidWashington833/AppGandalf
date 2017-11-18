package com.example.david.gandalf.tasks;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.david.gandalf.CategoriaFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.ItemsCategoria;
import com.google.gson.Gson;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */


public class PegaProdutosCategoriaTask extends AsyncTask<Void, Void, String> {
    private CategoriaFragment context;
    private ViewGroup container;

    public PegaProdutosCategoriaTask(CategoriaFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        EditText id = (EditText)context.getActivity().findViewById(R.id.hiddenIdCat);
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/categoria/" + id.getText().toString() );

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {


        ItemsCategoria[] item = new Gson().fromJson(resposta, ItemsCategoria[].class);

        final ArrayAdapter<ItemsCategoria> adapter = new ArrayAdapter<ItemsCategoria>(context.getContext(), android.R.layout.simple_list_item_1, item);

        final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);

        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ItemsCategoria c = adapter.getItem(i);
                    EditText id = (EditText)context.getActivity().findViewById(R.id.hiddenIdCat);

                    Toast t = Toast.makeText(context.getActivity(), c.getNomeProduto(), Toast.LENGTH_LONG);
                    t.show();
                }
            });
        }

        context.setListAdapter(adapter);


    }
}