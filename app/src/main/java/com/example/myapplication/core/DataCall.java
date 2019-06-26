package com.example.myapplication.core;

public interface DataCall<T> {
    void success(T data);
    void fail();
}
