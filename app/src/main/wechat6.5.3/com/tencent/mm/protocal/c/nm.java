package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class nm extends aqx {
    public String glj;
    public String gln;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;
    public String mfo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.glj != null) {
                    aVar.e(2, this.glj);
                }
                if (this.mfo != null) {
                    aVar.e(3, this.mfo);
                }
                if (this.gln != null) {
                    aVar.e(4, this.gln);
                }
                aVar.dV(5, this.mdz);
                aVar.dV(6, this.mdA);
                aVar.dV(7, this.mdB);
                if (this.mfg == null) {
                    return 0;
                }
                aVar.dX(8, this.mfg.aHr());
                this.mfg.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.mfo != null) {
                r0 += a.a.a.b.b.a.f(3, this.mfo);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(4, this.gln);
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.mdz)) + a.a.a.a.dS(6, this.mdA)) + a.a.a.a.dS(7, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(8, this.mfg.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nm nmVar = (nm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nmVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    nmVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    nmVar.mfo = aVar3.pMj.readString();
                    return 0;
                case 4:
                    nmVar.gln = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nmVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 6:
                    nmVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 7:
                    nmVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nmVar.mfg = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
