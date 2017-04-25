package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aqq extends a {
    public int jho;
    public int lDw;
    public int mDr;
    public int mNI;
    public aqt mPV;
    public aqs mPW;
    public String mPX;
    public int mPY;
    public int mPZ;
    public int mQa;
    public int mjt;
    public int myO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mPX == null) {
                throw new b("Not all required fields were included: SampleId");
            }
            aVar.dV(1, this.mNI);
            if (this.mPV != null) {
                aVar.dX(2, this.mPV.aHr());
                this.mPV.a(aVar);
            }
            if (this.mPW != null) {
                aVar.dX(3, this.mPW.aHr());
                this.mPW.a(aVar);
            }
            aVar.dV(4, this.myO);
            aVar.dV(5, this.jho);
            if (this.mPX != null) {
                aVar.e(6, this.mPX);
            }
            aVar.dV(7, this.mjt);
            aVar.dV(8, this.mPY);
            aVar.dV(9, this.lDw);
            aVar.dV(10, this.mPZ);
            aVar.dV(11, this.mQa);
            aVar.dV(12, this.mDr);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mNI) + 0;
            if (this.mPV != null) {
                r0 += a.a.a.a.dU(2, this.mPV.aHr());
            }
            if (this.mPW != null) {
                r0 += a.a.a.a.dU(3, this.mPW.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(4, this.myO)) + a.a.a.a.dS(5, this.jho);
            if (this.mPX != null) {
                r0 += a.a.a.b.b.a.f(6, this.mPX);
            }
            return (((((r0 + a.a.a.a.dS(7, this.mjt)) + a.a.a.a.dS(8, this.mPY)) + a.a.a.a.dS(9, this.lDw)) + a.a.a.a.dS(10, this.mPZ)) + a.a.a.a.dS(11, this.mQa)) + a.a.a.a.dS(12, this.mDr);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mPX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SampleId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqq com_tencent_mm_protocal_c_aqq = (aqq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aqt;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aqq.mNI = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_aqt = new aqt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqt.a(aVar4, com_tencent_mm_protocal_c_aqt, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqq.mPV = com_tencent_mm_protocal_c_aqt;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_aqt = new aqs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqt.a(aVar4, com_tencent_mm_protocal_c_aqt, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqq.mPW = com_tencent_mm_protocal_c_aqt;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqq.myO = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqq.jho = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqq.mPX = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqq.mjt = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqq.mPY = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqq.lDw = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqq.mPZ = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqq.mQa = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aqq.mDr = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
