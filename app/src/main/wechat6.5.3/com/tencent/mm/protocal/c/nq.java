package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class nq extends aqx {
    public int mbT;
    public String mcN;
    public long mcb;
    public int mfb;
    public int mfd;
    public int mff;
    public are mfg;
    public int mfh;
    public int mpw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else {
                aVar.dV(1, this.mbT);
                aVar.dV(2, this.mfb);
                aVar.dV(3, this.mff);
                aVar.dV(5, this.mpw);
                if (this.mcN != null) {
                    aVar.e(6, this.mcN);
                }
                if (this.mfg != null) {
                    aVar.dX(7, this.mfg.aHr());
                    this.mfg.a(aVar);
                }
                aVar.dV(8, this.mfh);
                if (this.mQl != null) {
                    aVar.dX(9, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(10, this.mfd);
                aVar.C(11, this.mcb);
                return 0;
            }
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.mbT) + 0) + a.a.a.a.dS(2, this.mfb)) + a.a.a.a.dS(3, this.mff)) + a.a.a.a.dS(5, this.mpw);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(6, this.mcN);
            }
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(7, this.mfg.aHr());
            }
            r0 += a.a.a.a.dS(8, this.mfh);
            if (this.mQl != null) {
                r0 += a.a.a.a.dU(9, this.mQl.aHr());
            }
            return (r0 + a.a.a.a.dS(10, this.mfd)) + a.a.a.a.B(11, this.mcb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else if (this.mQl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BaseResponse");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nq nqVar = (nq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    nqVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 2:
                    nqVar.mfb = aVar3.pMj.mH();
                    return 0;
                case 3:
                    nqVar.mff = aVar3.pMj.mH();
                    return 0;
                case 5:
                    nqVar.mpw = aVar3.pMj.mH();
                    return 0;
                case 6:
                    nqVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nqVar.mfg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    nqVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nqVar.mQl = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 10:
                    nqVar.mfd = aVar3.pMj.mH();
                    return 0;
                case 11:
                    nqVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
