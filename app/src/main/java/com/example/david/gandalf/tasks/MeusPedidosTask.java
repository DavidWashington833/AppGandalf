package com.example.david.gandalf.tasks;

import android.os.AsyncTask;

import com.example.david.gandalf.MeusPedidosFragment;
import com.example.david.gandalf.WebClient;

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
        String resposta = client.get("http://192.168.15.12:8084/Gandalf/rest/pedido/cliente/43");

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {

        }
    }
}
