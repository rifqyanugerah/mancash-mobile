package org.d3if3095.mancashmobile.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.d3if3095.mancashmobile.R;
import org.d3if3095.mancashmobile.model.ModelDatabase;
import org.d3if3095.mancashmobile.utils.FunctionHelper;
import org.d3if3095.mancashmobile.view.fragment.pengeluaran.PengeluaranAdapter;
import org.d3if3095.mancashmobile.view.fragment.pengeluaran.PengeluaranViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    private TextView tvNotFound;
    private TextView tvTotal;
    private PengeluaranAdapter pengeluaranAdapter;

    private List<ModelDatabase> modelDatabase = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {R.drawable.ic_pengeluaran, R.drawable.ic_pemasukan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        setIdLayout();
        setInitLayout();
        observeData();
    }

    private void setIdLayout() {
        tvTotal = findViewById(R.id.tvTotal);
        tabLayout = findViewById(R.id.tabsLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private void setInitLayout() {
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void observeData() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getTotalPengeluaranSaldo().observe(this, new Observer<Integer>(){
            @Override
            public void onChanged(Integer integer) {
                if (integer == null) {
                    int totalPrice = 0;
                    String initPrice = FunctionHelper.rupiahFormat(totalPrice);
                    tvTotal.setText(initPrice);
                } else {
                    int totalPrice = integer;
                    String initPrice = FunctionHelper.rupiahFormat(totalPrice);
                    tvTotal.setText(initPrice);
                }
            }
        });
    }
}

