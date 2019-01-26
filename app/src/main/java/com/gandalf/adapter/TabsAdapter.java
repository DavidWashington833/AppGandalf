package com.gandalf.adapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gandalf.Fragments.CategoriesFragment;
import com.gandalf.Fragments.ProductsFragment;
import com.gandalf.R;

import java.util.Arrays;
import java.util.List;

public class TabsAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    private List<Fragment> fragments;

    public TabsAdapter(FragmentManager fragmentManager, Resources resources) {
        super(fragmentManager);
        titles = Arrays.asList(
            resources.getString(R.string.activity_main_tab_title_one),
            resources.getString(R.string.activity_main_tab_title_two)
        );
        fragments = Arrays.asList(
            new CategoriesFragment(),
            new ProductsFragment()
        );
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
