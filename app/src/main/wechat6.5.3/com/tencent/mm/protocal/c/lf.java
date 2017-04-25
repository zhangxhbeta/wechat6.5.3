package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class lf extends aqp {
    public String mbN;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;
    public String mnJ;
    public String mnK;
    public int mnL;

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
            if (this.mbN != null) {
                aVar.e(2, this.mbN);
            }
            aVar.dV(3, this.mdz);
            aVar.dV(4, this.mdA);
            aVar.dV(5, this.mdB);
            if (this.mfg != null) {
                aVar.dX(6, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            if (this.mnJ != null) {
                aVar.e(7, this.mnJ);
            }
            if (this.mnK != null) {
                aVar.e(9, this.mnK);
            }
            aVar.dV(10, this.mnL);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mbN);
            }
            r0 = ((r0 + a.a.a.a.dS(3, this.mdz)) + a.a.a.a.dS(4, this.mdA)) + a.a.a.a.dS(5, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(6, this.mfg.aHr());
            }
            if (this.mnJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.mnJ);
            }
            if (this.mnK != null) {
                r0 += a.a.a.b.b.a.f(9, this.mnK);
            }
            return r0 + a.a.a.a.dS(10, this.mnL);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
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
            lf lfVar = (lf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        lfVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    lfVar.mbN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    lfVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    lfVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 5:
                    lfVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        lfVar.mfg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 7:
                    lfVar.mnJ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    lfVar.mnK = aVar3.pMj.readString();
                    return 0;
                case 10:
                    lfVar.mnL = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
