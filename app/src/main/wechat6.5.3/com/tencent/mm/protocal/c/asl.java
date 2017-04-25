package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class asl extends aqp {
    public String cHf;
    public co mRg;
    public String mRh;
    public String mRi;
    public int mRj;
    public int mdC;
    public int mjU;
    public String mpC;
    public int mpQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mRg == null) {
                throw new b("Not all required fields were included: Msg");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mRg != null) {
                aVar.dX(2, this.mRg.aHr());
                this.mRg.a(aVar);
            }
            if (this.mRh != null) {
                aVar.e(3, this.mRh);
            }
            aVar.dV(4, this.mpQ);
            if (this.mpC != null) {
                aVar.e(5, this.mpC);
            }
            aVar.dV(6, this.mdC);
            if (this.cHf != null) {
                aVar.e(7, this.cHf);
            }
            if (this.mRi != null) {
                aVar.e(8, this.mRi);
            }
            aVar.dV(9, this.mRj);
            aVar.dV(10, this.mjU);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mRg != null) {
                r0 += a.a.a.a.dU(2, this.mRg.aHr());
            }
            if (this.mRh != null) {
                r0 += a.a.a.b.b.a.f(3, this.mRh);
            }
            r0 += a.a.a.a.dS(4, this.mpQ);
            if (this.mpC != null) {
                r0 += a.a.a.b.b.a.f(5, this.mpC);
            }
            r0 += a.a.a.a.dS(6, this.mdC);
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(7, this.cHf);
            }
            if (this.mRi != null) {
                r0 += a.a.a.b.b.a.f(8, this.mRi);
            }
            return (r0 + a.a.a.a.dS(9, this.mRj)) + a.a.a.a.dS(10, this.mjU);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mRg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asl com_tencent_mm_protocal_c_asl = (asl) objArr[1];
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
                        com_tencent_mm_protocal_c_asl.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new co();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asl.mRg = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asl.mRh = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asl.mpQ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asl.mpC = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asl.mdC = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asl.cHf = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asl.mRi = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_asl.mRj = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asl.mjU = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
