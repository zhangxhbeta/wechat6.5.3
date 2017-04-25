package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.g;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class d {
    static volatile int a = 0;
    static volatile long b = 0;
    static volatile long c = 0;
    private static volatile Map<Object, Long> e = new ConcurrentHashMap();
    private static volatile Map<String, Properties> f = new ConcurrentHashMap();
    private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
    private static volatile long i = 0;
    private static volatile long j = 0;
    private static String k = "";
    private static volatile int l = 0;
    private static volatile String m = "";
    private static volatile String n = "";
    private static f pKD;
    private static volatile long pKE = 0;
    private static Map<String, Long> pKF = new ConcurrentHashMap();
    private static Map<String, Long> pKG = new ConcurrentHashMap();
    private static b pKH = l.bQC();
    private static UncaughtExceptionHandler pKI = null;
    private static Context pKJ = null;
    private static volatile boolean s = true;

    static int a(Context context, boolean z, e eVar) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z || currentTimeMillis - i < ((long) b.bPY())) {
            boolean z2 = false;
        } else {
            int i2 = 1;
        }
        i = currentTimeMillis;
        if (j == 0) {
            j = l.c();
        }
        if (currentTimeMillis >= j) {
            j = l.c();
            if (r.gR(context).gS(context).e != 1) {
                r.gR(context).gS(context).e = 1;
            }
            b.bQk();
            a = 0;
            k = l.bQD();
            i2 = 1;
        }
        Object obj = k;
        if (l.a(eVar)) {
            obj = eVar.a + k;
        }
        if (pKG.containsKey(obj)) {
            i = i2;
        }
        if (i != 0) {
            if (l.a(eVar)) {
                a(context, eVar);
            } else if (b.c() < b.bQj()) {
                l.hl(context);
                a(context, null);
            } else {
                pKH.by("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            pKG.put(obj, Long.valueOf(1));
        }
        if (s) {
            if (b.bPX()) {
                Context gI = gI(context);
                if (gI == null) {
                    pKH.error("The Context of StatService.testSpeed() can not be null!");
                } else if (gJ(gI) != null) {
                    pKD.a(new h(gI));
                }
            }
            s = false;
        }
        return l;
    }

    private static synchronized void a(Context context) {
        boolean z = false;
        synchronized (d.class) {
            if (context != null) {
                if (pKD == null) {
                    long bD = q.bD(context, b.c);
                    long QZ = l.QZ("2.0.3");
                    boolean z2 = true;
                    if (QZ <= bD) {
                        pKH.error("MTA is disable for current version:" + QZ + ",wakeup version:" + bD);
                        z2 = false;
                    }
                    bD = q.bD(context, b.d);
                    if (bD > System.currentTimeMillis()) {
                        pKH.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + bD);
                    } else {
                        z = z2;
                    }
                    b.kH(z);
                    if (z) {
                        Context applicationContext = context.getApplicationContext();
                        pKJ = applicationContext;
                        pKD = new f();
                        k = l.bQD();
                        pKE = System.currentTimeMillis() + b.i;
                        pKD.a(new al(applicationContext));
                    }
                }
            }
        }
    }

    private static void a(Context context, e eVar) {
        if (gJ(context) != null) {
            if (b.bPW()) {
                pKH.bz("start new session.");
            }
            if (eVar == null || l == 0) {
                l = l.a();
            }
            b.bQi();
            b.b();
            new n(new g(context, l, bQn(), eVar)).a();
        }
    }

    public static void a(Context context, String str, e eVar) {
        if (b.bPX()) {
            Context gI = gI(context);
            if (gI == null || str == null || str.length() == 0) {
                pKH.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (gJ(gI) != null) {
                pKD.a(new ap(str2, gI, eVar));
            }
        }
    }

    static void a(Context context, Throwable th) {
        if (b.bPX()) {
            Context gI = gI(context);
            if (gI == null) {
                pKH.error("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (gJ(gI) != null) {
                pKD.a(new an(gI, th));
            }
        }
    }

    static boolean a() {
        if (a < 2) {
            return false;
        }
        b = System.currentTimeMillis();
        return true;
    }

    public static void b(Context context, String str, e eVar) {
        if (b.bPX()) {
            Context gI = gI(context);
            if (gI == null || str == null || str.length() == 0) {
                pKH.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (gJ(gI) != null) {
                pKD.a(new j(gI, str2, eVar));
            }
        }
    }

    private static JSONObject bQn() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (b.pKe.d != 0) {
                jSONObject2.put("v", b.pKe.d);
            }
            jSONObject.put(Integer.toString(b.pKe.a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (b.pKd.d != 0) {
                jSONObject2.put("v", b.pKd.d);
            }
            jSONObject.put(Integer.toString(b.pKd.a), jSONObject2);
        } catch (Throwable e) {
            pKH.i(e);
        }
        return jSONObject;
    }

    static void c() {
        a = 0;
        b = 0;
    }

    static void d() {
        a++;
        b = System.currentTimeMillis();
        gO(pKJ);
    }

    private static Context gI(Context context) {
        return context != null ? context : pKJ;
    }

    private static f gJ(Context context) {
        if (pKD == null) {
            synchronized (d.class) {
                if (pKD == null) {
                    try {
                        a(context);
                    } catch (Throwable th) {
                        pKH.bQy();
                        b.kH(false);
                    }
                }
            }
        }
        return pKD;
    }

    public static void gK(Context context) {
        if (b.bPX() && gJ(context) != null) {
            pKD.a(new k(context, null));
        }
    }

    public static void gL(Context context) {
        if (b.bPX() && gJ(context) != null) {
            pKD.a(new am(context, null));
        }
    }

    static void gM(Context context) {
        if (b.bPX()) {
            Context gI = gI(context);
            if (gI == null) {
                pKH.error("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                ai.hu(gI).a(new com.tencent.wxop.stat.a.d(gI), new ao());
            } catch (Throwable th) {
                pKH.i(th);
            }
        }
    }

    public static void gN(Context context) {
        if (b.bPX()) {
            if (b.bPW()) {
                pKH.bw(new StringBuilder("commitEvents, maxNumber=-1").toString());
            }
            Context gI = gI(context);
            if (gI == null) {
                pKH.error("The Context of StatService.commitEvents() can not be null!");
            } else if (f.gQ(pKJ).f() && gJ(gI) != null) {
                pKD.a(new g(gI, -1));
            }
        }
    }

    public static void gO(Context context) {
        if (b.bPX() && b.m > 0) {
            Context gI = gI(context);
            if (gI == null) {
                pKH.error("The Context of StatService.testSpeed() can not be null!");
                return;
            }
            r gR = r.gR(gI);
            if (b.bPX()) {
                try {
                    gR.pKL.a(new u(gR));
                } catch (Throwable th) {
                    r.pLp.i(th);
                }
            }
        }
    }

    static void gP(Context context) {
        c = System.currentTimeMillis() + ((long) (60000 * b.bQe()));
        q.a(context, "last_period_ts", c);
        gN(context);
    }
}
