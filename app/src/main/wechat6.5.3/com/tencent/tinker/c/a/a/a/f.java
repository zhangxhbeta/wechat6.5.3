package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private a pDx;
    private e pDy;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEH.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOs();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        int zp = bVar.zp(fVar.pAw);
        int zp2 = bVar.zp(fVar.pAx);
        int zs = bVar.zs(fVar.pAy);
        int zo = bVar.zo(fVar.pAz);
        int i = fVar.pAA;
        int indexOfKey = bVar.pCq.indexOfKey(i);
        if (indexOfKey >= 0) {
            i = bVar.pCq.pCP[indexOfKey];
        } else if (i >= 0 && bVar.pCE.get(i)) {
            i = -1;
        }
        int i2 = fVar.pAB;
        indexOfKey = bVar.pCs.indexOfKey(i2);
        if (indexOfKey >= 0) {
            i2 = bVar.pCs.pCP[indexOfKey];
        } else if (i2 >= 0 && bVar.pCG.get(i2)) {
            i2 = -1;
        }
        int i3 = fVar.pAC;
        indexOfKey = bVar.pCr.indexOfKey(i3);
        if (indexOfKey >= 0) {
            i3 = bVar.pCr.pCP[indexOfKey];
        } else if (i3 >= 0 && bVar.pCF.get(i3)) {
            i3 = -1;
        }
        return new com.tencent.tinker.a.a.f(fVar.pBP, zp, fVar.pAt, zp2, zs, zo, i, i2, i3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.f fVar = (com.tencent.tinker.a.a.f) comparable;
        a aVar = this.pDx;
        aVar.size++;
        return this.pDy.a(fVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return 32;
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDx = null;
        this.pDy = null;
        if (iVar2 != null) {
            this.pDx = iVar2.pAU.pBv;
            this.pDy = iVar2.a(this.pDx);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBv;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEe;
        }
        return this.pCQ.pAU.pBv.pBP;
    }
}
