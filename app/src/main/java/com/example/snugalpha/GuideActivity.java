package com.example.snugalpha;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import com.example.snugalpha.Utils.GuideAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{//实现监听接口

    private ViewPager vp;
    private GuideAdapter vpAdapter;
    private List<View> views;
    // 导航点
    private ImageView[] dots;
    private int[] ids = {R.id.iv1, R.id.iv2,R.id.iv3};

    // 开始按钮
    private Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);//加载guide.xml 视图

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.initView();//初始化视图
        this.initDots();//初始化导航点
        System.out.println("onCreate");
    }
    //全屏并且状态栏透明显示
    private void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    //获取手机状态栏高度
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    // 初始化view
    public void initView() {
        /*
        * Inflater英文意思是膨胀，在Android中应该是扩展的意思吧。
          LayoutInflater的作用类似于 findViewById(),
          不同点是LayoutInflater是用来找layout文件夹下的xml布局文件，并且实例化！
          而 findViewById()是找具体某一个xml下的具体 widget控件(如:Button,TextView等)。
        *
        * */
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.onepage, null));  // 加载视图1
        views.add(inflater.inflate(R.layout.twopage, null));  // 加载视图2
        views.add(inflater.inflate(R.layout.threepage, null));  // 加载视图3

        vpAdapter = new GuideAdapter(views, this);   // 创建我们的 adapter
        vp = (ViewPager) findViewById(R.id.view_pager);
        vp.setAdapter(vpAdapter);                       // viewpage绑定 adapter
        vp.setOnPageChangeListener(this);                // ViewPager 监听自己
        // 进入按钮
        this.bt = (Button) views.get(2).findViewById(R.id.btn_start);
        this.bt.setOnClickListener(new View.OnClickListener() {  // 监听
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GuideActivity.this, MainActivity.class);  // 进去MainActivity
                startActivity(i);
                finish();  //销毁当前的Activity
            }
        });
    }
    private void initDots() {                           // 初始化 我们的导航点
        this.dots = new ImageView[this.views.size()];
        for (int i=0; i<this.views.size(); i++) {
            dots[i] = (ImageView) this.findViewById(this.ids[i]);
        }
    }


    // 监听 页面滑动的方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        for (int i=0; i<this.ids.length; i++) {
            if (position == i) {
                this.dots[i].setImageResource(R.drawable.point_black);  // 变成选中的
            } else {
                this.dots[i].setImageResource(R.drawable.point);    //变成不选中的
            }
        }
    }

    //选中
    @Override
    public void onPageSelected(int position) {

    }

    // 滑动状态改变
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
