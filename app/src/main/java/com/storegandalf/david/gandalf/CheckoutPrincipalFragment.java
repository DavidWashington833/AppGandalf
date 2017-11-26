package com.storegandalf.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.storegandalf.david.gandalf.tasks.CheckoutTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutPrincipalFragment extends Fragment {

    public RadioGroup rdGroup;
    public RadioButton rbBoleto;
    public RadioButton rbCartao;
    public Button btnFinalizarCompraCheckout;
    String qualMetodo = "0";

    public CheckoutPrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_principal, container, false);

        new CheckoutTask(CheckoutPrincipalFragment.this).execute();

        rbBoleto = (RadioButton) view.findViewById(R.id.rdBoleto);
        rbCartao = (RadioButton) view.findViewById(R.id.rdCartao);
        btnFinalizarCompraCheckout = (Button) view.findViewById(R.id.btnFinalizarCompraCheckout);



        btnFinalizarCompraCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbBoleto.isChecked()){
                    qualMetodo = "1";
                    chamaFragmentAdd(new CheckoutBoletoFragment());

                }

                if(rbCartao.isChecked()){
                    qualMetodo = "2";
                    chamaFragmentAdd(new CheckoutCreditoFragment());
                }
            }
        });


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
