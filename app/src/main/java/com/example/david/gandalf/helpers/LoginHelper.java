package com.example.david.gandalf.helpers;

import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.R;
import com.example.david.gandalf.models.Login;

/**
 * Created by Silva on 03/11/2017.
 */

public class LoginHelper {
    private final EditText email;
    private final EditText senha;
    private final ImageView visualizar;
    private LoginActivity activity;

    public LoginHelper(LoginActivity activity) {
        this.activity = activity;
        email = (EditText) activity.findViewById(R.id.login_email);
        senha = (EditText) activity.findViewById(R.id.login_senha);
        visualizar = (ImageView) activity.findViewById(R.id.login_visualizar_senha);
    }

    public void alternaSenha() {
        if(senha.getInputType() == InputType.TYPE_CLASS_TEXT) {
            senha.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            senha.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }

    public Login getLogin() {
        Login login = new Login();
        login.setEmail(email.getText().toString());
        login.setSenha(senha.getText().toString());
        return login;
    }

}
