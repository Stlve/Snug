package com.example.snugalpha.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    public List<Fragment> list;
    private List<String> titles;

    public FragmentAdapter(FragmentManager fm, List<Fragment> list, List<String> titles){
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    //返回显示的Fragment总数
    @Override
    public int getCount() {
        return list.size();
    }

    //返回要显示的Fragment的某个实例

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    //返回每个Tab的标题

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
