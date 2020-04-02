package com.yaxon.githubtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxFragmentActivity;
import com.yaxon.mylibrary.bean.LoginBean;
import com.yaxon.mylibrary.bean.LoginProtocol;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends RxFragmentActivity {

    private LoginPresenter mLoginPresenter;
    private LoginProtocol loginprotocol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mLoginPresenter = new LoginPresenter(this);
//        findViewById(R.id.text_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mLoginPresenter.login("13459272002", "000000");
//            }
//        });

        loginprotocol = LoginProtocol.getInstance();
        findViewById(R.id.text_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable dispose =  loginprotocol.login("13459272002", "000000")
                        .subscribe(new Consumer<LoginBean>() {
                            @Override
                            public void accept(LoginBean expressInfo) throws Exception {

                                Log.v("loginprotocol", expressInfo.toString());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.v("loginprotocol", "fail");
                            }
                        });
            }
        });
    }
}
