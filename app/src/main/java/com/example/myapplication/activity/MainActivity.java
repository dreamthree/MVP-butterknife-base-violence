package com.example.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.bean.UserInfo;
import com.example.myapplication.core.DataCall;
import com.example.myapplication.core.Result;
import com.example.myapplication.precenter.LoginPrecenter;

public class MainActivity extends AppCompatActivity {
    LoginPrecenter loginPrecenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化precenter
        loginPrecenter=new LoginPrecenter(new LoginData());
        //发送登录参数
        loginPrecenter.reqeust(1,2);
    }
    private class LoginData implements DataCall<Result<UserInfo>> {
        //成功的回调
        @Override
        public void success(Result<UserInfo> data) {
            if (data.getStatus().equals("0000")){
                Toast.makeText(MainActivity.this, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        //失败的回调
        @Override
        public void fail() {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPrecenter.unBind();
    }
}
