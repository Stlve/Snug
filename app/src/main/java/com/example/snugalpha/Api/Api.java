package com.example.snugalpha.Api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("register")
    Call<RegisterResponse> register(@Body UserDto user);

    @POST("login")
    Call<LoginResponse> login(@Body LoginUser loginUser);

    @POST("userInfo")
    Call<UserInfoResponse> getuserInfo(@Body userInfo userInfo);

    @POST("alterUserInfo")
    Call<RegisterResponse> getalterUserInfo(@Body alterUserInfo alterUserInfo);

    @POST("viewTask")
    Call<viewTaskResponse> getviewTask(@Body viewTask viewTask);

    @POST("addTask")
    Call<RegisterResponse> getaddTask(@Body UserTask userTask);

    @POST("alterTask")
    Call<RegisterResponse> getalterTask(@Body alterUserTask alterUserTask);

    @POST("viewSysTask")
    Call<viewSysTaskResponse> getviewSysTask(@Body viewSysTask viewSystask);

    @POST("taskFeedback")
    Call<RegisterResponse> getTaskFeedback(@Body TaskFeedbackUser taskFeedbackUser);
}
