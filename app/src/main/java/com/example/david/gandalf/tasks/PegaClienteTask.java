package com.example.david.gandalf.tasks;

import android.os.AsyncTask;
import android.widget.ListView;

import com.example.david.gandalf.MinhaContaFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by igorr on 23/11/2017.
 */

public class PegaClienteTask extends AsyncTask<Void, Void, String> {

    private MinhaContaFragment context;
    private int idCliente;

    public PegaClienteTask(MinhaContaFragment context, int idCliente) {
        this.context = context;
        this.idCliente = idCliente;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... voids) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/cliente/" + idCliente);

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {
            Cliente cliente = new Gson().fromJson(resposta, Cliente.class);

            context.getHelper().inputText(cliente, context);
        }
    }
}
