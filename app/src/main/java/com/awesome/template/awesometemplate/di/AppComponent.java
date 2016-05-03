package com.awesome.template.awesometemplate.di;

import android.app.Application;
import com.awesome.template.awesometemplate.AwesomeActivity;
import com.awesome.template.awesometemplate.network.di.NetModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(Application application);
    void inject(AwesomeActivity activity);

    Application getApplication();
}
