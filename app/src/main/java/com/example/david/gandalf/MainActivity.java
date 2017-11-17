package com.example.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        }
                        else {
                            menuItem.setChecked(true);
                        }
                        drawerLayout.closeDrawers();
                        if (menuItem.getItemId() == R.id.menu_login) {
                            Intent newAct = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(newAct);
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_qrcode) {
                            Intent newAct = new Intent(MainActivity.this, QRCodeActivity.class);
                            startActivity(newAct);
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_pedidos) {
                            chamaFragment(new MeusPedidosFragment());
                        }

                        return false;
                    }
                });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        R.string.openDrawer, R.string.closeDrawer) {
                };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        PrincipalFragment newFragment = new PrincipalFragment();
        //PaginaCarrinho newFragment = new PaginaCarrinho();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_principal, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_principal, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
