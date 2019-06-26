package com.example.myapplication.precenter;

import com.example.myapplication.core.DataCall;
import com.example.myapplication.core.NetWorkManager;
import com.example.myapplication.http.IRequest;

import io.reactivex.Observable;

public class LoginPrecenter extends BasePrecenter{
    public LoginPrecenter(DataCall dataCall) {
        super(dataCall);
    }
    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = NetWorkManager.getInstance().create(IRequest.class);
        return iRequest.loginRx((String)args[0],(String)args[1]);
    }
}
