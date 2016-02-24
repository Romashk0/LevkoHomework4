package com.levko.roma.levkohomework4;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {

    private static int cTheme;

    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;

        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity, int theme) {
        switch (cTheme) {
            default:
            case Constants.THEME_1:
                activity.setTheme(R.style.AppTheme);
                break;
            case Constants.THEME_2:
                activity.setTheme(R.style.AppTheme2);
                break;
        }
    }
}
