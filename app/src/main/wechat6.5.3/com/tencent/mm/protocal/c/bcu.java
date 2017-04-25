package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bcu extends aqx {
    public String gom;
    public String gon;
    public int hNS;
    public int mbT;
    public String mcN;
    public long mcb;
    public int mfb;
    public int mfd;
    public int mff;
    public int mfh;
    public int mpw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.gon != null) {
                aVar.e(1, this.gon);
            }
            if (this.gom != null) {
                aVar.e(2, this.gom);
            }
            aVar.dV(3, this.mfb);
            aVar.dV(4, this.mff);
            aVar.dV(5, this.hNS);
            if (this.mcN != null) {
                aVar.e(6, this.mcN);
            }
            aVar.dV(7, this.mbT);
            aVar.dV(8, this.mpw);
            aVar.dV(9, this.mfh);
            if (this.mQl != null) {
                aVar.dX(10, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(11, this.mfd);
            aVar.C(12, this.mcb);
            return 0;
        } else if (i == 1) {
            if (this.gon != null) {
                r0 = a.a.a.b.b.a.f(1, this.gon) + 0;
            } else {
                r0 = 0;
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(2, this.gom);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.mfb)) + a.a.a.a.dS(4, this.mff)) + a.a.a.a.dS(5, this.hNS);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(6, this.mcN);
            }
            r0 = ((r0 + a.a.a.a.dS(7, this.mbT)) + a.a.a.a.dS(8, this.mpw)) + a.a.a.a.dS(9, this.mfh);
            if (this.mQl != null) {
                r0 += a.a.a.a.dU(10, this.mQl.aHr());
            }
            return (r0 + a.a.a.a.dS(11, this.mfd)) + a.a.a.a.B(12, this.mcb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bcu com_tencent_mm_protocal_c_bcu = (bcu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bcu.gon = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcu.gom = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcu.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcu.mff = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcu.hNS = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcu.mcN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcu.mbT = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcu.mpw = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcu.mfh = aVar3.pMj.mH();
                    return 0;
                case 10:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcu.mQl = eoVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcu.mfd = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bcu.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
