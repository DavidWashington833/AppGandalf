package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  =  inflater.inflate(R.layout.fragment_principal, container, false);

        // Inflate the layout for this fragment
        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) v.findViewById(R.id.viewpager);
        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        pager.setCurrentItem(1);

        return v;


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
            return "";
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new CategoriaFragment();
            }
            if (position == 1) {
                return new ProdutoFragment();
            }

            return null;
        }
    }

}
