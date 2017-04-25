package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bbo extends aqp {
    public int efm;
    public String glj;
    public String gln;
    public String mXu;
    public int mcM;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;
    public String mpI;

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
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            aVar.dV(3, this.mcM);
            if (this.mXu != null) {
                aVar.e(4, this.mXu);
            }
            if (this.gln != null) {
                aVar.e(5, this.gln);
            }
            aVar.dV(6, this.mdz);
            aVar.dV(7, this.mdA);
            aVar.dV(8, this.mdB);
            if (this.mfg != null) {
                aVar.dX(9, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            aVar.dV(10, this.efm);
            if (this.mpI == null) {
                return 0;
            }
            aVar.e(11, this.mpI);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            r0 += a.a.a.a.dS(3, this.mcM);
            if (this.mXu != null) {
                r0 += a.a.a.b.b.a.f(4, this.mXu);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(5, this.gln);
            }
            r0 = ((r0 + a.a.a.a.dS(6, this.mdz)) + a.a.a.a.dS(7, this.mdA)) + a.a.a.a.dS(8, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(9, this.mfg.aHr());
            }
            r0 += a.a.a.a.dS(10, this.efm);
            if (this.mpI != null) {
                r0 += a.a.a.b.b.a.f(11, this.mpI);
            }
            return r0;
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
            bbo com_tencent_mm_protocal_c_bbo = (bbo) objArr[1];
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
                        com_tencent_mm_protocal_c_bbo.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbo.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbo.mcM = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbo.mXu = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbo.gln = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbo.mdz = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbo.mdA = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbo.mdB = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbo.mfg = enVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bbo.efm = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bbo.mpI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
