package com.example.snugalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.snugalpha.Utils.Task;
import com.example.snugalpha.Adapter.TaskAdapter;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    ImageView task_list_btn_back;

    TextView mTextMonthDay;

    TextView mTextYear;

    TextView mTextLunar;

    TextView mTextCurrentDay;

    CalendarView mCalendarView;

    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;

    private ListView listView;
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        init();

    }

    public void  init(){

        task_list_btn_back = findViewById(R.id.task_list_btn_back);
        task_list_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskListActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mTextMonthDay = findViewById(R.id.tv_month_day);
        mTextYear = findViewById(R.id.tv_year);
        mTextLunar = findViewById(R.id.tv_lunar);
        mRelativeTool = findViewById(R.id.rl_tool);
        mCalendarView = findViewById(R.id.calendarView);
        mTextCurrentDay = findViewById(R.id.tv_current_day);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!mCalendarLayout.isExpand()) {
//                    mCalendarLayout.expand();
//                    return;
//                }
//                mCalendarView.showYearSelectLayout(mYear);
//                mTextLunar.setVisibility(View.GONE);
//                mTextYear.setVisibility(View.GONE);
//                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mCalendarLayout = findViewById(R.id.calendarLayout);
        mCalendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
            @Override
            public void onCalendarOutOfRange(Calendar calendar) {

            }

            @Override
            public void onCalendarSelect(Calendar calendar, boolean isClick) {

                mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
                mTextYear.setText(String.valueOf(calendar.getYear()));
                mTextLunar.setText(calendar.getLunar());
                mYear = calendar.getYear();
                if (calendar.getYear()== mCalendarView.getCurYear() && calendar.getMonth() == mCalendarView.getCurMonth() && calendar.getDay() == mCalendarView.getCurDay()){
                    mTextLunar.setVisibility(View.VISIBLE);
                    mTextLunar.setText("今日");
                }
                else{
                    mTextLunar.setVisibility(View.GONE);
                }

            }
        });
//        mCalendarView.setOnYearChangeListener(new CalendarView.OnYearChangeListener() {
//            @Override
//            public void onYearChange(int year) {
//
//            }
//        });

        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));

        listView = findViewById(R.id.list_view);
        for (int i = 0;i<5;i++){
            Task task = new Task("这是个标题"+(i+1)+"","这是有点详细又不是很详细的任务详情"+(i+1)+"");
            tasks.add(task);
        }
        TaskAdapter taskAdapter = new TaskAdapter(TaskListActivity.this,R.layout.task_item,tasks);
        listView.setAdapter(taskAdapter);
    }

}
