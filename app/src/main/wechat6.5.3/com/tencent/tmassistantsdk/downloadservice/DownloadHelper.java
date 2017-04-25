package com.tencent.tmassistantsdk.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DownloadHelper {
    public static final int PHONE = 1;
    public static final float SAVE_FATOR = 1.5f;
    public static final long SAVE_LENGTH = 104857600;
    public static final int SDCARD = 2;
    public static final String TAG = DownloadHelper.class.getSimpleName();
    public static final int UNKNOWN = 0;

    public static WakeLock getWakeLock() {
        return null;
    }

    public static String correctURL(String str) {
        String trim = str.replace("\r", "").replace("\n", "").trim();
        String str2 = new String(trim);
        try {
            Uri parse = Uri.parse(trim);
            CharSequence lastPathSegment = parse.getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.length() > 0) {
                str2 = str2.replace(lastPathSegment, URLEncoder.encode(parse.getLastPathSegment()).replace("+", "%20"));
            }
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
        }
        return str2;
    }

    public static String genAPKFileName(String str) {
        if (str.contains(".apk")) {
            String trim = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (trim.contains("?")) {
                trim = trim.substring(0, trim.lastIndexOf("?"));
            }
            if (!TextUtils.isEmpty(trim)) {
                TMLog.i(TAG, "file name = " + trim);
                return renameAPKFileName(trim);
            }
        }
        return null;
    }

    public static String decodeFileName(String str) {
        if (str != null) {
            return URLDecoder.decode(str);
        }
        return null;
    }

    public static String correctFileName(String str) {
        return str.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    }

    public static String renameAPKFileName(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf == str.length() - 1) {
            return str;
        }
        String str2;
        String[] strArr = new String[]{str.substring(0, lastIndexOf), str.substring(lastIndexOf, str.length())};
        int i = 0;
        do {
            if (i == 0) {
                str2 = str;
            } else {
                str2 = strArr[0] + "(" + i + ")" + strArr[1];
            }
            i++;
        } while (new File(TMAssistantFile.getSavePathRootDir() + File.separator + str2).exists());
        return str2;
    }

    public static boolean isValidURL(String str) {
        try {
            URI uri = new URI(correctURL(str));
            return true;
        } catch (Throwable th) {
            v.a(TAG, th, "", new Object[0]);
            return false;
        }
    }

    public static String generateFileNameFromURL(String str, String str2) {
        String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
        if (TextUtils.isEmpty(calcMD5AsString)) {
            calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("application/vnd.android.package-archive")) {
                str3 = ".apk";
            } else if (str2.equals("application/tm.android.apkdiff")) {
                str3 = ".diff";
            } else if (str2.equals("resource/tm.android.unknown")) {
                str3 = ".other";
            }
        }
        return calcMD5AsString + str3;
    }

    public static synchronized String getNetStatus() {
        String str;
        synchronized (DownloadHelper.class) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context == null) {
                str = "";
            } else {
                try {
                    if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                        str = "";
                    } else {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            str = "";
                        } else if (activeNetworkInfo.getType() == 1) {
                            str = "wifi";
                        } else {
                            str = activeNetworkInfo.getExtraInfo();
                            if (str == null) {
                                str = "";
                            } else {
                                str = str.toLowerCase();
                                TMLog.v(TAG, "netInfo  =  " + str);
                            }
                        }
                    }
                } catch (Exception e) {
                    str = "";
                }
            }
        }
        return str;
    }

    public static boolean isNetworkConncted() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            TMLog.w(TAG, "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        boolean isAvailable;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            isAvailable = activeNetworkInfo.isAvailable();
        } else {
            isAvailable = false;
        }
        return isAvailable;
    }

    public static boolean isDownloadFileExisted(String str, String str2) {
        try {
            if (new File(TMAssistantFile.getSaveFilePath(generateFileNameFromURL(str, str2))).exists()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return false;
        }
    }

    public static boolean isDownloadFileExisted(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (new File(TMAssistantFile.getSaveFilePath(str)).exists()) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSpaceEnough(java.lang.String r13, long r14) {
        /*
        r10 = 104857600; // 0x6400000 float:3.6111186E-35 double:5.1806538E-316;
        r8 = 4;
        r5 = 0;
        r4 = 1;
        r0 = 0;
        r2 = -1;
        r6 = getStorePosition(r13);
        if (r6 != r4) goto L_0x003d;
    L_0x0011:
        r2 = android.os.Environment.getDataDirectory();
        r3 = new android.os.StatFs;
        r2 = r2.getPath();
        r3.<init>(r2);
        r2 = r3.getBlockSize();
        r6 = (long) r2;
        r2 = r3.getAvailableBlocks();
        r2 = (long) r2;
        r2 = r2 - r8;
        r2 = r2 * r6;
        r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r6 >= 0) goto L_0x0073;
    L_0x002e:
        r2 = (float) r14;
        r3 = 1069547520; // 0x3fc00000 float:1.5 double:5.28426686E-315;
        r2 = r2 * r3;
        r2 = (long) r2;
        r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r6 <= 0) goto L_0x0077;
    L_0x0037:
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0075;
    L_0x003b:
        r0 = r4;
    L_0x003c:
        return r0;
    L_0x003d:
        r7 = 2;
        if (r6 != r7) goto L_0x0073;
    L_0x0040:
        r2 = "mounted";
        r3 = android.os.Environment.getExternalStorageState();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002e;
    L_0x004d:
        r2 = android.os.Environment.getExternalStorageDirectory();
        r2 = r2.getPath();
        r3 = new java.io.File;
        r3.<init>(r2);
        r2 = new android.os.StatFs;
        r3 = r3.getPath();
        r2.<init>(r3);
        r3 = r2.getBlockSize();
        r6 = (long) r3;
        r2 = r2.getAvailableBlocks();
        r2 = (long) r2;
        r2 = r2 - r8;
        r2 = r2 * r6;
        r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r6 < 0) goto L_0x002e;
    L_0x0073:
        r0 = r2;
        goto L_0x002e;
    L_0x0075:
        r0 = r5;
        goto L_0x003c;
    L_0x0077:
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 < 0) goto L_0x007d;
    L_0x007b:
        r0 = r4;
        goto L_0x003c;
    L_0x007d:
        r0 = r5;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadservice.DownloadHelper.isSpaceEnough(java.lang.String, long):boolean");
    }

    public static int getStorePosition(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str != null && str.startsWith("/data")) {
            return 1;
        }
        if (TMAssistantFile.isSDCardExistAndCanWrite()) {
            return 2;
        }
        return 0;
    }
}
