package com.dismas.imaya.newpipe;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by imaya on 3/25/16.
 */
public class ActivityCommunicator {

    private static ActivityCommunicator activityCommunicator = null;

    public static ActivityCommunicator getCommunicator() {
        if(activityCommunicator == null) {
            activityCommunicator = new ActivityCommunicator();
        }
        return activityCommunicator;
    }

    // Thumbnail send from VideoItemDetailFragment to BackgroundPlayer
    public volatile Bitmap backgroundPlayerThumbnail;

    // Sent from any activity to ErrorActivity.
    public volatile List<Exception> errorList;
    public volatile Class returnActivity;
    public volatile ErrorActivity.ErrorInfo errorInfo;
}