package com.gandalf.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.R;
import com.gandalf.models.Login;
import com.gandalf.tasks.LoginTask;

public class LoginActivity extends AppCompatActivity {
    private ImageView showPassword;
    private Button login;
    private TextView register;

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.activity_login_enter);
        showPassword = (ImageView) findViewById(R.id.activity_login_show_password);
        register = (TextView) findViewById(R.id.activity_login_register);
        email = (EditText) findViewById(R.id.activity_login_email);
        password = (EditText) findViewById(R.id.activity_login_password);

        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePassword();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginTask(LoginActivity.this).execute();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void togglePassword() {
        if(password.getInputType() == InputType.TYPE_CLASS_TEXT) {
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            password.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }

    public Login getLogin() {
        Login login = new Login();
        login.setEmail(email.getText().toString());
        login.setSenha(password.getText().toString());
        return login;
    }
}


