package com.c.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Array;
import java.util.List;

class n extends b {
    private final e aJA = new e();
    final j aJB = new j();
    private final d aJC = new d();
    private final i aJD;
    final s aJE;
    private long aJF;
    private long aJG;
    private long aJH;
    private int aJI;
    private long aJJ;
    private boolean aJK;
    private Location aJL;
    private int aJM;
    private float aJN;
    private float aJO;
    private float aJP;
    private int aJQ;
    private int aJR;
    private long aJS;

    private static class d {
        private String aKa;
        private long aKb;
        private String aKc;
        private long aKd;

        private d() {
        }

        final synchronized String a(String str, long j, boolean z) {
            String str2;
            if (z) {
                if (this.aKa != null && c(j, this.aKb)) {
                    str = new StringBuilder(String.valueOf(str)).append(this.aKa).toString();
                    this.aKa = null;
                }
                str2 = str;
                if (this.aKc != null && c(j, this.aKd)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(this.aKc).toString();
                    this.aKc = null;
                }
            } else {
                if (this.aKa != null && c(j, this.aKb)) {
                    str = new StringBuilder(String.valueOf(str)).append(v.aF(this.aKa)).toString();
                    this.aKa = null;
                }
                str2 = str;
                if (this.aKc != null && c(j, this.aKd)) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(v.aE(this.aKc)).toString();
                    this.aKc = null;
                }
            }
            return str2;
        }

        final synchronized void b(String str, long j) {
            this.aKa = str;
            this.aKb = j;
        }

        final synchronized void c(String str, long j) {
            this.aKc = str;
            this.aKd = j;
        }

        final synchronized void reset() {
            this.aKa = null;
            this.aKc = null;
            this.aKb = 0;
            this.aKd = 0;
        }

