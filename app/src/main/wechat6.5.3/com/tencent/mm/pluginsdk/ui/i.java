package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class i {
    public static boolean u(final Context context, final String str, final String str2) {
        if (!ab.Ki("wap_reporter_shown")) {
            return false;
        }
        g.a(context, 2131234553, 2131231164, 2131231142, 2131231010, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Context context = context;
                String str = str;
                String str2 = str2;
                if (context == null) {
                    v.w("Micromsg.NetworkErrAlert", "reportViaWap: context is null");
                    return;
                }
                if (str == null) {
                    v.w("Micromsg.NetworkErrAlert", "reportViaWap: ip is null");
                }
                if (str2 == null) {
                    v.w("Micromsg.NetworkErrAlert", "reportViaWap: errMsg is null");
                }
                ak.yW();
                String str3 = (String) c.vf().get(2, null);
                str3 = ((("http://w.mail.qq.com/cgi-bin/mmfeedback?t=mmfeedback&f=xhtml" + "&u=" + Base64.encodeToString(str3.getBytes(), 8)) + "&i=" + Base64.encodeToString(be.ah(str, SQLiteDatabase.KeyEmpty).getBytes(), 8)) + "&e=" + Base64.encodeToString(be.ah(str2, SQLiteDatabase.KeyEmpty).getBytes(), 8)) + "&autologin=n";
                v.d("Micromsg.NetworkErrAlert", "upload error to " + str3);
                be.E(context, str3);
            }
        }, null);
        return true;
    }

    public static boolean dl(final Context context) {
        if (!ab.Ki("network_doctor_shown")) {
            return false;
        }
        g.a(context, 2131234028, 2131231164, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
        }, null);
        return true;
    }
}
