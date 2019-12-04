package com.example.snugalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.snugalpha.Adapter.TripAdapter;
import com.example.snugalpha.Utils.Trip;

import java.util.ArrayList;
import java.util.List;

public class AllTripActivity extends AppCompatActivity {

    private ListView listView;
    private List<Trip> trips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trip);

        init();

    }

    public void init(){

        Trip trip1 = new Trip(R.drawable.card1,"一次神秘的旅行","感觉精力充沛",3,30);
        trips.add(trip1);
        Trip trip2 = new Trip(R.drawable.card2,"拥抱健康的饮食","控制体重和吃得更健康",6,20);
        trips.add(trip2);
        Trip trip3 = new Trip(R.drawable.card3,"一个美妙的夜晚","睡得更好",0,30);
        trips.add(trip3);
        Trip trip4 = new Trip(R.drawable.card4,"维持在道路上的你","更专注和集中",10,60);
        trips.add(trip4);

        listView = findViewById(R.id.all_trip_list_view);
        TripAdapter tripAdapter = new TripAdapter(AllTripActivity.this,R.layout.trip_item,trips);
        listView.setAdapter(tripAdapter);

    }

}
