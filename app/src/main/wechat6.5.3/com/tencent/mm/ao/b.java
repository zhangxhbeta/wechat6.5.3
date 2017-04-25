package com.tencent.mm.ao;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.al.k;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.d;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] cXc = "@wechat*weixin!!".getBytes();
    private static b cXd;
    private boolean cXe = false;
    private ad cXf;
    int cXg = 5000;
    int cXh = 5000;
    int cXi = 30000;
    private int cXj = 3600;
    private c cXk;
    private List<d> cXl = new ArrayList();
    private List<d> cXm = new ArrayList();
    private c cXn = new c<d>(this) {
        final /* synthetic */ b cXA;

        {
            this.cXA = r2;
            this.nhz = d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (!((d) bVar).aWo.aWp) {
                v.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(Math.max(this.cXA.cXh, this.cXA.cXg)));
                g.iuh.a(345, 5, 1, false);
                this.cXA.cXo.ea((long) r0);
            }
            return false;
        }
    };
    private ah cXo = new ah(ak.vA().htb.getLooper(), new a(this) {
        final /* synthetic */ b cXA;

        {
            this.cXA = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
            g.iuh.a(345, 2, 1, false);
            this.cXA.IC();
            return false;
        }
    }, false);
    private com.tencent.map.a.a.b cXp = new com.tencent.map.a.a.b(this) {
        final /* synthetic */ b cXA;

        {
            this.cXA = r1;
        }

        public final void a(double d, double d2, int i, int i2, long j) {
            v.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        }
    };
    private int cXq = 0;
    private com.tencent.map.a.a.c cXr = new com.tencent.map.a.a.c(this) {
        final /* synthetic */ b cXA;

        {
            this.cXA = r1;
        }

        public final void g(int i, String str) {
            v.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i), str);
            if (i != 0 && b.o(this.cXA) > 3) {
                v.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", Integer.valueOf(3));
                g.iuh.a(345, 3, 1, false);
                this.cXA.IC();
            }
        }
    };
    private long startTime = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ b cXA;
        final /* synthetic */ int cXs;
        final /* synthetic */ float cXt;
        final /* synthetic */ float cXu;
        final /* synthetic */ int cXv;
        final /* synthetic */ int cXw;
        final /* synthetic */ int cXx = 0;
        final /* synthetic */ String cXy;
        final /* synthetic */ String cXz;

        public AnonymousClass1(b bVar, int i, float f, float f2, int i2, int i3, int i4, String str, String str2) {
            this.cXA = bVar;
            this.cXs = i;
            this.cXt = f;
            this.cXu = f2;
            this.cXv = i2;
            this.cXw = i3;
            this.cXy = str;
            this.cXz = str2;
        }

        public final void run() {
            if (this.cXA.cXe) {
                v.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
            } else if (this.cXA.ID()) {
                b.IE();
                if (this.cXA.cXm.size() == 0 && this.cXA.cXl.size() == 0) {
                    b.e(this.cXA);
                }
                if (b.a(this.cXA, this.cXs, this.cXt, this.cXu)) {
                    v.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(this.cXs), Float.valueOf(this.cXt), Float.valueOf(this.cXu), Integer.valueOf(this.cXv));
                    this.cXA.cXe = true;
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(com.tencent.mm.platformtools.t.Nh()));
                    com.tencent.mm.sdk.c.a.nhr.e(this.cXA.cXn);
                    if (this.cXA.cXk != null) {
                        this.cXA.cXk.finish();
                    }
                    this.cXA.cXq = 0;
                    this.cXA.startTime = be.Nj();
                    this.cXA.cXk = new c(this.cXt, this.cXu, this.cXw, this.cXx, this.cXy, this.cXz, this.cXs, this.cXv);
                    Object IF = b.IB();
                    if (TextUtils.isEmpty(IF)) {
                        throw new NullPointerException("SenseWhereEngine:invalid imei!");
                    }
                    com.c.a.a.t.setImei(IF);
                    com.c.a.a.t.a(aa.getContext(), this.cXA.cXk);
                    Handler i = this.cXA.cXf = new ad("sensewhere");
                    int i2 = this.cXA.cXg;
                    com.c.a.a.t.a(i, (long) this.cXA.cXh, this.cXA.cXp, this.cXA.cXr);
                    g.iuh.a(345, 1, 1, false);
                    this.cXA.cXo.ea((long) this.cXA.cXi);
                }
            } else {
                v.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
            }
        }
    }

    static /* synthetic */ boolean a(b bVar, int i, float f, float f2) {
        List<d> list = i == 1 ? bVar.cXl : bVar.cXm;
        if (list == null || list.size() <= 0) {
            v.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            return false;
        }
        boolean z;
        long Nj = be.Nj();
        for (d dVar : list) {
            v.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.cXH));
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.cXH) {
                z = true;
                break;
            }
        }
        z = false;
        v.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(be.az(Nj)));
        return z;
    }

    static /* synthetic */ void e(b bVar) {
        bVar.cXl.clear();
        bVar.cXm.clear();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_SENSE_WHERE_LOCATION_STRING, SQLiteDatabase.KeyEmpty);
        if (be.kS(str)) {
            v.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            return;
        }
        Map q = f.q(str, "SenseWhere");
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i));
            str = (String) q.get(str2 + ".$gpstype");
            if (be.kS(str)) {
                g.iuh.a(345, 6, 1, false);
                v.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(bVar.cXm.size()), Integer.valueOf(bVar.cXl.size()));
                return;
            }
            d dVar = new d();
            dVar.cXG = str;
            dVar.longitude = be.getDouble((String) q.get(str2 + ".$longitude"), 0.0d);
            dVar.latitude = be.getDouble((String) q.get(str2 + ".$latitude"), 0.0d);
            dVar.cXH = be.getDouble((String) q.get(str2 + ".$distance"), 0.0d);
            if (dVar.cXH > 5500000.0d) {
                dVar.cXH = 5500000.0d;
            }
            if ("1".equals(dVar.cXG)) {
                bVar.cXl.add(dVar);
            } else {
                bVar.cXm.add(dVar);
            }
            i++;
        }
    }

    static /* synthetic */ void l(b bVar) {
        if (bVar.cXf != null) {
            bVar.cXf.htb.quit();
        }
        bVar.cXf = null;
    }

    static /* synthetic */ void n(b bVar) {
        if (bVar.startTime > 0) {
            v.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf((be.Nj() - bVar.startTime) / 1000), Integer.valueOf(be.f((Integer) g.a((int) ((be.Nj() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14))));
            g.iuh.a(345, (long) r0, 1, false);
        }
    }

    static /* synthetic */ int o(b bVar) {
        int i = bVar.cXq + 1;
        bVar.cXq = i;
        return i;
    }

    public static b IA() {
        if (cXd == null) {
            cXd = new b();
        }
        return cXd;
    }

    private static String IB() {
        String rJ = p.rJ();
        ak.yW();
        try {
            v.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new String(Base64.encode(new r().encrypt((rJ + "_" + new o(com.tencent.mm.model.c.ww()).toString()).getBytes("UTF-8"), cXc), 0), "UTF-8"), be.KW(r1));
            return new String(Base64.encode(new r().encrypt((rJ + "_" + new o(com.tencent.mm.model.c.ww()).toString()).getBytes("UTF-8"), cXc), 0), "UTF-8");
        } catch (Throwable e) {
            v.a("MicroMsg.SenseWhereHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public final void IC() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b cXA;

            {
                this.cXA = r1;
            }

            public final void run() {
                v.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
                com.tencent.mm.sdk.c.a.nhr.f(this.cXA.cXn);
                com.c.a.a.t.ny();
                com.c.a.a.t.finish();
                if (this.cXA.cXk != null) {
                    this.cXA.cXk.finish();
                    this.cXA.cXk = null;
                }
                b.l(this.cXA);
                this.cXA.cXo.QI();
                b.n(this.cXA);
                this.cXA.cXe = false;
            }
        });
    }

    private boolean ID() {
        ak.yW();
        if (new o(com.tencent.mm.model.c.ww()).longValue() < 1000000) {
            v.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            return false;
        }
        String value = j.sU().getValue("AndroidSenseWhereArgs");
        if (be.kS(value)) {
            v.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            return false;
        }
        try {
            v.d("MicroMsg.SenseWhereHelper", "sense where config : " + value);
            String[] split = value.split(";");
            int i = be.getInt(split[0], 0);
            ak.yW();
            if (h.aq(com.tencent.mm.model.c.ww() + 5, 100) > i) {
                v.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(h.aq(com.tencent.mm.model.c.ww() + 5, 100)), Integer.valueOf(i));
                return false;
            }
            this.cXh = be.getInt(split[1], 5000);
            this.cXg = be.getInt(split[2], 5000);
            this.cXi = be.getInt(split[3], 30000);
            this.cXj = be.getInt(split[4], 3600);
            v.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.cXh), Integer.valueOf(this.cXg), Integer.valueOf(this.cXi), Integer.valueOf(this.cXj));
            ak.yW();
            if (com.tencent.mm.platformtools.t.ax(((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue()) > ((long) this.cXj)) {
                return true;
            }
            v.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(com.tencent.mm.platformtools.t.ax(((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue())), Integer.valueOf(this.cXj));
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.SenseWhereHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            v.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            return false;
        }
    }

    public static void IE() {
        ak.yW();
        if (com.tencent.mm.platformtools.t.ax(com.tencent.mm.platformtools.t.e((Long) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, null))) * 1000 > 21600000) {
            v.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            ak.vy().a(new k(36), 0);
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(com.tencent.mm.platformtools.t.Nh()));
        }
    }
}
