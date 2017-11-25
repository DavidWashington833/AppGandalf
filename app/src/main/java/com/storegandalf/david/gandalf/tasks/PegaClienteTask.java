package com.storegandalf.david.gandalf.tasks;

import android.os.AsyncTask;

import com.storegandalf.david.gandalf.MinhaContaFragment;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Cliente;
import com.google.gson.Gson;

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
