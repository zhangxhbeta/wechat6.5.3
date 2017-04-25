package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class o extends i<Integer> {
    private a pDR;
    private e pDS;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEu.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return Integer.valueOf(aVar.hua.getInt());
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        return Integer.valueOf(bVar.zo(((Integer) comparable).intValue()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.pDS.hua.position();
        this.pDS.writeInt(num.intValue());
        a aVar = this.pDR;
        aVar.size++;
        return position;
    }

    protected final /* bridge */ /* synthetic */ int f(Comparable comparable) {
        return 4;
    }

    public o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private o(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDR = null;
        this.pDS = null;
        if (iVar2 != null) {
            this.pDR = iVar2.pAU.pBr;
            this.pDS = iVar2.a(this.pDR);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBr;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEa;
        }
        return this.pCQ.pAU.pBr.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            bVar.pCi.put(i, i3);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i >= 0) {
            bVar.pCw.set(i);
        }
    }
}
