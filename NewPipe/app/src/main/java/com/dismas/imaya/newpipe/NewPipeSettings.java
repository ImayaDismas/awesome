package com.dismas.imaya.newpipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import java.io.File;

/**
 * Created by imaya on 3/25/16.
 */
public class NewPipeSettings {

    private NewPipeSettings() {
    }

    public static void initSettings(Context context) {
        PreferenceManager.setDefaultValues(context, R.xml.settings, false);
        getVideoDownloadFolder(context);
        getAudioDownloadFolder(context);
    }

    public static File getDownloadFolder() {
        return getFolder(Environment.DIRECTORY_DOWNLOADS);
    }

    public static File getVideoDownloadFolder(Context context) {
        return getFolder(context, R.string.download_path_key, Environment.DIRECTORY_MOVIES);
    }

    public static File getAudioDownloadFolder(Context context) {
        return getFolder(context, R.string.download_path_audio_key, Environment.DIRECTORY_MUSIC);
    }

    private static File getFolder(Context context, int keyID, String defaultDirectoryName) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final String key = context.getString(keyID);
        String downloadPath = prefs.getString(key, null);
        if ((downloadPath != null) && (!downloadPath.isEmpty())) return new File(downloadPath.trim());

        final File folder = getFolder(defaultDirectoryName);
        SharedPreferences.Editor spEditor = prefs.edit();
        spEditor.putString(key
                , new File(folder,"NewPipe").getAbsolutePath());
        spEditor.apply();
        return folder;
    }

    @NonNull
    private static File getFolder(String defaultDirectoryName) {
        return new File(Environment.getExternalStorageDirectory(),defaultDirectoryName);
    }
}