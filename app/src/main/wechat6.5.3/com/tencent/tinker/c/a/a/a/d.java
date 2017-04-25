package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.lang.reflect.Array;
import java.util.BitSet;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a pDt;
    private e pDu;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEC.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOz();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int zt = bVar.zt(dVar.pAk);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.pAl.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = bVar.zq(dVar.pAl[i][0]);
            iArr[i][1] = bVar.zt(dVar.pAl[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.pAm.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = bVar.zr(dVar.pAm[i][0]);
            iArr2[i][1] = bVar.zt(dVar.pAm[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.pAn.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = bVar.zr(dVar.pAn[i][0]);
            int[] iArr4 = iArr3[i];
            int i2 = dVar.pAn[i][1];
            int indexOfKey = bVar.pCp.indexOfKey(i2);
            if (indexOfKey >= 0) {
                i2 = bVar.pCp.pCP[indexOfKey];
            } else if (i2 >= 0 && bVar.pCD.get(i2)) {
                i2 = -1;
            }
            iArr4[1] = i2;
        }
        return new com.tencent.tinker.a.a.d(dVar.pBP, zt, iArr, iArr2, iArr3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.pDt;
        aVar.size++;
        return this.pDu.a(dVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        return ((((dVar.pAl.length + dVar.pAm.length) + dVar.pAn.length) * 2) + 4) * 4;
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDt = null;
        this.pDu = null;
        if (iVar2 != null) {
            this.pDt = iVar2.pAU.pBG;
            this.pDu = iVar2.a(this.pDt);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBG;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEp;
        }
        return this.pCQ.pAU.pBG.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCq.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCE.set(i2);
        }
    }
}
