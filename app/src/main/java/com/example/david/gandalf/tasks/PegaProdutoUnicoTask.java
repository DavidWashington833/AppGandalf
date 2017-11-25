package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.ProdutoUnicoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;


public class PegaProdutoUnicoTask extends AsyncTask<Void, Void, String> {
    private ProdutoUnicoFragment context;
    private ProgressDialog dialog;

    public PegaProdutoUnicoTask(ProdutoUnicoFragment context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Buscando cliente...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/" + codP.getText().toString());
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        dialog.dismiss();
        if (!resposta.equals("null")) {
            Produto p = new Gson().fromJson(resposta, Produto.class);

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);
            ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imgProduto);
<<<<<<< HEAD
//            EditText hiddenId = (EditText) context.getActivity().findViewById(R.id.hiddenIdProd);
=======

            context.produtoP = p;
>>>>>>> origin/CabeloTesteCarrinho

            nomeP.setText(p.getNomeProduto());
            codP.setText(p.getIdProduto());
            precoP.setText(p.getPrecProduto());
            byte[] imageAsBytes = Base64.decode(p.getImagem().getBytes(), Base64.DEFAULT);
            imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
//            hiddenId.setText(p.getIdProduto());
        }
    }
}