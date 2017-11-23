package com.example.david.gandalf.tasks;

import android.os.AsyncTask;
import android.widget.ListView;

import com.example.david.gandalf.CarrinhoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Categoria;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by gabriel.elmontibelle on 21/11/2017.
 */

public class AlimentaCarrinhoTask extends AsyncTask<Void, Void, String> {
    private CarrinhoFragment context;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        String resposta ="";
        return resposta;

    }

    @Override
    protected void onPostExecute(String resposta) {

//        Produto[] produto = new Gson().fromJson(resposta, Produto[].class);
//        CarrinhoSingletonHelper.getInstance().pushProduto(produto);

    }
}


