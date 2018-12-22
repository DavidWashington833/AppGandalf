package com.gandalf.activitys;


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
import com.gandalf.CartFragment;
import com.gandalf.CategoriaFragment;
import com.gandalf.ContatoFragment;
import com.gandalf.LoginActivity;
import com.gandalf.LojaFragment;
import com.gandalf.MinhaContaFragment;
import com.gandalf.ProdutoUnicoFragment;
import com.gandalf.QRCodeActivity;
import com.gandalf.R;
import com.gandalf.SearchFragment;
import com.gandalf.SobreNosFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private String idProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.activity_main_navigation_view);
        ViewPager viewpager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.activity_main_tabs);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);

        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewpager);
        viewpager.setCurrentItem(1);

        navigationView.setNavigationItemSelectedListener(getNavigationView());

//        TODO: refactoring
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        TabsFragment newFragment = new TabsFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.activity_main_tabs, newFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

//    TODO: refactoring
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        else {
//            if(item.getItemId() == R.id.actionbar_cart) {
//                chamaFragment(new CartFragment());
//                Intent newAct = new Intent(MainActivity.this, CartActivity.class);
//                startActivity(newAct);
//            }
//
//            if(item.getItemId() == R.id.actionbar_search) {
//                chamaFragment(new SearchFragment());
//            }
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                idProduct = data.getStringExtra("idProduct");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (idProduct != null) {
            chamaFragment(new ProdutoUnicoFragment(idProduct));
            idProduct = null;
        }

//        chamaFragment(new TabsFragment());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)  {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public NavigationView.OnNavigationItemSelectedListener getNavigationView() {
        return new NavigationView.OnNavigationItemSelectedListener() {
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
                    chamaFragment(new CartFragment());
                }

                if(menuItem.getItemId() == R.id.menu_search) {
                    chamaFragment(new SearchFragment());
                }

                if(menuItem.getItemId() == R.id.actionbar_search) {
                    chamaFragment(new SearchFragment());
                }
                return false;
            }
        };
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
                return new CartFragment();
            }
            return null;
        }
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

}
