package com.example.myapplication.core;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {
    private static NetWorkManager mInstance;
        private Retrofit retrofit;
        private static final String BASE_URL = "网址前缀在这里";
        private NetWorkManager(){
            init();
        }
        public static NetWorkManager getInstance(){
            if (mInstance==null){
                mInstance = new NetWorkManager();
            }
            return mInstance;
        }
        /**
         * 初始化必要对象和参数
         */
        private void init() {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // 初始化okhttp
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
            // 初始化Retrofit
            retrofit = new Retrofit.Builder()
                    .client(client)//添加自定义的OKHhttp
                    .baseUrl(BASE_URL)//设置base_url
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//rxjava处理回调的数据
                    .addConverterFactory(GsonConverterFactory.create())//gson数据转换器
                    .build();
        }
        //把接口的注解翻译为OKhttp请求
        public <T> T create(final Class<T> service) {
            return retrofit.create(service);
        }
}