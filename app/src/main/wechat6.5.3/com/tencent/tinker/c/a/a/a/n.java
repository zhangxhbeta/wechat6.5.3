package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class n extends i<s> {
    private a pDN;
    private a pDO;
    private e pDP;
    private e pDQ;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEt.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOn();
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        int a = this.pDP.a((s) comparable);
        this.pDQ.writeInt(a);
        a aVar = this.pDN;
        aVar.size++;
        aVar = this.pDO;
        aVar.size++;
        return a;
    }

    protected final /* synthetic */ int f(Comparable comparable) {
        return ((s) comparable).bOL();
    }

    public n(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private n(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDN = null;
        this.pDO = null;
        this.pDP = null;
        this.pDQ = null;
        if (iVar2 != null) {
            this.pDN = iVar2.pAU.pBC;
            this.pDO = iVar2.pAU.pBq;
            this.pDP = iVar2.a(this.pDN);
            this.pDQ = iVar2.a(this.pDO);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBC;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEl;
        }
        return this.pCQ.pAU.pBC.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            bVar.pCh.put(i, i3);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i >= 0) {
            bVar.pCv.set(i);
        }
    }
}
