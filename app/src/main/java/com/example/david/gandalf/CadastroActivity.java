package com.example.david.gandalf;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private Button btnNext1;
    private Button btnNext2;
    private Button btnNext3;
    private Button btnNext4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        chamaFragment(new CadastroPt1Fragment());

        btnNext1 = (Button) findViewById(R.id.cadastro_proximo_pt1);
//        btnNext2 = (Button) findViewById(R.id.cadastro_proximo_pt2);
//        btnNext3 = (Button) findViewById(R.id.cadastro_proximo_pt3);
//        btnNext4 = (Button) findViewById(R.id.cadastro_proximo_pt4);

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamaFragment(new CadastroPt2Fragment());
            }
        });

//        btnNext2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                chamaFragment(new CadastroPt3Fragment());
//            }
//        });
//
//        btnNext3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                chamaFragment(new CadastroPt4Fragment());
//            }
//        });
//
//        btnNext4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.cadastro_frame, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }
}
