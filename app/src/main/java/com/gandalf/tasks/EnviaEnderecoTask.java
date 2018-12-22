package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.gandalf.CadastroActivity;
import com.gandalf.WebClient;
import com.gandalf.models.EnderecoDTO;
import com.google.gson.Gson;

/**
 * Created by Silva on 24/11/2017.
 */

public class EnviaEnderecoTask extends AsyncTask<Void, Void, String> {
    private CadastroActivity context;
    private ProgressDialog dialog;
    private int idCliente;

    public EnviaEnderecoTask(CadastroActivity context, int idCliente) {
        this.idCliente = idCliente;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Cadastrando endereco...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
//        enderecoDTO.setIdCliente("9");
//        enderecoDTO.setNomeEndereco("asdsaddas");
//        enderecoDTO.setLogradouroEndereco("sdafdsafdsa");
//        enderecoDTO.setNumeroEndereco("111");
//        enderecoDTO.setCEPEndereco("132123");
//        enderecoDTO.setComplementoEndereco("asdsads");
//        enderecoDTO.setCidadeEndereco("asdsa");
//        enderecoDTO.setPaisEndereco("sadfadsf");
//        enderecoDTO.setUFEndereco("sa");

        SharedPreferences preferences = context.getSharedPreferences("login", 0);
        EnderecoDTO enderecoDTO = new EnderecoDTO(context.getEndereco());
        enderecoDTO.setIdCliente(String.valueOf(idCliente));
        Gson gson = new Gson();
        String jsonInString = gson.toJson(enderecoDTO);
        WebClient client = new WebClient();
        String resposta = client.post("http://192.168.15.17:8084/Gandalf/rest/endereco/", jsonInString);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();

        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
