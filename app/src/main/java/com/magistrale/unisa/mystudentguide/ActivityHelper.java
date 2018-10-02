/*
 * ActivityHelper.java
 *
 * Copyright (c) 2018 myStudentGuide App
 */

// Package
package com.magistrale.unisa.mystudentguide;

// External Packages
import android.app.Activity;
import android.content.pm.ActivityInfo;

// ActivityHelper Class
public class ActivityHelper {

    public static void initialize(Activity activity) {

        //FORCE SCREEN ORIENTATION LOCKED ON PORTRAIT
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
