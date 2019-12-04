package com.example.snugalpha.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkTest {
    static String name;
    static String telephone;
    static String id;

    public static void main(String[] args) {
        Network.init();
        //register();
       //login();
        //getuserInfo();
       // getalterUserInfo();
        //getviewTask();
       // getaddTask();
        //getalterTask();
        //getviewSysTask();
      // getTaskfeedback();
    }
    private static void getTaskfeedback() {
        Network.api.getTaskFeedback(new TaskFeedbackUser(1,40,1,"1")).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

    private  static  void  getviewSysTask(){
        Network.api.getviewSysTask(new viewSysTask(20,"健康的饮食")).enqueue(new Callback<viewSysTaskResponse>() {
            @Override
            public void onResponse(Call<viewSysTaskResponse> call, Response<viewSysTaskResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<viewSysTaskResponse> call, Throwable t) {

            }
        });
    }

    private static void getalterTask(){
        Network.api.getalterTask(new alterUserTask("记得约会","2019-12-1 23:10:00","2019-12-1 23:30:00",1,1)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
    private static void getaddTask(){
        Network.api.getaddTask(new UserTask("记得跑步","2019-02-26 23:10:00","2019-12-1 23:30:00",5)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

   private static void login(){
        Network.api.login(new LoginUser("666","666")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
   }
    private static void getviewTask(){
        Network.api.getviewTask(new viewTask(5,"2019-02-26 23:10:00")).enqueue(new Callback<viewTaskResponse>() {
            @Override
            public void onResponse(Call<viewTaskResponse> call, Response<viewTaskResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<viewTaskResponse> call, Throwable t) {

            }
        });
    }
    private static void getalterUserInfo(){
        Network.api.getalterUserInfo(new alterUserInfo(1,"我kaixin","aaa","sss","321")).enqueue(
                new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        System.out.println(response.body().msg);
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    }
                }
        );
    }
    private static void getuserInfo(){
        Network.api.getuserInfo(new userInfo(1)).enqueue(new Callback<UserInfoResponse>() {
            @Override
            public void onResponse(Call<UserInfoResponse> call, Response<UserInfoResponse> response) {
                System.out.println(response.body().msg);
            }

            @Override
            public void onFailure(Call<UserInfoResponse> call, Throwable t) {

            }
        });
    }
    private static void register() {
        Network.api.register(new UserDto("666","666","666")).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
              System.out.println(response.body().msg);
            //  Log.d("msg",response.body().msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
}
