package com.bw.miaoheng20200311;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.bw.miaoheng20200311.view.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.vp);
        final List<Fragment> list=new ArrayList<>();
        HomeFragment homeFragment0 = HomeFragment.getInstance(0);
        HomeFragment homeFragment1 = HomeFragment.getInstance(1);
        HomeFragment homeFragment2 = HomeFragment.getInstance(2);
        HomeFragment homeFragment3 = HomeFragment.getInstance(3);
        HomeFragment homeFragment9 = HomeFragment.getInstance(9);
        list.add(homeFragment0);
        list.add(homeFragment1);
        list.add(homeFragment2);
        list.add(homeFragment3);
        list.add(homeFragment9);
        final List<String>  title=new ArrayList<>();
        title.add("全部订单");
        title.add("代付款");
        title.add("待收货");
        title.add("待评价");
        title.add("已完成");
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
