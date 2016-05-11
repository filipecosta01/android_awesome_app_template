package com.awesome.template.awesometemplate.storage.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.awesome.template.awesometemplate.prefs.AwesomePreferences;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class StorageModule {

    @Provides
    @Singleton
    AwesomePreferences provideAwesomePreferences(final Application application) {
        return new AwesomePreferences(PreferenceManager.getDefaultSharedPreferences(application));
    }
}
