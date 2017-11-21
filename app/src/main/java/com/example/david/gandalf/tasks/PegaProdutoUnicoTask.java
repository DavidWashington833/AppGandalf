package com.example.david.gandalf.tasks;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.ProdutoUnicoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import org.w3c.dom.Text;


public class PegaProdutoUnicoTask extends AsyncTask<Void, Void, String> {
    private ProdutoUnicoFragment context;
    private String id;

    public PegaProdutoUnicoTask(ProdutoUnicoFragment context) {
        this.context = context;
    }

    public PegaProdutoUnicoTask(ProdutoUnicoFragment context, String id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/" + id);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        System.out.println(resposta);
        if (!resposta.equals("null")) {
            Produto p = new Gson().fromJson(resposta, Produto.class);

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);
            ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imgProduto);
            TextView descP = (TextView) context.getActivity().findViewById(R.id.descProduto);

            nomeP.setText(p.getNomeProduto());
            codP.setText(p.getIdProduto());
            precoP.setText(p.getPrecProduto());
            descP.setText(p.getDescProduto());
            byte[] imageAsBytes = Base64.decode(p.getImagem().getBytes(), Base64.DEFAULT);
            imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }
    }
}