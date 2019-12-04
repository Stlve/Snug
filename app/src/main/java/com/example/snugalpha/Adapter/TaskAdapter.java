package com.example.snugalpha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.snugalpha.R;
import com.example.snugalpha.Utils.Task;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private int resourceId;
    private List<Task> tasks;

    public TaskAdapter(Context context, int textViewResourceId, List<Task> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
        tasks = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.time_start_line = view.findViewById(R.id.time_start_line);
            viewHolder.time_dot = view.findViewById(R.id.time_dot);
            viewHolder.time_end_line = view.findViewById(R.id.time_end_line);
            viewHolder.task_title = view.findViewById(R.id.task_title);
            viewHolder.task_detail = view.findViewById(R.id.task_detail);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.task_title.setText(task.getTitle());
        viewHolder.task_detail.setText(task.getDetail());
        if (position < 1){
            viewHolder.time_start_line.setAlpha(0);
        }
        else{
            viewHolder.time_start_line.setAlpha(1);
        }
        if(position == tasks.size()-1){
            viewHolder.time_end_line.setVisibility(View.GONE);
        }
        else{
            viewHolder.time_end_line.setVisibility(View.VISIBLE);
        }
        return view;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{

        View time_start_line;
        ImageView time_dot;
        View time_end_line;
        TextView task_title;
        TextView task_detail;

    }

}
