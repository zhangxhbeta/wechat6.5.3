package com.c.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u extends d implements SensorEventListener {
    private static u aLG;
    private static final int aLm;
    private static final int aLn;
    private SensorManager aHA = null;
    private float[][] aLA = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aLB = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[] aLC = new float[4];
    private float[][] aLD = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aLE = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aLF = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    boolean aLH;
    private c aLI;
    private boolean[] aLJ = new boolean[6];
    private int[] aLK = new int[6];
    private float[] aLL = new float[6];
    private float[] aLM = new float[6];
    private float[] aLN = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] aLO = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    private final d aLP = new d();
    private final f aLQ = new f();
    private final a aLR = new a();
    private Sensor aLo;
    private Sensor aLp;
    private Sensor aLq;
    private Sensor aLr;
    private Sensor aLs = null;
    private long aLt = 0;
    private boolean aLu = true;
    private float[][] aLv = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] aLw = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] aLx = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] aLy = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] aLz = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));

    private static class a {
        int aLS;
        float aLT;
        long aLU;
        float aLV;
        boolean aLW;
        long aLX;
        float[] aLY;
        float[] aLZ;
        float[] aMa;
        float[] aMb;
        float[] aMc;
        float[] aMd;
        float[] aMe;
        float[] aMf;
        float[] aMg;
        float aMh;
        float aMi;
        float aMj;
        boolean aMk;

        private a() {
            this.aLS = 0;
            this.aLT = 0.0f;
            this.aLU = 0;
            this.aLV = 0.0f;
            this.aLW = false;
            this.aLX = 0;
            this.aLY = new float[6];
            this.aLZ = new float[6];
            this.aMa = new float[6];
            this.aMb = new float[6];
            this.aMc = new float[6];
            this.aMd = new float[6];
            this.aMe = new float[6];
            this.aMf = new float[6];
            this.aMg = new float[6];
            this.aMh = 0.0f;
            this.aMi = Float.NEGATIVE_INFINITY;
            this.aMj = Float.POSITIVE_INFINITY;
            this.aMk = false;
        }

        final void reset() {
            this.aLS = 0;
            this.aLT = 0.0f;
            this.aLU = 0;
            this.aLV = 0.0f;
            this.aLW = false;
            this.aLX = 0;
            this.aLY = new float[6];
            this.aLZ = new float[6];
            this.aMa = new float[6];
            this.aMh = 0.0f;
            this.aMi = Float.NEGATIVE_INFINITY;
            this.aMj = Float.POSITIVE_INFINITY;
        }
    }

    private static class b {
        float[] aMA;
        float aMl;
        float aMm;
        float aMn;
        float aMo;
        float aMp;
        float aMq;
        float aMr;
        float aMs;
        float aMt;
        float aMu;
        float aMv;
        float[] aMw;
        float[] aMx;
        float[] aMy;
        float[] aMz;
        long time;

        private b() {
            this.aMw = new float[6];
            this.aMx = new float[6];
            this.aMy = new float[6];
            this.aMz = new float[6];
            this.aMA = new float[6];
        }
    }

    private static class d {
        private float aMC;
        private float aMD;
        private float aME;
        private float aMF;
        private float aMG;
        private float aMH;
        private float aMI;
        private float aMJ;
        private float aMK;
        private int count;

        private d() {
            this.count = 0;
            this.aMC = 0.0f;
            this.aMD = 0.0f;
            this.aME = 0.0f;
            this.aMF = 0.0f;
            this.aMG = 0.0f;
            this.aMH = 0.0f;
            this.aMI = 0.0f;
            this.aMJ = 0.0f;
            this.aMK = 0.0f;
        }

        final synchronized void reset() {
            this.count = 0;
            this.aMC = 0.0f;
            this.aMD = 0.0f;
            this.aME = 0.0f;
            this.aMF = 0.0f;
            this.aMG = 0.0f;
            this.aMH = 0.0f;
            this.aMI = 0.0f;
            this.aMJ = 0.0f;
            this.aMK = 0.0f;
        }

        final synchronized void a(float[] fArr, float[] fArr2, float[] fArr3) {
            if (fArr.length >= 3) {
                this.count++;
                this.aMC += fArr[0];
                this.aMD += fArr[1];
                this.aME += fArr[2];
                this.aMF += fArr2[0];
                this.aMG += fArr2[1];
                this.aMH += fArr2[2];
                this.aMI += fArr3[0];
                this.aMJ += fArr3[1];
                this.aMK += fArr3[2];
            }
        }

        final synchronized b a(float[][] fArr) {
            b bVar;
            synchronized (this) {
                if (this.count <= 0 || fArr.length < 3) {
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.time = SystemClock.elapsedRealtime();
                    for (int i = 0; i <= 5; i++) {
                        bVar.aMw[i] = fArr[i][0];
                        bVar.aMx[i] = fArr[i][1];
                        bVar.aMy[i] = fArr[i][2];
                        bVar.aMz[i] = (float) Math.sin((double) bVar.aMw[i]);
                        bVar.aMA[i] = (float) Math.cos((double) bVar.aMw[i]);
                    }
                    bVar.aMl = this.aMC / ((float) this.count);
                    bVar.aMm = this.aMD / ((float) this.count);
                    bVar.aMn = this.aME / ((float) this.count);
                    bVar.aMo = this.aMF / ((float) this.count);
                    bVar.aMp = this.aMG / ((float) this.count);
                    bVar.aMq = this.aMH / ((float) this.count);
                    bVar.aMr = this.aMI / ((float) this.count);
                    bVar.aMs = this.aMJ / ((float) this.count);
                    bVar.aMt = this.aMK / ((float) this.count);
                    bVar.aMv = (float) Math.sqrt((double) ((bVar.aMl * bVar.aMl) + (bVar.aMm * bVar.aMm)));
                    reset();
                }
            }
            return bVar;
        }
    }

    private class f {
        final /* synthetic */ u aMB;
        private ArrayList<b> aMO;
        private a[] aMP;
        private int aMQ;
        private float[][] aMR;
        private float[][] aMS;
        private float[][] aMT;
        private int[] aMU;
        private int aMV;
        private int aMW;
        private int aMX;

        private class a {
            int aMY;
            float aMZ;
            float aNa;
            float aNb;
            long aNc;
            final /* synthetic */ f aNd;
            float x;
            float y;
            float z;

            protected final /* synthetic */ Object clone() {
                return nG();
            }

            private a(f fVar) {
                this.aNd = fVar;
                this.x = 0.0f;
                this.y = 0.0f;
                this.z = 0.0f;
                this.aMY = 0;
                this.aMZ = 0.0f;
                this.aNa = 0.0f;
                this.aNb = 0.0f;
                this.aNc = 0;
            }

            protected final a nG() {
                a aVar = new a(this.aNd);
                aVar.x = this.x;
                aVar.y = this.y;
                aVar.z = this.z;
                aVar.aMY = this.aMY;
                aVar.aMZ = this.aMZ;
                aVar.aNa = this.aNa;
                aVar.aNc = this.aNc;
                aVar.aNb = this.aNb;
                return aVar;
            }
        }

        private f(u uVar) {
            this.aMB = uVar;
            this.aMO = new ArrayList();
            this.aMP = new a[5];
            this.aMQ = 0;
            this.aMR = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aMS = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aMT = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.aMU = new int[6];
            this.aMV = 5;
            this.aMW = -1;
            this.aMX = 0;
        }

        final synchronized void reset() {
            this.aMO.clear();
            this.aMP = new a[5];
            this.aMQ = 0;
            this.aMR = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aMS = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.aMT = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.aMU = new int[6];
            this.aMV = 5;
        }

        private synchronized boolean nD() {
            boolean z;
            if (this.aMQ >= 20) {
                float[] fArr = this.aMR[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aMR[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aMR[2];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aMS[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aMS[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.aMS[2];
                fArr[2] = fArr[2] / 20.0f;
                float f = this.aMS[0][2];
                float f2 = this.aMR[0][0] - this.aMR[0][2];
                float f3 = this.aMR[0][2] - this.aMR[0][1];
                float f4 = this.aMS[1][2];
                float f5 = this.aMR[1][0] - this.aMR[1][2];
                float f6 = this.aMR[1][2] - this.aMR[1][1];
                float f7 = this.aMS[2][2];
                float f8 = this.aMR[2][0] - this.aMR[2][2];
                float f9 = this.aMR[2][2] - this.aMR[2][1];
                this.aMT[0][0] = (f * 0.32999998f) + (0.67f * this.aMT[0][0]);
                this.aMT[0][1] = (f2 * 0.32999998f) + (0.67f * this.aMT[0][1]);
                this.aMT[0][2] = (f3 * 0.32999998f) + (0.67f * this.aMT[0][2]);
                this.aMT[1][0] = (0.67f * this.aMT[1][0]) + (f4 * 0.32999998f);
                this.aMT[1][1] = (0.67f * this.aMT[1][1]) + (0.32999998f * f5);
                this.aMT[1][2] = (0.67f * this.aMT[1][2]) + (0.32999998f * f6);
                this.aMT[2][0] = (0.67f * this.aMT[2][0]) + (0.32999998f * f7);
                this.aMT[2][1] = (0.67f * this.aMT[2][1]) + (0.32999998f * f8);
                this.aMT[2][2] = (0.67f * this.aMT[2][2]) + (0.32999998f * f9);
                a(nE());
                this.aMQ = 0;
                this.aMR = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.aMS = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.aMO.size() >= 100) {
                    this.aMO.subList(0, 20).clear();
                    this.aMO.trimToSize();
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        private synchronized a nE() {
            a aVar;
            Object obj;
            float abs;
            float abs2;
            float abs3;
            float f;
            int i;
            int i2;
            Object obj2 = this.aMX == 0 ? 1 : null;
            if (obj2 != null) {
                this.aMV = ((double) Math.abs(this.aMT[2][0])) < 9.3d ? 5 : 2;
                this.aMU = new int[6];
                obj = null;
            } else {
                Object obj3 = (Math.abs(this.aMT[0][0]) < 7.0f || (this.aMT[1][1] < 2.3f && this.aMT[1][2] < 2.3f)) ? null : 1;
                if (obj3 != null) {
                    this.aMV = 2;
                    this.aMU = new int[6];
                    obj = obj3;
                } else {
                    int i3;
                    abs = Math.abs(this.aMT[0][0]);
                    abs2 = Math.abs(this.aMT[1][0]);
                    abs3 = Math.abs(this.aMT[2][0]);
                    if (abs > abs2) {
                        if (abs > abs3) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                    } else if (abs2 > abs3) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    f = 0.0f;
                    int i4 = 0;
                    i = 0;
                    for (i2 = 0; i2 < 3; i2++) {
                        if (i2 != i3) {
                            for (int i5 = 1; i5 < 3; i5++) {
                                if (this.aMT[i2][i5] > f) {
                                    i4 = i2;
                                    f = this.aMT[i2][i5];
                                    i = i5;
                                }
                            }
                        }
                    }
                    i3 = ((i4 * 2) + i) - 1;
                    int[] iArr = this.aMU;
                    iArr[i3] = iArr[i3] + 1;
                    i3 = 0;
                    while (i3 <= 5) {
                        if (i3 != this.aMV && this.aMU[i3] > this.aMU[this.aMV]) {
                            this.aMV = i3;
                        }
                        i3++;
                    }
                    obj = obj3;
                }
            }
            if (this.aMW >= 0 && this.aMW <= 5) {
                this.aMV = this.aMW;
            }
            f fVar = this;
            aVar = new a();
            fVar = this;
            aVar = new a();
            if (this.aMP[0] != null) {
                aVar.aNc = this.aMP[0].aNc;
                aVar.aMZ = this.aMP[0].aMZ;
            }
            if (this.aMP[4] != null) {
                aVar.aNc = this.aMP[4].aNc;
                aVar.aMZ = this.aMP[4].aMZ;
            }
            if (!this.aMO.isEmpty()) {
                b bVar;
                i2 = this.aMO.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator it = this.aMO.iterator();
                abs3 = 0.0f;
                float f2 = 0.0f;
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    f2 += obj == null ? bVar.aMn : bVar.aMq;
                    if (obj == null) {
                        abs2 = bVar.aMv;
                    } else {
                        abs2 = (float) Math.sqrt((double) (((bVar.aMo * bVar.aMo) + (bVar.aMp * bVar.aMp)) + (bVar.aMq * bVar.aMq)));
                        bVar.aMu = abs2;
                    }
                    abs3 += abs2;
                    for (i = 0; i <= 5; i++) {
                        fArr[i] = fArr[i] + bVar.aMz[i];
                        fArr2[i] = fArr2[i] + bVar.aMA[i];
                    }
                }
                float f3 = f2 / ((float) i2);
                float f4 = abs3 / ((float) i2);
                float f5 = obj == null ? f3 : f4;
                float[] fArr3 = new float[]{(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
                f = obj == null ? f3 : f4;
                abs2 = 0.0f;
                float f6 = obj == null ? 1.2f : 1.0f;
                float f7 = obj2 != null ? 0.08726647f : 0.2617994f;
                Iterator it2 = this.aMO.iterator();
                float f8 = 0.0f;
                float f9 = 0.0f;
                int i6 = 0;
                f2 = f4;
                while (it2.hasNext()) {
                    float f10;
                    bVar = (b) it2.next();
                    float f11 = obj == null ? bVar.aMn : bVar.aMu;
                    abs3 = obj == null ? bVar.aMv : bVar.aMu;
                    if (obj == null) {
                        f10 = f3;
                    } else {
                        f10 = f4;
                    }
                    if (i6 > 0) {
                        float f12;
                        float f13;
                        if (f < f11) {
                            if (obj2 == null) {
                                f = f11 - f10;
                                if (f > 2.0f * f6) {
                                    f12 = f / 2.0f;
                                    f13 = f11;
                                }
                            }
                            f12 = f6;
                            f13 = f11;
                        } else {
                            f12 = f6;
                            f13 = f;
                        }
                        if (f2 < abs3) {
                            f = abs3;
                        } else {
                            f = f2;
                        }
                        if (f11 > f10) {
                            f6 = f12;
                            f2 = f;
                            i6++;
                            f = f13;
                        } else {
                            if (i6 <= 10) {
                                Object obj4 = 1;
                                if (aVar.aNc != 0 && bVar.time - aVar.aNc < 250) {
                                    obj4 = null;
                                }
                                if (obj4 != null && f - f4 < 0.3f) {
                                    obj4 = null;
                                }
                                if (obj4 != null) {
                                    aVar.aMY++;
                                    abs2 += f13;
                                    f2 = (float) Math.atan2((double) (bVar.aMz[this.aMV] + f9), (double) (bVar.aMA[this.aMV] + f8));
                                    abs3 = Math.abs(f2 - fArr3[this.aMV]);
                                    if (abs3 > 3.1415927f) {
                                        abs3 = 6.2831855f - abs3;
                                    }
                                    Object obj5 = abs3 >= f7 ? 1 : null;
                                    abs3 = 1.0f;
                                    if (obj5 != null) {
                                        abs3 = 0.93f;
                                    } else {
                                        f2 = fArr3[this.aMV];
                                    }
                                    f6 = (float) (Math.sin((double) f2) * ((double) abs3));
                                    abs3 = (float) (((double) abs3) * Math.cos((double) f2));
                                    aVar.x += f6;
                                    aVar.y += abs3;
                                    if (bVar.time - aVar.aNc > 250) {
                                        aVar.x -= f6;
                                        aVar.y -= abs3;
                                        aVar.aMY++;
                                    }
                                }
                                aVar.aNc = bVar.time;
                            }
                            abs3 = bVar.aMz[this.aMV];
                            f6 = f12;
                            f8 = bVar.aMA[this.aMV];
                            f9 = abs3;
                            i6 = 0;
                            f2 = f;
                            f = f13;
                        }
                    } else if (f11 <= f10) {
                        abs3 = bVar.aMz[this.aMV];
                        f8 = bVar.aMA[this.aMV];
                        f9 = abs3;
                    } else if (f11 - f10 >= f6) {
                        f2 = abs3;
                        f = f11;
                        i6 = 1;
                    }
                }
                if (aVar.aMY > 0) {
                    abs = obj == null ? 0.0f : 0.08f;
                    abs2 /= (float) aVar.aMY;
                    abs3 = aVar.aMZ;
                    abs += ((abs2 - f5) / 15.0f) + 0.537f;
                    if (abs3 != 0.0f) {
                        abs = (abs * 0.67f) + (0.33f * abs3);
                    }
                    aVar.aMZ = abs;
                    aVar.x *= aVar.aMZ;
                    aVar.y *= aVar.aMZ;
                    aVar.aNa = ((float) aVar.aMY) * aVar.aMZ;
                }
            }
            aVar.aNb = aVar.aNa / ((float) (this.aMO.size() / 20));
            if (this.aMP[0] != null) {
                aVar.x += this.aMP[0].x;
                aVar.y += this.aMP[0].y;
                aVar.z += this.aMP[0].z;
                aVar.aMY += this.aMP[0].aMY;
                aVar.aNa += this.aMP[0].aNa;
            }
            if (this.aMP[4] != null && aVar.aMY > 0) {
                this.aMP[4].x = ((this.aMP[4].x + aVar.x) + (aVar.x * aVar.aMZ)) / 2.0f;
                this.aMP[4].y = ((this.aMP[4].y + aVar.y) + (aVar.y * aVar.aMZ)) / 2.0f;
            }
            return aVar;
        }

        private synchronized void a(a aVar) {
            System.arraycopy(this.aMP, 1, this.aMP, 0, 4);
            if (this.aMP[4] == null || SystemClock.elapsedRealtime() - aVar.aNc <= 1000) {
                this.aMP[4] = aVar;
            } else {
                a aVar2 = this.aMP[4];
                aVar2.x = (aVar2.x + aVar.x) / 2.0f;
                aVar2.y = (aVar2.y + aVar.y) / 2.0f;
                aVar2.z = (aVar2.z + aVar.z) / 2.0f;
                aVar2.aMY = Math.round(((float) (aVar2.aMY + aVar.aMY)) / 2.0f);
                aVar2.aMZ = (aVar2.aMZ + aVar.aMZ) / 2.0f;
                aVar2.aNa = (aVar2.aNa + aVar.aNa) / 2.0f;
                aVar2.aNc = aVar.aNc;
                aVar2.aNb = aVar.aNb;
            }
        }

        final synchronized void a(b bVar) {
            if (this.aMX > 0 && this.aMX < MMGIFException.D_GIF_ERR_OPEN_FAILED) {
                this.aMX--;
            }
            this.aMO.add(bVar);
            this.aMQ++;
            if (bVar.aMo > this.aMR[0][0]) {
                this.aMR[0][0] = bVar.aMo;
            }
            if (bVar.aMo < this.aMR[0][1]) {
                this.aMR[0][1] = bVar.aMo;
            }
            float[] fArr = this.aMR[0];
            fArr[2] = fArr[2] + bVar.aMo;
            if (bVar.aMp > this.aMR[1][0]) {
                this.aMR[1][0] = bVar.aMp;
            }
            if (bVar.aMp < this.aMR[1][1]) {
                this.aMR[1][1] = bVar.aMp;
            }
            fArr = this.aMR[1];
            fArr[2] = fArr[2] + bVar.aMp;
            if (bVar.aMq > this.aMR[2][0]) {
                this.aMR[2][0] = bVar.aMq;
            }
            if (bVar.aMq < this.aMR[2][1]) {
                this.aMR[2][1] = bVar.aMq;
            }
            fArr = this.aMR[2];
            fArr[2] = fArr[2] + bVar.aMq;
            if (bVar.aMr > this.aMS[0][0]) {
                this.aMS[0][0] = bVar.aMr;
            }
            if (bVar.aMr < this.aMS[0][1]) {
                this.aMS[0][1] = bVar.aMr;
            }
            fArr = this.aMS[0];
            fArr[2] = fArr[2] + bVar.aMr;
            if (bVar.aMs > this.aMS[1][0]) {
                this.aMS[1][0] = bVar.aMs;
            }
            if (bVar.aMs < this.aMS[1][1]) {
                this.aMS[1][1] = bVar.aMs;
            }
            fArr = this.aMS[1];
            fArr[2] = fArr[2] + bVar.aMs;
            if (bVar.aMt > this.aMS[2][0]) {
                this.aMS[2][0] = bVar.aMt;
            }
            if (bVar.aMt < this.aMS[2][1]) {
                this.aMS[2][1] = bVar.aMt;
            }
            fArr = this.aMS[2];
            fArr[2] = fArr[2] + bVar.aMt;
            if (nD()) {
                u.b(this.aMB);
            }
        }

        final synchronized a nF() {
            return this.aMP[4] != null ? this.aMP[4].nG() : null;
        }
    }

    private class c extends e {
        final /* synthetic */ u aMB;

        c(u uVar, Handler handler) {
            this.aMB = uVar;
            super(handler);
        }

        final void ne() {
            u.a(this.aMB);
        }
    }

    static class e extends p {
        final float aJq;
        final float aML;
        final float aMM;
        final int aMN;
        final float x;
        final float y;

        private e(float f, float f2, int i, float f3, float f4, float f5) {
            super(301);
            this.x = f;
            this.y = f2;
            this.aMN = i;
            this.aML = f3;
            this.aMM = f4;
            this.aJq = f5;
        }
    }

    static {
        int round = Math.round(50000.0f);
        aLm = round;
        aLn = round;
    }

    static u nC() {
        if (aLG == null) {
            aLG = new u();
        }
        return aLG;
    }

    private u() {
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
    }

    private static float[] a(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    final void N(Context context) {
    }

    final void a(Context context, Handler handler, a aVar) {
        if (context == null) {
            try {
                throw new Exception("SensorModule: register with null context");
            } catch (Exception e) {
                this.aLH = false;
                return;
            }
        }
        boolean a;
        for (int i = 0; i <= 5; i++) {
            this.aLw[i][0] = 1.0f;
            this.aLw[i][1] = 0.0f;
            this.aLw[i][2] = 0.0f;
            this.aLw[i][3] = 0.0f;
            this.aLw[i][4] = 1.0f;
            this.aLw[i][5] = 0.0f;
            this.aLw[i][6] = 0.0f;
            this.aLw[i][7] = 0.0f;
            this.aLw[i][8] = 1.0f;
        }
        this.aHA = (SensorManager) context.getSystemService("sensor");
        this.aLo = this.aHA.getDefaultSensor(10);
        this.aLr = this.aHA.getDefaultSensor(9);
        if (!(this.aLo == null || this.aLr == null)) {
            this.aLs = this.aHA.getDefaultSensor(11);
            if (this.aLs != null) {
                a = a(this.aHA, this, aLm, aLn, handler, this.aLo, this.aLr, this.aLs);
            } else {
                this.aLp = this.aHA.getDefaultSensor(4);
                this.aLq = this.aHA.getDefaultSensor(2);
                if (!(this.aLp == null || this.aLq == null)) {
                    a = a(this.aHA, this, aLm, aLn, handler, this.aLo, this.aLr, this.aLp, this.aLq);
                }
            }
            if (a) {
                this.aLH = true;
                this.aLI = new c(this, handler);
                if (this.aLI != null) {
                    this.aLI.b((long) Math.round(50.0f), 1000);
                }
            }
        }
        a = false;
        if (a) {
            this.aLH = true;
            this.aLI = new c(this, handler);
            if (this.aLI != null) {
                this.aLI.b((long) Math.round(50.0f), 1000);
            }
        }
    }

    final void O(Context context) {
        if (this.aLI != null) {
            this.aLI.stop();
        }
        if (this.aHA != null) {
            try {
                this.aHA.unregisterListener(this);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        this.aHA = null;
        this.aLs = null;
        this.aLr = null;
        this.aLq = null;
        this.aLp = null;
        this.aLo = null;
        this.aLt = 0;
        this.aLu = true;
        this.aLv = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.aLw = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.aLy = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aLz = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aLA = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.aLJ = new boolean[6];
        this.aLK = new int[6];
        this.aLL = new float[6];
        this.aLM = new float[6];
        this.aLN = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.aLO = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20});
        this.aLR.reset();
        this.aLP.reset();
        this.aLQ.reset();
    }

    final void na() {
    }

    final synchronized void a(Handler handler, a aVar) {
        super.a(handler, aVar);
    }

    static /* synthetic */ void b(u uVar) {
        a nF = uVar.aLQ.nF();
        if (nF != null) {
            uVar.c(new e(nF.x, nF.y, nF.aMY, nF.aMZ, nF.aNa, nF.aNb));
        }
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        try {
            Object obj = VERSION.SDK_INT >= 19 ? 1 : null;
            int length = sensorArr.length;
            int i3 = 0;
            while (i3 < length) {
                Sensor sensor = sensorArr[i3];
                if (obj != null ? sensorManager.registerListener(sensorEventListener, sensor, i, i2, handler) : sensorManager.registerListener(sensorEventListener, sensor, i, handler)) {
                    i3++;
                } else {
                    sensorManager.unregisterListener(sensorEventListener);
                    return false;
                }
            }
            return true;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    static /* synthetic */ void a(u uVar) {
        if (!(uVar.aLo == null || uVar.aLp == null || uVar.aLq == null || uVar.aLr == null)) {
            for (int i = 0; i <= 5; i++) {
                float f;
                float[] fArr;
                float[] fArr2;
                float f2;
                float f3;
                float abs;
                Object obj = null;
                if (Float.isNaN(uVar.aLN[i])) {
                    uVar.aLN[i] = uVar.aLz[i][0];
                } else {
                    f = uVar.aLz[i][0] - uVar.aLA[i][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    fArr = uVar.aLO[i];
                    int[] iArr = uVar.aLK;
                    int i2 = iArr[i];
                    iArr[i] = i2 + 1;
                    fArr[i2] = f;
                    if (uVar.aLK[i] == 20) {
                        uVar.aLK[i] = 0;
                        if (!uVar.aLJ[i]) {
                            uVar.aLJ[i] = true;
                        }
                    }
                    fArr = uVar.aLM;
                    fArr[i] = fArr[i] + f;
                    fArr = uVar.aLL;
                    fArr[i] = f + fArr[i];
                    if (uVar.aLJ[i]) {
                        Object obj2;
                        if (Math.abs(uVar.aLL[i]) < 0.08726647f) {
                            if (Math.abs(uVar.aLM[i]) < 0.08726647f) {
                                f = uVar.aLz[i][0] - uVar.aLN[i];
                                if (f < -3.1415927f) {
                                    f += 6.2831855f;
                                } else if (f > 3.1415927f) {
                                    f -= 6.2831855f;
                                }
                                uVar.aLz[i][0] = (f / 2.0f) + uVar.aLN[i];
                                if (uVar.aLz[i][0] < -3.1415927f) {
                                    uVar.aLz[i][0] = 6.2831855f + uVar.aLz[i][0];
                                } else if (uVar.aLz[i][0] > 3.1415927f) {
                                    uVar.aLz[i][0] = uVar.aLz[i][0] - 6.2831855f;
                                }
                                uVar.aLN[i] = uVar.aLz[i][0];
                                obj2 = 1;
                                fArr2 = uVar.aLL;
                                fArr2[i] = fArr2[i] - uVar.aLO[i][uVar.aLK[i]];
                                obj = obj2;
                            } else {
                                f = uVar.aLM[i] % 1.5707964f;
                                float abs2 = Math.abs(f);
                                if (abs2 < 0.08726647f) {
                                    fArr = uVar.aLM;
                                    fArr[i] = fArr[i] - f;
                                    uVar.aLN[i] = (uVar.aLN[i] + uVar.aLM[i]) % 6.2831855f;
                                    if (uVar.aLN[i] < -3.1415927f) {
                                        uVar.aLN[i] = 6.2831855f + uVar.aLN[i];
                                    } else if (uVar.aLN[i] > 3.1415927f) {
                                        uVar.aLN[i] = uVar.aLN[i] - 6.2831855f;
                                    }
                                } else if (abs2 > 1.4835299f) {
                                    if (uVar.aLM[i] > 0.0f) {
                                        uVar.aLM[i] = (uVar.aLM[i] - f) + 1.5707964f;
                                    } else {
                                        uVar.aLM[i] = (uVar.aLM[i] - f) - 1.5707964f;
                                    }
                                    uVar.aLN[i] = (uVar.aLN[i] + uVar.aLM[i]) % 6.2831855f;
                                    if (uVar.aLN[i] < -3.1415927f) {
                                        uVar.aLN[i] = 6.2831855f + uVar.aLN[i];
                                    } else if (uVar.aLN[i] > 3.1415927f) {
                                        uVar.aLN[i] = uVar.aLN[i] - 6.2831855f;
                                    }
                                } else {
                                    uVar.aLN[i] = uVar.aLz[i][0];
                                }
                                uVar.aLM[i] = 0.0f;
                            }
                        }
                        obj2 = null;
                        fArr2 = uVar.aLL;
                        fArr2[i] = fArr2[i] - uVar.aLO[i][uVar.aLK[i]];
                        obj = obj2;
                    }
                }
                a aVar = uVar.aLR;
                float[] fArr3 = uVar.aLz[i];
                float[] fArr4 = uVar.aLy[i];
                float[] fArr5 = uVar.aLA[i];
                if (i == 0 && aVar.aLS != 0) {
                    aVar.aLU++;
                    aVar.aMh = aVar.aLT / ((float) aVar.aLS);
                    f2 = aVar.aMh - aVar.aLV;
                    f = Math.abs(f2);
                    f3 = aVar.aLV;
                    f = (aVar.aLV == 0.0f || aVar.aLU <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                    aVar.aLV = (f * (f2 / ((float) aVar.aLU))) + f3;
                    aVar.aLW = Math.abs(aVar.aMh - aVar.aLV) >= 1.25f;
                    if (aVar.aLW) {
                        if (aVar.aLX < 1200) {
                            aVar.aLX++;
                        }
                    } else if (aVar.aLX > 0) {
                        aVar.aLX--;
                    }
                    aVar.aLS = 0;
                    aVar.aLT = 0.0f;
                    if (aVar.aMh < aVar.aMj) {
                        aVar.aMj = aVar.aMh;
                    }
                    if (aVar.aMh > aVar.aMi) {
                        aVar.aMi = aVar.aMh;
                    }
                    if (aVar.aLU == 20 && Math.max(aVar.aMi - aVar.aLV, aVar.aLV - aVar.aMj) > 5.0f) {
                        aVar.reset();
                    }
                }
                float[] fArr6;
                if (aVar.aLU <= 20) {
                    fArr6 = aVar.aMe;
                    fArr2 = aVar.aMf;
                    aVar.aMg[i] = 1.0f;
                    fArr2[i] = 1.0f;
                    fArr6[i] = 1.0f;
                    fArr6 = aVar.aMb;
                    fArr2 = aVar.aMc;
                    aVar.aMd[i] = 0.0f;
                    fArr2[i] = 0.0f;
                    fArr6[i] = 0.0f;
                } else if (aVar.aLW || aVar.aMk || r1 != null) {
                    fArr6 = aVar.aMb;
                    fArr2 = aVar.aMc;
                    aVar.aMd[i] = 1.0f;
                    fArr2[i] = 1.0f;
                    fArr6[i] = 1.0f;
                    fArr6 = aVar.aMe;
                    fArr2 = aVar.aMf;
                    aVar.aMg[i] = 0.0f;
                    fArr2[i] = 0.0f;
                    fArr6[i] = 0.0f;
                } else {
                    if (aVar.aLX > 0) {
                        aVar.aLY[i] = fArr5[0];
                        aVar.aLZ[i] = fArr5[1];
                        aVar.aMa[i] = fArr5[2];
                    }
                    f = Math.abs(fArr5[0] - fArr3[0]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.aLY[i] - fArr4[0]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.aMb[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.aMb[i]) / 2.0f;
                    aVar.aMe[i] = 1.0f - aVar.aMb[i];
                    f = Math.abs(fArr5[1] - fArr3[1]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.aLZ[i] - fArr4[1]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.aMc[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.aMc[i]) / 2.0f;
                    aVar.aMf[i] = 1.0f - aVar.aMc[i];
                    f = Math.abs(fArr5[2] - fArr3[2]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.aMa[i] - fArr4[2]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    float max = Math.max(abs, f);
                    aVar.aMd[i] = ((max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f) + aVar.aMd[i]) / 2.0f;
                    aVar.aMg[i] = 1.0f - aVar.aMd[i];
                }
                aVar.aLY[i] = fArr4[0];
                aVar.aLZ[i] = fArr4[1];
                aVar.aMa[i] = fArr4[2];
                f = uVar.aLy[i][0] - uVar.aLz[i][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.aLR.aMe[i]) + uVar.aLz[i][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.aLA[i][0] = f;
                f = uVar.aLy[i][1] - uVar.aLz[i][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.aLR.aMf[i]) + uVar.aLz[i][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.aLA[i][1] = f;
                f = uVar.aLy[i][2] - uVar.aLz[i][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.aLR.aMg[i]) + uVar.aLz[i][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.aLA[i][2] = f;
                float[][] fArr7 = uVar.aLw;
                fArr2 = uVar.aLA[i];
                fArr = new float[9];
                fArr3 = new float[9];
                fArr4 = new float[9];
                float sin = (float) Math.sin((double) fArr2[1]);
                f2 = (float) Math.cos((double) fArr2[1]);
                f3 = (float) Math.sin((double) fArr2[2]);
                float cos = (float) Math.cos((double) fArr2[2]);
                float sin2 = (float) Math.sin((double) fArr2[0]);
                abs = (float) Math.cos((double) fArr2[0]);
                fArr[0] = 1.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = f2;
                fArr[5] = sin;
                fArr[6] = 0.0f;
                fArr[7] = -sin;
                fArr[8] = f2;
                fArr3[0] = cos;
                fArr3[1] = 0.0f;
                fArr3[2] = f3;
                fArr3[3] = 0.0f;
                fArr3[4] = 1.0f;
                fArr3[5] = 0.0f;
                fArr3[6] = -f3;
                fArr3[7] = 0.0f;
                fArr3[8] = cos;
                fArr4[0] = abs;
                fArr4[1] = sin2;
                fArr4[2] = 0.0f;
                fArr4[3] = -sin2;
                fArr4[4] = abs;
                fArr4[5] = 0.0f;
                fArr4[6] = 0.0f;
                fArr4[7] = 0.0f;
                fArr4[8] = 1.0f;
                fArr7[i] = a(fArr4, a(fArr, fArr3));
                System.arraycopy(uVar.aLA[i], 0, uVar.aLz[i], 0, 3);
            }
        }
        b a = uVar.aLP.a(uVar.aLs != null ? uVar.aLB : uVar.aLA);
        if (a != null) {
            uVar.aLQ.a(a);
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        float[] fArr;
        int i2;
        float[][] fArr2;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.aLE);
                a aVar = this.aLR;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    aVar.aLS++;
                    aVar.aLT = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) aVar.aLT));
                    return;
                }
                return;
            case 4:
                if (this.aLy[2][0] != 0.0f || this.aLy[2][1] != 0.0f || this.aLy[2][2] != 0.0f) {
                    if (this.aLu) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            this.aLw[i2] = a(this.aLw[i2], this.aLv[i2]);
                        }
                        this.aLu = false;
                    }
                    fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.aLt != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.aLt));
                        a(sensorEvent.values, this.aLD);
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr3 = this.aLD[i3];
                            float[] fArr4 = fArr2[i3];
                            float f2 = f / 2.0f;
                            float[] fArr5 = new float[3];
                            float sqrt = (float) Math.sqrt((double) (((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1])) + (fArr3[2] * fArr3[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr5[0] = fArr3[0] / sqrt;
                                fArr5[1] = fArr3[1] / sqrt;
                                fArr5[2] = fArr3[2] / sqrt;
                            }
                            float f3 = sqrt * f2;
                            f2 = (float) Math.sin((double) f3);
                            f3 = (float) Math.cos((double) f3);
                            fArr4[0] = fArr5[0] * f2;
                            fArr4[1] = fArr5[1] * f2;
                            fArr4[2] = f2 * fArr5[2];
                            fArr4[3] = f3;
                        }
                    }
                    this.aLt = sensorEvent.timestamp;
                    while (i <= 5) {
                        fArr = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr, fArr2[i]);
                        } catch (Exception e) {
                        }
                        this.aLw[i] = a(this.aLw[i], fArr);
                        i++;
                    }
                    a(this.aLw, this.aLz);
                    return;
                }
                return;
            case 9:
                a(sensorEvent.values, this.aLF);
                if (this.aLE[2][0] != 0.0f || this.aLE[2][1] != 0.0f || this.aLE[2][2] != 0.0f) {
                    fArr2 = this.aLv;
                    float[][] fArr6 = this.aLF;
                    float[][] fArr7 = this.aLE;
                    i2 = (SensorManager.getRotationMatrix(fArr2[0], null, fArr6[0], fArr7[0]) && SensorManager.getRotationMatrix(fArr2[1], null, fArr6[1], fArr7[1]) && SensorManager.getRotationMatrix(fArr2[2], null, fArr6[2], fArr7[2]) && SensorManager.getRotationMatrix(fArr2[3], null, fArr6[3], fArr7[3]) && SensorManager.getRotationMatrix(fArr2[4], null, fArr6[4], fArr7[4]) && SensorManager.getRotationMatrix(fArr2[5], null, fArr6[5], fArr7[5])) ? 1 : 0;
                    if (i2 != 0) {
                        a(this.aLv, this.aLy);
                        if (this.aLz[2][0] == 0.0f && this.aLz[2][1] == 0.0f && this.aLz[2][2] == 0.0f) {
                            fArr6 = this.aLy;
                            float[][] fArr8 = this.aLz;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr6[i2], 0, fArr8[i2], 0, 3);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 10:
                fArr = new float[16];
                float[] fArr9 = (this.aLs != null ? this.aLx : this.aLw)[2];
                float[] fArr10 = new float[16];
                if (fArr9.length == 9) {
                    fArr10[0] = fArr9[0];
                    fArr10[1] = fArr9[1];
                    fArr10[2] = fArr9[2];
                    fArr10[3] = 0.0f;
                    fArr10[4] = fArr9[3];
                    fArr10[5] = fArr9[4];
                    fArr10[6] = fArr9[5];
                    fArr10[7] = 0.0f;
                    fArr10[8] = fArr9[6];
                    fArr10[9] = fArr9[7];
                    fArr10[10] = fArr9[8];
                    fArr10[11] = 0.0f;
                    fArr10[12] = 0.0f;
                    fArr10[13] = 0.0f;
                    fArr10[14] = 0.0f;
                    fArr10[15] = 1.0f;
                }
                Matrix.invertM(fArr, 0, fArr10, 0);
                Matrix.multiplyMV(this.aLC, 0, fArr, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.aLP.a(this.aLC, sensorEvent.values, this.aLF[2]);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.aLx[2], sensorEvent.values);
                } catch (IllegalArgumentException e2) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.aLx[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.aLx[2], 2, 129, this.aLx[0]);
                SensorManager.remapCoordinateSystem(this.aLx[2], 130, 1, this.aLx[1]);
                SensorManager.remapCoordinateSystem(this.aLx[2], 129, 130, this.aLx[3]);
                SensorManager.remapCoordinateSystem(this.aLx[2], 129, 3, this.aLx[4]);
                SensorManager.remapCoordinateSystem(this.aLx[2], 1, 3, this.aLx[5]);
                while (i <= 5) {
                    SensorManager.getOrientation(this.aLx[i], this.aLB[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }
}
