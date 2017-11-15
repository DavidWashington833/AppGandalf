package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.david.gandalf.FragmentCategoria;
import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Login;
import com.google.gson.Gson;

/**
 * Created by Gabriel_Montibeller on 15/11/2017.
 */

public class PegaCategoriasTask extends AsyncTask<Void, Void, String> {
    private FragmentCategoria context;

    public PegaCategoriasTask(FragmentCategoria context) {
        this.context = context;
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

        String categorias[] = {resposta};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context.getActivity(), android.R.layout.simple_list_item_1, categorias);

        setListAdapter(adapter);
    }
}
