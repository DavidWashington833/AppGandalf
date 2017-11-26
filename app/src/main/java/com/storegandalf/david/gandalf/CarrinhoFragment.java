package com.storegandalf.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.storegandalf.david.gandalf.adapter.CarrinhoAdapter;
import com.storegandalf.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.storegandalf.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoFragment extends Fragment {

    Button btnContinuarComprando;
    Button btnFacaCheckout;


    public CarrinhoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        String result = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduto());

        if (result != null && !result.equals("[null]")) {

            final Produto[] produtos = new Gson().fromJson(result, Produto[].class);

            List<Produto> plist = new ArrayList<Produto>();
            plist.addAll(Arrays.asList(produtos));
            final CarrinhoAdapter adapter = new CarrinhoAdapter(this.getContext(), plist);
            final ListView listView = (ListView) view.findViewById(R.id.list_produto_carrinho);

            listView.setAdapter(adapter);

            btnContinuarComprando = (Button) view.findViewById(R.id.btnContinuarComprando);

            btnFacaCheckout = (Button) view.findViewById(R.id.btnFacaCheckout);

            btnContinuarComprando.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent newAct = new Intent(getContext(), MainActivity.class);
                    startActivity(newAct);
                }
            });

            btnFacaCheckout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chamaFragmentAdd(new CheckoutPrincipalFragment());
                }
            });

        }

        return view;
    }

    public void chamaFragmentAdd(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_principal, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

}
