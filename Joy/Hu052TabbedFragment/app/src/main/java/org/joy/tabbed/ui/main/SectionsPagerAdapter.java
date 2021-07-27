package org.joy.tabbed.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.joy.tabbed.Fragment1;
import org.joy.tabbed.Fragment2;
import org.joy.tabbed.Fragment3;
import org.joy.tabbed.FragmentError;
import org.joy.tabbed.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
// public class SectionsPagerAdapter extends FragmentPagerAdapter {
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{ R.string.tab_text_1,
            R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5  };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position) {
            case 0: fragment = new Fragment1(); break;
            case 1: fragment = new Fragment2(); break;
            case 2: fragment = new Fragment3(); break;
            default: fragment = new FragmentError(); break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length ;
    }
}