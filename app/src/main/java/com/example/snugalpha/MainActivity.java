package com.example.snugalpha;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.snugalpha.Utils.Card;
import com.example.snugalpha.Utils.CardAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Card[] cards = {new Card("和我说话",R.drawable.talkwithmeldpi),new Card("当前旅程",R.drawable.tripldpi),new Card("选择旅程",R.drawable.alltripldpi),new Card("成长回顾",R.drawable.conclusionldpi)};
    private List<Card> cardList = new ArrayList<>();
    private CardAdapter adapter;
    private ImageView head_photo;
    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        initCards();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddEventActivity.class);
                i.putExtra("id",id);
                startActivity(i);
            }
        });
        //得到用户的id
        Intent intent=getIntent();
        String s =intent.getStringExtra("id");
//        id = Integer.parseInt(s);
//        id = intent.getStringExtra("id");
        adapter = new CardAdapter(cardList);
        recyclerView.setAdapter(adapter);
        adapter.setRecyclerItemClickListener(new CardAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(int Position, List<Card> cardList) {
                if (Position==0){
                    Intent i = new Intent(MainActivity.this, TrainingActivity.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
                if (Position==1){
                    Intent i = new Intent(MainActivity.this, TaskListActivity.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
                if (Position==2){
                    Intent i = new Intent(MainActivity.this, AllTripActivity.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
                if (Position==3){
                    Intent i = new Intent(MainActivity.this,ConclusionActivity.class);
                    i.putExtra("id",id);
                    startActivity(i);
                }
            }
        });
        head_photo = (ImageView)findViewById(R.id.head_photo);
        head_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, LogActivity.class);  // 进去MainActivity
                i.putExtra("id",id);
                startActivity(i);
            }
        });

    }
    private void initCards(){
        cardList.clear();
        for (int i=0;i<4;i++){
            cardList.add(cards[i]);
        }
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


}
