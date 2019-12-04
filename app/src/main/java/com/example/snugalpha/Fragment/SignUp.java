package com.example.snugalpha.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.snugalpha.Api.LoginResponse;
import com.example.snugalpha.Api.LoginUser;
import com.example.snugalpha.Api.Network;
import com.example.snugalpha.Api.RegisterResponse;
import com.example.snugalpha.Api.UserDto;
import com.example.snugalpha.MainActivity;
import com.example.snugalpha.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends Fragment {

    private View view;
    private static Context mContext;
    private EditText editText1;
    private EditText editText2;
    private EditText user_name;
    private EditText phone;
    private static String registerphone,registerpassword,registername;
    private static String getlogin_name, getlogin_telephone;
    private  static String getlogin_id;
    //  Button get_code;
    Button btn_sign_up;
    private TextInputLayout til1,til2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up,container,false);
        mContext = view.getContext();
        //get_code=view.findViewById(R.id.get_code);
        btn_sign_up = view.findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO:注册按钮
                editText1 = view.findViewById(R.id.input_edit);   // 密码
                editText2 = view.findViewById(R.id.match_edit);     //确认密码
                user_name =view.findViewById(R.id.edit_text);    //
                phone=view.findViewById(R.id.phone);  //获得昵称
                if(user_name==null){
                    Toast.makeText(mContext,"用户名不能为空", Toast.LENGTH_LONG).show();
                }
//                String serch_textip=mEdit1.getText().toString().trim();
//                if(serch_textip.length()==0)                              //判断IP输入框是否为空
                else if(editText1.getText().toString().trim().length()==0||editText2.getText().toString().trim().length()==0){
                    Toast.makeText(mContext,"密码不能为空", Toast.LENGTH_LONG).show();
                }
                else if(!editText1.getText().toString().trim().equals(editText2.getText().toString().trim())){
                    Toast.makeText(mContext,"密码不一致，请重新输入", Toast.LENGTH_LONG).show();
                    Toast.makeText(mContext,"两次密码不相同", Toast.LENGTH_LONG).show();
                }
                else {
                    registername = user_name.getText().toString();
                    registerpassword= editText1.getText().toString();
                    registerphone = phone.getText().toString();
                    register();
                    login();
                    Intent i = new Intent(mContext, MainActivity.class);
                    //  i.putExtra("id", get_login_id);
                    startActivity(i);

                }
            }
        });

        return view;
    }
    private void register() {
        Network.api.register(new UserDto(registername,registerphone,registerpassword)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().getMsg());
                //  Log.d("msg",response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

    private static void login(){
        Network.api.login(new LoginUser(registerphone,registerpassword)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                System.out.println(response.body().msg);
                getlogin_id = response.body().data.id;
                getlogin_name = response.body().data.name;
                getlogin_telephone = response.body().data.telephone;
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
