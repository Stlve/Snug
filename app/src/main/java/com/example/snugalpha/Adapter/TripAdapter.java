package com.example.snugalpha.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snugalpha.R;
import com.example.snugalpha.Utils.Trip;

import java.util.List;

public class TripAdapter extends ArrayAdapter<Trip> {

    private int resourceId;
    private List<Trip> trips;

    public TripAdapter(Context context, int textViewResourceId, List<Trip> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
        trips = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Trip trip = getItem(position);
        View view;
        TripAdapter.ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new TripAdapter.ViewHolder();
            viewHolder.all_trip_card_view = view.findViewById(R.id.all_trip_card_view);
            viewHolder.trip_type_image = view.findViewById(R.id.trip_type_image);
            viewHolder.trip_type_name_1 = view.findViewById(R.id.trip_type_name_1);
            viewHolder.trip_type_name_2 = view.findViewById(R.id.trip_type_name_2);
            viewHolder.missions_number = view.findViewById(R.id.missions_number);
            viewHolder.all_missions_number = view.findViewById(R.id.all_missions_number);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (TripAdapter.ViewHolder)view.getTag();
        }
        viewHolder.trip_type_image.setImageResource(trip.getImage_id());
        viewHolder.trip_type_name_1.setText(trip.getText_1());
        viewHolder.trip_type_name_2.setText(trip.getText_2());
        viewHolder.missions_number.setText(trip.getNum_1()+"");
        viewHolder.all_missions_number.setText(trip.getNum_2()+"");
//        if (position == 0){
//            viewHolder.time_start_line.setAlpha(0);
//        }
//        else{
//            viewHolder.time_start_line.setAlpha(1);
//        }
//        if(position == trips.size()-1){
//            viewHolder.time_end_line.setVisibility(View.GONE);
//        }
//        else{
//            viewHolder.time_end_line.setVisibility(View.VISIBLE);
//        }
        return view;
    }

    @Override
    public int getCount() {
        return trips.size();
    }

    @Override
    public Trip getItem(int position) {
        return trips.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{

        CardView all_trip_card_view;
        ImageView trip_type_image;
        TextView trip_type_name_1;
        TextView trip_type_name_2;
        TextView missions_number;
        TextView all_missions_number;

    }

}
