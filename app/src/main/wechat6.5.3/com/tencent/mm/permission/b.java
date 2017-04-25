package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ju;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    static final String aRh;
    static final String aRi;
    static Map<Integer, a> dow;
    c dox = new c<ju>(this) {
        final /* synthetic */ b doz;

        {
            this.doz = r2;
            this.nhz = ju.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ju juVar = (ju) bVar;
            if (true == juVar.bkt.bkv) {
                if (!b.gF(juVar.bkt.type)) {
                    if (com.tencent.mm.compatible.e.a.cfL == null) {
                        List<b> arrayList = new ArrayList();
                        List<a> arrayList2 = new ArrayList();
                        com.tencent.mm.compatible.e.a.a(e.cng + "permissioncfg.cfg", arrayList, arrayList2);
                        PInt pInt = new PInt(0);
                        PBool pBool = new PBool();
                        for (b bVar2 : arrayList) {
                            pInt.value = 0;
                            pBool.value = true;
                            if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, bVar2.cfQ, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                                com.tencent.mm.compatible.e.a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                            }
                            if (pBool.value && pInt.value > 0) {
                                com.tencent.mm.compatible.e.a.cfL = Boolean.valueOf(1 == bVar2.cfO);
                            }
                        }
                        if (com.tencent.mm.compatible.e.a.cfL == null || true != com.tencent.mm.compatible.e.a.cfL.booleanValue()) {
                            for (PackageInfo packageInfo : com.tencent.mm.compatible.e.a.ay(false)) {
                                for (a aVar : arrayList2) {
                                    pInt.value = 0;
                                    pBool.value = true;
                                    if (com.tencent.mm.compatible.e.a.a(packageInfo.packageName, aVar.aRm, pInt, pBool)) {
                                        if (aVar.cfM == 0 && aVar.cfN == 0) {
                                            pBool.value = true;
                                        } else if (aVar.cfM > packageInfo.versionCode || aVar.cfN < packageInfo.versionCode) {
                                            pBool.value = false;
                                        } else {
                                            pInt.value++;
                                            pBool.value = true;
                                        }
                                    }
                                    if (pBool.value && pInt.value > 0) {
                                        com.tencent.mm.compatible.e.a.cfL = Boolean.valueOf(1 == aVar.cfO);
                                    }
                                }
                                if (com.tencent.mm.compatible.e.a.cfL != null && true == com.tencent.mm.compatible.e.a.cfL.booleanValue()) {
                                    break;
                                }
                            }
                            if (com.tencent.mm.compatible.e.a.cfL == null) {
                                com.tencent.mm.compatible.e.a.cfL = Boolean.valueOf(false);
                            }
                        }
                    }
                    if (com.tencent.mm.compatible.e.a.cfL.booleanValue()) {
                        juVar.bku.bkx = b.w(juVar.bkt.type, true);
                        b.b(juVar.bkt.type, false, true);
                    }
                }
                juVar.bku.bkx = false;
                b.b(juVar.bkt.type, true, false);
            } else {
                juVar.bku.bkx = false;
                b.b(juVar.bkt.type, false, juVar.bkt.bkw);
            }
            return false;
        }
    };
    private c doy = new c<jv>(this) {
        final /* synthetic */ b doz;

        {
            this.doz = r2;
            this.nhz = jv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            jv jvVar = (jv) bVar;
            jvVar.bkz.bkx = b.w(jvVar.bky.type, false);
            return false;
        }
    };

    private static class a {
        public int doA;
        public int doB;
        public int doC;
        public int doD;
        public int doE;

        public a(int i, int i2, int i3, int i4, int i5) {
            this.doA = i;
            this.doB = i2;
            this.doC = i3;
            this.doD = i4;
            this.doE = i5;
        }
    }

    static /* synthetic */ void b(int i, boolean z, boolean z2) {
        v.i("MicroMsg.PermissionMgr", "makeMark, setOrClear: " + z);
        ak.yT().setInt(((a) dow.get(Integer.valueOf(i))).doA, z ? 1 : 0);
        if (true == z) {
            a.MQ().MR();
        }
        if (!z && true == z2) {
            long j = ak.yT().getLong(((a) dow.get(Integer.valueOf(i))).doB, 0);
            if (0 != j && System.currentTimeMillis() - j >= 86400000) {
                H("LastTick: " + j + ", CurrentTtick: " + System.currentTimeMillis() + "\n", ak.yT().getInt(((a) dow.get(Integer.valueOf(i))).doC, 0) == 1 ? 6 : 5);
                ak.yT().setLong(((a) dow.get(Integer.valueOf(i))).doB, 0);
            }
        }
    }

    static /* synthetic */ boolean gF(int i) {
        int i2 = ak.yT().getInt(((a) dow.get(Integer.valueOf(i))).doA, 0);
        v.i("MicroMsg.PermissionMgr", "current mark status: " + i2);
        return i2 == 0;
    }

    static /* synthetic */ boolean w(int i, boolean z) {
        int lR;
        int lR2;
        int lR3;
        boolean z2;
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (ak.uz()) {
            lR = lR("ShowPermissionDialog");
            lR2 = lR("OnlyScanRunningService");
            lR3 = lR("Interval4ShowPmsDialog");
        } else {
            lR = 1;
            lR2 = 1;
            lR3 = 3600000;
        }
        v.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", Integer.valueOf(lR), Integer.valueOf(lR2), Integer.valueOf(lR3));
        long j = 0;
        for (a aVar2 : dow.values()) {
            long j2 = ak.yT().getLong(aVar2.doB, 0);
            if (j < j2) {
                j = j2;
            }
        }
        boolean z3 = 1 == lR && System.currentTimeMillis() - j >= ((long) lR3);
        if (z3) {
            String str;
            z2 = 1 == lR2;
            List arrayList = new ArrayList();
            List<b> arrayList2 = new ArrayList();
            List<a> arrayList3 = new ArrayList();
            com.tencent.mm.compatible.e.a.a(e.cng + "permissioncfg.cfg", arrayList2, arrayList3);
            String str2 = null;
            PInt pInt = new PInt(0);
            PBool pBool = new PBool();
            for (b bVar : arrayList2) {
                pInt.value = 0;
                pBool.value = true;
                if (com.tencent.mm.compatible.e.a.a(Build.MANUFACTURER, bVar.cfQ, pInt, pBool) && com.tencent.mm.compatible.e.a.a(Build.MODEL, bVar.model, pInt, pBool)) {
                    com.tencent.mm.compatible.e.a.a(VERSION.RELEASE, bVar.version, pInt, pBool);
                }
                str = (!pBool.value || pInt.value <= 0) ? str2 : (String) bVar.cfP.get(i);
                str2 = str;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            List<PackageInfo> ay = com.tencent.mm.compatible.e.a.ay(z2);
            if (ay != null) {
                for (PackageInfo packageInfo : ay) {
                    str2 = null;
                    for (a aVar3 : arrayList3) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (com.tencent.mm.compatible.e.a.a(packageInfo.packageName, aVar3.aRm, pInt, pBool)) {
                            if (aVar3.cfM == 0 && aVar3.cfN == 0) {
                                pBool.value = true;
                            } else if (aVar3.cfM > packageInfo.versionCode || aVar3.cfN < packageInfo.versionCode) {
                                pBool.value = false;
                            } else {
                                pInt.value++;
                                pBool.value = true;
                            }
                        }
                        str = (!pBool.value || pInt.value <= 0) ? str2 : (String) aVar3.cfP.get(i);
                        str2 = str;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
            v.i("MicroMsg.PermissionMgr", "len of tips list: " + arrayList.size());
            if (arrayList.size() != 0) {
                a(i, arrayList, z);
                c(arrayList, z);
                z2 = true;
            } else {
                if (System.currentTimeMillis() - ak.yT().getLong(42, 0) < 2592000000L) {
                    bo(z);
                } else if (1 == i) {
                    ak.yT().setLong(42, System.currentTimeMillis());
                    PermissionWarningDialog.a(aa.getContext(), 1 == lR2, z);
                }
                z2 = false;
            }
            ak.yT().setLong(((a) dow.get(Integer.valueOf(i))).doB, System.currentTimeMillis());
        } else {
            z2 = false;
        }
        v.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.sn() + ", needShowDlg: " + z3);
        return z2;
    }

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
        Map hashMap = new HashMap();
        dow = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, 2131231119, 2131231111));
        dow.put(Integer.valueOf(2), new a(43, 44, 45, 2131231118, 2131231112));
    }

    public b() {
        com.tencent.mm.sdk.c.a.nhr.e(this.dox);
        com.tencent.mm.sdk.c.a.nhr.e(this.doy);
    }

    private static int lR(String str) {
        int i = 0;
        try {
            i = be.getInt(j.sU().getValue(str), 0);
        } catch (Exception e) {
            v.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static void bo(boolean z) {
        H("App_List:\n", z ? 4 : 3);
    }

    public static void f(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = aa.getContext().getPackageManager();
        List<PackageInfo> ay = com.tencent.mm.compatible.e.a.ay(z);
        if (ay != null) {
            stringBuilder.append("App_List:\n");
            for (PackageInfo packageInfo : ay) {
                if (packageInfo != null) {
                    String str = SQLiteDatabase.KeyEmpty;
                    if (!(packageInfo.applicationInfo == null || packageManager == null)) {
                        str = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    }
                    stringBuilder.append(str + ":" + packageInfo.packageName + ":" + packageInfo.versionCode + "\n");
                }
            }
        }
        H(stringBuilder.toString(), z2 ? 4 : 3);
    }

    private static void c(List<String> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Match_Tips:\n");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append((String) list.get(i));
            stringBuilder.append("\n");
        }
        H(stringBuilder.toString(), z ? 2 : 1);
    }

    private static void a(int i, List<String> list, boolean z) {
        int i2;
        int i3;
        int size = list.size() > 5 ? 5 : list.size();
        int[] iArr = new int[]{2131231115, 2131231120, 2131231117, 2131231114, 2131231113};
        Context context = aa.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(((a) dow.get(Integer.valueOf(i))).doE));
        for (i2 = 0; i2 < size; i2++) {
            stringBuilder.append(context.getString(iArr[i2]));
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append('\n');
        }
        q yT = ak.yT();
        i2 = ((a) dow.get(Integer.valueOf(i))).doC;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        yT.setInt(i2, i3);
        PermissionWarningDialog.i(context, context.getString(((a) dow.get(Integer.valueOf(i))).doD), stringBuilder.toString());
    }

    private static void H(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(d.lWh).append("\n");
        stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.e.cmU).append("\n");
        stringBuilder.append("#accinfo.uin=").append(ai.cse.A("last_login_uin", aRi)).append("\n");
        stringBuilder.append("#accinfo.dev=").append(aRh).append("\n");
        stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.e.cmX).append(":").append(com.tencent.mm.sdk.platformtools.e.cmY).append(":").append(f.aPW).append("\n");
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        stringBuilder.append("#permission.type=").append(String.valueOf(i)).append('\n');
        stringBuilder.append("#permission.content:\n");
        Intent intent = new Intent();
        intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String A = ai.cse.A("login_weixin_username", SQLiteDatabase.KeyEmpty);
        if (be.kS(A)) {
            A = ai.cse.A("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, A);
        intent.putExtra("tag", "permission");
        v.d("MicroMsg.PermissionMgr", "report type: %d, len: %d", Integer.valueOf(i), Integer.valueOf((stringBuilder.toString() + str).length()));
        intent.putExtra("exceptionMsg", Base64.encodeToString(A.getBytes(), 2));
        aa.getContext().startService(intent);
    }
}
