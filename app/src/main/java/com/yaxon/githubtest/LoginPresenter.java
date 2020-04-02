package com.yaxon.githubtest;

import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.yaxon.mylibrary.bean.LoginBean;
import com.yaxon.mylibrary.bean.LoginProtocol;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginPresenter extends BasePresenter {
    private LoginProtocol mLoginProtocol;

    public LoginPresenter(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        mLoginProtocol = LoginProtocol.getInstance();
    }

    /**
     * 登录
     *
     * @param username 登录帐号
     * @param password 密码
     */
    public void login(String username, String password) {
        sendLogin(username, password);

    }

    /**
     * 发送登录请求
     *
     * @param username 用户名
     * @param password 密码
     */
    private void sendLogin(String username, String password) {
        Disposable dispose =  mLoginProtocol.login(username, password)
                .compose(getProvider().<LoginBean>bindUntilEvent(ActivityEvent.DESTROY)) // onDestroy取消订阅
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean expressInfo) throws Exception {

                        Log.v("loginprotocol", expressInfo.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }


    /**
     * 当页面销毁的时候,需要把View=null,
     * 然后调用 System.gc();//尽管不会马上回收，只是通知jvm可以回收了，等jvm高兴就会回收
     */
    @Override
    public void onDestroy() {
        System.gc();
    }
}
