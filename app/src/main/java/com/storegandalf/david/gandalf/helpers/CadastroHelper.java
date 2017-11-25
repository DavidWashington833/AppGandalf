package com.storegandalf.david.gandalf.helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.storegandalf.david.gandalf.CadastroActivity;
import com.storegandalf.david.gandalf.R;

/**
 * Created by david.wfsilva on 22/11/2017.
 */

public class CadastroHelper {
    private CadastroActivity context;

    public CadastroHelper(CadastroActivity activity) {
        this.context = activity;
    }
    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = context.getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.cadastro_frame, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }
}
