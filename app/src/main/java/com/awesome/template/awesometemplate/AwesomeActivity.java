package com.awesome.template.awesometemplate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import javax.inject.Inject;

public class AwesomeActivity extends AppCompatActivity {

    @Inject SharedPreferences mSharedPreferences;
    @BindView(R.id.tv_main) TextView mTextView;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awesome);

        AwesomeApplication.get().getAppComponent().inject(this);

        mSharedPreferences.edit().putString("X", "Y").apply();

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTextView.setText(mSharedPreferences.getString("X", "Z"));
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();

        super.onDestroy();
    }
}
