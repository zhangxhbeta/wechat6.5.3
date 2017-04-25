package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.u.h;
import com.tencent.mm.u.i;
import com.tencent.mm.u.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public final class f {
    private static int ftg = 0;

    public static boolean P(Context context, String str) {
        if (be.kS(str)) {
            v.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public static void a(b bVar, abt com_tencent_mm_protocal_c_abt, abu com_tencent_mm_protocal_c_abu) {
        if (com_tencent_mm_protocal_c_abu != null) {
            bVar.field_connProto = com_tencent_mm_protocal_c_abu.mCN;
            bVar.field_connStrategy = com_tencent_mm_protocal_c_abu.mCO;
            bVar.field_closeStrategy = com_tencent_mm_protocal_c_abu.mCP;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.sE(com.tencent.mm.plugin.exdevice.j.b.sF(com_tencent_mm_protocal_c_abu.mfU));
            bVar.field_authKey = com_tencent_mm_protocal_c_abu.mec;
            bVar.field_brandName = com_tencent_mm_protocal_c_abu.mCM;
            bVar.bP(com_tencent_mm_protocal_c_abu.cHh);
            bVar.w(com_tencent_mm_protocal_c_abu.bLh);
            bVar.cC(com_tencent_mm_protocal_c_abu.mCV);
            bVar.cB(com_tencent_mm_protocal_c_abu.mCU);
            bVar.cA(com_tencent_mm_protocal_c_abu.mCT);
            bVar.dp(com_tencent_mm_protocal_c_abu.mCW);
            bVar.cy(com_tencent_mm_protocal_c_abu.gnp);
            bVar.dq(com_tencent_mm_protocal_c_abu.bLg);
            bVar.cz(com_tencent_mm_protocal_c_abu.gkT);
            bVar.cD(com_tencent_mm_protocal_c_abu.bLi);
            bVar.cE(com_tencent_mm_protocal_c_abu.bLj);
            bVar.cF(com_tencent_mm_protocal_c_abu.bLk);
            bVar.cG(com_tencent_mm_protocal_c_abu.bLl);
        }
        if (com_tencent_mm_protocal_c_abt != null) {
            bVar.field_deviceID = com_tencent_mm_protocal_c_abt.eez;
            bVar.field_deviceType = com_tencent_mm_protocal_c_abt.meq;
            bVar.field_md5Str = g.m(new String(com_tencent_mm_protocal_c_abt.meq + com_tencent_mm_protocal_c_abt.eez).getBytes());
            if (be.kS(bVar.field_brandName)) {
                bVar.field_brandName = com_tencent_mm_protocal_c_abt.meq;
            }
        }
    }

    public static boolean e(b bVar) {
        return bVar != null && (bVar.bLh & 1) == 1;
    }

    public static String aja() {
        u.Dy();
        List fi = d.fi(1);
        if (fi.size() > 0) {
            return (String) fi.get(0);
        }
        return null;
    }

    public static boolean ajb() {
        boolean z;
        String value = j.sU().getValue("DeviceTimingSyncOpen");
        if (be.kS(value)) {
            z = true;
        } else {
            z = "1".equals(value);
        }
        v.i("MicroMsg.exdevice.ExdeviceLogic", "Has device timing auto sync opened(%b).", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    private static long ajc() {
        int hours;
        Exception e;
        Calendar instance;
        String value = j.sU().getValue("DeviceTimingSyncEndTime");
        v.i("MicroMsg.exdevice.ExdeviceLogic", "syncEndTime is %s", new Object[]{value});
        int i = 22;
        if (!be.kS(value)) {
            Date parse;
            try {
                parse = new SimpleDateFormat("HH:mm").parse(value);
                hours = parse.getHours();
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.exdevice.ExdeviceLogic", "parse syncEndTime failed : %s.", new Object[]{e});
                hours = i;
                i = 0;
                instance = Calendar.getInstance();
                instance.set(11, hours);
                instance.set(12, i);
                v.d("MicroMsg.exdevice.ExdeviceLogic", "time(%s), hour(%s), minute(%s).", new Object[]{Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
                return instance.getTimeInMillis();
            }
            try {
                i = parse.getMinutes();
            } catch (Exception e3) {
                Exception exception = e3;
                i = hours;
                e = exception;
                v.e("MicroMsg.exdevice.ExdeviceLogic", "parse syncEndTime failed : %s.", new Object[]{e});
                hours = i;
                i = 0;
                instance = Calendar.getInstance();
                instance.set(11, hours);
                instance.set(12, i);
                v.d("MicroMsg.exdevice.ExdeviceLogic", "time(%s), hour(%s), minute(%s).", new Object[]{Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
                return instance.getTimeInMillis();
            }
            instance = Calendar.getInstance();
            instance.set(11, hours);
            instance.set(12, i);
            v.d("MicroMsg.exdevice.ExdeviceLogic", "time(%s), hour(%s), minute(%s).", new Object[]{Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
            return instance.getTimeInMillis();
        }
        hours = i;
        i = 0;
        instance = Calendar.getInstance();
        instance.set(11, hours);
        instance.set(12, i);
        v.d("MicroMsg.exdevice.ExdeviceLogic", "time(%s), hour(%s), minute(%s).", new Object[]{Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
        return instance.getTimeInMillis();
    }

    private static long ajd() {
        String value = j.sU().getValue("DeviceTimingSyncBeginTime");
        v.i("MicroMsg.exdevice.ExdeviceLogic", "syncBeginTime is %s", new Object[]{value});
        int i = 21;
        int i2 = 30;
        if (!be.kS(value)) {
            try {
                Date parse = new SimpleDateFormat("HH:mm").parse(value);
                i = parse.getHours();
                i2 = parse.getMinutes();
            } catch (Exception e) {
                v.e("MicroMsg.exdevice.ExdeviceLogic", "parse syncBeginTime failed : %s", new Object[]{e});
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        v.d("MicroMsg.exdevice.ExdeviceLogic", "time(%s), hour(%s), minute(%s).", new Object[]{Long.valueOf(instance.getTimeInMillis()), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12))});
        return instance.getTimeInMillis();
    }

    public static boolean aje() {
        int nextInt;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        long ajd = ajd();
        long ajc = ajc();
        if (ajc - ajd > 1200000) {
            ak.yW();
            nextInt = new Random((long) com.tencent.mm.model.c.ww()).nextInt(1200000);
            v.i("MicroMsg.exdevice.ExdeviceLogic", "create random interval %d msec.", new Object[]{Integer.valueOf(nextInt)});
        } else {
            nextInt = 0;
        }
        if (currentTimeMillis < ajd + ((long) nextInt) || currentTimeMillis > ajc) {
            z = false;
        } else {
            z = true;
        }
        v.i("MicroMsg.exdevice.ExdeviceLogic", "needSyncStep by timing.(r : %b, msec : %s)", new Object[]{Boolean.valueOf(z), Long.valueOf(currentTimeMillis)});
        return z;
    }

    public static String sb(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.exdevice.ExdeviceLogic", "Get avatar url failed, username is null.");
            return null;
        }
        ak.yW();
        String str2 = (String) com.tencent.mm.model.c.vf().get(a.npg, null);
        if (!be.kS(str2)) {
            return str2;
        }
        str2 = sc(str);
        if (!be.kS(str2)) {
            return str2;
        }
        u.Dy();
        List fi = d.fi(1);
        if (fi.size() > 0) {
            return sc((String) fi.get(0));
        }
        return str2;
    }

    private static String sc(String str) {
        h gQ = n.Bo().gQ(str);
        if (gQ == null) {
            return null;
        }
        String Be = gQ.Be();
        if (be.kS(Be)) {
            return gQ.Bf();
        }
        return Be;
    }

    public static final void b(String str, final Runnable runnable) {
        i Bo = n.Bo();
        if (Bo != null) {
            h gQ = Bo.gQ(str);
            if (gQ == null || be.kS(gQ.Bf())) {
                final long Ni = be.Ni();
                ab.a.crZ.a(str, "", new ab.c.a() {
                    public final void p(String str, boolean z) {
                        if (z) {
                            v.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (be.Ni() - Ni) + " ms");
                            com.tencent.mm.u.b.r(str, 3);
                            if (runnable != null) {
                                runnable.run();
                                return;
                            }
                            return;
                        }
                        v.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
                    }
                });
            }
        }
    }
}
