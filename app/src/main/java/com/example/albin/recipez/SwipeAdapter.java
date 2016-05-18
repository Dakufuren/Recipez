package com.example.albin.recipez;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bumblebee on 2016-05-18.
 */
public class SwipeAdapter extends FragmentPagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SearchMenueFragment();
        Fragment fragment2 = new FavoritesFramgent();
        Bundle bundle = new Bundle();
        bundle.putInt("count", position+1);
        fragment.setArguments(bundle);


        if (position == 0) {
            return fragment;
        } else if (position == 1) {
            return fragment2;
        } else {
            return fragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
