package com.example.snugalpha;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.snugalpha.Adapter.FragmentAdapter;
import com.example.snugalpha.Fragment.AchievementValue;
import com.example.snugalpha.Fragment.CompletionQuantity;
import com.example.snugalpha.Utils.MyViewPager;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class ConclusionActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private MyViewPager mViewPager;
    private FragmentTransaction ftr;

    private Fragment achievementValue;
    private Fragment completionQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);

        initWidgets();
        initViewPager();


    }

    private void initWidgets(){
        mTabLayout = findViewById(R.id.conclusion_tab_layout);


        mViewPager = findViewById(R.id.conclusion_view_pager);
    }

    private void initViewPager(){
        List<String> titles = new ArrayList<>();
        titles.add("完成数");
        titles.add("成就值");
        for (int i = 0;i<titles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new CompletionQuantity());
        fragments.add(new AchievementValue());

        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(mFragmentAdapter);
        //将TabLayout和ViewPager关联
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }






}
