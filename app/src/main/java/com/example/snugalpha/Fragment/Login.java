package com.example.snugalpha.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.snugalpha.Api.LoginUser;
import com.example.snugalpha.Api.Network;
import com.example.snugalpha.Api.LoginResponse;
import com.example.snugalpha.MainActivity;
import com.example.snugalpha.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.snugalpha.Api.LoginResponse.Data.datas;


public class Login extends Fragment {

    private View view;
    private Context mContext;
    Button btn_login;
    private EditText name;
    private EditText telephone;
    private EditText password;
    private static String login_name, login_telephone, login_password;
    private static String get_login_name, get_login_telephone;
    private  static String get_login_id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        mContext = view.getContext();
      //  name = view.findViewById(R.id.login_telephone);
        telephone = view.findViewById(R.id.login_telephone);
        password = view.findViewById(R.id.input_edit);
        btn_login = view.findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // login_name = name.getText().toString();
                login_password = password.getText().toString();
                login_telephone = telephone.getText().toString();
                    login();

                Intent i = new Intent(mContext, MainActivity.class);
                //  i.putExtra("id", get_login_id);
                startActivity(i);
            }
        });
        return view;
    }
    private static void login(){
        Network.api.login(new LoginUser(login_telephone,login_password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                System.out.println(response.body().msg);
                String name = response.body().data.name;
                String telephone = response.body().data.telephone;
                int id = response.body().data.id;
                LoginResponse.Data data = new LoginResponse.Data(name,telephone,id);
                LoginResponse.Data.setDatas(data);
//                LoginResponse.Data.data.setId(id);//response.body().data
//                LoginResponse.Data.data.setName(name);
//                LoginResponse.Data.data.setTelephone(telephone);
               // System.out.println(LoginResponse.Data.getData().id);
                System.out.println("这里是测试"+LoginResponse.Data.getDatas());

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }


}
