package com.example.snugalpha;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity implements Runnable{

    // private final int SPLASH_DISPLAY_LENGHT = 2000; // 两秒后进入系统
    public static final String IS_FIRST="is_first";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
//        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);
        //启动一个延迟线程
        new  Thread(this).start();
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message message) {
//                if(ToolKits.GetBoolean(SplashActivity.this,IS_FIRST,false))
//                {
//                    //如果默认值为false，则没有登陆过，跳转到引导页
//                    startActivity(new Intent(SplashActivity.this,GuideActivity.class));
//                    //将boolean值设置为true
//                    ToolKits.putBoolean(SplashActivity.this,IS_FIRST,true);
//                }else{
//                    //否则跳转为主页
//                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
//                }
//                ToolKits.putBoolean(SplashActivity.this,IS_FIRST,true);
//                return true;
//            }
//        }).sendEmptyMessageDelayed(0,2000);/*延迟1s*/
//        Thread myThread=new Thread(){//创建子线程
//            @Override
//            public void run() {
//                try{
//                    sleep(2000);//使程序休眠五秒
//                    Intent it=new Intent(getApplicationContext(),SplashActivity.class);//启动MainActivity
//                    startActivity(it);
//                    finish();//关闭当前活动
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        };
//        myThread.start();//启动线程
    }
    public void run(){
        try{
            //延迟1秒时间
            Thread.sleep(2000);
            SharedPreferences preferences= getSharedPreferences("count", 0); // 存在则打开它，否则创建新的Preferences
            int count = preferences.getInt("count", 0); // 取出数据

            /**
             *如果用户不是第一次使用则直接调转到显示界面,否则调转到引导界面
             */
            if (count == 0) {
                Intent intent1 = new Intent();
                intent1.setClass(SplashActivity.this, GuideActivity.class);
                startActivity(intent1);
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(SplashActivity.this,GuideActivity.class);
                startActivity(intent2);
            }
            finish();

            //实例化Editor对象
            SharedPreferences.Editor editor = preferences.edit();
            //存入数据
            editor.putInt("count", 1); // 存入数据
            //提交修改
            editor.commit();
        } catch (InterruptedException e) {

        }

    }

}

