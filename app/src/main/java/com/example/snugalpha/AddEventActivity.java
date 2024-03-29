package com.example.snugalpha;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.snugalpha.Api.LoginResponse;
import com.example.snugalpha.Api.Network;
import com.example.snugalpha.Api.RegisterResponse;
import com.example.snugalpha.Utils.UserTask;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddEventActivity extends AppCompatActivity {
//implements View.OnClickListener
    private Calendar cal;
    String time = "";
    private int year, month, day;
    int minute, hour;
    private TextView tvShowDialog, tvShowDialog2,data1,data2;
    private Button finish;
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    private Switch aSwitch;
    private TimePicker timePicker;
    private RelativeLayout relativeLayout;
    private static UserTask userTask=null;
    private int id;
    private EditText Event_name;
    private TimePickerDialog dialogAll;
    private boolean pinlu = true;
    private String count = "";

    DateFormat format= DateFormat.getDateTimeInstance();
    Calendar calendar = Calendar.getInstance(Locale.CHINA);

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
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
        //添加Spinner事件监听
     spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            count = data_list.get(arg2);
            //设置显示当前选择的项
            arg0.setVisibility(View.VISIBLE);
         }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    });


        tvShowDialog = (TextView) findViewById(R.id.tvShowDialog);
        tvShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.tvShowDialog:
                        showTimePickerDialog(AddEventActivity.this,  4, tvShowDialog, calendar);
//
//                        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
//                        int minute = calendar.get(Calendar.MINUTE);            //得到分钟
//                        new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
//                                tvShowDialog.setText("" + hourOfDay + ":" + minute);
//                            }
//                        }, hourOfDay, minute, true).show();
                        break;
                    default:
                        break;
                }
            }
        });
        tvShowDialog2 = (TextView) findViewById(R.id.tvShowDialog2);
        tvShowDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tvShowDialog2:
                        showTimePickerDialog(AddEventActivity.this,  4, tvShowDialog2, calendar);
//                        Calendar calendar = Calendar.getInstance();
//                        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
//                        int minute = calendar.get(Calendar.MINUTE);            //得到分钟
//                        new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
//                                tvShowDialog2.setText(" " + hourOfDay + ":" + minute );
//                                //  time=" "+hourOfDay+":"+minute+":00";
//                            }
//                        }, hourOfDay, minute, true).show();
//                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//                        userTask.setEnd(df.format(new Date())+time);
                        break;
                    default:
                        break;
                }
            }
        });
        data1 = (TextView)findViewById(R.id.data1);
        data1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePickerDialog(AddEventActivity.this,  0, data1, calendar);
            }
        });
        data2 = (TextView)findViewById(R.id.data2);
        data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(AddEventActivity.this,  0, data2, calendar);
            }
        });
        Event_name = (EditText) findViewById(R.id.event_name);
        //完成按钮的点击事件
        finish = (Button) findViewById(R.id.addclose);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTask = new UserTask("","","",LoginResponse.Data.datas.id);
                String start_time,end_time;
                start_time = data2.getText().toString()+tvShowDialog.getText().toString();
                end_time = data1.getText().toString()+tvShowDialog2.getText().toString();
                System.out.println(start_time+" "+end_time);
                userTask.setInfo(Event_name.getText().toString());
                userTask.setStart(tvShowDialog.getText().toString());
                userTask.setEnd(tvShowDialog2.getText().toString());
                userTask.setUserId(LoginResponse.Data.datas.id);
                //频率
                //是否评级
                Intent i = new Intent(AddEventActivity.this, MainActivity.class);  // 进去MainActivity
                startActivity(i);

            }
        });
        aSwitch = (Switch) findViewById(R.id.switcher);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    aSwitch.setChecked(true);
                    pinlu = true;

                } else {
                    pinlu = false;
                    aSwitch.setChecked(false);
                }
            }
        });
        ImageView addclose = (ImageView) findViewById(R.id.add_close);
        addclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AddEventActivity.this, MainActivity.class);  // 进去MainActivity
                startActivity(i);
            }
        });


    }
        private void showStatusBar () {
            WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(attrs);
        }

        //获取手机状态栏高度
        public static int getStatusBarHeight (Context context){
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
    private static void getaddTask(){
        Network.api.getaddTask(new com.example.snugalpha.Api.UserTask("记得跑步","2019-02-26 23:10:00","2019-12-1 23:30:00",5)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
    /**
     * 日期选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                tv.setText(" " + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    /**
     * 时间选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showTimePickerDialog(Activity activity,int themeResId, final TextView tv, Calendar calendar) {
        // Calendar c = Calendar.getInstance();
        // 创建一个TimePickerDialog实例，并把它显示出来
        // 解释一哈，Activity是context的子类
        new TimePickerDialog( activity,themeResId,
                // 绑定监听器
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv.setText(" " + hourOfDay + "时" + minute  + "分");
                    }
                }
                // 设置初始时间
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                // true表示采用24小时制
                ,true).show();
    }

    }

