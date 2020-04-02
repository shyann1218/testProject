package com.yaxon.mylibrary.protocol;


import com.yaxon.mylibrary.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 请求参数接口
 * Created by xieyuang on 2017/6/26.
 */

public interface RetrofitService {

	String LOGIN = "login.do";  //登录
	/**
	 * 登录
	 * @param parms   请求参数
	 * @return Call<LoginBean>
	 */
	@POST(LOGIN)
	Observable<LoginBean> login(@Body RequestBody parms);

}
