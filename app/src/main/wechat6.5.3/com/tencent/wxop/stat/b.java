package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.a.a.a.a.g;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import java.net.URI;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static long G = 0;
    private static long H = 300000;
    private static int J = 0;
    private static int M = 0;
    private static boolean N = false;
    private static String Q = null;
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    static String f = "";
    static boolean g = false;
    static int h = 100;
    static long i = 10000;
    static boolean j = true;
    static volatile String k = "pingma.qq.com:80";
    static boolean l = true;
    static int m = 0;
    static int o = 512;
    private static com.tencent.wxop.stat.b.b pKc = l.bQC();
    static af pKd = new af(2);
    static af pKe = new af(1);
    private static c pKf = c.APP_LAUNCH;
    private static String pKg = null;
    private static String pKh;
    private static String pKi;
    private static String pKj = "mta_channel";
    private static int pKk = 180;
    private static int pKl = 1024;
    public static boolean pKm = true;
    private static volatile String pKn = "http://pingma.qq.com:80/mstat/report";
    private static volatile int pKo = 0;
    private static int pKp = 20;
    private static int pKq = Downloads.RECV_BUFFER_SIZE;
    private static boolean pKr = false;
    private static boolean pKs = false;
    private static ag pKt = null;
    static long pKu = 10000;
    private static boolean r = false;
    private static boolean s = true;
    private static int t = 30000;
    private static int u = 100000;
    private static int v = 30;
    private static int w = 10;
    private static int x = 100;
    private static int y = 30;
    private static int z = 1;

    private static void K(JSONObject jSONObject) {
        try {
            c zO = c.zO(jSONObject.getInt("rs"));
            if (zO != null) {
                pKf = zO;
                if (zO != c.PERIOD) {
                    d.c = 0;
                }
                if (r) {
                    pKc.bz("Change to statSendStrategy: " + zO);
                }
            }
        } catch (JSONException e) {
            if (r) {
                pKc.bw("rs not found.");
            }
        }
    }

    static String QX(String str) {
        try {
            String string = pKe.pMa.getString(str);
            if (string != null) {
                return string;
            }
        } catch (Throwable th) {
            pKc.bx("can't find custom key:" + str);
        }
        return null;
    }

    public static void QY(String str) {
        if (str == null || str.length() == 0) {
            pKc.error("statReportUrl cannot be null or empty.");
            return;
        }
        pKn = str;
        try {
            k = new URI(pKn).getHost();
        } catch (Exception e) {
            pKc.bx(e);
        }
        if (r) {
            pKc.bw("url:" + pKn + ", domain:" + k);
        }
    }

    static int a() {
        return v;
    }

    private static void a(long j) {
        q.a(ai.a(), c, j);
        kH(false);
        pKc.warn("MTA is disable for current SDK version");
    }

    static void a(Context context, af afVar) {
        if (afVar.a == pKe.a) {
            pKe = afVar;
            K(afVar.pMa);
            if (!pKe.pMa.isNull("iplist")) {
                f gQ = f.gQ(context);
                String string = pKe.pMa.getString("iplist");
                if (r) {
                    gQ.pKO.bw("updateIpList " + string);
                }
                try {
                    if (l.c(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        if (jSONObject.length() > 0) {
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                string = jSONObject.getString((String) keys.next());
                                if (l.c(string)) {
                                    for (String str : string.split(";")) {
                                        String str2;
                                        if (l.c(str2)) {
                                            String[] split = str2.split(":");
                                            if (split.length > 1) {
                                                str2 = split[0];
                                                if (f.b(str2) && !gQ.a.contains(str2)) {
                                                    if (r) {
                                                        gQ.pKO.bw("add new ip:" + str2);
                                                    }
                                                    gQ.a.add(str2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable e) {
                    gQ.pKO.i(e);
                }
                gQ.f = new Random().nextInt(gQ.a.size());
            }
        } else if (afVar.a == pKd.a) {
            pKd = afVar;
        }
    }

    private static void a(Context context, af afVar, JSONObject jSONObject) {
        try {
            String str;
            Object obj;
            Iterator keys = jSONObject.keys();
            Object obj2 = null;
            while (keys.hasNext()) {
                str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    obj = afVar.d != i ? 1 : obj2;
                    afVar.d = i;
                    obj2 = obj;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        afVar.pMa = new JSONObject(str);
                    }
                } else {
                    try {
                        if (str.equalsIgnoreCase("m")) {
                            afVar.c = jSONObject.getString("m");
                        }
                    } catch (JSONException e) {
                        pKc.bz("__HIBERNATE__ not found.");
                    } catch (Throwable th) {
                        pKc.i(th);
                    }
                }
            }
            if (obj2 == 1) {
                r gR = r.gR(ai.a());
                if (!(gR == null || afVar == null)) {
                    gR.pKL.a(new w(gR, afVar));
                }
                if (afVar.a == pKe.a) {
                    K(afVar.pMa);
                    JSONObject jSONObject2 = afVar.pMa;
                    if (!(jSONObject2 == null || jSONObject2.length() == 0)) {
                        Context a = ai.a();
                        try {
                            str = jSONObject2.optString(e);
                            if (l.c(str)) {
                                JSONObject jSONObject3 = new JSONObject(str);
                                if (jSONObject3.length() != 0) {
                                    if (!jSONObject3.isNull("sm")) {
                                        obj = jSONObject3.get("sm");
                                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                                        if (intValue > 0) {
                                            if (r) {
                                                pKc.bw("match sleepTime:" + intValue + " minutes");
                                            }
                                            q.a(a, d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                                            kH(false);
                                            pKc.warn("MTA is disable for current SDK version");
                                        }
                                    }
                                    if (d(jSONObject3, "sv", "2.0.3")) {
                                        pKc.bw("match sdk version:2.0.3");
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (d(jSONObject3, "md", Build.MODEL)) {
                                        pKc.bw("match MODEL:" + Build.MODEL);
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "av", l.ha(a))) {
                                        pKc.bw("match app version:" + l.ha(a));
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "mf", Build.MANUFACTURER)) {
                                        pKc.bw("match MANUFACTURER:" + Build.MANUFACTURER);
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "osv", VERSION.SDK_INT)) {
                                        pKc.bw("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "ov", VERSION.SDK_INT)) {
                                        pKc.bw("match android SDK version:" + VERSION.SDK_INT);
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "ui", r.gR(a).gS(a).a)) {
                                        pKc.bw("match imei:" + r.gR(a).gS(a).a);
                                        obj = 1;
                                    }
                                    if (d(jSONObject3, "mid", gH(a))) {
                                        pKc.bw("match mid:" + gH(a));
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        a(l.QZ("2.0.3"));
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            pKc.i(th2);
                        }
                        str = jSONObject2.getString(c);
                        if (r) {
                            pKc.bz("hibernateVer:" + str + ", current version:2.0.3");
                        }
                        long QZ = l.QZ(str);
                        if (l.QZ("2.0.3") <= QZ) {
                            a(QZ);
                        }
                    }
                }
            }
            a(context, afVar);
        } catch (Throwable th22) {
            pKc.i(th22);
        } catch (Throwable th222) {
            pKc.i(th222);
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(pKe.a))) {
                    a(context, pKe, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(pKd.a))) {
                    a(context, pKd, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    c zO = c.zO(jSONObject.getInt(str));
                    if (zO != null) {
                        pKf = zO;
                        if (r) {
                            pKc.bz("Change to ReportStrategy:" + zO.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            pKc.i(e);
        }
    }

    static void b() {
        M++;
    }

    public static c bPV() {
        return pKf;
    }

    public static boolean bPW() {
        return r;
    }

    public static boolean bPX() {
        return s;
    }

    public static int bPY() {
        return t;
    }

    public static int bPZ() {
        return x;
    }

    public static int bQa() {
        return y;
    }

    public static int bQb() {
        return w;
    }

    public static int bQc() {
        return z;
    }

    public static int bQd() {
        return u;
    }

    public static int bQe() {
        return pKk;
    }

    public static int bQf() {
        return pKl;
    }

    public static boolean bQg() {
        return pKm;
    }

    public static String bQh() {
        return pKn;
    }

    static synchronized void bQi() {
        synchronized (b.class) {
            pKo = 0;
        }
    }

    public static int bQj() {
        return pKp;
    }

    static void bQk() {
        M = 0;
    }

    public static boolean bQl() {
        return pKr;
    }

    public static ag bQm() {
        return pKt;
    }

    static int c() {
        return M;
    }

    private static boolean d(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (l.c(str2) && l.c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized String gD(Context context) {
        String str;
        synchronized (b.class) {
            if (pKh != null) {
                str = pKh;
            } else {
                if (context != null) {
                    if (pKh == null) {
                        pKh = l.f(context);
                    }
                }
                if (pKh == null || pKh.trim().length() == 0) {
                    pKc.error("AppKey can not be null or empty, please read Developer's Guide first!");
                }
                str = pKh;
            }
        }
        return str;
    }

    public static synchronized String gE(Context context) {
        String str;
        synchronized (b.class) {
            if (pKi != null) {
                str = pKi;
            } else {
                str = q.C(context, pKj, "");
                pKi = str;
                if (str == null || pKi.trim().length() == 0) {
                    pKi = l.gX(context);
                }
                if (pKi == null || pKi.trim().length() == 0) {
                    pKc.bx("installChannel can not be null or empty, please read Developer's Guide first!");
                }
                str = pKi;
            }
        }
        return str;
    }

    public static String gF(Context context) {
        return q.C(context, "mta.acc.qq", f);
    }

    public static String gG(Context context) {
        if (context == null) {
            pKc.error("Context for getCustomUid is null.");
            return null;
        }
        if (Q == null) {
            Q = q.C(context, "MTA_CUSTOM_UID", "");
        }
        return Q;
    }

    public static String gH(Context context) {
        return context != null ? g.P(context).nL().c : "0";
    }

    public static void kH(boolean z) {
        s = z;
        if (!z) {
            pKc.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }
}
