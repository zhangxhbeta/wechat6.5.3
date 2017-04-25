package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import java.util.BitSet;

public final class c extends i<b> {
    private a pDr;
    private e pDs;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ com.tencent.tinker.c.a.b.b pDo;

        AnonymousClass1(com.tencent.tinker.c.a.b.b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEA.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOx();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        b bVar2 = (b) comparable;
        int length = bVar2.pAi.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            int i2 = bVar2.pAi[i];
            int indexOfKey = bVar.pCn.indexOfKey(i2);
            if (indexOfKey >= 0) {
                i2 = bVar.pCn.pCP[indexOfKey];
            } else if (i2 >= 0 && bVar.pCB.get(i2)) {
                i2 = -1;
            }
            iArr[i] = i2;
        }
        return new b(bVar2.pBP, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        b bVar = (b) comparable;
        a aVar = this.pDr;
        aVar.size++;
        return this.pDs.a(bVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return (((b) comparable).pAi.length + 1) * 4;
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, com.tencent.tinker.c.a.b.b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDr = null;
        this.pDs = null;
        if (iVar2 != null) {
            this.pDr = iVar2.pAU.pBz;
            this.pDs = iVar2.a(this.pDr);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBz;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEi;
        }
        return this.pCQ.pAU.pBz.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCo.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCC.set(i2);
        }
    }
}
