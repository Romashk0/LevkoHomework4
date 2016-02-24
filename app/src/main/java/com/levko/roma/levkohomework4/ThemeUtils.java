package com.levko.roma.levkohomework4;

import android.app.Activity;
import android.content.Intent;

public class ThemeUtils {

    private static int cTheme;
    public final static int THEME_1 = 0;
    public final static int THEME_2 = 1;

    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;

        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity, int theme) {
        switch (cTheme) {
            default:
            case THEME_1:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_2:
                activity.setTheme(R.style.AppTheme2);
                break;
        }
    }
}
