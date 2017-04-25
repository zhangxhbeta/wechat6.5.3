package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class k extends i<p> {
    private a pDH;
    private e pDI;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEy.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOq();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        p pVar = (p) comparable;
        int zp = bVar.zp(pVar.pBj);
        int i = pVar.pBl;
        int indexOfKey = bVar.pCj.indexOfKey(i);
        if (indexOfKey >= 0) {
            i = bVar.pCj.pCP[indexOfKey];
        } else if (i >= 0 && bVar.pCx.get(i)) {
            i = -1;
        }
        return new p(pVar.pBP, zp, i, bVar.zo(pVar.pBk));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        p pVar = (p) comparable;
        a aVar = this.pDH;
        aVar.size++;
        return this.pDI.a(pVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return 8;
    }

    public k(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private k(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDH = null;
        this.pDI = null;
        if (iVar2 != null) {
            this.pDH = iVar2.pAU.pBu;
            this.pDI = iVar2.a(this.pDH);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBu;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEd;
        }
        return this.pCQ.pAU.pBu.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            bVar.pCl.put(i, i3);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i >= 0) {
            bVar.pCz.set(i);
        }
    }
}
