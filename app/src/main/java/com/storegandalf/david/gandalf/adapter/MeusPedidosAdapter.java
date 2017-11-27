package com.storegandalf.david.gandalf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.models.Pedido;
import com.storegandalf.david.gandalf.models.Produto;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Igor Ramos on 26/11/2017.
 */

public class MeusPedidosAdapter extends BaseAdapter {
    private final List<Pedido> pedidos;
    private final Context context;

    public MeusPedidosAdapter(List<Pedido> pedidos, Context context) {
        this.pedidos = pedidos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return pedidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(pedidos.get(position).getIdPedido());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Pedido pedido = pedidos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.cardview_meus_pedidos, parent, false);
        }

        DecimalFormat format = new DecimalFormat("###,###,###,###,##0.00");

        final TextView numeroPedido = (TextView) view.findViewById(R.id.txtNumeroPedido);
        numeroPedido.setText(pedido.getIdPedido());

        final TextView dataPedido = (TextView) view.findViewById(R.id.txtDataPedido);
        dataPedido.setText(pedido.getDataPedido());


        return view;
    }
}
