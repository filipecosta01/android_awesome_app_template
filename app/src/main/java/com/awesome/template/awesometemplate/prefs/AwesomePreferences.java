package com.awesome.template.awesometemplate.prefs;

import android.content.SharedPreferences;

public class AwesomePreferences {

    SharedPreferences mSharedPreferences = null;

    public static final String EXAMPLE_KEY = "key_example";

    public AwesomePreferences(final SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public String getExample() {
        return mSharedPreferences.getString(EXAMPLE_KEY, "Data not found.");
    }

    public void setExample(final String example) {
        mSharedPreferences.edit().putString(EXAMPLE_KEY, example).apply();
    }
}
