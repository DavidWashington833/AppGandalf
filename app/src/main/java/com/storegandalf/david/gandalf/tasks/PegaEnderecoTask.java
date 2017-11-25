package com.storegandalf.david.gandalf.tasks;

import android.os.AsyncTask;
import android.widget.TextView;

import com.storegandalf.david.gandalf.EditarEnderecoFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Endereco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class PegaEnderecoTask extends AsyncTask<Void, Void, String> {

    private EditarEnderecoFragment context;
    private String id;
    private Type listType = new TypeToken<List<Endereco>>(){}.getType();


    public PegaEnderecoTask(EditarEnderecoFragment context, String id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... voids) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/endereco/cliente/" + id);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {
            List<Endereco> lista = new Gson().fromJson(resposta, listType);

            //Log.i("TESTE", "onPostExecute: "+ lista.get(0).getNomeEndereco());

            TextView cep = (TextView) context.getActivity().findViewById(R.id.cep);
            TextView rua = (TextView) context.getActivity().findViewById(R.id.rua);
            TextView numero = (TextView) context.getActivity().findViewById(R.id.numero);
            TextView cidade = (TextView) context.getActivity().findViewById(R.id.cidade);

            cep.setText(lista.get(0).getCEPEndereco());
            rua.setText(lista.get(0).getNomeEndereco());
            numero.setText(lista.get(0).getNumeroEndereco());
            cidade.setText(lista.get(0).getCidadeEndereco());

        }
    }
}
