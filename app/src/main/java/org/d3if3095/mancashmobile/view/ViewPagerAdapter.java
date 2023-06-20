package org.d3if3095.mancashmobile.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.d3if3095.mancashmobile.view.fragment.pemasukan.PemasukanFragment;
import org.d3if3095.mancashmobile.view.fragment.pengeluaran.PengeluaranFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new PengeluaranFragment();
                break;
            case 1:
                fragment = new PemasukanFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String strTitle = "";
        switch (position) {
            case 0:
                strTitle = "Pengeluaran";
                break;
            case 1:
                strTitle = "Pemasukan";
                break;
        }
        return strTitle;
    }
}
