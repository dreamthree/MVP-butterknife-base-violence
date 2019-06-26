package com.example.myapplication.core;

public class Result<T> {
    String message;
    String status;
    T result;
    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Result(String message, String status, T result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }
}
