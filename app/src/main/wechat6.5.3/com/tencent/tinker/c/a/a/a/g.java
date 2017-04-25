package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.b.b.c;
import com.tencent.tinker.c.a.b.b;
import java.util.BitSet;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private e pDA;
    private a pDz;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEF.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOt();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int i = gVar.pAG;
        int indexOfKey = bVar.pCt.indexOfKey(i);
        if (indexOfKey >= 0) {
            i = bVar.pCt.pCP[indexOfKey];
        } else if (i >= 0 && bVar.pCH.get(i)) {
            i = -1;
        }
        short[] sArr = gVar.pAH;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new c(bVar).a(sArr);
        }
        com.tencent.tinker.a.a.g.a[] aVarArr2 = gVar.pAJ;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new com.tencent.tinker.a.a.g.a[aVarArr2.length];
            for (indexOfKey = 0; indexOfKey < aVarArr2.length; indexOfKey++) {
                com.tencent.tinker.a.a.g.a aVar = aVarArr2[indexOfKey];
                int length = aVar.pAK.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = bVar.zp(aVar.pAK[i2]);
                }
                aVarArr[indexOfKey] = new com.tencent.tinker.a.a.g.a(iArr, aVar.pAL, aVar.pAM, aVar.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar.pBP, gVar.pAD, gVar.pAE, gVar.pAF, i, sArr, gVar.pAI, aVarArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        a aVar = this.pDz;
        aVar.size++;
        return this.pDA.a(gVar);
    }

    protected final /* synthetic */ int f(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int length = gVar.pAH.length;
        int i = (length * 2) + 16;
        if (gVar.pAI.length > 0) {
            if ((length & 1) == 1) {
                i += 2;
            }
            i = (i + (gVar.pAI.length * 8)) + o.yS(gVar.pAJ.length);
            com.tencent.tinker.a.a.g.a[] aVarArr = gVar.pAJ;
            int length2 = aVarArr.length;
            int i2 = 0;
            while (i2 < length2) {
                com.tencent.tinker.a.a.g.a aVar = aVarArr[i2];
                int length3 = aVar.pAK.length;
                length = aVar.pAM != -1 ? i + (o.yT(-length3) + o.yS(aVar.pAM)) : i + o.yT(length3);
                for (i = 0; i < length3; i++) {
                    length += o.yS(aVar.pAK[i]) + o.yS(aVar.pAL[i]);
                }
                i2++;
                i = length;
            }
        }
        return i;
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDz = null;
        this.pDA = null;
        if (iVar2 != null) {
            this.pDz = iVar2.pAU.pBB;
            this.pDA = iVar2.a(this.pDz);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBB;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEk;
        }
        return this.pCQ.pAU.pBB.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCu.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCI.set(i2);
        }
    }
}
