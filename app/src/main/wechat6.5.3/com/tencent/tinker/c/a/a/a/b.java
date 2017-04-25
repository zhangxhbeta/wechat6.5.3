package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import java.util.BitSet;

public final class b extends i<c> {
    private a pDp;
    private e pDq;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ com.tencent.tinker.c.a.b.b pDo;

        AnonymousClass1(com.tencent.tinker.c.a.b.b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEB.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOy();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.pAj.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bVar.zt(cVar.pAj[i]);
        }
        return new c(cVar.pBP, iArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        c cVar = (c) comparable;
        a aVar = this.pDp;
        aVar.size++;
        return this.pDq.a(cVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return (((c) comparable).pAj.length + 1) * 4;
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, com.tencent.tinker.c.a.b.b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDp = null;
        this.pDq = null;
        if (iVar2 != null) {
            this.pDp = iVar2.pAU.pBy;
            this.pDq = iVar2.a(this.pDp);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBy;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEh;
        }
        return this.pCQ.pAU.pBy.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCp.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCD.set(i2);
        }
    }
}
