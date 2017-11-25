package com.storegandalf.david.gandalf.tasks;

import android.os.AsyncTask;

import com.storegandalf.david.gandalf.WebClient;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class RecuperarSenhaTask extends AsyncTask<Void, Void, String> {

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... voids) {
        WebClient client = new WebClient();
        String resposta = client.get("");

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {

        }
    }
}
