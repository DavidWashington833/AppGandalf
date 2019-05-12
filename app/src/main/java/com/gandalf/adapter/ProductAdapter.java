package com.gandalf.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.Utils;
import com.gandalf.activitys.MainActivity;
import com.gandalf.ProdutoUnicoFragment;
import com.gandalf.R;
import com.gandalf.models.Product;

import java.text.DecimalFormat;
import java.util.List;


public class ProductAdapter extends BaseAdapter {

    private final List<Product> products;
    private final Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(((Product) this.getItem(position)).getIdProduto());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = (Product) this.getItem(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_product, parent, false);
        byte[] imageAsBytes = Base64.decode(product.getImagem(), Base64.DEFAULT);

        ((TextView) view.findViewById(R.id.cardview_product_name)).setText(product.getNomeProduto());
        ((TextView) view.findViewById(R.id.cardview_product_price)).setText("R$" + Utils.formatPrice(product.getPrecProduto()));
        ((ImageView) view.findViewById(R.id.cardview_product_image)).setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ProductAdapter", product.getIdProduto());
            }
        });

        return view;
    }
}
