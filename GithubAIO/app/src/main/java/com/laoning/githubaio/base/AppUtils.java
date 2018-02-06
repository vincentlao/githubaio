

package com.laoning.githubaio.base;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.laoning.githubaio.GithubAioApp;

import java.util.Locale;

/**
 * Created on 2017/10/30 11:23:03
 * Copied from Copyright (C) 2017 Kosh.
 * Modified by Copyright (C) 2017 ThirtyDegreesRay.
 */

public class AppUtils {

    private static final String DOWNLOAD_SERVICE_PACKAGE_NAME = "com.android.providers.downloads";

    public static boolean checkApplicationEnabledSetting(Context context, String packageName) {
        int state = context.getPackageManager().getApplicationEnabledSetting(packageName);
        return state == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT ||
                state == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
    }

    public static boolean checkDownloadServiceEnabled(Context context) {
        return checkApplicationEnabledSetting(context, DOWNLOAD_SERVICE_PACKAGE_NAME);
    }

    public static void showDownloadServiceSetting(Context context) {
        try {
            Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + DOWNLOAD_SERVICE_PACKAGE_NAME));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    private static void updateResources(Context context, String language) {
        Locale locale = getLocale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    private static void updateResourcesLegacy(Context context, String language) {
        Locale locale = getLocale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @NonNull
    public static Locale getLocale(String language) {
        Locale locale;
        if (language.equalsIgnoreCase("zh-rCN")) {
            return Locale.SIMPLIFIED_CHINESE;
        } else if (language.equalsIgnoreCase("zh-rTW")) {
            return Locale.TRADITIONAL_CHINESE;
        }
        String[] array = language.split("-");
        if (array.length > 1) {
            locale = new Locale(array[0], array[1]);
        } else {
            locale = new Locale(language);
        }
        return locale;
    }


    public static boolean isLandscape(@NonNull Resources resources) {
        return resources.getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @SuppressWarnings("WeakerAccess")
    public static void showKeyboard(@NonNull View v, @NonNull Context activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v, 0);
    }

    public static void showKeyboard(@NonNull View v) {
        showKeyboard(v, v.getContext());
    }

    public static void hideKeyboard(@NonNull View view) {
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
