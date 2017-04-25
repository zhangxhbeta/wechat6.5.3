package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class l extends i<r> {
    private a pDJ;
    private e pDK;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEw.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOr();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        r rVar = (r) comparable;
        return new r(rVar.pBP, bVar.zo(rVar.pBm), bVar.zp(rVar.pBn), bVar.zs(rVar.pBo));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        r rVar = (r) comparable;
        a aVar = this.pDJ;
        aVar.size++;
        return this.pDK.a(rVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return 12;
    }

    public l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private l(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDJ = null;
        this.pDK = null;
        if (iVar2 != null) {
            this.pDJ = iVar2.pAU.pBs;
            this.pDK = iVar2.a(this.pDJ);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBs;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEb;
        }
        return this.pCQ.pAU.pBs.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            bVar.pCj.put(i, i3);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i >= 0) {
            bVar.pCx.set(i);
        }
    }
}
