package com.gosuncn.mvpdemo.service;

import android.util.Log;

import com.gosuncn.mvpdemo.api.BookApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weiye on 2018/5/5 0005.
 */

public class RetrofitService {
    private static final String TAG=RetrofitService.class.getSimpleName();
    private static final String Base_URL="http://120.79.145.157:8080/web_library/";
    private static final long TIMEOUT = 30;
    private Retrofit mretrofit;




       public RetrofitService(){
           mretrofit=new Retrofit.Builder()
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .addConverterFactory(GsonConverterFactory.create())
                   .baseUrl(Base_URL)
                   .client(initOkhttpClient())
                   .build();

       }


       public  OkHttpClient initOkhttpClient(){
           // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
           OkHttpClient httpClient = new OkHttpClient.Builder()
                   // 添加通用的Header
                   .addInterceptor(new Interceptor() {
                       @Override
                       public Response intercept(Chain chain) throws IOException {
                           Request.Builder builder = chain.request().newBuilder();
                           // 替换为自己的token
                           builder.addHeader("token", "123");
                           return chain.proceed(builder.build());
                       }
                   })
            /*
            这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
             */
                   .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                       @Override
                       public void log(String message) {
                           Log.e(TAG,"message="+message);
                       }
                   }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                   .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                   .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                   .build();

                   return httpClient;
       }

    public static RetrofitService getInstance(){
        return SingleInstance.INSTANVE;
    }
    private static class SingleInstance{
        private static final RetrofitService INSTANVE=new RetrofitService();
    }
    public BookApi getBookApi(){
        return  mretrofit.create(BookApi.class);
    }
}
