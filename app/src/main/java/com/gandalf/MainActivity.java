package com.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

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

        navigationView = (NavigationView) findViewById(R.id.activity_main_navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
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

                        if (menuItem.getItemId() == R.id.menu_store) {
                            Intent newAct = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(newAct);
                            return true;
                        }

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

                        if (menuItem.getItemId() == R.id.menu_account) {
                            chamaFragment(new MinhaContaFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_account) {
                            chamaFragment(new MinhaContaFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_contact) {
                            chamaFragment(new ContatoFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_about) {
                            chamaFragment(new SobreNosFragment());
                        }

                        if (menuItem.getItemId() == R.id.menu_cart) {
                            chamaFragment(new CarrinhoFragment());
                        }

                        if(menuItem.getItemId() == R.id.menu_search) {
                           chamaFragment(new BuscaProdutoFragment());
                        }

                        if(menuItem.getItemId() == R.id.actionbar_search) {
                            chamaFragment(new BuscaProdutoFragment());
                        }
                        return false;
                    }
                });

        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        R.string.openDrawer, R.string.closeDrawer) {
                };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();



//        TabsFragment newFragment = new TabsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

//        transaction.replace(R.id.activity_main_tabs, newFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

        // Inflate the layout for this fragment
        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.activity_main_bar);
        tabs.setViewPager(pager);
        pager.setCurrentItem(1);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Categorias";
            }
            if (position == 1) {
                return "Loja";
            }
            if (position == 2) {
                return "Carrinho";
            }
            return "";
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new CategoriaFragment();
            }
            if (position == 1) {
                return new LojaFragment();
            }
            if (position == 2) {
                return new CarrinhoFragment();
            }
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else {
            if(item.getItemId() == R.id.actionbar_cart) {
                chamaFragment(new CarrinhoFragment());
            }

            if(item.getItemId() == R.id.actionbar_search) {
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

//        chamaFragment(new TabsFragment());

    }

    public void chamaFragment(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStackImmediate(backStateName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.activity_main_tabs, fragment);
//        transaction.addToBackStack(backStateName);
//        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
