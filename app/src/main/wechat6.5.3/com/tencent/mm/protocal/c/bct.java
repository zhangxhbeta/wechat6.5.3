package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bct extends aqp {
    public String gom;
    public String gon;
    public int mHH;
    public int mYB;
    public int mYC;
    public int mbT;
    public String mbZ;
    public String mcN;
    public long mcb;
    public int mfb;
    public int mfd;
    public int mff;
    public are mfg;
    public int mfh;
    public int mpQ;
    public int mpw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.gon != null) {
                aVar.e(1, this.gon);
            }
            if (this.gom != null) {
                aVar.e(2, this.gom);
            }
            aVar.dV(3, this.mfb);
            aVar.dV(4, this.mff);
            if (this.mcN != null) {
                aVar.e(5, this.mcN);
            }
            aVar.dV(6, this.mbT);
            aVar.dV(7, this.mpw);
            if (this.mfg != null) {
                aVar.dX(8, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            aVar.dV(9, this.mfh);
            if (this.mPU != null) {
                aVar.dX(10, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(11, this.mfd);
            if (this.mbZ != null) {
                aVar.e(12, this.mbZ);
            }
            aVar.dV(13, this.mHH);
            aVar.dV(14, this.mYB);
            aVar.dV(15, this.mYC);
            aVar.C(16, this.mcb);
            aVar.dV(17, this.mpQ);
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
            r0 = (r0 + a.a.a.a.dS(3, this.mfb)) + a.a.a.a.dS(4, this.mff);
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(5, this.mcN);
            }
            r0 = (r0 + a.a.a.a.dS(6, this.mbT)) + a.a.a.a.dS(7, this.mpw);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(8, this.mfg.aHr());
            }
            r0 += a.a.a.a.dS(9, this.mfh);
            if (this.mPU != null) {
                r0 += a.a.a.a.dU(10, this.mPU.aHr());
            }
            r0 += a.a.a.a.dS(11, this.mfd);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(12, this.mbZ);
            }
            return ((((r0 + a.a.a.a.dS(13, this.mHH)) + a.a.a.a.dS(14, this.mYB)) + a.a.a.a.dS(15, this.mYC)) + a.a.a.a.B(16, this.mcb)) + a.a.a.a.dS(17, this.mpQ);
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
            bct com_tencent_mm_protocal_c_bct = (bct) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bct.gon = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bct.gom = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bct.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bct.mff = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bct.mcN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bct.mbT = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bct.mpw = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bct.mfg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bct.mfh = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bct.mPU = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bct.mfd = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bct.mbZ = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bct.mHH = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bct.mYB = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bct.mYC = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bct.mcb = aVar3.pMj.mI();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bct.mpQ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
