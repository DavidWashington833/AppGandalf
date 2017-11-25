package com.storegandalf.david.gandalf;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TermosServicosFragment extends Fragment {
    private Button btn_concordo;
    private Button btn_nao_concordo;


    public TermosServicosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_termos_servicos, container, false);
        Button btn_concordo = (Button) view.findViewById(R.id.btn_concordo);
        Button btn_nao_concordo = (Button) view.findViewById(R.id.btn_nao_concordo);

        btn_concordo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("InfosCliente", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("Concordo", true);
                editor.apply();

                PrincipalFragment newFragment = new PrincipalFragment();
//        PaginaCarrinho newFragment = new PaginaCarrinho();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.frame_principal, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btn_nao_concordo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().moveTaskToBack(true);
                getActivity().finish();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
