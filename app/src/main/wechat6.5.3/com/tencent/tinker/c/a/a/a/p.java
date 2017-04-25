package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class p extends i<u> {
    private a pDT;
    private e pDU;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEv.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOo();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        u uVar = (u) comparable;
        if (uVar == u.pBR) {
            return uVar;
        }
        short[] sArr = new short[uVar.pBS.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) bVar.zp(uVar.pBS[i]);
        }
        return new u(uVar.pBP, sArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        u uVar = (u) comparable;
        a aVar = this.pDT;
        aVar.size++;
        return this.pDU.a(uVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return (((u) comparable).pBS.length * 2) + 4;
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDT = null;
        this.pDU = null;
        if (iVar2 != null) {
            this.pDT = iVar2.pAU.pBx;
            this.pDU = iVar2.a(this.pDT);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBx;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEg;
        }
        return this.pCQ.pAU.pBx.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCm.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCA.set(i2);
        }
    }
}
