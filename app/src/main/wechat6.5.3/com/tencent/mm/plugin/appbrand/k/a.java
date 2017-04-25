package com.tencent.mm.plugin.appbrand.k;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class a {
    private static volatile ad ckz;
    private static final Object dSD = new Object();
    private static final Set<Object> dSE = new HashSet();
    private static final char[] dSF = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] dSG = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    public static long Sm() {
        return be.Nh();
    }

    public static String d(int i, Object... objArr) {
        return aa.getResources().getString(i, objArr);
    }

    public static <T> T aC(T t) {
        if (t != null) {
            dSE.add(t);
        }
        return t;
    }

    public static void aD(Object obj) {
        if (obj != null) {
            dSE.remove(obj);
        }
    }

    public static void Sn() {
        if (ckz != null) {
            synchronized (dSD) {
                if (ckz != null) {
                    ckz.htb.quit();
                    ckz = null;
                }
            }
        }
    }

    public static ad vA() {
        if (ckz == null) {
            synchronized (dSD) {
                ckz = new ad("SubCoreAppBrand#WorkerThread");
            }
        }
        return ckz;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ad.o(runnable);
        } else {
            runnable.run();
        }
    }

    public static void bt(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842936, 16842937});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void bu(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void hG(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.nFI, com.tencent.mm.ui.MMFragmentActivity.a.nFJ);
        }
    }

    public static void p(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                p((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }

    public static String ou(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < dSF.length) {
                String str2 = dSG[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != dSF.length) {
                stringBuffer.append(dSF[i2]);
                i = dSG[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }
}
