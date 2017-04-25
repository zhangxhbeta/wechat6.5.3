package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class eh extends aqp {
    public String meZ;
    public int mfa;
    public int mfb;
    public int mfd;
    public int mff;
    public are mfg;
    public int mfh;
    public String mfo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.meZ != null) {
                aVar.e(2, this.meZ);
            }
            aVar.dV(3, this.mfb);
            aVar.dV(4, this.mff);
            if (this.mfo != null) {
                aVar.e(5, this.mfo);
            }
            if (this.mfg != null) {
                aVar.dX(6, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            aVar.dV(7, this.mfh);
            aVar.dV(8, this.mfd);
            aVar.dV(9, this.mfa);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.meZ);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mfb)) + a.a.a.a.dS(4, this.mff);
            if (this.mfo != null) {
                r0 += a.a.a.b.b.a.f(5, this.mfo);
            }
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(6, this.mfg.aHr());
            }
            return ((r0 + a.a.a.a.dS(7, this.mfh)) + a.a.a.a.dS(8, this.mfd)) + a.a.a.a.dS(9, this.mfa);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mfg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            eh ehVar = (eh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ehVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ehVar.meZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ehVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ehVar.mff = aVar3.pMj.mH();
                    return 0;
                case 5:
                    ehVar.mfo = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ehVar.mfg = enVar;
                    }
                    return 0;
                case 7:
                    ehVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 8:
                    ehVar.mfd = aVar3.pMj.mH();
                    return 0;
                case 9:
                    ehVar.mfa = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