        static boolean c(long j, long j2) {
            return Math.abs(j - j2) <= 10000;
        }
    }

    private class e {
        long aKe;
        boolean aKf;
        final /* synthetic */ n aKg;

        private e(n nVar) {
            this.aKg = nVar;
            this.aKf = y.aNE;
        }

        final void af(boolean z) {
            if ((this.aKf ^ z) != 0) {
                this.aKf = !this.aKf;
                this.aKg.aJE.nt();
                this.aKg.aJE.nv();
                this.aKg.aJB.af(this.aKf);
                this.aKg.ni();
                if (y.aNz) {
                    String str = "vehicle mode: " + (this.aKf ? "enable" : "disable");
                    o.m("filter_input_log_" + y.aNG, str);
                    o.m("filter_output_log_" + y.aNG, str);
                }
            }
        }

        final void reset() {
            this.aKe = 0;
            this.aKf = y.aNE;
        }
    }

    static class a extends p {
        final int aJT;
        final int aJU;
        final long aJV;
        final double lat;
        final double lng;

        a(double d, double d2, int i, int i2, long j) {
            super(9901);
            this.lat = d;
            this.lng = d2;
            this.aJT = i;
            this.aJU = i2;
            this.aJV = j;
        }
    }

    static class b extends p {
        final int aJW;
        final String aJX;
        final boolean aJY;

        private b(int i, String str) {
            super(9902);
            this.aJW = i;
            this.aJX = str;
            this.aJY = false;
        }

        b(int i, String str, byte b) {
            this(i, str);
        }
    }

    static class c extends a {
        final long aJZ;

        c(long j, long j2) {
            super(Math.max(j, 3000));
            this.aJZ = j2;
        }
    }

    n() {
        if (i.aHX == null) {
            i.aHX = new i();
        }
        this.aJD = i.aHX;
        this.aJK = true;
        this.aJE = new s(this);
    }

    private boolean a(long j, int i, double d, double d2, double d3, float f, int i2, float f2) {
        boolean z;
        long j2 = j / 1000;
        double toRadians = Math.toRadians(d);
        double toRadians2 = Math.toRadians(d2);
        if (this.aJK) {
            this.aJB.a(j2, toRadians, toRadians2, f, this.aJA.aKf, y.aNF);
            this.aJK = false;
            z = true;
        } else {
            z = false;
        }
        a aVar = new a(i, (double) j2, toRadians, toRadians2, d3, (double) f, i2, (double) f2, 0, 0.0d, 0.0d);
        this.aJB.a(aVar);
        if (y.aNz) {
            o.m("filter_input_log_" + y.aNG, aVar.toString());
        }
        return z;
    }

    final void ni() {
        this.aJK = true;
        this.aJL = null;
        this.aJM = 0;
    }

    final void a(List<ScanResult> list, long j, long j2) {
        long p = aa.p(j);
        boolean z = this.aJG == 0 || j2 - this.aJG >= this.aJF;
        String a = v.a(list, z);
        String a2 = this.aJC.a(a, j2, z);
        if (z) {
            d nl = r.nl();
            int i = this.aJR;
            if (a2 != null) {
                long currentTimeMillis;
                if (nl.aHp) {
                    if (nl.nn()) {
                        currentTimeMillis = System.currentTimeMillis();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (nl.aKt != null) {
                            nl.aKt.execute(new e(a2, currentTimeMillis, elapsedRealtime, i));
                        }
                    } else {
                        nl.nm();
                    }
                }
                currentTimeMillis = aa.p(System.currentTimeMillis());
                if (nl.aKt != null) {
                    nl.aKt.execute(new c(a2, currentTimeMillis, 0));
                }
            }
        } else {
            r.nl().az(v.a(a2, p, "0"));
        }
        if (d.c(j2, this.aJH)) {
            String str;
            if (z) {
                str = null;
            } else {
                str = a;
            }
            if (str == null) {
                str = v.a(list, false);
            }
            String a3 = v.a(str, p, "2");
            s sVar = this.aJE;
            float f = this.aJN;
            float f2 = this.aJO;
            float f3 = this.aJP;
            float f4 = (float) this.aJQ;
            int i2 = this.aJI;
            if (sVar.aKO != 0.0f) {
                z.b(null).execute(new a(f, f2, f3, f4, i2, a3));
            }
        }
    }

    void a(x xVar, long j, long j2) {
        this.aJG = xVar.aKI;
        this.aJI = xVar.level;
        this.aJJ = xVar.aJV;
        if (xVar.aNk.equals("W")) {
            if (a(j2, 2, xVar.latitude, xVar.longitude, xVar.altitude, xVar.aJp, xVar.aNp, xVar.aJq)) {
                this.aJD.a(xVar.latitude, xVar.longitude, xVar.aJp, this.aJN, this.aJO, this.aJP);
            }
        }
        if (!u.nC().aLH) {
            c(new a(xVar.latitude, xVar.longitude, Float.valueOf(xVar.aJp).intValue(), this.aJI, this.aJJ));
        }
    }

    final void a(float f, float f2, int i, float f3, float f4, float f5, long j) {
        Object obj;
        e eVar = this.aJA;
        if (j - eVar.aKe > 5000) {
            eVar.af(false);
        }
        if (j - this.aJH > 5000) {
            nj();
        }
        this.aJN = f;
        this.aJO = f2;
        this.aJP = f4;
        this.aJQ = i;
        this.aJH = j;
        int i2 = f5 > 0.0f ? 1 : 0;
        this.aJR = i2;
        if (this.aJG != 0 || j - this.aJS >= 30000) {
            boolean z = i2 == 0;
            if (!(z && this.aJA.aKf)) {
                ab.nI().ae(z);
                k.nh().ae(z);
            }
        }
        double[] dArr = new double[2];
        i iVar = this.aJD;
        double[] dArr2 = new double[]{(double) f, (double) f2};
        if (iVar.aIg) {
            dArr[0] = iVar.aHY;
            dArr[1] = iVar.aHZ;
            dArr[0] = dArr[0] + ((1.0E-5d * (dArr2[1] - ((double) iVar.aIb))) / ((double) iVar.aIe));
            dArr[1] = dArr[1] + ((1.0E-5d * (dArr2[0] - ((double) iVar.aIa))) / ((double) iVar.aIf));
            if (dArr[0] > 90.0d) {
                dArr[0] = 180.0d - dArr[0];
            } else if (dArr[0] < -90.0d) {
                dArr[0] = -180.0d - dArr[0];
            }
            if (dArr[1] > 180.0d) {
                dArr[1] = dArr[1] - 360.0d;
            } else if (dArr[1] < -180.0d) {
                dArr[1] = dArr[1] + 360.0d;
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            double d = dArr[0];
            double d2 = dArr[1];
            iVar = this.aJD;
            float f6 = ((f4 - iVar.aIc) / 10.0f) + iVar.aId;
            float f7 = 0.0f;
            Location location = new Location("S");
            location.setLatitude(d);
            location.setLongitude(d2);
            if (this.aJL != null) {
                f7 = this.aJL.bearingTo(location);
            }
            this.aJL = location;
            int max = Math.max(0, i - this.aJM);
            this.aJM = i;
            a aVar = new a(3, (double) (j / 1000), Math.toRadians(d), Math.toRadians(d2), 0.0d, (double) f6, 0, (double) f5, max, (double) f3, Math.toRadians((double) f7));
            this.aJB.a(aVar);
            if (y.aNz) {
                o.m("filter_input_log_" + y.aNG, aVar.toString());
            }
            double[] dArr3 = new double[4];
            long j2 = j / 1000;
            double[] dArr4 = new double[2];
            double[] dArr5 = new double[2];
            double[] dArr6 = new double[2];
            double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            double[][] dArr8 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
            j jVar = this.aJB;
            d = ((double) j2) - jVar.aIi.aIk;
            double d3 = d * d;
            double[] dArr9 = new double[2];
            dArr4[0] = jVar.aIi.aIT[0] + (jVar.aIi.aIT[2] * d);
            dArr4[1] = (d * jVar.aIi.aIT[3]) + jVar.aIi.aIT[1];
            dArr6[0] = jVar.aIi.aIT[2];
            dArr6[1] = jVar.aIi.aIT[3];
            if (jVar.aIi.aIB) {
                dArr9[0] = dArr4[0] - jVar.aIi.aIC[0];
                dArr9[1] = dArr4[1] - jVar.aIi.aIC[1];
                d = Math.sqrt((dArr9[0] * dArr9[0]) + (dArr9[1] * dArr9[1]));
                d = (d * d) * jVar.aIi.aIW;
            } else {
                d = 0.0d;
            }
            dArr7[0][0] = (jVar.aIi.aIU[0][0] + (jVar.aIi.aIU[2][2] * d3)) + d;
            dArr7[0][1] = jVar.aIi.aIU[0][1] + (jVar.aIi.aIU[2][3] * d3);
            dArr7[1][0] = jVar.aIi.aIU[1][0] + (jVar.aIi.aIU[3][2] * d3);
            dArr7[1][1] = d + ((d3 * jVar.aIi.aIU[3][3]) + jVar.aIi.aIU[1][1]);
            dArr8[0][0] = jVar.aIi.aIU[2][2];
            dArr8[0][1] = jVar.aIi.aIU[2][3];
            dArr8[1][0] = jVar.aIi.aIU[3][2];
            dArr8[1][1] = jVar.aIi.aIU[3][3];
            jVar.a(1, dArr4, dArr5);
            dArr3[0] = Math.toDegrees(dArr5[0]);
            dArr3[1] = Math.toDegrees(dArr5[1]);
            dArr3[2] = Math.sqrt((dArr7[0][0] + dArr7[1][1]) / 2.0d);
            dArr3[3] = Math.sqrt((dArr6[0] * dArr6[0]) + (dArr6[1] * dArr6[1]));
            if (y.aNz) {
                o.m("filter_output_log_" + y.aNG, String.valueOf(j2) + ',' + dArr3[0] + ',' + dArr3[1] + ',' + dArr3[2] + ',' + dArr3[3]);
            }
            d = dArr3[0];
            double d4 = dArr3[1];
            int intValue = Double.valueOf(dArr3[2]).intValue();
            this.aJC.c(!v.c(d, d4) ? SQLiteDatabase.KeyEmpty : "&SD=" + d + ',' + d4 + ',' + 0 + ',' + intValue + ',' + this.aJI + ',' + 0 + ',' + Double.valueOf(dArr3[3]).intValue() + ',' + 0 + ',' + 0 + ',' + 0, j);
            c(new a(d, d4, intValue, this.aJI, this.aJJ));
        }
    }

    final void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2) {
        if (i2 > 0) {
            e eVar = this.aJA;
            if (i3 >= 3) {
                if (j2 - eVar.aKe <= 5000) {
                    eVar.af(true);
                }
                eVar.aKe = j2;
            }
            this.aJC.b(!v.c(d, d2) ? SQLiteDatabase.KeyEmpty : "&GD=" + d + ',' + d2 + ',' + i + ',' + i3 + ',' + i5 + ',' + i2 + ',' + Math.round(f) + ',' + j + ',', j2);
            if (a(j2, 1, d, d2, (double) i, (float) i2, i5, (float) i3)) {
                this.aJD.a(d, d2, (float) i2, this.aJN, this.aJO, this.aJP);
            }
            if (d.c(j2, this.aJH)) {
                this.aJE.a(d, d2, (double) i2, f, (double) this.aJN, (double) this.aJO, (double) this.aJP, j2);
            }
            if (y.aNz) {
                o.m("gps_log_" + y.aNG, String.valueOf(d) + ',' + d2 + ',' + i + ',' + i2 + ',' + i3 + ',' + i4 + ',' + i5 + ',' + f + ',' + j);
            }
        }
    }

    void a(int i, String str, long j, long j2) {
        c(new b(i, str, (byte) 0));
        if (i == -4 || i == -5) {
            stop();
        }
    }

    synchronized void a(Handler handler, a aVar) {
        if (aVar instanceof c) {
            aVar = (c) aVar;
        } else {
            aVar = new c(aVar != null ? aVar.aHt : 5000, 9000);
        }
        this.aJF = aVar.aJZ;
        nj();
        this.aJE.aKT = handler;
        this.aJS = SystemClock.elapsedRealtime();
        super.a(handler, aVar);
    }

    final synchronized void stop() {
        this.aJE.nt();
        super.stop();
    }

    private void nj() {
        this.aJD.aIg = false;
        this.aJE.nv();
        this.aJC.reset();
        this.aJA.reset();
        ni();
        this.aJG = 0;
        this.aJH = SystemClock.elapsedRealtime();
        this.aJN = 0.0f;
        this.aJO = 0.0f;
        this.aJP = 0.0f;
        this.aJQ = 0;
        this.aJR = 0;
        this.aJI = 0;
    }

    final a a(a aVar) {
        return new a(0);
    }
}
