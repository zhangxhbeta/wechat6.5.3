package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int pAD;
    public int pAE;
    public int pAF;
    public int pAG;
    public short[] pAH;
    public b[] pAI;
    public a[] pAJ;

    public static class a implements Comparable<a> {
        public int offset;
        public int[] pAK;
        public int[] pAL;
        public int pAM;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int a = c.a(this.pAK, aVar.pAK);
            if (a != 0) {
                return a;
            }
            a = c.a(this.pAL, aVar.pAL);
            return a == 0 ? c.dL(this.pAM, aVar.pAM) : a;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.pAK = iArr;
            this.pAL = iArr2;
            this.pAM = i;
            this.offset = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int pAN;
        public int pAO;
        public int pAP;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int dL = c.dL(this.pAN, bVar.pAN);
            if (dL != 0) {
                return dL;
            }
            dL = c.dL(this.pAO, bVar.pAO);
            return dL == 0 ? c.dL(this.pAP, bVar.pAP) : dL;
        }

        public b(int i, int i2, int i3) {
            this.pAN = i;
            this.pAO = i2;
            this.pAP = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int dL = c.dL(this.pAD, gVar.pAD);
        if (dL != 0) {
            return dL;
        }
        dL = c.dL(this.pAE, gVar.pAE);
        if (dL != 0) {
            return dL;
        }
        dL = c.dL(this.pAF, gVar.pAF);
        if (dL != 0) {
            return dL;
        }
        dL = c.dL(this.pAG, gVar.pAG);
        if (dL != 0) {
            return dL;
        }
        dL = c.a(this.pAH, gVar.pAH);
        if (dL != 0) {
            return dL;
        }
        dL = c.a(this.pAI, gVar.pAI);
        return dL == 0 ? c.a(this.pAJ, gVar.pAJ) : dL;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.pAD = i2;
        this.pAE = i3;
        this.pAF = i4;
        this.pAG = i5;
        this.pAH = sArr;
        this.pAI = bVarArr;
        this.pAJ = aVarArr;
    }
}
