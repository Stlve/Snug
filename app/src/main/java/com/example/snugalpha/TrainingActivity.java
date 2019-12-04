package com.example.snugalpha;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TrainingActivity extends AppCompatActivity {

    private RadioButton fluent1,fluent2,fluent3;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;   //多选按钮
    private Button btnQueDing;  //确定
    private List<CheckBox> checkBoxList = new ArrayList<>();        //  多选框集合
    private List<RadioButton> fluent = new ArrayList<>();
    private ImageView back;
    private TextView start_time;
    private TextView finish_time;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        //上面条条隐藏
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        //全屏并且状态栏透明显示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        start_time=(TextView) findViewById(R.id.check_starttime);
        start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.check_starttime:
                        Calendar calendar = Calendar.getInstance();
                        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
                        int minute  = calendar.get(Calendar.MINUTE);            //得到分钟
                        new TimePickerDialog(TrainingActivity.this, new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
                                start_time.setText(""+hourOfDay+":"+minute);
                            }
                        }, hourOfDay, minute, true).show();
                        break;
                    default:
                        break;
                }
            }
        });
        finish_time=(TextView) findViewById(R.id.check_endtime);
        finish_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.check_endtime:
                        Calendar calendar = Calendar.getInstance();
                        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY);    //得到小时
                        int minute  = calendar.get(Calendar.MINUTE);            //得到分钟
                        new TimePickerDialog(TrainingActivity.this, new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                //  这个方法是得到选择后的 小时、分钟，分别对应着三个参数 —   hourOfDay、minute
                                finish_time.setText(""+hourOfDay+":"+minute);
                            }
                        }, hourOfDay, minute, true).show();
                        break;
                    default:
                        break;
                }
            }
        });
        initView();     //  绑定id

        //追加到checkBoxList中
        fluent.add(fluent1);fluent.add(fluent2);fluent.add(fluent3);
        checkBoxList.add(checkBox1);
        checkBoxList.add(checkBox2);
        checkBoxList.add(checkBox3);
        checkBoxList.add(checkBox4);
        checkBoxList.add(checkBox5);
        checkBoxList.add(checkBox6);
        checkBoxList.add(checkBox7);
        checkBoxList.add(checkBox8);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();       //字符流跟字符串差不多，不过这样节省资源
                for (CheckBox checkbox : checkBoxList) {        //遍历一遍集合
                    if (checkbox.isChecked()) {                 //isChecked()是组件是否被选中，选中返回true,否则返回false
                        sb.append(checkbox.getText().toString() + "\n\n");      //StringBuffer.append是字符串拼接
                    }
                }

                Intent i = new Intent(TrainingActivity.this, MainActivity.class);  // 进去MainActivity
                startActivity(i);
                // tvShow.setText(sb);//显示
            }
        });
    }
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
    private void initView() {
        checkBox1 = findViewById(R.id.domain1);
        checkBox2 = findViewById(R.id.domain2);
        checkBox3 = findViewById(R.id.domain3);
        checkBox4 = findViewById(R.id.domain4);
        checkBox5 = findViewById(R.id.domain5);
        checkBox6 = findViewById(R.id.domain6);
        checkBox7 = findViewById(R.id.domain7);
        checkBox8 = findViewById(R.id.domain8);
        fluent1 = findViewById(R.id.fluent1);
        fluent2 = findViewById(R.id.fluent2);
        fluent3 = findViewById(R.id.fluent3);
        back = (ImageView)findViewById(R.id.train_back);
        //tvShow = findViewById(R.id.tv_show);显示
        //btnQueDing = findViewById(R.id.btn_Queding);
    }


    public static void unCheck(List<CheckBox> checkBoxList) {
        for (CheckBox chb : checkBoxList) {
            chb.setChecked(false);
        }
    }
    /**
     * 获取单选值
     *
     * @param checkBoxList
     * @return String 单选值
     */
    public static String getOne(List<CheckBox> checkBoxList) {
        String tag = "";
        for (CheckBox chb : checkBoxList) {
            if (chb.getTag() == null) {
                continue;
            }
            if (chb.isChecked()) {
                tag = chb.getTag().toString();
                break;
            }
        }
        return tag;
    }
}