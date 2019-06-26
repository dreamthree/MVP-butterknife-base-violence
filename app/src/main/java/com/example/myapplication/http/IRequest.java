package com.example.myapplication.http;

import com.example.myapplication.core.Result;
import com.example.myapplication.bean.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface  IRequest {
    //登录
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<Result<UserInfo>> loginRx(@Field("phone")String mobile, @Field("pwd")String password);
}
