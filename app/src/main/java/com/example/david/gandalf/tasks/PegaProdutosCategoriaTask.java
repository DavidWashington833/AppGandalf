package com.example.david.gandalf.tasks;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.david.gandalf.FragmentCategoria;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Categoria;
import com.example.david.gandalf.models.ItemsCategoria;
import com.google.gson.Gson;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */


public class PegaProdutosCategoriaTask extends AsyncTask<Void, Void, String> {
    private FragmentCategoria context;
    private ViewGroup container;

    public PegaProdutosCategoriaTask(FragmentCategoria context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        int id = 2;
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/categoria/" + id);

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
                    Toast t = Toast.makeText(context.getActivity(), c.getNomeProduto().toString(), Toast.LENGTH_SHORT);
                    t.show();
                }
            });
        }

        context.setListAdapter(adapter);


    }
}