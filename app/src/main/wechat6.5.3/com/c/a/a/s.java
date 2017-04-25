package com.c.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

final class s {
    private long aKN;
    float aKO;
    private ArrayList<String> aKP = new ArrayList();
    private ArrayList<float[]> aKQ = new ArrayList();
    private ArrayList<double[]> aKR = new ArrayList();
    final d aKS;
    Handler aKT;

    private class a implements Runnable {
        final int aJU;
        final float aKU;
        final float aKV;
        final String aKW;
        final /* synthetic */ s aKX;
        final float x;
        final float y;

        private a(s sVar, float f, float f2, float f3, float f4, int i, String str) {
            this.aKX = sVar;
            this.x = f;
            this.y = f2;
            this.aKU = f3;
            this.aKV = f4;
            this.aJU = i;
            this.aKW = str;
        }

        public final void run() {
            this.aKX.a(this.x, this.y, this.aKU, this.aKV, this.aJU, this.aKW);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ s aKX;
        final double aKY;
        final double aKZ;
        final double aLa;
        final double aLb;
        final double aLc;
        final double aLd;
        final double lat;
        final double lng;

        private b(s sVar, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.aKX = sVar;
            this.lat = d;
            this.lng = d2;
            this.aKY = d3;
            this.aKZ = d4;
            this.aLa = d5;
            this.aLb = d6;
            this.aLc = d7;
            this.aLd = d8;
        }

        public final void run() {
            this.aKX.a(this.lat, this.lng, this.aKY, this.aKZ, this.aLa, this.aLb, this.aLc, this.aLd);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ s aKX;

        private c(s sVar) {
            this.aKX = sVar;
        }

        public final void run() {
            this.aKX.nu();
        }
    }

    private class d implements Runnable {
        private final p aHn;
        final /* synthetic */ s aKX;

        private d(s sVar, p pVar) {
            this.aKX = sVar;
            this.aHn = pVar;
        }

        public final void run() {
            this.aKX.aKS.c(this.aHn);
        }
    }

    private class f implements Runnable {
        final /* synthetic */ s aKX;

        private f(s sVar) {
            this.aKX = sVar;
        }

        public final void run() {
            this.aKX.reset();
        }
    }

    static class e extends p {
        final int aLe;

        e(int i) {
            super(8901);
            this.aLe = i;
        }
    }

    static class g extends p {
        final boolean aLf;

        g(boolean z) {
            super(8902);
            this.aLf = z;
        }
    }

    public s(d dVar) {
        this.aKS = dVar;
    }

    private void d(p pVar) {
        if (this.aKT != null) {
            this.aKT.post(new d(pVar));
        }
    }

    private static void aC(String str) {
        o.m("post_processing_log_" + y.aNG, str);
    }

    final void nt() {
        z.b(null).execute(new c());
    }

    final synchronized void nu() {
        try {
            ag(true);
        } catch (Exception e) {
        }
    }

    final void nv() {
        this.aKN = 0;
        this.aKO = 0.0f;
        z.b(null).execute(new f());
    }

    final synchronized void reset() {
        nw();
        nx();
    }

    private synchronized void nw() {
        this.aKR.clear();
    }

    private synchronized void nx() {
        this.aKP.clear();
        this.aKQ.clear();
    }

    private synchronized void ag(boolean z) {
        if (!(this.aKQ.isEmpty() || this.aKR.isEmpty())) {
            int size = z ? this.aKR.size() : this.aKR.size() - 1;
            int size2 = this.aKQ.size();
            if (size > 1) {
                int i = 0;
                int i2 = 1;
                while (i2 < size) {
                    int i3;
                    double[] dArr = (double[]) this.aKR.get(i2 - 1);
                    double[] dArr2 = (double[]) this.aKR.get(i2);
                    float[] fArr = new float[1];
                    Location.distanceBetween(dArr[0], dArr[1], dArr[0], (dArr[1] <= 179.0d ? 1.0E-5d : -1.0E-5d) + dArr[1], fArr);
                    double d = (double) fArr[0];
                    Location.distanceBetween(dArr[0], dArr[1], (dArr[0] <= 89.0d ? 1.0E-5d : -1.0E-5d) + dArr[0], dArr[1], fArr);
                    double d2 = (double) fArr[0];
                    double d3 = dArr2[0] - dArr[0];
                    double d4 = dArr2[1] - dArr[1];
                    if (d4 > 180.0d) {
                        d4 -= 360.0d;
                    } else if (d4 < -180.0d) {
                        d4 += 360.0d;
                    }
                    d4 = (d4 / 1.0E-5d) * d;
                    d3 = (d3 / 1.0E-5d) * d2;
                    double d5 = dArr2[4] - dArr[4];
                    double d6 = dArr2[5] - dArr[5];
                    double sqrt = Math.sqrt(((d4 * d4) + (d3 * d3)) / ((d5 * d5) + (d6 * d6)));
                    if (sqrt < ((double) (1.0f / y.aNJ)) || sqrt > ((double) y.aNJ)) {
                        int i4 = i;
                        while (i4 < size2 && ((double) ((float[]) this.aKQ.get(i4))[2]) <= dArr2[6]) {
                            i4++;
                        }
                        i3 = i4;
                    } else {
                        float f;
                        float f2;
                        float f3;
                        int i5;
                        Object obj;
                        int i6;
                        boolean z2;
                        d4 = Math.atan2(d3, d4) - Math.atan2(d6, d5);
                        d3 = Math.cos(d4);
                        double[] dArr3 = new double[]{d3, -Math.sin(d4), d5, d3};
                        if (sqrt < 1.0d) {
                            d4 = sqrt;
                        } else {
                            d4 = 1.0d / sqrt;
                        }
                        double d7 = d4 * 10.0d;
                        double abs = 1.0d + Math.abs(d5);
                        StringBuilder stringBuilder = new StringBuilder();
                        float f4 = 0.0f;
                        if (y.aNz) {
                            aC("ref_point," + dArr[0] + ',' + dArr[1] + ',' + dArr[2] + ',' + dArr[8]);
                            f = 0.0f;
                            f2 = 0.0f;
                            f3 = 0.0f;
                            i5 = 0;
                            obj = 1;
                            i6 = i;
                        } else {
                            f = 0.0f;
                            f2 = 0.0f;
                            f3 = 0.0f;
                            i5 = 0;
                            int i7 = 1;
                            i6 = i;
                        }
                        while (i6 < size2) {
                            float[] fArr2 = (float[]) this.aKQ.get(i6);
                            if (((double) fArr2[2]) > dArr2[6]) {
                                break;
                            }
                            float f5;
                            Object obj2;
                            fArr2[3] = Double.valueOf(Math.max(6.0d, Math.min((Math.abs((((double) fArr2[2]) - dArr[6]) / d7) * abs) + dArr[2], (Math.abs((((double) fArr2[2]) - dArr2[6]) / d7) * abs) + dArr2[2]))).floatValue();
                            double[] dArr4 = new double[]{((double) fArr2[0]) - dArr[4], ((double) fArr2[1]) - dArr[5]};
                            double[] dArr5 = new double[]{dArr4[0] * sqrt, dArr4[1] * sqrt};
                            dArr4 = new double[]{(dArr5[0] * dArr3[0]) + (dArr5[1] * dArr3[1]), (dArr5[0] * dArr3[2]) + (dArr5[1] * dArr3[3])};
                            dArr5 = new double[]{dArr4[0] + 0.0d, dArr4[1] + 0.0d};
                            double[] dArr6 = new double[]{((1.0E-5d * dArr5[1]) / d2) + dArr[0], ((1.0E-5d * dArr5[0]) / d) + dArr[1]};
                            if (dArr6[0] > 90.0d) {
                                dArr6[0] = 180.0d - dArr6[0];
                            } else if (dArr6[0] < -90.0d) {
                                dArr6[0] = -180.0d - dArr6[0];
                            }
                            if (dArr6[1] > 180.0d) {
                                dArr6[1] = dArr6[1] - 360.0d;
                            } else if (dArr6[1] < -180.0d) {
                                dArr6[1] = dArr6[1] + 360.0d;
                            }
                            if (y.aNz) {
                                aC("scan_point," + dArr6[0] + ',' + dArr6[1] + ',' + fArr2[3]);
                            }
                            String str = (String) this.aKP.get(i6);
                            int round = Math.round(fArr2[3]);
                            if (round > i5) {
                                i5 = round;
                            }
                            int round2 = Math.round(fArr2[4]);
                            if (str != null) {
                                try {
                                    stringBuilder.append(str);
                                    double d8 = dArr6[0];
                                    double d9 = dArr6[1];
                                    str = SQLiteDatabase.KeyEmpty;
                                    if (v.c(d8, d9)) {
                                        str = "|MD," + d8 + ',' + d9 + ',' + round + ',' + round2 + ',' + str;
                                    } else {
                                        str = SQLiteDatabase.KeyEmpty;
                                    }
                                    stringBuilder.append(str);
                                } catch (Error e) {
                                }
                            }
                            if (obj != null) {
                                f = fArr2[5];
                                f5 = fArr2[2];
                                obj2 = null;
                            } else {
                                obj2 = obj;
                                f5 = f;
                                f = f2;
                            }
                            f3 = fArr2[5];
                            f2 = f;
                            i6++;
                            f = f5;
                            obj = obj2;
                            f4 = fArr2[2];
                        }
                        if (y.aNz) {
                            aC("ref_point," + dArr2[0] + ',' + dArr2[1] + ',' + dArr2[2] + ',' + dArr2[8]);
                        }
                        if (((float) i5) <= y.aNH) {
                            float f6 = f3 - f2;
                            f4 -= f;
                            if (f6 > 0.0f && (((double) f4) * sqrt) / ((double) f6) <= ((double) y.aNI)) {
                                r.nl().az(stringBuilder.toString());
                                z2 = true;
                                if (y.aNz) {
                                    aC(z2 ? "buffered" : "discarded");
                                }
                                d(new g(z2));
                                i3 = i6;
                            }
                        }
                        z2 = false;
                        if (y.aNz) {
                            if (z2) {
                            }
                            aC(z2 ? "buffered" : "discarded");
                        }
                        d(new g(z2));
                        i3 = i6;
                    }
                    i2++;
                    i = i3;
                }
                this.aKP.subList(0, i).clear();
                this.aKP.trimToSize();
                this.aKQ.subList(0, i).clear();
                this.aKQ.trimToSize();
                this.aKR.subList(0, size - 1).clear();
                this.aKR.trimToSize();
            }
        }
    }

    final synchronized void a(float f, float f2, float f3, float f4, int i, String str) {
        this.aKP.add(str);
        this.aKQ.add(new float[]{f, f2, f3, null, (float) i, f4});
        if (this.aKP.size() > FileUtils.S_IRUSR) {
            this.aKP.subList(0, 1).clear();
            this.aKP.trimToSize();
            if (this.aKQ.size() > FileUtils.S_IRUSR) {
                this.aKQ.subList(0, 1).clear();
                this.aKQ.trimToSize();
            }
        }
    }

    final boolean a(double d, double d2, double d3, float f, double d4, double d5, double d6, long j) {
        if (f < y.aNK) {
            return false;
        }
        if (j - this.aKN < 1000 && f <= this.aKO) {
            return false;
        }
        z b = z.b(null);
        b.execute(new b(d, d2, d3, (double) f, d4, d5, d6, (double) j));
        this.aKN = j;
        this.aKO = f;
        return true;
    }

    final synchronized void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        Object obj;
        int size = this.aKR.size();
        int size2 = this.aKP.size();
        if (size <= 0) {
            this.aKR.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
            obj = 1;
        } else {
            Object obj2 = (double[]) this.aKR.get(size - 1);
            float[] fArr;
            if (d8 - obj2[8] >= 30000.0d) {
                fArr = new float[1];
                Location.distanceBetween(obj2[0], obj2[1], d, d2, fArr);
                if (fArr[0] >= 30.0f) {
                    this.aKR.add(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8});
                    obj = 1;
                    if (size >= 8) {
                        this.aKR.subList(0, 1).clear();
                        this.aKR.trimToSize();
                    }
                    try {
                        ag(false);
                    } catch (Exception e) {
                    }
                }
            } else if (d4 >= obj2[3]) {
                fArr = new float[]{30.0f};
                if (size > 1) {
                    double[] dArr = (double[]) this.aKR.get(size - 2);
                    Location.distanceBetween(dArr[0], dArr[1], d, d2, fArr);
                }
                if (fArr[0] >= 30.0f) {
                    System.arraycopy(new double[]{d, d2, d3, d4, d5, d6, d7, (double) size2, d8}, 0, obj2, 0, obj2.length);
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj != null) {
            int size3 = this.aKR.size();
            d(new e(size3));
            if (size3 == 1) {
                nx();
            }
        }
    }
}
