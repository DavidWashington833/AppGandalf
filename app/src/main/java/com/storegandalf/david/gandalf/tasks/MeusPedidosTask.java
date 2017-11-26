package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;
import com.storegandalf.david.gandalf.MeusPedidosFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.adapter.MeusPedidosAdapter;
import com.storegandalf.david.gandalf.adapter.ProdutoAdapter;
import com.storegandalf.david.gandalf.models.Pedido;
import com.storegandalf.david.gandalf.models.Produto;

import java.util.Arrays;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class MeusPedidosTask extends AsyncTask<Void, Void, String> {

    private MeusPedidosFragment context;
    private ProgressDialog dialog;
    private Integer id;

    public MeusPedidosTask(MeusPedidosFragment context) {
        this.context = context;
    }

    public MeusPedidosTask(MeusPedidosFragment context, Integer id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Buscando seus preciosos...", "Carregando Pedidos...", true, false);
    }

    @Override
    protected String doInBackground(Void... voids) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/pedido/cliente/" + id);
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {
            Pedido[] pedidos = new Gson().fromJson(resposta, Pedido[].class);
            final MeusPedidosAdapter adapter = new MeusPedidosAdapter(Arrays.asList(pedidos), context.getContext());
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_pedidos);
            listView.setAdapter(adapter);
        }
    }
}
