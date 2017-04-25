package com.tencent.mm.model.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean ZO = false;

    static /* synthetic */ void eZ(int i) {
        ak.yW();
        c.vf().a(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
    }

    static /* synthetic */ void x(List list) {
        if (be.bP(list)) {
            v.w("MicroMsg.ABTestUpdater", "No expired Exp");
            return;
        }
        d Au = c.Au();
        if (!be.bP(list)) {
            for (Integer num : list) {
                if (num != null) {
                    com.tencent.mm.sdk.h.c cVar = new com.tencent.mm.storage.c();
                    cVar.field_expId = String.valueOf(num);
                    Au.c(cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b Av = c.Av();
        if (!be.bP(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    cVar = new com.tencent.mm.storage.a();
                    cVar.field_expId = String.valueOf(num2);
                    Av.c(cVar, "expId");
                }
            }
        }
    }

    static /* synthetic */ void y(List list) {
        if (list == null || list.size() == 0) {
            v.w("MicroMsg.ABTestUpdater", "No Exp");
            return;
        }
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (com.tencent.mm.ba.b a : list) {
            a.a gi = a.gi(m.a(a));
            linkedList.addAll(gi.cwd);
            linkedList2.addAll(gi.cwe);
        }
        c.Au().bQ(linkedList);
        c.Av().bQ(linkedList2);
    }

    static void Ao() {
        if (ak.uz()) {
            boolean z;
            ak.yW();
            Long l = (Long) c.vf().get(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            long longValue = l == null ? 0 : l.longValue();
            int intValue;
            if (longValue == 0) {
                eX(new Random().nextInt(86400));
                Ap();
                Aq();
                v.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(intValue));
                z = true;
            } else {
                ak.yW();
                Integer num = (Integer) c.vf().get(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
                intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                long j = (long) intValue;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(currentTimeMillis);
                v.i(str, str2, objArr);
                z = currentTimeMillis > longValue + j;
            }
            if (!z) {
                v.v("MicroMsg.ABTestUpdater", "No need to update");
                return;
            } else if (ZO) {
                v.i("MicroMsg.ABTestUpdater", "Updating");
                return;
            } else {
                ZO = true;
                com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                aVar.czn = new rw();
                aVar.czo = new rx();
                aVar.uri = "/cgi-bin/mmux-bin/getabtest";
                aVar.czm = 1801;
                com.tencent.mm.v.b Bv = aVar.Bv();
                rw rwVar = (rw) Bv.czk.czs;
                ak.yW();
                Integer num2 = (Integer) c.vf().get(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
                rwVar.mvW = num2 == null ? 0 : num2.intValue();
                rwVar.mvX = c.Au().buW();
                rwVar.mvX.addAll(c.Av().buW());
                v.i("MicroMsg.ABTestUpdater", "update abtest: %s", b(rwVar.mvX));
                u.a(Bv, new u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                        if (i == 0 && i2 == 0) {
                            rx rxVar = (rx) bVar.czl.czs;
                            b.Ap();
                            b.eZ(rxVar.mqK);
                            b.eX(rxVar.mvZ);
                            b.x(rxVar.mwa);
                            b.y(rxVar.mvY);
                            b.Aq();
                            v.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(rxVar.mvZ));
                            b.ZO = false;
                        } else {
                            v.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                            b.Ap();
                            b.eX(86400);
                            b.Aq();
                        }
                        return 0;
                    }
                });
                return;
            }
        }
        v.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
    }

    private static String b(LinkedList<pb> linkedList) {
        String str = SQLiteDatabase.KeyEmpty;
        Iterator it = linkedList.iterator();
        String str2 = str;
        while (it.hasNext()) {
            pb pbVar = (pb) it.next();
            str2 = str2 + pbVar.moX + ":" + pbVar.priority + "|";
        }
        return str2;
    }

    private static void Ap() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ak.yW();
        c.vf().a(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
    }

    private static void eX(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        ak.yW();
        c.vf().a(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
    }

    private static void Aq() {
        ak.yW();
        c.vf().iB(true);
    }
}
