package com.example.snugalpha;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.snugalpha.Utils.UserTask;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AddEventActivity extends AppCompatActivity {

    private Calendar cal;
    String time="";
    private int year,month,day;
    int minute,hour;
   private TextView tvShowDialog,tvShowDialog2;
    private Button finish;
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    private Switch aSwitch;
    private TimePicker timePicker;
    private RelativeLayout relativeLayout;
    private static UserTask userTask;
    private int id;
    private EditText Event_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);//添加打卡事件
        //上面条条隐藏
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        //全屏并且状态栏透明显示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();
//        id = Integer.parseInt(intent.getStringExtra("id"));


        spinner = (Spinner) findViewById(R.id.spin_one);
        //数据
        data_list = new ArrayList<String>();
        data_list.add("一天1次");
        data_list.add("一天2次");
        data_list.add("一天3次");
        data_list.add("一天4次");

        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);

        tvShowDialog=(TextView) findViewById(R.id.tvShowDialog);
        tvShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.tvShowDialog:
                        Calendar calendar = Calendar.getInstance();
                        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
                        int minute  = calendar.get(Calendar.MINUTE);            //得到分钟
                        new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {@Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
                               tvShowDialog.setText(" "+hourOfDay+":"+minute+":00");
                                time=" "+hourOfDay+":"+minute+":00";
                            }
                        }, hourOfDay, minute, true).show();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                       // System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                        userTask.setStart(df.format(new Date())+time);

                        break;
                    default:
                        break;
                }
            }
        });
        tvShowDialog2=(TextView) findViewById(R.id.tvShowDialog2);
        tvShowDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tvShowDialog2:
                        Calendar calendar = Calendar.getInstance();
                        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
                        int minute  = calendar.get(Calendar.MINUTE);            //得到分钟
                        new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
                               tvShowDialog.setText(" "+hourOfDay+":"+minute+":00");
                                time=" "+hourOfDay+":"+minute+":00";
                            }
                        }, hourOfDay, minute, true).show();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                        userTask.setEnd(df.format(new Date())+time);
                        break;
                    default:
                        break;
                }
            }
        });
        Event_name =(EditText)findViewById(R.id.event_name);
        finish = (Button)findViewById(R.id.addclose);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTask.setInfo(Event_name.getText().toString());
                Intent i = new Intent(AddEventActivity.this, MainActivity.class);  // 进去MainActivity
                i.putExtra("id",id);
                startActivity(i);

            }
        });
        aSwitch = (Switch)findViewById(R.id.switcher);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    aSwitch.setChecked(true);

                }else {

                    aSwitch.setChecked(false);
                }
            }
        });
        ImageView addclose = (ImageView)findViewById(R.id.add_close);
        addclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AddEventActivity.this, MainActivity.class);  // 进去MainActivity
                startActivity(i);
            }
        });

    }
//    public void addTask(){
//        Network.api.addTask(userTask).enqueue(new Callback<addTaskResponse>() {
//            @Override
//            public void onResponse(Call<addTaskResponse> call, Response<addTaskResponse> response) {
//                //返回msg
//                if(response.body().msg=="ok"){
//                    Toast.makeText(AddEventActivity.this,"添加成功",Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<addTaskResponse> call, Throwable t) {
//
//            }
//        });
//    }
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