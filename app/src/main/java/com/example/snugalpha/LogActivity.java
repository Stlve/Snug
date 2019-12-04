package com.example.snugalpha;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


import com.example.snugalpha.Adapter.FragmentAdapter;
import com.example.snugalpha.Api.Network;
import com.example.snugalpha.Fragment.Login;
import com.example.snugalpha.Fragment.SignUp;

import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    static String name;
    static String telephone;
    static String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initWidgets();
        initViewPager();

        Network.init();
        //register();
        //login();
    }

    private void initWidgets(){
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
    }

    private void initViewPager(){
        List<String> titles = new ArrayList<>();
        titles.add("登录");
        titles.add("注册");
        for (int i = 0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new Login());
        fragments.add(new SignUp());

        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapter);
        //将TabLayout和ViewPager关联
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }



}
