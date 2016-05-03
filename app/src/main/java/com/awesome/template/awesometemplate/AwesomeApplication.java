package com.awesome.template.awesometemplate;

import android.app.Application;
import android.content.Context;
import com.awesome.template.awesometemplate.di.AppComponent;
import com.awesome.template.awesometemplate.di.AppModule;
import com.awesome.template.awesometemplate.di.DaggerAppComponent;
import com.awesome.template.awesometemplate.network.di.NetModule;

public class AwesomeApplication extends Application {
    private AppComponent mAppComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        setContext(getApplicationContext());

        initGraph();
    }

    public static AwesomeApplication get() {
        return (AwesomeApplication) mContext.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void initGraph() {
        mAppComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .netModule(new NetModule("Bla"))
            .build();
        mAppComponent.inject(this);
    }

    public static void setContext(final Context mContext) {
        AwesomeApplication.mContext = mContext;
    }
}
