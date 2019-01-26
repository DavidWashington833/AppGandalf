package com.gandalf.tasks;

import android.os.AsyncTask;

import com.gandalf.MeusPedidosFragment;
import com.gandalf.WebClient;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class MeusPedidosTask extends AsyncTask<Void, Void, String> {

    private MeusPedidosFragment context;

    public MeusPedidosTask(MeusPedidosFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... voids) {
        WebClient client = new WebClient();
        String resposta = client.get("/gandalf/rest/pedido/cliente/43");

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {

        }
    }
}
