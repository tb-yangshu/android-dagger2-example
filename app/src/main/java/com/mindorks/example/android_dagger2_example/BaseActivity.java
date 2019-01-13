package com.mindorks.example.android_dagger2_example;

import android.support.v7.app.AppCompatActivity;

import com.mindorks.example.android_dagger2_example.di.component.ActivityComponent;
import com.mindorks.example.android_dagger2_example.di.component.DaggerActivityComponent;

/**
 * BaseActivity
 *
 * @author tianbin03
 * @date 2019/1/13.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityComponent activityComponent;

    protected ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }
}
