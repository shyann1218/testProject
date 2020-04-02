package com.yaxon.mylibrary.bean;


import com.yaxon.mylibrary.protocol.RetrofitHelper;
import com.yaxon.mylibrary.protocol.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 登录
 */
public class LoginProtocol {

	private static LoginProtocol loginProtocol;
	private RetrofitService retrofitService;

	public static LoginProtocol getInstance() {
		return loginProtocol == null ? loginProtocol = new LoginProtocol() : loginProtocol;
	}

	private LoginProtocol() {
		retrofitService = RetrofitHelper.getInstance().getRetrofitService();
	}


	/**
	 * 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return  Call<LoginBean>
	 */
	public Observable<LoginBean> login(String username, String password) {

		JSONObject json = new JSONObject();
		try {
			json.put("userName", username);
			json.put("passWord", password);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString() );

		return retrofitService.login(body)
				.subscribeOn(Schedulers.io())// 在子线程中进行Http访问
				.observeOn(AndroidSchedulers.mainThread()); // UI线程处理返回接口
	}

}
