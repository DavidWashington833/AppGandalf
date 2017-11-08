package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Login;

/**
 * Created by Silva on 04/11/2017.
 */

public class EnviaLoginTask extends AsyncTask<Void, Void, String> {
    private LoginActivity context;
    private ProgressDialog dialog;

    public EnviaLoginTask(LoginActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        Login login = context.getHelper().getLogin();
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/cliente/authentic/" + login.getEmail() + "/" + login.getSenha());
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
