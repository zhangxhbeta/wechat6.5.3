package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.b.b.b.AnonymousClass4;
import com.tencent.tinker.c.a.b.b;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private com.tencent.tinker.a.a.t.a pDm;
    private e pDn;

    class AnonymousClass1 implements com.tencent.tinker.c.a.a.a.i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEz.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOw();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar.pAh.data.length);
        new a(bVar, new AnonymousClass4(bVar, byteArrayOutputStream)).b(new m(aVar.pAh, 29));
        return new com.tencent.tinker.a.a.a(aVar.pBP, aVar.pAg, new k(aVar.pAh.pBP, byteArrayOutputStream.toByteArray()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        com.tencent.tinker.a.a.t.a aVar2 = this.pDm;
        aVar2.size++;
        return this.pDn.a(aVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return (((com.tencent.tinker.a.a.a) comparable).pAh.data.length * 1) + 1;
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, com.tencent.tinker.c.a.a.a.i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDm = null;
        this.pDn = null;
        if (iVar2 != null) {
            this.pDm = iVar2.pAU.pBE;
            this.pDn = iVar2.a(this.pDm);
        }
    }

    protected final com.tencent.tinker.a.a.t.a c(i iVar) {
        return iVar.pAU.pBE;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEn;
        }
        return this.pCQ.pAU.pBE.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCn.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCB.set(i2);
        }
    }
}
