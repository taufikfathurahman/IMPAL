package com.example.ayedis_ecommerce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class onboardIntroAdapter extends FragmentPagerAdapter {

    public onboardIntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int posisi) {
        switch (posisi) {
            case 0:
                return new bigsaleFragment();
            case 1:
                return new specialbonusFragment();
            case 2:
                return new nonstopwithyouFragment();
            case 3:
                return new everywhereFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
