package com.magistrale.unisa.mystudentguide;

import android.app.Activity;
import android.content.pm.ActivityInfo;

public class ActivityHelper {
    public static void initialize(Activity activity) {
        //FORCE SCREEN ORIENTATION LOCKED ON PORTRAIT
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
