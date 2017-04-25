package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.e.a.cq;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.cs;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelmulti.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.acw;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    private static c bYe;
    private static float bYf = -1000.0f;
    private static float bYg = -1000.0f;
    private static boolean bYh = false;
    private static Map<String, acr> bYi = new ConcurrentHashMap();
    private static List<acr> bYj = new CopyOnWriteArrayList();
    private static Boolean bYk = Boolean.valueOf(false);
    private static a bYl = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (z) {
                v.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                k.bYf = f2;
                k.bYg = f;
                k.bYh = true;
                if (k.bYe != null) {
                    k.bYe.c(k.bYl);
                    k.bYh = false;
                }
            } else {
                v.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            return false;
        }
    };
    private static ah bYm = new ah(Looper.getMainLooper(), new ah.a() {
        public final boolean oU() {
            try {
                ak.yW();
                Boolean valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false));
                List<String> sR = j.sV().sR();
                if (sR != null) {
                    for (String str : sR) {
                        v.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        b crVar = new cr();
                        crVar.baC.baE = str;
                        crVar.baC.baB = false;
                        if (!valueOf.booleanValue()) {
                            com.tencent.mm.sdk.c.a.nhr.z(crVar);
                        }
                    }
                    act com_tencent_mm_protocal_c_act = new act();
                    com_tencent_mm_protocal_c_act.latitude = (double) k.bYf;
                    com_tencent_mm_protocal_c_act.longitude = (double) k.bYg;
                    ak.yW();
                    long a = be.a((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, null), 0);
                    if (k.bYi.size() <= 0 || k.bYk.booleanValue() || k.bYj.size() <= 0) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                    } else {
                        k.bYk = Boolean.valueOf(true);
                        final com.tencent.mm.v.k dVar = new d(k.bYj, a, com_tencent_mm_protocal_c_act);
                        v.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.bYj.size() + ",info:" + k.bYj.toString());
                        ak.vy().a(1708, new e(this) {
                            final /* synthetic */ AnonymousClass2 bYp;

                            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                                if (i == 0 && i2 == 0) {
                                    tc tcVar = (tc) dVar.cQA.czl.czs;
                                    if (tcVar.bpc == 0) {
                                        acw com_tencent_mm_protocal_c_acw = tcVar.mwA;
                                        acr com_tencent_mm_protocal_c_acr = tcVar.mwC;
                                        Object obj = com_tencent_mm_protocal_c_acw.title + "," + com_tencent_mm_protocal_c_acw.desc + "," + com_tencent_mm_protocal_c_acw.mDP + "," + com_tencent_mm_protocal_c_acw.mDQ + "," + com_tencent_mm_protocal_c_acr.gjT + "," + com_tencent_mm_protocal_c_acr.major + "," + com_tencent_mm_protocal_c_acr.minor;
                                        ak.yW();
                                        String[] split = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty).split(",");
                                        Boolean valueOf = Boolean.valueOf(false);
                                        Boolean bool = valueOf;
                                        for (String equals : split) {
                                            if (equals.equals(com_tencent_mm_protocal_c_acr.gjT + com_tencent_mm_protocal_c_acr.major + com_tencent_mm_protocal_c_acr.minor)) {
                                                bool = Boolean.valueOf(true);
                                            }
                                        }
                                        if (bool.booleanValue()) {
                                            ak.yW();
                                            com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                                        } else {
                                            g.iuh.h(12653, Integer.valueOf(1), Integer.valueOf(1));
                                            g.iuh.h(12653, Integer.valueOf(2), Integer.valueOf(1));
                                            ak.yW();
                                            com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, obj);
                                        }
                                    } else {
                                        ak.yW();
                                        com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                                    }
                                } else {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                                }
                                ak.yW();
                                com.tencent.mm.model.c.uI();
                                com.tencent.mm.sdk.c.a.nhr.z(new cq());
                                k.bYk = Boolean.valueOf(false);
                                ak.vy().b(1708, (e) this);
                            }
                        });
                        ak.vy().a(dVar, 0);
                    }
                    k.bYi.clear();
                    k.bYj.clear();
                    com.tencent.mm.sdk.c.a.nhr.f(k.bYn);
                }
            } catch (Exception e) {
                v.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
            }
            return false;
        }
    }, true);
    private static com.tencent.mm.sdk.c.c bYn = new com.tencent.mm.sdk.c.c<cs>() {
        {
            this.nhz = cs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cs csVar = (cs) bVar;
            if (csVar != null && (csVar instanceof cs)) {
                String str = csVar.baG.baE;
                int i = csVar.baG.baH;
                int i2 = csVar.baG.baI;
                if (!k.bYi.containsKey(str + "," + i + "," + i2)) {
                    acr com_tencent_mm_protocal_c_acr = new acr();
                    com_tencent_mm_protocal_c_acr.gjT = str;
                    com_tencent_mm_protocal_c_acr.major = i;
                    com_tencent_mm_protocal_c_acr.minor = 65535 & i2;
                    com_tencent_mm_protocal_c_acr.cXH = csVar.baG.baJ;
                    k.bYi.put(str + "," + i + "," + i2, com_tencent_mm_protocal_c_acr);
                    if (csVar.baG.baJ >= 0.0d && k.bYj.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.bYj.size()) {
                            acr com_tencent_mm_protocal_c_acr2 = (acr) k.bYj.get(i3);
                            if (csVar.baG.baJ >= com_tencent_mm_protocal_c_acr2.cXH) {
                                if (i3 == k.bYj.size() - 1 && csVar.baG.baJ > com_tencent_mm_protocal_c_acr2.cXH) {
                                    k.bYj.add(com_tencent_mm_protocal_c_acr);
                                    break;
                                }
                                i3++;
                            } else {
                                k.bYj.add(i3, com_tencent_mm_protocal_c_acr);
                                break;
                            }
                        }
                    }
                    k.bYj.add(com_tencent_mm_protocal_c_acr);
                }
                v.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(k.bYi.size()));
            }
            return false;
        }
    };

    public static void run() {
        if (ak.uz() && !ak.uG()) {
            ak.yW();
            Boolean valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
            v.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is " + valueOf);
            if (valueOf.booleanValue()) {
                long Nh = be.Nh();
                ak.yW();
                long a = be.a((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
                ak.yW();
                if (Nh - a > be.a((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0)) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    com.tencent.mm.model.c.uI();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, SQLiteDatabase.KeyEmpty);
                    return;
                }
                List<String> sR = j.sV().sR();
                if (sR != null) {
                    for (String str : sR) {
                        v.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                        b crVar = new cr();
                        crVar.baC.baE = str;
                        crVar.baC.baB = true;
                        com.tencent.mm.sdk.c.a.nhr.z(crVar);
                    }
                    bYe = c.FY();
                    if (bYm.btC()) {
                        bYm.ea(3000);
                    }
                    if (!(bYh || bYe == null)) {
                        bYe.b(bYl);
                    }
                    com.tencent.mm.sdk.c.a.nhr.e(bYn);
                }
            }
        }
    }
}
