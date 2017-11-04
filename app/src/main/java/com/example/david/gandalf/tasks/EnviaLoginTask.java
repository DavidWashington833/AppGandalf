package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.david.gandalf.WebClient;

/**
 * Created by Silva on 04/11/2017.
 */

public class EnviaLoginTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviaLoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
//        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.post();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
//        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
