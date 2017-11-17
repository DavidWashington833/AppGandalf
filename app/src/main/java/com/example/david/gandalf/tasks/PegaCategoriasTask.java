package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.david.gandalf.FragmentCategoria;
import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Categoria;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Login;
import com.google.gson.Gson;

/**
 * Created by Gabriel_Montibeller on 15/11/2017.
 */

public class PegaCategoriasTask extends AsyncTask<Void, Void, String> {
    private FragmentCategoria context;
    private ViewGroup container;

    public PegaCategoriasTask(FragmentCategoria context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/categoria/");

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {


        Categoria[] categorias = new Gson().fromJson(resposta, Categoria[].class);

        final ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(context.getContext(), android.R.layout.simple_list_item_1, categorias);

        final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);

        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Categoria c = adapter.getItem(i);
                    Toast t = Toast.makeText(context.getActivity(), c.getIdCategoria(), Toast.LENGTH_SHORT);
                    t.show();
                }
            });
        }

        context.setListAdapter(adapter);


    }
}
