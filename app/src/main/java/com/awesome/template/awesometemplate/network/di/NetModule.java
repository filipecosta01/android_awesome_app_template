package com.awesome.template.awesometemplate.network.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    String mBaseUrl;

    public NetModule(final String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(final Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(final Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson(final Application application) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final Cache cache) {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().cache(cache);
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final Gson gson, final OkHttpClient okHttpClient) {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(mBaseUrl)
            .client(okHttpClient)
            .build();
    }
}
