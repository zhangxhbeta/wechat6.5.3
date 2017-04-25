package com.tencent.mm.modelstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private static c dbh;
    private ah dbi = null;
    private final int dbj = 20971520;
    private ArrayList<b> dbk = new ArrayList();
    private String dbl = null;
    private long dbm = 0;
    private ArrayList<c> dbn = new ArrayList();
    private long dbo = 0;
    private long dbp = 0;
    private ac handler = null;

    private static class a {
        long dbo;
        long dbp;
        List<c> dbv = new ArrayList();

        static class a extends Exception {
            a(String str) {
                super(str);
            }

            a(Throwable th) {
                super(th);
            }
        }

        private a() {
        }

        public final String toString() {
            return "Config{nextUpdateInterval=" + this.dbo + ", samplePeriod=" + this.dbp + ", eventList=" + this.dbv + '}';
        }

        static a ku(String str) {
            a aVar = new a();
            try {
                Map q = bf.q(str, "eventSampleConf");
                if (q == null) {
                    v.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", str);
                    throw new a("reportConfigMap is null");
                }
                aVar.dbo = be.getLong((String) q.get(".eventSampleConf.nextUpdateInterval"), 0);
                if (aVar.dbo <= 0 || aVar.dbo > 432000) {
                    aVar.dbo = 432000;
                }
                aVar.dbp = be.getLong((String) q.get(".eventSampleConf.samplePeriod"), 0);
                int i = 0;
                while (true) {
                    c cVar = new c();
                    String str2 = ".eventSampleConf.events.event" + (i > 0 ? Integer.valueOf(i) : SQLiteDatabase.KeyEmpty) + ".";
                    int i2 = i + 1;
                    cVar.id = be.getInt((String) q.get(str2 + "id"), 0);
                    if (cVar.id > 0) {
                        String str3;
                        int i3;
                        String str4;
                        cVar.dby = be.getLong((String) q.get(str2 + "expireTime"), 0);
                        cVar.name = (String) q.get(str2 + "name");
                        cVar.dbz = be.getFloat((String) q.get(str2 + "rate"), 0.0f);
                        cVar.dbA = be.getInt((String) q.get(str2 + "logId"), 0);
                        cVar.dbB = (String) q.get(str2 + "pages.$type");
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "pages.page" + (i > 0 ? Integer.valueOf(i) : SQLiteDatabase.KeyEmpty) + ".";
                            i3 = i + 1;
                            str4 = (String) q.get(str3 + "$id");
                            if (str4 == null) {
                                break;
                            }
                            arrayList.add(new Pair(str4, Boolean.valueOf(((String) q.get(str3 + "$action")).equals("true"))));
                            i = i3;
                        }
                        cVar.dbC = arrayList;
                        arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            str3 = str2 + "specialPVPages.pageItem" + (i > 0 ? Integer.valueOf(i) : SQLiteDatabase.KeyEmpty) + ".";
                            i3 = i + 1;
                            str4 = (String) q.get(str3 + "$prePage");
                            if (str4 == null) {
                                break;
                            }
                            arrayList.add(new Pair(str4, (String) q.get(str3 + "$page")));
                            i = i3;
                        }
                        cVar.dbD = arrayList;
                        aVar.dbv.add(cVar);
                        v.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", cVar);
                        i = i2;
                    } else {
                        v.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", aVar);
                        return aVar;
                    }
                }
            } catch (Throwable e) {
                throw new a(e);
            }
        }
    }

    static class b implements Serializable, Comparable<b> {
        int bdf = 0;
        String dbw = null;
        long dbx;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((b) obj).time);
        }

        b() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.dbw, Integer.valueOf(this.bdf), c.ao(this.time)});
        }
    }

    private static class c {
        int dbA;
        String dbB;
        ArrayList<Pair<String, Boolean>> dbC;
        ArrayList<Pair<String, String>> dbD;
        long dby;
        float dbz;
        int id;
        String name;

        private c() {
            this.dbC = new ArrayList();
            this.dbD = new ArrayList();
        }

        public final String toString() {
            return "ReportConfigEvent{id=" + this.id + ", name='" + this.name + '\'' + ", expireTime=" + this.dby + ", rate=" + this.dbz + ", logId=" + this.dbA + ", pagesType='" + this.dbB + '\'' + ", pageList=" + this.dbC + ", specialPVPages=" + this.dbD + '}';
        }
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.dbk == null || cVar.dbk.size() == 0) {
            v.e("MicroMsg.ClickFlowStatReceiver", "page info array size is 0");
            return;
        }
        Pair h = h(cVar.dbk);
        cVar.dbk.clear();
        if (h == null) {
            v.e("MicroMsg.ClickFlowStatReceiver", "report failed :getResumeList return null ");
            return;
        }
        Object str;
        int intValue = ((Integer) h.first).intValue();
        ArrayList arrayList = (ArrayList) h.second;
        int i = 0;
        if (aa.bto() && !ak.yN() && ak.uz() && !ak.uG()) {
            ak.yW();
            i = com.tencent.mm.model.c.ww();
        }
        if (i == 0) {
            v.e("MicroMsg.ClickFlowStatReceiver", "report get uin failed  , maybe AccNotReady,  but report it");
        }
        long longValue = new o(i).longValue();
        if (cVar.dbl == null) {
            cVar.dbl = com.tencent.mm.loader.stub.a.cng + "ClickFlow/";
            File file = new File(cVar.dbl);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        final com.tencent.mm.sdk.h.a aVar = new com.tencent.mm.sdk.h.a(cVar.dbl + "stg_20971520_" + longValue + ".cfg");
        final String str2 = cVar.dbl + "ReportConfig_20971520_" + longValue + ".xml";
        if (cVar.dbn == null || cVar.dbn.size() == 0) {
            byte[] d = e.d(str2, 0, -1);
            str = d != null ? new String(d) : SQLiteDatabase.KeyEmpty;
            try {
                if (com.tencent.mm.sdk.b.b.bsI() && e.aR("/sdcard/reportConfig-android.xml")) {
                    d = e.d("/sdcard/reportConfig-android.xml", 0, -1);
                    v.w("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString: use /sdcard/reportConfig-android.xml as config, cgi config is ignored!!!");
                    str = d != null ? new String(d) : SQLiteDatabase.KeyEmpty;
                }
                if (TextUtils.isEmpty(str)) {
                    v.i("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString xml is empty and don't use /sdcard/reportConfig-android.xml");
                } else {
                    cVar.a(a.ku(str));
                }
            } catch (Throwable e) {
                v.a("MicroMsg.ClickFlowStatReceiver", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString throwable :%s %s", e.getMessage(), be.e(e));
                v(15013, be.e(e));
            }
        }
        if (!an(longValue)) {
            long Nh = be.Nh();
            long a = be.a(aVar.Lb("LAST_UPDATE_CONFIG"), 0);
            str = (a <= 0 || cVar.dbo <= 0 || cVar.dbo + a < Nh) ? 1 : null;
            boolean z = str != null && cVar.dbm + 3600 < Nh;
            v.i("MicroMsg.ClickFlowStatReceiver", "readReportConfig shouldUpdate:%b now:%d lastCheckUpdateConfigDiff:%d lastUpdate:%d diff:%d  updateintval:%d", Boolean.valueOf(z), Long.valueOf(Nh), Long.valueOf(Nh - cVar.dbm), Long.valueOf(a), Long.valueOf(Nh - a), Long.valueOf(cVar.dbo));
            if (z) {
                com.tencent.mm.network.e eVar = ak.vy().cAa;
                if (eVar == null) {
                    v.d("MicroMsg.ClickFlowStatReceiver", "dispatcher is null");
                } else {
                    if (new i(new com.tencent.mm.ba.b(be.KG(aVar.getValue("versionBuffer")))).a(eVar, new com.tencent.mm.v.e(cVar) {
                        final /* synthetic */ c dbq;

                        public final void a(int i, int i2, String str, k kVar) {
                            if (kVar.getType() == 1126 && i == 0 && i2 == 0) {
                                final vx vxVar = (vx) ((i) kVar).dcy.czl.czs;
                                if (vxVar == null) {
                                    v.e("MicroMsg.ClickFlowStatReceiver", "NetSceneUpdateEventConfig onSceneEnd resp is null");
                                } else {
                                    this.dbq.handler.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass4 dbu;

                                        public final void run() {
                                            String str = null;
                                            aVar.H("LAST_UPDATE_CONFIG", be.Nh());
                                            if (vxVar.myy == null || vxVar.myy.lVU.length <= 0 || vxVar.myw == null || vxVar.myw.lVU.length <= 0) {
                                                Integer num;
                                                Integer valueOf;
                                                String str2 = "MicroMsg.ClickFlowStatReceiver";
                                                String str3 = "OnSceneEnd NetSceneUpdateEventConfig failed, eventsampleconf:%s, versionbuffer:%s";
                                                Object[] objArr = new Object[2];
                                                if (vxVar.myy == null) {
                                                    num = null;
                                                } else {
                                                    num = Integer.valueOf(vxVar.myy.lVU.length);
                                                }
                                                objArr[0] = num;
                                                if (vxVar.myw != null) {
                                                    valueOf = Integer.valueOf(vxVar.myw.lVU.length);
                                                }
                                                objArr[1] = valueOf;
                                                v.e(str2, str3, objArr);
                                                return;
                                            }
                                            g.iuh.a(346, 3, 1, false);
                                            str3 = be.bn(vxVar.myw.lVU);
                                            String value = aVar.getValue("versionBuffer");
                                            aVar.dD("versionBuffer", str3);
                                            com.tencent.mm.ba.b bVar = vxVar.myy;
                                            try {
                                                str = new String(q.q(bVar.lVU), "UTF-8");
                                            } catch (Throwable e) {
                                                Throwable th = e;
                                                String str4 = "MicroMsg.ClickFlowStatReceiver";
                                                String str5 = "decompress failed, configString length %d, msg:%s  [%s]";
                                                Object[] objArr2 = new Object[3];
                                                objArr2[0] = Integer.valueOf(bVar == null ? 0 : bVar.lVU.length);
                                                objArr2[1] = th.getMessage();
                                                objArr2[2] = be.e(th);
                                                v.e(str4, str5, objArr2);
                                            }
                                            if (TextUtils.isEmpty(str)) {
                                                g.iuh.a(346, 2, 1, false);
                                                return;
                                            }
                                            boolean z;
                                            try {
                                                a ku = a.ku(str);
                                                e.b(str2, str.getBytes(), str.getBytes().length);
                                                this.dbu.dbq.a(ku);
                                                z = true;
                                            } catch (Throwable e2) {
                                                v.e("MicroMsg.ClickFlowStatReceiver", "readReportConfig failed :%s  [%s]", e2.getMessage(), be.e(e2));
                                                z = false;
                                            }
                                            if (!str3.equals(value)) {
                                                long j;
                                                v.i("MicroMsg.ClickFlowStatReceiver", "idKeyStat, configOK:%b", Boolean.valueOf(z));
                                                g gVar = g.iuh;
                                                if (z) {
                                                    j = 0;
                                                } else {
                                                    j = 1;
                                                }
                                                gVar.a(346, j, 1, false);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }) == 0) {
                        cVar.dbm = Nh;
                    }
                }
            }
        }
        cVar.a(longValue, arrayList, aVar);
        cVar.a(longValue, arrayList, aVar, intValue);
        if (!an(longValue)) {
            cVar.b(longValue, arrayList, aVar);
        }
    }

    static /* synthetic */ void a(c cVar, int i, String str, int i2, long j) {
        long Ni = be.Ni();
        if (TextUtils.isEmpty(str) || j > Ni) {
            v.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", str, Long.valueOf(Ni - j));
            return;
        }
        b bVar = new b();
        bVar.bdf = i;
        if (5 == i || 6 == i) {
            bVar.bdf = 4;
        } else if (!(3 == i || 4 == i)) {
            v.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", Integer.valueOf(i), str);
            return;
        }
        bVar.time = j;
        if (str.contains(".")) {
            str = str.substring(str.lastIndexOf(".") + 1);
        }
        bVar.dbw = str;
        cVar.dbk.add(bVar);
        v.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", Integer.valueOf(bVar.bdf), ao(bVar.time), Integer.valueOf(i2), bVar.dbw, Long.valueOf(be.ay(Ni)));
        if (bVar.bdf == 3) {
            cVar.dbi.QI();
        } else if (bVar.bdf == 4) {
            cVar.dbi.QI();
            cVar.dbi.ea(5000);
        }
    }

    public static c JW() {
        if (dbh == null) {
            synchronized (c.class) {
                if (dbh == null) {
                    dbh = new c();
                }
            }
        }
        return dbh;
    }

    private c() {
        if (com.tencent.mm.sdk.b.b.bsI()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", aa.bto());
        }
        HandlerThread Lg = com.tencent.mm.sdk.i.e.Lg("ClickFlow");
        Lg.start();
        this.handler = new ac(Lg.getLooper());
        this.dbi = new ah(Lg.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ c dbq;

            {
                this.dbq = r1;
            }

            public final boolean oU() {
                v.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", Boolean.valueOf(l.dG(aa.getContext())), Boolean.valueOf(!be.kS(c.bf(aa.getContext()))), c.bf(aa.getContext()));
                if (l.dG(aa.getContext()) && r0) {
                    return true;
                }
                c.a(this.dbq);
                return false;
            }
        }, true);
    }

    public final synchronized void JX() {
        long Ni = be.Ni();
        v.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", (Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
            final /* synthetic */ c dbq;

            protected final /* synthetic */ Object run() {
                c.a(this.dbq);
                return Boolean.valueOf(true);
            }
        }.c(this.handler), Long.valueOf(be.ay(Ni)));
    }

    public final synchronized void n(final Intent intent) {
        if (intent != null) {
            if (intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ c dbq;

                    public final void run() {
                        String stringExtra = intent.getStringExtra("ui");
                        int intExtra = intent.getIntExtra("uiHashCode", 0);
                        int intExtra2 = intent.getIntExtra("opCode", 0);
                        v.d("MicroMsg.ClickFlowStatReceiver", "onReceive op:%d ui:%s hash:0x%x time:%d", Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Long.valueOf(be.ay(intent.getLongExtra("nowMilliSecond", 0))));
                        if (2147483632 == intExtra2) {
                            c.a(this.dbq);
                        } else {
                            c.a(this.dbq, intExtra2, stringExtra, intExtra, r4);
                        }
                    }
                });
            }
        }
    }

    private static boolean an(long j) {
        return j == 0;
    }

    private static Pair<Integer, ArrayList<b>> h(ArrayList<b> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        long Ni = be.Ni();
        try {
            b bVar;
            Object arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                bVar = (b) arrayList.get(i);
                if (bVar.time < 0 || bVar.time > Ni || Ni - bVar.time > 50400000) {
                    v.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", Long.valueOf(bVar.time), Long.valueOf(Ni - bVar.time), Integer.valueOf(bVar.bdf), bVar.dbw);
                    return null;
                }
                long j2;
                if (bVar.bdf == 4) {
                    if (j < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j;
                } else if (bVar.bdf != 3) {
                    v.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", Integer.valueOf(bVar.bdf), bVar.dbw);
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                return null;
            }
            Collections.sort(arrayList3);
            bVar = new b();
            Iterator it = arrayList3.iterator();
            b bVar2 = bVar;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (!bVar.dbw.equals(bVar2.dbw)) {
                    arrayList2.add(bVar);
                    bVar2.dbx = bVar.time;
                    bVar2 = bVar;
                }
            }
            bVar2.dbx = ((b) arrayList.get(arrayList.size() - 1)).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((b) arrayList2.get(arrayList2.size() - 1)).dbx = Ni;
            } else if (j > Ni) {
                ((b) arrayList2.get(arrayList2.size() - 1)).dbx = Ni;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).dbx - ((b) arrayList2.get(0)).time > 50400000) {
                v.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                return null;
            }
            v.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(be.ay(Ni)));
            return Pair.create(Integer.valueOf(0), arrayList2);
        } catch (Throwable e) {
            v(15008, be.e(e));
            v.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", be.e(e));
            return null;
        }
    }

    private static void v(int i, String str) {
        g.iuh.Y(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
    }

    private void a(a aVar) {
        this.dbo = aVar.dbo;
        if (this.dbo <= 0 || this.dbo > 432000) {
            this.dbo = 432000;
        }
        this.dbp = aVar.dbp;
        this.dbn.clear();
        this.dbn.addAll(aVar.dbv);
        v.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", Integer.valueOf(this.dbn.size()), Long.valueOf(this.dbo), Long.valueOf(this.dbp));
    }

    private static boolean a(long j, float f, long j2) {
        if (f <= 0.0f) {
            return false;
        }
        long j3;
        boolean z;
        int i = 10000 / ((int) (10000.0f * f));
        int i2 = (int) j;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        int i3 = ((i2 >> 16) ^ i2) % i;
        long Nh = be.Nh();
        if (j2 == 0) {
            j3 = 259200;
        } else {
            j3 = j2;
        }
        if (i3 == ((int) ((Nh / j3) % ((long) i)))) {
            z = true;
        } else {
            z = false;
        }
        v.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", Boolean.valueOf(z), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r5), Integer.valueOf(i3), Integer.valueOf(r1));
        return z;
    }

    private static void a(List<b> list, c cVar, SparseArray<String> sparseArray) {
        int i = 0;
        String str = cVar.dbB;
        int i2 = -1;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    i2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    i2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    i2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    i2 = 3;
                    break;
                }
                break;
        }
        int i3;
        int i4;
        switch (i2) {
            case 0:
                v.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", cVar);
                sparseArray.put(cVar.dbA, be.ma((String) sparseArray.get(cVar.dbA)) + cVar.id + ";");
                return;
            case 1:
                v.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", cVar);
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < cVar.dbC.size()) {
                        int size;
                        if (((String) ((Pair) cVar.dbC.get(i4)).first).equals(((b) list.get(i3)).dbw)) {
                            sparseArray.put(cVar.dbA, be.ma((String) sparseArray.get(cVar.dbA)) + cVar.id + ";");
                            i4 = cVar.dbC.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                return;
            case 2:
                v.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", cVar);
                if (list.size() >= 2) {
                    if ((cVar.dbC.size() == 2 ? 1 : 0) == 0) {
                        v.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.dbC.toString());
                        return;
                    }
                    String str2 = (String) ((Pair) cVar.dbC.get(1)).first;
                    if (((b) list.get(0)).dbw.equals((String) ((Pair) cVar.dbC.get(0)).first) && ((b) list.get(list.size() - 1)).dbw.equals(str2)) {
                        sparseArray.put(cVar.dbA, be.ma((String) sparseArray.get(cVar.dbA)) + cVar.id + ";");
                        return;
                    }
                    return;
                }
                return;
            case 3:
                v.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", cVar);
                List list2 = cVar.dbC;
                if (list2.size() > 0) {
                    for (i2 = list2.size() - 1; i2 < list.size(); i2 = (list2.size() - i4) + i3) {
                        i4 = list2.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) list2.get(i4)).first).equals(((b) list.get(i3)).dbw)) {
                            if (i4 == 0) {
                                i = 1;
                            } else {
                                i4--;
                                i3--;
                            }
                        }
                    }
                }
                if (i != 0) {
                    sparseArray.put(cVar.dbA, be.ma((String) sparseArray.get(cVar.dbA)) + cVar.id + ";");
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.h.a aVar) {
        c cVar;
        long j2 = ((b) arrayList.get(0)).time;
        long j3 = ((b) arrayList.get(arrayList.size() - 1)).dbx;
        long Nh = be.Nh();
        int i = 0;
        while (i < this.dbn.size()) {
            try {
                if ("app".equals(((c) this.dbn.get(i)).dbB)) {
                    cVar = (c) this.dbn.get(i);
                    break;
                }
                i++;
            } catch (Throwable e) {
                v(15004, be.e(e));
                v.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", be.e(e));
                return;
            }
        }
        cVar = null;
        if (cVar == null) {
            v.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (an(j)) {
                a(aVar, 13604, 100001, j2, j3);
            } else {
                v.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            }
        } else if (cVar.dby <= Nh || !a(j, cVar.dbz, this.dbp)) {
            v.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", cVar, Long.valueOf(Nh));
        } else {
            v.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", cVar, Long.valueOf(Nh));
            a(aVar, cVar.dbA, cVar.id, j2, j3);
        }
    }

    private static void a(com.tencent.mm.sdk.h.a aVar, int i, int i2, long j, long j2) {
        long Ni = be.Ni();
        if (j > j2 || j < 0 || j2 < 0 || j > Ni || j2 > Ni) {
            v.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(Ni));
            return;
        }
        int f = be.f(aVar.Lc("SEQ_" + i));
        aVar.bH("SEQ_" + i, f + 1);
        Ni = be.d(aVar.Lb("LastQuit_" + i2));
        aVar.H("LastQuit_" + i2, j2);
        if (Ni <= 0 || Ni > j) {
            Ni = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", Ni / 1000).put("inbg", (j - Ni) / 1000);
        a(i, String.valueOf(i2), f, jSONObject.toString());
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.h.a aVar, int i) {
        try {
            int i2;
            long Ni = be.Ni();
            JSONArray jSONArray = new JSONArray();
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                JSONObject jSONObject = new JSONObject();
                b bVar = (b) arrayList.get(i2);
                if (bVar.dbx < bVar.time || bVar.time < 0 || bVar.dbx < 0 || bVar.dbx > Ni || bVar.time > Ni) {
                    v.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", Long.valueOf(bVar.time), Long.valueOf(bVar.dbx), Long.valueOf(Ni));
                    return;
                }
                jSONObject.put("p", bVar.dbw).put("tbe", bVar.time / 1000).put("in", (bVar.dbx - bVar.time) / 1000);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("t", 2).put("errt", i).put("pf", jSONArray);
            if (an(j)) {
                int f = be.f(aVar.Lc("SEQ_13604"));
                aVar.bH("SEQ_13604", f + 1);
                a(13604, "100002", f, jSONObject2.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.dbn.size() == 0) {
                v.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (i2 = 0; i2 < this.dbn.size(); i2++) {
                c cVar = (c) this.dbn.get(i2);
                if (cVar.dby > be.Nh()) {
                    if (a(j, cVar.dbz, this.dbp)) {
                        a((List) arrayList, cVar, sparseArray);
                    }
                }
                v.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", cVar, Long.valueOf(be.Nh()));
            }
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                String str = (String) sparseArray.get(keyAt);
                int f2 = be.f(aVar.Lc("SEQ_" + keyAt));
                aVar.bH("SEQ_" + keyAt, f2 + 1);
                a(keyAt, str, f2, jSONObject2.toString());
            }
        } catch (Throwable e) {
            v(15005, be.e(e));
            v.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", be.e(e));
        }
    }

    private void b(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.h.a aVar) {
        long Ni = be.Ni();
        long j2 = ((b) arrayList.get(arrayList.size() - 1)).dbx;
        if (j2 <= 0 || j2 > Ni) {
            v.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", Long.valueOf(j2), Long.valueOf(Ni));
            return;
        }
        long Nh = be.Nh();
        try {
            String str = this.dbl + "stg_20971520_" + j + ".HashMap";
            HashMap kt = kt(str);
            kt.put(Long.valueOf(j2), arrayList);
            Iterator it = kt.entrySet().iterator();
            while (it.hasNext()) {
                if (((Long) ((Entry) it.next()).getKey()).longValue() + 259200000 < j2) {
                    it.remove();
                }
            }
            b(str, kt);
            long j3 = com.tencent.mm.sdk.b.b.bsI() ? 180000 : 3600000;
            long a = be.a(aVar.Lb("LAST_REPORT_STATISITIC_TIME"), 0);
            if (a + j3 > j2) {
                v.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", Long.valueOf(a), Long.valueOf(j2), Long.valueOf(j3));
                return;
            }
            c cVar;
            int i;
            aVar.H("LAST_REPORT_STATISITIC_TIME", j2);
            HashMap hashMap = new HashMap();
            for (Long l : kt.keySet()) {
                if (l.longValue() > a) {
                    hashMap.put(l, kt.get(l));
                }
            }
            long j4 = Long.MAX_VALUE;
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            for (int i2 = 0; i2 < this.dbn.size(); i2++) {
                if ("pagestat".equals(((c) this.dbn.get(i2)).dbB)) {
                    cVar = (c) this.dbn.get(i2);
                    break;
                }
            }
            cVar = null;
            long j5 = 0;
            for (Long l2 : hashMap.keySet()) {
                if (j4 > l2.longValue()) {
                    a = l2.longValue();
                } else {
                    a = j4;
                }
                ArrayList arrayList2 = (ArrayList) hashMap.get(l2);
                j5 += ((b) arrayList2.get(arrayList2.size() - 1)).dbx - ((b) arrayList2.get(0)).time;
                if (j5 < 0 || j5 > 172800000) {
                    v.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", Long.valueOf(j5));
                    return;
                }
                i = 0;
                b bVar = null;
                while (i < arrayList2.size()) {
                    b bVar2 = (b) arrayList2.get(i);
                    r28 = new Object[5];
                    r28[1] = Long.valueOf(be.d((Long) hashMap2.get(bVar2.dbw)));
                    r28[2] = Long.valueOf(bVar2.dbx);
                    r28[3] = Long.valueOf(bVar2.time);
                    r28[4] = Long.valueOf(bVar2.dbx - bVar2.time);
                    v.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", r28);
                    long j6 = bVar2.dbx - bVar2.time;
                    if (j6 < 0 || j6 > 86400000) {
                        v.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", Long.valueOf(bVar2.time), Long.valueOf(bVar2.dbx), Long.valueOf(Ni), Long.valueOf(j6));
                        j6 = 0;
                    }
                    hashMap2.put(bVar2.dbw, Long.valueOf(j6 + be.d((Long) hashMap2.get(bVar2.dbw))));
                    hashMap3.put(bVar2.dbw, Long.valueOf(be.d((Long) hashMap3.get(bVar2.dbw)) + 1));
                    if (bVar != null) {
                        String str2 = bVar.dbw + "," + bVar2.dbw;
                        hashMap5.put(str2, Long.valueOf(be.d((Long) hashMap5.get(str2)) + 1));
                    }
                    i++;
                    bVar = bVar2;
                }
                if (cVar != null) {
                    Iterator it2 = cVar.dbD.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        str = ((String) pair.first) + "," + ((String) pair.second);
                        if (hashMap5.containsKey(str)) {
                            hashMap4.put(pair.second, hashMap5.get(str));
                        }
                    }
                }
                j4 = a;
            }
            a = ((b) ((ArrayList) hashMap.get(Long.valueOf(j4))).get(0)).time;
            if (a > Ni || a < 0) {
                v.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", Long.valueOf(a), Long.valueOf(Ni));
                return;
            }
            c cVar2;
            int i3 = 0;
            while (i3 < this.dbn.size()) {
                try {
                    if ("appstat".equals(((c) this.dbn.get(i3)).dbB)) {
                        cVar2 = (c) this.dbn.get(i3);
                        break;
                    }
                    i3++;
                } catch (Throwable e) {
                    v(15006, be.e(e));
                    v.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", be.e(e));
                }
            }
            cVar2 = null;
            c cVar3;
            JSONArray jSONArray;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            if (cVar2 == null || (j2 - a) - j5 <= 0) {
                v.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null");
                while (i3 < this.dbn.size()) {
                    try {
                        if (!"pagestat".equals(((c) this.dbn.get(i3)).dbB)) {
                            cVar3 = (c) this.dbn.get(i3);
                            break;
                        }
                    } catch (Throwable e2) {
                        v(15007, be.e(e2));
                        v.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", be.e(e2));
                        return;
                    }
                }
                cVar3 = null;
                if (cVar3 != null) {
                    if (cVar3.dby > Nh) {
                        if (a(j, cVar3.dbz, this.dbp)) {
                            v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", cVar3, Long.valueOf(Nh));
                            i = be.f(aVar.Lc("SEQ_" + cVar3.dbA));
                            aVar.bH("SEQ_" + cVar3.dbA, i + 1);
                            jSONArray = new JSONArray();
                            for (String str3 : hashMap2.keySet()) {
                                jSONObject = new JSONObject();
                                jSONObject.put("p", str3).put("in", ((Long) hashMap2.get(str3)).longValue() / 1000).put("c", hashMap3.get(str3)).put("c2", hashMap4.get(str3));
                                jSONArray.put(jSONObject);
                            }
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("t", 6).put("tbe", a / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                            a(cVar3.dbA, cVar3.id, i, jSONObject2.toString());
                            return;
                        }
                    }
                    v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", cVar3, Long.valueOf(Nh));
                    return;
                }
                v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            }
            if (cVar2.dby > Nh) {
                if (a(j, cVar2.dbz, this.dbp)) {
                    v.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", cVar2, Long.valueOf(Nh));
                    int f = be.f(aVar.Lc("SEQ_" + cVar2.dbA));
                    aVar.bH("SEQ_" + cVar2.dbA, f + 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("t", 5).put("tbe", a / 1000).put("ten", j2 / 1000).put("in", j5 / 1000).put("inbg", ((j2 - a) - j5) / 1000).put("swc", hashMap.size());
                    a(cVar2.dbA, cVar2.id, f, jSONObject3.toString());
                    for (i3 = 0; i3 < this.dbn.size(); i3++) {
                        if (!"pagestat".equals(((c) this.dbn.get(i3)).dbB)) {
                            cVar3 = (c) this.dbn.get(i3);
                            break;
                        }
                    }
                    cVar3 = null;
                    if (cVar3 != null) {
                        v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
                    }
                    if (cVar3.dby > Nh) {
                        if (a(j, cVar3.dbz, this.dbp)) {
                            v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", cVar3, Long.valueOf(Nh));
                            i = be.f(aVar.Lc("SEQ_" + cVar3.dbA));
                            aVar.bH("SEQ_" + cVar3.dbA, i + 1);
                            jSONArray = new JSONArray();
                            for (String str32 : hashMap2.keySet()) {
                                jSONObject = new JSONObject();
                                jSONObject.put("p", str32).put("in", ((Long) hashMap2.get(str32)).longValue() / 1000).put("c", hashMap3.get(str32)).put("c2", hashMap4.get(str32));
                                jSONArray.put(jSONObject);
                            }
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("t", 6).put("tbe", a / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                            a(cVar3.dbA, cVar3.id, i, jSONObject2.toString());
                            return;
                        }
                    }
                    v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", cVar3, Long.valueOf(Nh));
                    return;
                }
            }
            v.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", cVar2, Long.valueOf(Nh));
            for (i3 = 0; i3 < this.dbn.size(); i3++) {
                if (!"pagestat".equals(((c) this.dbn.get(i3)).dbB)) {
                    cVar3 = (c) this.dbn.get(i3);
                    break;
                }
            }
            cVar3 = null;
            if (cVar3 != null) {
                if (cVar3.dby > Nh) {
                    if (a(j, cVar3.dbz, this.dbp)) {
                        v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", cVar3, Long.valueOf(Nh));
                        i = be.f(aVar.Lc("SEQ_" + cVar3.dbA));
                        aVar.bH("SEQ_" + cVar3.dbA, i + 1);
                        jSONArray = new JSONArray();
                        for (String str322 : hashMap2.keySet()) {
                            jSONObject = new JSONObject();
                            jSONObject.put("p", str322).put("in", ((Long) hashMap2.get(str322)).longValue() / 1000).put("c", hashMap3.get(str322)).put("c2", hashMap4.get(str322));
                            jSONArray.put(jSONObject);
                        }
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("t", 6).put("tbe", a / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                        a(cVar3.dbA, cVar3.id, i, jSONObject2.toString());
                        return;
                    }
                }
                v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", cVar3, Long.valueOf(Nh));
                return;
            }
            v.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
        } catch (Throwable e22) {
            v.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", be.e(e22));
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private synchronized HashMap<Long, ArrayList<b>> kt(String str) {
        HashMap<Long, ArrayList<b>> hashMap;
        ObjectInputStream objectInputStream;
        Throwable e;
        InputStream inputStream;
        FileInputStream fileInputStream = null;
        synchronized (this) {
            long Ni = be.Ni();
            try {
                File file = new File(str);
                if (!file.exists() || file.length() <= 0) {
                    v.w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", str);
                    hashMap = new HashMap();
                } else {
                    InputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        objectInputStream = new ObjectInputStream(fileInputStream2);
                        try {
                            hashMap = (HashMap) objectInputStream.readObject();
                            v.i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", Integer.valueOf(hashMap.size()), Long.valueOf(be.ay(Ni)));
                            try {
                                objectInputStream.close();
                            } catch (Exception e2) {
                            }
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = fileInputStream2;
                            try {
                                v.e("MicroMsg.ClickFlowStatReceiver", "readStorage exception: %s [%s]", e.getMessage(), be.e(e));
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e6) {
                                    }
                                }
                                hashMap = new HashMap();
                                return hashMap;
                            } catch (Throwable th) {
                                e = th;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e7) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            inputStream = fileInputStream2;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        objectInputStream = null;
                        inputStream = fileInputStream2;
                        v.e("MicroMsg.ClickFlowStatReceiver", "readStorage exception: %s [%s]", e.getMessage(), be.e(e));
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        hashMap = new HashMap();
                        return hashMap;
                    } catch (Throwable th3) {
                        e = th3;
                        objectInputStream = null;
                        inputStream = fileInputStream2;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e;
                    }
                }
            } catch (Exception e10) {
                e = e10;
                objectInputStream = null;
                v.e("MicroMsg.ClickFlowStatReceiver", "readStorage exception: %s [%s]", e.getMessage(), be.e(e));
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                hashMap = new HashMap();
                return hashMap;
            } catch (Throwable th4) {
                e = th4;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return hashMap;
    }

    private synchronized void b(String str, HashMap<Long, ArrayList<b>> hashMap) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream2 = null;
        synchronized (this) {
            try {
                long Ni = be.Ni();
                fileOutputStream = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        v.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), be.e(e));
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream = fileOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream.flush();
                    v.i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", Integer.valueOf(hashMap.size()), Long.valueOf(be.ay(Ni)));
                    try {
                        objectOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e8) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream2 = fileOutputStream;
                    v.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), be.e(e));
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    return;
                } catch (Throwable th3) {
                    e = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Exception e10) {
                e = e10;
                objectOutputStream = null;
                v.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", e.getMessage(), be.e(e));
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                objectOutputStream = null;
                fileOutputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
        return;
    }

    private static void a(int i, String str, int i2, String str2) {
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                v.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length())));
                g.iuh.a(346, 4, 1, false);
                g.iuh.Y(i, r11);
            }
        } catch (Throwable e) {
            v(15009, be.e(e));
            v.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", be.e(e));
        }
    }

    private static String ao(long j) {
        if (j < 100000000000L) {
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
    }

    private static String bf(Context context) {
        int i;
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools"))) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return SQLiteDatabase.KeyEmpty;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return SQLiteDatabase.KeyEmpty;
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            v.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", e.getMessage(), be.e(e));
        }
    }
}
