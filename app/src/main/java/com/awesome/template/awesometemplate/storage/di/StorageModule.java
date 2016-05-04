package com.awesome.template.awesometemplate.storage.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class StorageModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(final Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
