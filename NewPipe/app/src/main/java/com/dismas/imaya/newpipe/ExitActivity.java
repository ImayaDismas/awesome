package com.dismas.imaya.newpipe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by imaya on 3/25/16.
 */
public class ExitActivity extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            finish();
        }

        System.exit(0);
    }

    public static void exitAndRemoveFromRecentApps(Activity activity) {
        Intent intent = new Intent(activity, ExitActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NO_ANIMATION);

        activity.startActivity(intent);
    }
}
