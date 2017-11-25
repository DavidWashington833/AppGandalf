package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.gandalf.ProdutoFragment;
import com.example.david.gandalf.ProdutoUnicoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Categoria;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by fernando.hyamamoto on 16/11/2017.
 */

public class PegaProdutosTask extends AsyncTask<Void, Void, String> {
    private String id;
    private ProdutoFragment context;
<<<<<<< HEAD
//    private ProdutoUnicoFragment teste;

    public PegaProdutosTask(ProdutoFragment context) {
        this.context = context;
//        this.teste = teste;
}
=======
    private ProgressDialog dialog;

    public PegaProdutosTask(ProdutoFragment context) {
        this.context = context;
    }

    public PegaProdutosTask(ProdutoFragment context, String id) {
        this.context = context;
        this.id = id;
    }
>>>>>>> branchIgorv3


    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Carregando Produtos...", true, true);

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/");
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(final String resposta) {
        if (!resposta.equals("null")) {
            final Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            final ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto);

<<<<<<< HEAD
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                   TextView tx = (TextView) teste.getActivity().findViewById(R.id.codigoProduto);

//                    EditText reclicado = (EditText) context.getActivity().findViewById(R.id.hiddenIdProd);
//                    reclicado.setText("0");
//                    Produto p = (Produto) adapter.getItem(i);

//                    EditText id = (EditText) context.getActivity().findViewById(R.id.hiddenIdProd);
//                    id.setText(p.getIdProduto().toString());
                }
            });

=======
>>>>>>> branchIgorv3
            listView.setAdapter(adapter);
        }
    }
}