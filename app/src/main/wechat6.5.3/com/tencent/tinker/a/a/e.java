package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] pAo;
    public a[] pAp;
    public b[] pAq;
    public b[] pAr;

    public static class a implements Comparable<a> {
        public int pAs;
        public int pAt;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int dK = c.dK(this.pAs, aVar.pAs);
            return dK != 0 ? dK : c.dL(this.pAt, aVar.pAt);
        }

        public a(int i, int i2) {
            this.pAs = i;
            this.pAt = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int pAt;
        public int pAu;
        public int pAv;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int dK = c.dK(this.pAu, bVar.pAu);
            if (dK != 0) {
                return dK;
            }
            dK = c.dL(this.pAt, bVar.pAt);
            return dK == 0 ? c.dL(this.pAv, bVar.pAv) : dK;
        }

        public b(int i, int i2, int i3) {
            this.pAu = i;
            this.pAt = i2;
            this.pAv = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.pAo, eVar.pAo);
        if (a != 0) {
            return a;
        }
        a = c.a(this.pAp, eVar.pAp);
        if (a != 0) {
            return a;
        }
        a = c.a(this.pAq, eVar.pAq);
        return a == 0 ? c.a(this.pAr, eVar.pAr) : a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.pAo = aVarArr;
        this.pAp = aVarArr2;
        this.pAq = bVarArr;
        this.pAr = bVarArr2;
    }

    public static int a(a[] aVarArr) {
        int i = 0;
        int length = aVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            a aVar = aVarArr[i];
            int i4 = aVar.pAs - i2;
            i2 = aVar.pAs;
            i3 += o.yS(aVar.pAt) + o.yS(i4);
            i++;
        }
        return i3;
    }

    public static int a(b[] bVarArr) {
        int i = 0;
        int length = bVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            b bVar = bVarArr[i];
            int i4 = bVar.pAu - i2;
            i2 = bVar.pAu;
            i3 += o.yS(bVar.pAv) + (o.yS(i4) + o.yS(bVar.pAt));
            i++;
        }
        return i3;
    }
}
