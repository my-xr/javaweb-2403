package com.gzu.ctts.common;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String message;
    private T data;


    public static <T> Result<T> success(T data){
        Result<T>  result = new Result<T> ();
        result.setCode(200);
        result.setMessage("Success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(int code, T data){
        Result<T>  result = new Result<T> ();
        result.setCode(code);
        result.setMessage("Success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(int code, String message){
        Result<T>  result = new Result<T> ();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
