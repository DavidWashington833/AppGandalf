package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.LoginFragment;
import com.example.david.gandalf.MainActivity;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Login;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Silva on 04/11/2017.
 */

public class EnviaLoginTask extends AsyncTask<Void, Void, String> {
    private LoginFragment context;
    private ProgressDialog dialog;

    public EnviaLoginTask(LoginFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        //dialog = ProgressDialog.show(context, "Aguarde", "Buscando cliente...", true, true);
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
        String feadback = "Email ou senha inválida!";

        if (!resposta.equals("null")) {
            Cliente cliente = new Gson().fromJson(resposta, Cliente.class);

            //SharedPreferences preferences = context.getSharedPreferences("login", 0);
            //SharedPreferences.Editor editor = preferences.edit();
            //editor.putInt("idCliente", cliente.getIdCliente());
            //editor.commit();

            feadback = "Usuario " + cliente.getNomeCompletoCliente() + " logado!";
            //context.finish();
        }

        //Toast.makeText(context, feadback, Toast.LENGTH_LONG).show();
    }
}
