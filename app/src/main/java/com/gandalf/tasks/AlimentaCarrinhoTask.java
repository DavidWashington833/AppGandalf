package com.gandalf.tasks;

import android.os.AsyncTask;
import android.widget.ListView;

import com.gandalf.CartFragment;
import com.gandalf.R;
import com.gandalf.CarrinhoAdapter;
import com.gandalf.helpers.CarrinhoSingletonHelper;
import com.gandalf.models.Product;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by gabriel.elmontibelle on 21/11/2017.
 */

public class AlimentaCarrinhoTask extends AsyncTask<Void, Void, String> {
    private CartFragment context;

    public AlimentaCarrinhoTask(CartFragment context) {
        this.context = context;
    }

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

          String result = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduct());
        if (!result.equals("null")) {

            Product[] produtos = new Gson().fromJson(result, Product[].class);
            final CarrinhoAdapter adapter = new CarrinhoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto_carrinho);

            listView.setAdapter(adapter);

        }
    }
}


