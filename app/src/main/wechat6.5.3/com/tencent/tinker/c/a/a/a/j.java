package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class j extends i<n> {
    private a pDF;
    private e pDG;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEx.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOp();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        n nVar = (n) comparable;
        return new n(nVar.pBP, bVar.zp(nVar.pBj), bVar.zp(nVar.pAw), bVar.zo(nVar.pBk));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        n nVar = (n) comparable;
        a aVar = this.pDF;
        aVar.size++;
        return this.pDG.a(nVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return 8;
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDF = null;
        this.pDG = null;
        if (iVar2 != null) {
            this.pDF = iVar2.pAU.pBt;
            this.pDG = iVar2.a(this.pDF);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBt;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEc;
        }
        return this.pCQ.pAU.pBt.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            bVar.pCk.put(i, i3);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i >= 0) {
            bVar.pCy.set(i);
        }
    }
}
