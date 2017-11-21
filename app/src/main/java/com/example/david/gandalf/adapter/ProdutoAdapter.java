package com.example.david.gandalf.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.MainActivity;
import com.example.david.gandalf.ProdutoUnicoFragment;
import com.example.david.gandalf.QRCodeActivity;
import com.example.david.gandalf.R;
import com.example.david.gandalf.models.Produto;

import java.util.List;

/**
 * Created by Silva on 18/11/2017.
 */

public class ProdutoAdapter extends BaseAdapter {
    private final List<Produto> produtos;
    private final Context context;

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(produtos.get(position).getIdProduto());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto produto = produtos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.cardview_produtos, parent, false);
        }

        final EditText campoId = (EditText) view.findViewById(R.id.hiddenIdProd);
        campoId.setText(produto.getIdProduto());

        TextView campoNome = (TextView) view.findViewById(R.id.txtNomeProd);
        campoNome.setText(produto.getNomeProduto());

        TextView campoPreco = (TextView) view.findViewById(R.id.txtPreco);
        campoPreco.setText(produto.getPrecProduto());

        ImageView campoImg = (ImageView) view.findViewById(R.id.imagemProd);
        String imagem = produto.getImagem();

        if (imagem != null) {
            byte[] imageAsBytes = Base64.decode(imagem.getBytes(), Base64.DEFAULT);
            campoImg.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }

        Button botaoDetalhes = (Button) view.findViewById(R.id.btnComprarProd);

        botaoDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaFragment(new ProdutoUnicoFragment());
                Toast.makeText(v.getContext(), campoId.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = ((MainActivity)context).getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_principal, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }
}
