package com.awesome.template.awesometemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.awesome.template.awesometemplate.prefs.AwesomePreferences;
import javax.inject.Inject;

public class AwesomeActivity extends AppCompatActivity {

    @Inject AwesomePreferences mAwesomePreferences;
    @BindView(R.id.tv_main) TextView mTextView;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awesome);

        AwesomeApplication.get().getAppComponent().inject(this);

        mAwesomePreferences.setExample("Y");

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTextView.setText(mAwesomePreferences.getExample());
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();

        super.onDestroy();
    }
}
