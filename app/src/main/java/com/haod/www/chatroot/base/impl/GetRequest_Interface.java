package com.haod.www.chatroot.base.impl;

import com.haod.www.chatroot.Constant;
import com.haod.www.chatroot.base.Translation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetRequest_Interface {

    // @GET注解的作用:采用Get方法发送网络请求
    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
    @GET("api?key=80aa4127a6c340da8b6841db0edd78c5&info=nihao")
    Call<Translation> getCall();

    @GET("api?key=80aa4127a6c340da8b6841db0edd78c5&")
    Call<Translation> getCall(@Query("info")String info);

}
