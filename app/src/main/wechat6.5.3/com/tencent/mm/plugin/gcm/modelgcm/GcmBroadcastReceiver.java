package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.a;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    static List<Pair<Long, Long>> gAy = new LinkedList();
    private static WakerLock wakerlock = null;

    public static void asO() {
        gAy.clear();
    }

    public void onReceive(Context context, Intent intent) {
        v.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
        String stringExtra;
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            final a asP = a.asP();
            String asR = asP.asR();
            stringExtra = intent.getStringExtra("registration_id");
            v.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + intent.toString());
            if (intent.getStringExtra("error") == null && intent.getStringExtra("unregistered") == null && stringExtra != null && asR.compareTo(stringExtra) != 0) {
                if (z.Mv() == null) {
                    v.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + stringExtra);
                } else {
                    asP.Y(context, stringExtra);
                    z.Mv().post(new Runnable() {
                        public final void run() {
                            asP.asT();
                        }
                    });
                }
            }
            b.itm.a(452, 25, 1, false);
            return;
        }
        a asP2 = a.asP();
        if (asP2 == null || be.kS(asP2.asR())) {
            asR = "GcmBroadcastReceiver";
            stringExtra = "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(asP2 == null);
            objArr[1] = Boolean.valueOf(asP2 == null ? false : asP2.asV());
            v.i(asR, stringExtra, objArr);
            g.iuh.Y(11250, new StringBuilder("1,2").toString());
            b.itm.a(452, asP2 == null ? 26 : 27, 1, false);
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("system_config_prefs", 4);
            if (sharedPreferences.getBoolean("settings_fully_exit", true)) {
                v.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
                g.iuh.Y(11250, new StringBuilder("1,2").toString());
                b.itm.a(452, 28, 1, false);
                return;
            }
            Bundle extras = intent.getExtras();
            a.C(context);
            asR = a.c(intent);
            if (extras.isEmpty()) {
                v.i("GcmBroadcastReceiver", "Intent extras is empty: ");
                g.iuh.Y(11250, new StringBuilder("1,0").toString());
                b.itm.a(452, 29, 1, false);
                return;
            }
            if ("send_error".equals(asR)) {
                v.i("GcmBroadcastReceiver", "Send error: " + extras.toString());
                g.iuh.Y(11250, new StringBuilder("1,1").toString());
                b.itm.a(452, 30, 1, false);
            } else if ("deleted_messages".equals(asR)) {
                v.i("GcmBroadcastReceiver", "Deleted messages on server.");
                g.iuh.Y(11250, new StringBuilder("1,1").toString());
                b.itm.a(452, 31, 1, false);
            } else if ("gcm".equals(asR)) {
                long j;
                b.itm.a(452, 32, 1, false);
                v.i("GcmBroadcastReceiver", "Received gcm msg. extras[%s]", extras.toString());
                stringExtra = extras.getString("seq");
                asR = extras.getString("uin");
                String string = extras.getString("cmd");
                long j2 = be.kS(asR) ? 0 : be.getLong(asR, 0);
                long j3 = be.kS(stringExtra) ? 0 : be.getLong(stringExtra, 0);
                if (be.kS(string)) {
                    j = 0;
                } else {
                    j = be.getLong(string, 0);
                }
                int i = sharedPreferences.getInt("default_uin", 0);
                if (j2 == 0 || !Integer.toHexString(i).equals(Long.toHexString(j2))) {
                    v.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + j2 + ", oldUin:" + i);
                    g.iuh.Y(11250, new StringBuilder("1,3").toString());
                    b bVar = b.itm;
                    if (j2 == 0) {
                        j = 33;
                    } else {
                        j = 34;
                    }
                    bVar.a(452, j, 1, false);
                    return;
                }
                Object obj;
                for (Pair pair : gAy) {
                    if (((Long) pair.first).longValue() == j && ((Long) pair.second).longValue() == j3) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    v.w("GcmBroadcastReceiver", "already has this seq:" + j3);
                    b.itm.a(452, 35, 1, false);
                    return;
                }
                gAy.add(Pair.create(Long.valueOf(j), Long.valueOf(j3)));
                if (gAy.size() > 60) {
                    gAy.remove(0);
                }
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context);
                    v.i("GcmBroadcastReceiver", "start new wakerlock");
                }
                wakerlock.lock(200, "GcmBroadcastReceiver.onReceive");
                com.tencent.mm.sdk.c.b foVar = new fo();
                foVar.beT.type = 13;
                com.tencent.mm.sdk.c.a.nhr.z(foVar);
            }
            v.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
        } catch (Throwable e) {
            v.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + e.toString());
            v.a("GcmBroadcastReceiver", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            b.itm.a(452, 36, 1, false);
        }
    }
}
