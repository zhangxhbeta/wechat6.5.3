package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private a pDv;
    private com.tencent.tinker.a.a.i.e pDw;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEG.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOv();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return new com.tencent.tinker.a.a.e(eVar.pBP, bVar.c(eVar.pAo), bVar.c(eVar.pAp), bVar.c(eVar.pAq), bVar.c(eVar.pAr));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        a aVar = this.pDv;
        aVar.size++;
        return this.pDw.a(eVar);
    }

    protected final /* synthetic */ int f(Comparable comparable) {
        com.tencent.tinker.a.a.e eVar = (com.tencent.tinker.a.a.e) comparable;
        return ((((((o.yS(eVar.pAo.length) + o.yS(eVar.pAp.length)) + o.yS(eVar.pAq.length)) + o.yS(eVar.pAr.length)) + com.tencent.tinker.a.a.e.a(eVar.pAo)) + com.tencent.tinker.a.a.e.a(eVar.pAp)) + com.tencent.tinker.a.a.e.a(eVar.pAq)) + com.tencent.tinker.a.a.e.a(eVar.pAr);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDv = null;
        this.pDw = null;
        if (iVar2 != null) {
            this.pDv = iVar2.pAU.pBA;
            this.pDw = iVar2.a(this.pDv);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBA;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEj;
        }
        return this.pCQ.pAU.pBA.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCs.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCG.set(i2);
        }
    }
}
