package com.example.myapplication.precenter;

import com.example.myapplication.core.DataCall;
import com.example.myapplication.core.Result;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePrecenter {
    private DataCall dataCall;
        private boolean running;
        public BasePrecenter(DataCall dataCall) {
            this.dataCall = dataCall;
        }

        protected abstract Observable observable(Object... args);

        public void reqeust(Object... args) {
            if (running) {
                return;
            }
            running = true;
                observable(args)
                        .compose(new ObservableTransformer() {
                            @Override
                            public ObservableSource apply(Observable upstream) {
                                return upstream.subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread());
                            }
                        })
                        .subscribe(new Consumer<Result>() {
                            @Override
                            public void accept(Result result) throws Exception {
                                dataCall.success(result);
                                running = false;
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                // 处理异常,请求失败
                                running = false;
                            }
                        });
        }
        public boolean isRunning() {
            return running;
        }
        public void unBind() {
            dataCall = null;
        }
}
