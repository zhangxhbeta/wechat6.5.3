package com.samsung.android.sdk.look;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Parcelable;
import android.os.SystemProperties;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;
import com.tencent.mmdb.FileUtils;

public final class Slook implements SsdkInterface {
    public static final int AIRBUTTON = 1;
    private static final int NOT_ASSIGN = -1;
    public static final int SMARTCLIP = 2;
    public static final int SPEN_BEZEL_INTERACTION = 5;
    public static final int SPEN_HOVER_ICON = 4;
    private static final String TAG = "Slook";
    public static final int WRITINGBUDDY = 3;
    private static int mVersionCode = -1;

    public static class VERSION_CODES {
        public static final int L1 = 1;
    }

    public final int getVersionCode() {
        if (mVersionCode != -1) {
            return mVersionCode;
        }
        try {
            mVersionCode = SystemProperties.getInt("ro.slook.ver", 0);
        } catch (Exception e) {
            mVersionCode = 0;
        }
        return mVersionCode;
    }

    public final String getVersionName() {
        return "1.0.1";
    }

    public final void initialize(Context context) {
        if (!SsdkVendorCheck.isSamsungDevice()) {
            throw new SsdkUnsupportedException("This device is not samsung product.", 0);
        } else if (getVersionCode() <= 0) {
            throw new SsdkUnsupportedException("This device is not supported.", 1);
        } else {
            try {
                insertLog(context);
            } catch (SecurityException e) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            }
        }
    }

    public final boolean isFeatureEnabled(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (getVersionCode() > 0) {
                    return SlookImpl.isFeatureEnabled(i);
                }
                return false;
            default:
                throw new IllegalArgumentException("The type(" + i + ") is not supported.");
        }
    }

    private void insertLog(Context context) {
        int i = -1;
        try {
            i = context.getPackageManager().getPackageInfo("com.samsung.android.providers.context", FileUtils.S_IWUSR).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (i <= 1) {
            return;
        }
        if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            throw new SecurityException();
        }
        Parcelable contentValues = new ContentValues();
        String name = getClass().getPackage().getName();
        String str = context.getPackageName() + "#" + getVersionCode();
        contentValues.put("app_id", name);
        contentValues.put("feature", str);
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
        intent.putExtra("data", contentValues);
        intent.setPackage("com.samsung.android.providers.context");
        context.sendBroadcast(intent);
    }
}
