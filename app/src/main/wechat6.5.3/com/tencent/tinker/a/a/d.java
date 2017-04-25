package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class d extends a<d> {
    public int pAk;
    public int[][] pAl;
    public int[][] pAm;
    public int[][] pAn;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.pAk != dVar.pAk) {
            return c.dK(this.pAk, dVar.pAk);
        }
        int length = this.pAl.length;
        int length2 = this.pAm.length;
        int length3 = this.pAn.length;
        int length4 = dVar.pAl.length;
        int length5 = dVar.pAm.length;
        int length6 = dVar.pAn.length;
        if (length != length4) {
            return c.dL(length, length4);
        }
        if (length2 != length5) {
            return c.dL(length2, length5);
        }
        if (length3 != length6) {
            return c.dL(length3, length6);
        }
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.pAl[length4][0];
            length6 = this.pAl[length4][1];
            int i = dVar.pAl[length4][0];
            int i2 = dVar.pAl[length4][1];
            if (length5 != i) {
                return c.dK(length5, i);
            }
            if (length6 != i2) {
                return c.dL(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.pAm[length4][0];
            length5 = this.pAm[length4][1];
            length6 = dVar.pAm[length4][0];
            i = dVar.pAm[length4][1];
            if (length != length6) {
                return c.dK(length, length6);
            }
            if (length5 != i) {
                return c.dL(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.pAn[length4][0];
            length2 = this.pAn[length4][1];
            length5 = dVar.pAn[length4][0];
            length6 = dVar.pAn[length4][1];
            if (length != length5) {
                return c.dK(length, length5);
            }
            if (length2 != length6) {
                return c.dL(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.pAk = i2;
        this.pAl = iArr;
        this.pAm = iArr2;
        this.pAn = iArr3;
    }
}
