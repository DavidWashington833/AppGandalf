package com.example.david.gandalf.tasks;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.david.gandalf.BuscaProdutoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class BuscaProdutoTask extends AsyncTask<Void, Void, String> {
    private BuscaProdutoFragment context;
    private ViewGroup container;


    public BuscaProdutoTask(BuscaProdutoFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        final EditText Teste = (EditText) context.getActivity().findViewById(R.id.txtBusca);
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/like/" + Teste.getText().toString());
        return resposta;
    }

    @Override
    protected void onPostExecute(final String resposta) {

        if (!resposta.equals("null")) {


            final EditText Teste = (EditText) context.getActivity().findViewById(R.id.txtBusca);

            Toast t = Toast.makeText(context.getActivity(), Teste.getText().toString() , Toast.LENGTH_LONG);
            t.show();

            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);

            listView.setAdapter(adapter);
        }
    }

}
