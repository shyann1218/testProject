package com.yaxon.mylibrary.protocol;




import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 获取RetrofitService实例
 * Created by xieyufang on 2020/03/11.
 */

public class RetrofitHelper {

	private static RetrofitHelper retrofitHelper;
	private RetrofitService retrofitService;

	public static RetrofitHelper getInstance() {
		return retrofitHelper == null ? retrofitHelper = new RetrofitHelper() : retrofitHelper;
	}

	private RetrofitHelper() {
		// 初始化Retrofit
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constant.URL.HOST)
				.addConverterFactory(GsonConverterFactory.create()) // json解析
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
				.build();
		retrofitService = retrofit.create(RetrofitService.class);
	}

	public RetrofitService getRetrofitService() {
		return retrofitService;
	}
}
