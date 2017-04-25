package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.b.b.b.AnonymousClass3;
import com.tencent.tinker.c.a.b.b;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;

public final class m extends i<k> {
    private a pDL;
    private e pDM;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pED.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOA();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        k kVar = (k) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar.data.length);
        new a(bVar, new AnonymousClass3(bVar, byteArrayOutputStream)).c(new com.tencent.tinker.a.a.m(kVar, 28));
        return new k(kVar.pBP, byteArrayOutputStream.toByteArray());
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        k kVar = (k) comparable;
        a aVar = this.pDL;
        aVar.size++;
        return this.pDM.a(kVar);
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return ((k) comparable).data.length * 1;
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDL = null;
        this.pDM = null;
        if (iVar2 != null) {
            this.pDL = iVar2.pAU.pBF;
            this.pDM = iVar2.a(this.pDL);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBF;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEo;
        }
        return this.pCQ.pAU.pBF.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCr.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCF.set(i2);
        }
    }
}
