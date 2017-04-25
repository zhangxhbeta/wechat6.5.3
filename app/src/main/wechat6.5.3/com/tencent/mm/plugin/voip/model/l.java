package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Toast;
import com.tencent.mm.az.d.a;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class l {
    private static boolean kuM = false;
    private static OnClickListener kuN = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            l.bcy();
        }
    };

    public static long a(String str, String str2, int i, int i2, String str3) {
        return a(str, str2, i, i2, str3, false);
    }

    public static long a(String str, String str2, int i, int i2, String str3, boolean z) {
        at atVar = new at();
        atVar.z(aw.fN(str));
        atVar.di(i);
        atVar.setType(50);
        atVar.cH(str);
        atVar.cN(str3);
        atVar.setContent(str2);
        atVar.dh(i2);
        if (z) {
            atVar.ds(atVar.bNn | 8);
        }
        ak.yW();
        long R = c.wJ().R(atVar);
        if (R < 0) {
            v.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        v.d("MicroMsg.VoipPluginManager", "inset voip  msgId " + R);
        return R;
    }

    public static void bcw() {
        ak.yW();
        c.vf().set(20480, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean bcx() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            long longValue = ((Long) c.vf().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                return false;
            }
            currentTimeMillis -= longValue;
            v.d("MicroMsg.VoipPluginManager", "diff is" + currentTimeMillis);
            if (currentTimeMillis < 21600000) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static void aw(final Context context, final String str) {
        new String[1][0] = context.getResources().getString(2131235857);
        kuM = false;
        try {
            ak.yW();
            at MJ = c.wJ().MJ(str);
            if (MJ != null) {
                kuM = d.dt(MJ.field_createTime);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (be.kS(str)) {
            v.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int BJ = ak.vy().BJ();
        v.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + BJ);
        if (BJ != 4 && BJ != 6) {
            g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.g.a(context, 2131235928, 2131235932, kuN);
        } else if (kuM) {
            if (!((k.xQ() & 1048576) == 0)) {
                com.tencent.mm.ui.base.g.a(context, 2131235939, 2131235966, kuN);
            } else if (com.tencent.mm.sdk.platformtools.ak.isWap(context)) {
                com.tencent.mm.ui.base.g.a(context, 2131235951, 0, 2131235952, 2131231010, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.cE(context);
                        l.bcy();
                    }
                }, kuN);
            } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(context) || bcx()) {
                d.bbw().aB(context, str);
            } else {
                com.tencent.mm.ui.base.g.a(context, 2131235931, 2131235932, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.bcw();
                        d.bbw().aB(context, str);
                    }
                }, kuN);
            }
        } else {
            try {
                ak.yW();
                Map Iq = a.Iq((String) c.vf().get(77829, null));
                if (Iq != null) {
                    a aVar;
                    if (Iq != null && Iq.size() > 0) {
                        if (Iq.containsKey(str)) {
                            aVar = (a) Iq.get(str);
                            aVar.hitCount++;
                            Iq.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Iq.put(str, aVar);
                        }
                    }
                    ak.yW();
                    c.vf().set(77829, a.T(Iq));
                    for (Entry entry : Iq.entrySet()) {
                        aVar = (a) entry.getValue();
                        v.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.cUl + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ak.yW();
                    c.vf().set(77829, a.T(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        v.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.cUl + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.g(context, str, 0);
            bcy();
        }
    }

    private static void bcy() {
        qi qiVar = new qi();
        qiVar.brC.bdn = 8;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
    }

    public static void cE(Context context) {
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception e) {
            searchIntentByClass(context, "ApnSettings");
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                v.e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        v.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                v.e("MicroMsg.VoipPluginManager", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Throwable e) {
                                v.a("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Throwable e22) {
            v.a("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        return null;
    }

    public static void ax(Context context, String str) {
        j.sV();
        if (com.tencent.mm.h.c.sN() == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        com.tencent.mm.ay.c.brh();
        if (i == 0) {
            Toast.makeText(context, context.getString(2131235963), 0).show();
            v.d("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(false)});
            return;
        }
        kuM = false;
        try {
            ak.yW();
            at MJ = c.wJ().MJ(str);
            if (MJ != null) {
                kuM = d.dt(MJ.field_createTime);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        az(context, str);
    }

    public static void ay(Context context, String str) {
        kuM = false;
        try {
            ak.yW();
            at MJ = c.wJ().MJ(str);
            if (MJ != null) {
                kuM = d.dt(MJ.field_createTime);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        az(context, str);
    }

    private static void az(final Context context, final String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int BJ = ak.vy().BJ();
        v.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + BJ);
        if (BJ != 4 && BJ != 6) {
            g.iuh.a(11518, true, true, new Object[]{Integer.valueOf(d.bbw().kuO.kqI.ksc.gFG), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.g.a(context, 2131235928, 2131235932, kuN);
        } else if (kuM) {
            boolean z;
            if ((k.xQ() & 4194304) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                com.tencent.mm.ui.base.g.a(context, 2131235938, 2131235966, kuN);
            } else if (com.tencent.mm.sdk.platformtools.ak.isWap(context)) {
                com.tencent.mm.ui.base.g.a(context, 2131235951, 0, 2131235952, 2131231010, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.cE(context);
                    }
                }, kuN);
            } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(context) || bcx()) {
                d.bbw().aA(context, str);
            } else {
                com.tencent.mm.ui.base.g.a(context, 2131235931, 2131235932, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.bcw();
                        d.bbw().aA(context, str);
                    }
                }, kuN);
            }
        } else {
            try {
                ak.yW();
                Map Iq = a.Iq((String) c.vf().get(77829, null));
                if (Iq != null) {
                    a aVar;
                    if (Iq != null && Iq.size() > 0) {
                        if (Iq.containsKey(str)) {
                            aVar = (a) Iq.get(str);
                            aVar.hitCount++;
                            Iq.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Iq.put(str, aVar);
                        }
                    }
                    ak.yW();
                    c.vf().set(77829, a.T(Iq));
                    for (Entry entry : Iq.entrySet()) {
                        aVar = (a) entry.getValue();
                        v.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.cUl + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    ak.yW();
                    c.vf().set(77829, a.T(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        v.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.cUl + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.g(context, str, 1);
            bcy();
        }
    }
}
