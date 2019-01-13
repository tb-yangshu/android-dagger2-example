package com.mindorks.example.android_dagger2_example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.mindorks.example.android_dagger2_example.data.ActivityData;
import com.mindorks.example.android_dagger2_example.data.ActivityDataWithScope;
import com.mindorks.example.android_dagger2_example.data.AppData;
import com.mindorks.example.android_dagger2_example.data.DataManager;
import com.mindorks.example.android_dagger2_example.data.model.User;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    DataManager mDataManager;

    @Inject
    ActivityData mActivityData;

    @Inject
    ActivityDataWithScope mActivityDataWithScope;

    @Inject
    AppData appData;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if (token != null) {
            mTvAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
