package com.gandalf.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.gandalf.CadastroActivity;
import com.gandalf.CartFragment;
import com.gandalf.ContatoFragment;
import com.gandalf.LoginActivity;
import com.gandalf.MinhaContaFragment;
import com.gandalf.ProdutoUnicoFragment;
import com.gandalf.QRCodeActivity;
import com.gandalf.R;
import com.gandalf.SearchFragment;
import com.gandalf.SobreNosFragment;
import com.gandalf.adapter.TabsAdapter;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

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

        viewpager.setAdapter(new TabsAdapter(getSupportFragmentManager(), getResources()));
        tabs.setViewPager(viewpager);
        viewpager.setCurrentItem(0);

        navigationView.setNavigationItemSelectedListener(getNavigationView());

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return super.onOptionsItemSelected(item);
        }
        if(item.getItemId() == R.id.actionbar_cart) {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.actionbar_search) {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
                drawerLayout.closeDrawers();
//                if (menuItem.getItemId() == R.id.menu_store) {
//                    Intent newAct = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(newAct);
//                    return true;
//                }
                return false;
            }
        };
    }

}
