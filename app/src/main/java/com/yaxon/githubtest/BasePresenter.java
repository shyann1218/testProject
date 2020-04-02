package com.yaxon.githubtest;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

public abstract class BasePresenter {

    private LifecycleProvider<ActivityEvent> provider;

    public BasePresenter(LifecycleProvider<ActivityEvent> provider) {
        this.provider = provider;
    }

    public LifecycleProvider<ActivityEvent> getProvider() {
        return provider;
    }


    /**
     * 当页面销毁的时候,需要把View=null,
     * 然后调用 System.gc();//尽管不会马上回收，只是通知jvm可以回收了，等jvm高兴就会回收
     */
    abstract public void onDestroy();
}
