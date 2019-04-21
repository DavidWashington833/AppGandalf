package com.gandalf.activitys;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gandalf.R;
import com.gandalf.models.Cliente;
import com.gandalf.tasks.RegisterUserTask;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private EditText name;
    private EditText phone;
    private EditText birthDay;
    private EditText CPF;
    private EditText email;
    private EditText password;
    private EditText passwordCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.register_activity_register);
        name = (EditText) findViewById(R.id.register_activity_name);
        phone = (EditText) findViewById(R.id.register_activity_phone);
        birthDay = (EditText) findViewById(R.id.register_activity_birth_day);
        CPF = (EditText) findViewById(R.id.register_activity_cpf);
        email = (EditText) findViewById(R.id.register_activity_email);
        password = (EditText) findViewById(R.id.register_activity_password);
        passwordCheck = (EditText) findViewById(R.id.register_activity_password_check);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new RegisterUserTask(RegisterActivity.this).execute();
            }
        });
    }

    public Cliente getCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(name.getText().toString());
        cliente.setCelularCliente(phone.getText().toString());
        cliente.setDtNascCliente(birthDay.getText().toString());
        cliente.setCpfCliente(CPF.getText().toString());
        cliente.setEmailCliente(email.getText().toString());
        cliente.setSenhaCliente(password.getText().toString());
        return cliente;
    }
}
