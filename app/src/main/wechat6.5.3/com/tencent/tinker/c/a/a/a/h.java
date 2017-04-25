package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.b.b.b.AnonymousClass2;
import com.tencent.tinker.c.a.b.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;

public final class h extends i<com.tencent.tinker.a.a.h> {
    private a pDB;
    private e pDC;

    class AnonymousClass1 implements i.a {
        final /* synthetic */ b pDo;

        AnonymousClass1(b bVar) {
            this.pDo = bVar;
        }

        public final boolean cr(String str, int i) {
            BitSet bitSet = (BitSet) this.pDo.pEE.get(str);
            return bitSet == null ? false : bitSet.get(i);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.bOu();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.b.b.b bVar, Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        int[] iArr = hVar.pAR;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = bVar.zo(iArr[i]);
        }
        byte[] bArr = hVar.pAS;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.tencent.tinker.a.a.b.a anonymousClass1 = new com.tencent.tinker.a.b.b.b.AnonymousClass1(bVar, byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        com.tencent.tinker.a.a.b.b anonymousClass2 = new AnonymousClass2(bVar, byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new com.tencent.tinker.a.a.h(hVar.pBP, hVar.pAQ, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 2:
                    o.c(anonymousClass2, o.a(anonymousClass1));
                    break;
                case 3:
                case 4:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    o.b(anonymousClass2, bVar.zo(o.c(anonymousClass1)));
                    o.b(anonymousClass2, bVar.zp(o.c(anonymousClass1)));
                    if (read != 4) {
                        break;
                    }
                    o.b(anonymousClass2, bVar.zo(o.c(anonymousClass1)));
                    break;
                case 5:
                case 6:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 9:
                    o.b(anonymousClass2, bVar.zo(o.c(anonymousClass1)));
                    break;
                default:
                    break;
            }
        }
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        a aVar = this.pDB;
        aVar.size++;
        return this.pDC.a(hVar);
    }

    protected final /* synthetic */ int f(Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        int yS = o.yS(hVar.pAR.length) + o.yS(hVar.pAQ);
        for (int i : hVar.pAR) {
            yS += o.yS(i + 1);
        }
        return (hVar.pAS.length * 1) + yS;
    }

    public h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, b bVar3) {
        this(aVar, iVar, iVar2, bVar, bVar2, new AnonymousClass1(bVar3));
    }

    private h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.a.b.b.b bVar, com.tencent.tinker.a.b.b.b bVar2, i.a aVar2) {
        super(aVar, iVar, bVar, bVar2, aVar2);
        this.pDB = null;
        this.pDC = null;
        if (iVar2 != null) {
            this.pDB = iVar2.pAU.pBD;
            this.pDC = iVar2.a(this.pDB);
        }
    }

    protected final a c(i iVar) {
        return iVar.pAU.pBD;
    }

    protected final int bOT() {
        if (this.pCS != null) {
            return this.pCS.pEm;
        }
        return this.pCQ.pAU.pBD.pBP;
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            bVar.pCt.put(i2, i4);
        }
    }

    protected final void a(com.tencent.tinker.a.b.b.b bVar, int i, int i2) {
        if (i2 >= 0) {
            bVar.pCH.set(i2);
        }
    }
}
