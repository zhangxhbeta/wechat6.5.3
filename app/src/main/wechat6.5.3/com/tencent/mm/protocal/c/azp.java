package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azp extends aqp {
    public int gll;
    public String mHw;
    public int mNl;
    public int mdA;
    public int mdz;
    public are mok;
    public int mpw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mok == null) {
                throw new b("Not all required fields were included: Content");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.gll);
            aVar.dV(3, this.mNl);
            if (this.mok != null) {
                aVar.dX(4, this.mok.aHr());
                this.mok.a(aVar);
            }
            aVar.dV(5, this.mdA);
            aVar.dV(6, this.mdz);
            if (this.mHw != null) {
                aVar.e(7, this.mHw);
            }
            aVar.dV(8, this.mpw);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.gll)) + a.a.a.a.dS(3, this.mNl);
            if (this.mok != null) {
                r0 += a.a.a.a.dU(4, this.mok.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mdA)) + a.a.a.a.dS(6, this.mdz);
            if (this.mHw != null) {
                r0 += a.a.a.b.b.a.f(7, this.mHw);
            }
            return r0 + a.a.a.a.dS(8, this.mpw);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mok != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Content");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azp com_tencent_mm_protocal_c_azp = (azp) objArr[1];
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
                        com_tencent_mm_protocal_c_azp.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azp.gll = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azp.mNl = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azp.mok = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azp.mdA = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azp.mdz = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azp.mHw = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azp.mpw = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
