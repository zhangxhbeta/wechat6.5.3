package com.tencent.mm.pluginsdk.i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;

public final class a {
    public static boolean a(final Activity activity, final String str, final int i, String str2, String str3) {
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            return true;
        }
        try {
            if (android.support.v4.content.a.d(activity, str) == 0) {
                return true;
            }
            if (be.kS(str3)) {
                android.support.v4.app.a.a(activity, new String[]{str}, i);
            } else {
                g.a((Context) activity, str3, str2, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        android.support.v4.app.a.a(activity, new String[]{str}, i);
                    }
                });
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e);
            return true;
        }
    }

    public static boolean aP(Context context, String str) {
        try {
            int d = android.support.v4.content.a.d(context, str);
            if (d != 0) {
                return false;
            }
            int i;
            String str2 = null;
            if (str.equals("android.permission.READ_CONTACTS")) {
                str2 = "android.permission.WRITE_CONTACTS";
            } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                str2 = "android.permission.READ_CONTACTS";
            }
            if (be.kS(str2)) {
                i = d;
            } else {
                try {
                    i = android.support.v4.content.a.d(context, str2);
                } catch (Exception e) {
                    v.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", e);
                    return false;
                }
            }
            if (i == 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            v.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", e2);
            return false;
        }
    }

    public static void e(Activity activity, String str) {
        android.support.v4.app.a.a(activity, new String[]{str}, 80);
    }
}
