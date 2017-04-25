package com.c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r extends d {
    private static final DecimalFormat aKm = new DecimalFormat("0000000000");
    private static final DecimalFormat aKn = new DecimalFormat("0000000000000000");
    private static r aKo;
    String aKA;
    private String aKp;
    private String aKq;
    private final b aKr = new b();
    private int aKs;
    z aKt;
    private SharedPreferences aKu;
    private f aKv;
    private final Object aKw = new Object();
    private final d aKx = new d();
    private int aKy;
    q aKz;

    private static abstract class a implements Runnable {
        private final WeakReference<r> aKB;

        private a(r rVar) {
            this.aKB = new WeakReference(rVar);
        }

        final r ns() {
            r rVar = (r) this.aKB.get();
            if (rVar != null) {
                return rVar;
            }
            throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
        }
    }

    private static class b {
        int aJW;
        final byte[] aKC;
        private final byte[] aKD;

        private b() {
            this.aJW = -1;
            this.aKC = new byte[27];
            this.aKD = new byte[8];
        }
    }

    private static class c extends a {
        private final String aKE;
        private final long aKF;
        private final int aKG;

        private c(r rVar, String str, long j, int i) {
            super();
            this.aKE = str;
            this.aKF = j;
            this.aKG = i;
        }

        public final void run() {
            try {
                switch (this.aKG) {
                    case 0:
                        ns().e(this.aKE, this.aKF);
                        return;
                    case 1:
                        ns().aA(this.aKE);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    private static class d extends a {
        private boolean aKH;

        private d(r rVar) {
            super();
        }

        static /* synthetic */ d a(d dVar) {
            if (dVar.aKH) {
                throw new Exception("OnlineModule: new-session runnable occupied");
            }
            dVar.aKH = true;
            return dVar;
        }

        public final void run() {
            try {
                r.a(ns());
                f b = ns().aKv;
                try {
                    b.aHE = Build.MODEL;
                    b.aHF = VERSION.RELEASE;
                    b.versionName = b.aHC.versionName;
                    CharSequence loadLabel = b.mContext.getApplicationInfo().loadLabel(b.aHB);
                    b.aHD = loadLabel != null ? loadLabel.toString() : "unknown";
                    if (b.aHA != null) {
                        Sensor defaultSensor = b.aHA.getDefaultSensor(1);
                        Sensor defaultSensor2 = b.aHA.getDefaultSensor(4);
                        Sensor defaultSensor3 = b.aHA.getDefaultSensor(2);
                        Sensor defaultSensor4 = b.aHA.getDefaultSensor(11);
                        if (defaultSensor != null) {
                            b.aHI = 1;
                        }
                        if (defaultSensor2 != null) {
                            b.aHJ = 1;
                        }
                        if (defaultSensor3 != null) {
                            b.aHK = 1;
                        }
                        if (defaultSensor4 != null) {
                            b.aHL = 1;
                        }
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                }
            } catch (Exception e3) {
            }
            this.aKH = false;
        }
    }

    private static class e extends a {
        private final int aJR;
        private final String aKE;
        private final long aKF;
        private final long aKI;
        private final boolean aKJ;

        private e(r rVar, String str, long j, long j2, int i, boolean z) {
            super();
            this.aKE = str;
            this.aKF = j;
            this.aKI = j2;
            this.aJR = i;
            this.aKJ = z;
        }

        public final void run() {
            try {
                r.a(ns(), this.aKE, this.aKF, this.aKI, this.aJR, this.aKJ);
            } catch (Exception e) {
            }
        }
    }

    static class f extends p {
        final String aJX;
        final int aKK;
        final x aKL;
        final boolean aKM;

        private f(int i, x xVar, String str) {
            super(202);
            this.aKK = i;
            this.aKL = xVar;
            this.aJX = str;
            boolean z = (this.aKK < 0 || this.aKK == 4 || this.aKK == 2) ? false : true;
            this.aKM = z;
        }
    }

    private r() {
    }

    static r nl() {
        if (aKo == null) {
            aKo = new r();
        }
        return aKo;
    }

    final void N(Context context) {
        try {
            String str = this.aKA;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.aKp = aB(str);
            this.aKq = a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.aKv = new f(context);
        } catch (Exception e) {
        }
        this.aKu = context.getSharedPreferences("0-474-85242", 0);
    }

    final void a(Context context, Handler handler, a aVar) {
        this.aKt = z.b(handler);
        nm();
    }

    final void O(Context context) {
    }

    final void na() {
        this.aKz = null;
    }

    final void nm() {
        if (this.aKt != null) {
            try {
                this.aKt.execute(d.a(this.aKx));
            } catch (Exception e) {
            }
        }
    }

    final void az(String str) {
        if (this.aKt != null) {
            this.aKt.execute(new c(str, 0, 1));
        }
    }

    final boolean nn() {
        return this.aKr.aJW == 1;
    }

    static /* synthetic */ void a(r rVar) {
        try {
            rVar.nr();
            if (rVar.nn()) {
                rVar.aKs = 0;
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(r rVar, String str, long j, long j2, int i, boolean z) {
        if (rVar.aHp) {
            synchronized (rVar.aKw) {
                String no = rVar.no();
                String stringBuilder = str != null ? new StringBuilder(String.valueOf(str)).append(no).toString() : no;
                if (stringBuilder.length() > 0) {
                    try {
                        long p = aa.p(j);
                        int i2 = rVar.aKs + 1;
                        rVar.aKs = i2;
                        String str2 = y.aNt;
                        String str3 = y.aNy;
                        boolean z2 = y.aNA;
                        int i3 = y.aNu;
                        int i4 = y.aNv;
                        if (str2 == null || str3 == null) {
                            throw new Exception("StringBuilding: null mode or user name");
                        }
                        no = new StringBuilder(String.valueOf("ST=" + String.valueOf(p) + ',' + i2 + ',' + str2 + ',' + str3 + ',' + (z2 ? '1' : '0') + ',' + i3 + ',' + i4 + ',' + i)).append(stringBuilder).toString();
                        if (y.aNz) {
                            o.m("data_transaction_log_" + y.aNG, no);
                        }
                        Object encode = Base64.encode(g.k(no.getBytes("UTF-8")), 0);
                        Object obj = new byte[(rVar.aKr.aKC.length + encode.length)];
                        System.arraycopy(rVar.aKr.aKC, 0, obj, 0, rVar.aKr.aKC.length);
                        System.arraycopy(encode, 0, obj, rVar.aKr.aKC.length, encode.length);
                        rVar.aKv.imei = rVar.aKA;
                        stringBuilder = new String(rVar.aKz.l(rVar.aKv.j(obj).getBytes("UTF-8")));
                        if (y.aNz) {
                            o.m("data_transaction_log_" + y.aNG, stringBuilder);
                        }
                        p b = b(stringBuilder, j, j2);
                        if (b.aKM) {
                            rVar.np();
                            rVar.aKy = 0;
                        } else {
                            rVar.aKy++;
                            int length = rVar.nq().getString("1-115-10127", SQLiteDatabase.KeyEmpty).length();
                            if (rVar.aKy > 20 || (length > 10240 && rVar.aKy > 3)) {
                                rVar.np();
                            }
                        }
                        if (b.aKK == 4) {
                            rVar.aKr.aJW = -1;
                        }
                        rVar.c(b);
                        if (b.aKM) {
                            return;
                        }
                    } catch (Exception e) {
                        rVar.c(new f(0, null, "connection failure"));
                        if (z) {
                            rVar.e(str, aa.p(j));
                        }
                    }
                }
            }
        }
        if (z) {
            rVar.e(str, aa.p(j));
        }
    }

    private static f b(String str, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            if (optInt != 0) {
                return new f(optInt, null, null);
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), "UTF-8");
            if (y.aNz) {
                o.m("data_transaction_log_" + y.aNG, str2);
            }
            if (str2.length() <= h.aHQ || !str2.startsWith("$UP,")) {
                throw new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
            }
            switch (str2.charAt(h.aHQ)) {
                case '0':
                    return new f(0, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
                case '1':
                    if (str2.length() > h.aHR) {
                        x d = d(str2.substring(h.aHR), optLong);
                        d.aNm = j;
                        d.aKI = j2;
                        return new f(1, d, null);
                    }
                    break;
                case '2':
                    return new f(2, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
                case '3':
                    return new f(3, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
                case '4':
                    return new f(4, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
                case '5':
                    return new f(5, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
                case '6':
                    return new f(6, null, str2.length() > h.aHR ? str2.substring(h.aHR) : null);
            }
            throw new Exception("OnlineModule: unable to parse data upload reply");
        } catch (Exception e) {
            if (y.aNz) {
                o.m("data_transaction_log_" + y.aNG, "parse json data error");
            }
            throw new Exception("parse json data error");
        }
    }

    private static x d(String str, long j) {
        int i = 0;
        if (str != null) {
            String[] split = str.split(",", -1);
            if (split.length == 10) {
                try {
                    int parseInt;
                    int parseInt2;
                    int parseInt3;
                    double parseDouble = Double.parseDouble(split[0]);
                    double parseDouble2 = Double.parseDouble(split[1]);
                    float parseFloat = Float.parseFloat(split[8]);
                    try {
                        parseInt = Integer.parseInt(split[3]);
                    } catch (NumberFormatException e) {
                        parseInt = i;
                    }
                    try {
                        parseInt2 = Integer.parseInt(split[4]);
                    } catch (NumberFormatException e2) {
                        parseInt2 = i;
                    }
                    try {
                        parseInt3 = Integer.parseInt(split[5]);
                    } catch (NumberFormatException e3) {
                        parseInt3 = i;
                    }
                    try {
                        i = Integer.parseInt(split[7]);
                    } catch (NumberFormatException e4) {
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat(split[9]);
                    } catch (NumberFormatException e5) {
                    }
                    x xVar = new x();
                    xVar.latitude = parseDouble;
                    xVar.longitude = parseDouble2;
                    xVar.aNj = split[2];
                    xVar.level = parseInt;
                    xVar.aNl = (long) parseInt2;
                    xVar.aNo = parseInt3;
                    xVar.aNk = split[6];
                    xVar.aNp = i;
                    xVar.aJp = parseFloat;
                    if (xVar.aNn == null) {
                        xVar.aNn = new a();
                    }
                    xVar.aNn.aNq = f;
                    xVar.aJV = j;
                    return xVar;
                } catch (NumberFormatException e6) {
                }
            }
        }
        throw new Exception("OnlineModule: unable to get location from data upload reply");
    }

    private void e(String str, long j) {
        String str2 = null;
        String str3 = "1";
        if (!(str == null || str.startsWith("&OD[]="))) {
            String aE = v.aE(v.aF(str));
            aE = aE == null ? null : aE.replace("&MD=", "|MD,");
            if (aE != null) {
                str2 = aE.replace("&WD[]=", "|WD,");
            }
            str = v.a(str2, j, str3);
        }
        aA(str);
    }

    @SuppressLint({"NewApi"})
    private void aA(String str) {
        if (str != null) {
            synchronized (this.aKw) {
                try {
                    String stringBuilder = new StringBuilder(String.valueOf(nq().getString("1-115-10127", SQLiteDatabase.KeyEmpty))).append(str).toString();
                    int length = stringBuilder.length() - 307200;
                    if (length > 0) {
                        int indexOf = stringBuilder.indexOf("&OD[]=", length);
                        stringBuilder = indexOf >= length ? stringBuilder.substring(indexOf) : SQLiteDatabase.KeyEmpty;
                    }
                    if (VERSION.SDK_INT >= 9) {
                        nq().edit().putString("1-115-10127", stringBuilder).apply();
                    } else {
                        nq().edit().putString("1-115-10127", stringBuilder).commit();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                    try {
                        if (VERSION.SDK_INT >= 9) {
                            nq().edit().putString("1-115-10127", SQLiteDatabase.KeyEmpty).apply();
                        } else {
                            nq().edit().putString("1-115-10127", SQLiteDatabase.KeyEmpty).commit();
                        }
                    } catch (Exception e3) {
                    }
                }
            }
        }
    }

    private String no() {
        try {
            return nq().getString("1-115-10127", SQLiteDatabase.KeyEmpty);
        } catch (Exception e) {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    @SuppressLint({"NewApi"})
    private void np() {
        try {
            if (VERSION.SDK_INT >= 9) {
                nq().edit().remove("1-115-10127").apply();
            } else {
                nq().edit().remove("1-115-10127").commit();
            }
        } catch (Exception e) {
        }
    }

    private SharedPreferences nq() {
        if (this.aKu != null) {
            return this.aKu;
        }
        throw new Exception("OnlineModule: data buffer unavailable");
    }

    private synchronized void nr() {
        String str = this.aKp;
        String str2 = this.aKq;
        b bVar = this.aKr;
        if (str == null || str2 == null || bVar == null) {
            throw new Exception("OnlineModule: authenticate: null arg");
        }
        System.arraycopy(new StringBuilder(String.valueOf(str)).append(str2).toString().getBytes(), 0, bVar.aKC, 0, 27);
        bVar.aJW = 1;
    }

    private static String aB(String str) {
        try {
            return "T" + aKn.format(Long.parseLong(str) + System.currentTimeMillis());
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid device id, type: 0");
        }
    }

    private static String a(Long l) {
        if (l == null) {
            throw new Exception("OnlineModule: null source id");
        }
        try {
            return aKm.format(l);
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid source id");
        }
    }
}
