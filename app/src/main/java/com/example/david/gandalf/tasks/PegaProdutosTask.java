package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.ProdutoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Categoria;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Login;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fernando.hyamamoto on 16/11/2017.
 */

public class PegaProdutosTask extends AsyncTask<Void, Void, String> {
    private ProdutoFragment context;
    private ProgressDialog dialog;

    public PegaProdutosTask(ProdutoFragment context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/");
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {
            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto);

            listView.setAdapter(adapter);
        }
    }
}