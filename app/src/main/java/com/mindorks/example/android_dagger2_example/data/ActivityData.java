package com.mindorks.example.android_dagger2_example.data;

import com.mindorks.example.android_dagger2_example.di.PerActivity;

import javax.inject.Inject;

/**
 * ActivityData
 * Created by tianbin on 17/2/13.
 */
@PerActivity
public class ActivityData {

    @Inject
    public ActivityData() {
    }
}
