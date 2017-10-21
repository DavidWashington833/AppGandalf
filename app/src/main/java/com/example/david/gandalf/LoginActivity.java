package com.example.david.gandalf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button bt_rsenha;
    private Button bt_login;
    private Button bt_cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_rsenha = (Button) findViewById(R.id.bt_rsenha);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_cc = (Button) findViewById(R.id.bt_cc);


//        View.OnClickListener Listenner_bt_cc = new View.OnClickListener() {
//            public void onClick(View v) {
//                CadastroActivity fragment = new CadastroActivity();
//                getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.,fragment).commit();
//            }
//        };
//        bt_cc.setOnClickListener(Listenner_bt_cc);
//
//
//
//        View.OnClickListener Listenner_bt_rsenha = new View.OnClickListener() {
//            public void onClick(View v) {
//            }
//        };
//        bt_rsenha.setOnClickListener(Listenner_bt_rsenha);
//
//
//
//        View.OnClickListener Listenner_bt_login = new View.OnClickListener() {
//            public void onClick(View v) {
//            }
//        };
//        bt_login.setOnClickListener(Listenner_bt_login);
//

    }
}
