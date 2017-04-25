package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azm extends aqp {
    public String fZW;
    public int mDi;
    public int mDj;
    public are mDk;
    public are mNe;
    public String mWk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mDk == null) {
                throw new b("Not all required fields were included: ReqText");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mDi);
            aVar.dV(3, this.mDj);
            if (this.mDk != null) {
                aVar.dX(4, this.mDk.aHr());
                this.mDk.a(aVar);
            }
            if (this.mNe != null) {
                aVar.dX(5, this.mNe.aHr());
                this.mNe.a(aVar);
            }
            if (this.fZW != null) {
                aVar.e(6, this.fZW);
            }
            if (this.mWk == null) {
                return 0;
            }
            aVar.e(7, this.mWk);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mDi)) + a.a.a.a.dS(3, this.mDj);
            if (this.mDk != null) {
                r0 += a.a.a.a.dU(4, this.mDk.aHr());
            }
            if (this.mNe != null) {
                r0 += a.a.a.a.dU(5, this.mNe.aHr());
            }
            if (this.fZW != null) {
                r0 += a.a.a.b.b.a.f(6, this.fZW);
            }
            if (this.mWk != null) {
                r0 += a.a.a.b.b.a.f(7, this.mWk);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mDk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReqText");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azm com_tencent_mm_protocal_c_azm = (azm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            are com_tencent_mm_protocal_c_are;
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
                        com_tencent_mm_protocal_c_azm.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azm.mDi = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azm.mDj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.mDk = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azm.mNe = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azm.fZW = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azm.mWk = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
