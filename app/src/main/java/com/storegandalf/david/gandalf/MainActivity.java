package com.storegandalf.david.gandalf;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.widget.TextView;

import com.storegandalf.david.gandalf.helpers.CarrinhoSingletonHelper;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String idProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
        final Integer logado = prefs.getInt("idCliente", 0);
        final String nomeCliente = prefs.getString("nomeCliente", null);


        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View viewMenu = navigationView.getHeaderView(0);

        TextView txtMenuCabecalho = (TextView) viewMenu.findViewById(R.id.txtMenuCabecalho);
        TextView txtNomeUsuarioMenu = (TextView) viewMenu.findViewById(R.id.txtNomeUsuarioMenu);

        if(logado == 0){
            txtNomeUsuarioMenu.setText("Olá!");
            txtMenuCabecalho.setText("Faça login para comprar.");
        } else {
            txtNomeUsuarioMenu.setText(nomeCliente + ",");
            txtMenuCabecalho.setText("seja bem-vindo!");
        }

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        } else {
                            menuItem.setChecked(true);
                        }
                        drawerLayout.closeDrawers();

                        if (menuItem.getItemId() == R.id.menu_loja) {
                            Intent newAct = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(newAct);
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_login) {
                            Intent newAct = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(newAct);
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_minhaconta) {
                            if (logado == 0){
                                chamaFragment(new PermissaoFragment());

                            } else {
                                chamaFragment(new MinhaContaFragment());
                            }

                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_pedidos) {
                            if (logado == 0){
                                chamaFragment(new PermissaoFragment());

                            } else {
                                chamaFragment(new MeusPedidosFragment(logado));
                            }

                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_qrcode) {
                            Intent newAct = new Intent(MainActivity.this, QRCodeActivity.class);
                            startActivityForResult(newAct, 1);
                            return true;
                        }

                        if (menuItem.getItemId() == R.id.menu_pedidos) {
                            if (logado == 0){
                                chamaFragmentAdd(new PermissaoFragment());

                            } else {
                                chamaFragmentAdd(new MeusPedidosFragment());
                            }
                        }

                        if (menuItem.getItemId() == R.id.menu_contato) {
                            chamaFragmentAdd(new ContatoFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_sobre) {
                            chamaFragment(new SobreNosFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_carrinho) {
                            if (CarrinhoSingletonHelper.getInstance().existeItem() != null && !CarrinhoSingletonHelper.getInstance().existeItem().equals("[]")){
                                chamaFragment(new CarrinhoFragment());
                            }else {
                                chamaFragment(new CarrinhoVazioFragment());
                            }
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

        SharedPreferences sharedPreferences = getSharedPreferences("InfosCliente", Context.MODE_PRIVATE);

        Boolean concordo = sharedPreferences.getBoolean("Concordo", false);

        if (concordo == false) {
            TermosServicosFragment newFragment = new TermosServicosFragment();
//        PaginaCarrinho newFragment = new PaginaCarrinho();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.frame_principal, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {

            PrincipalFragment newFragment = new PrincipalFragment();
//        PaginaCarrinho newFragment = new PaginaCarrinho();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
//        ProdutoUnicoFragment newFragment = new ProdutoUnicoFragment();
//        BuscaProdutoFragment newFragment = new BuscaProdutoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.frame_principal, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else {
            if(item.getItemId() == R.id.action_carrinho) {

                if (CarrinhoSingletonHelper.getInstance().existeItem() != null && !CarrinhoSingletonHelper.getInstance().existeItem().equals("[]")){
                    chamaFragment(new CarrinhoFragment());
                }else {
                    chamaFragment(new CarrinhoVazioFragment());
                }
            }

            if(item.getItemId() == R.id.action_busca) {
                chamaFragment(new BuscaProdutoFragment());
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                idProduto = data.getStringExtra("idProduto");
                //chamaFragment(new ProdutoUnicoFragment(idProduto));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (idProduto != null) {
            chamaFragment(new ProdutoUnicoFragment(idProduto));
            idProduto = null;
        }

       // chamaFragment(new PrincipalFragment());

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

    public void chamaFragmentAdd(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_principal, fragment);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
