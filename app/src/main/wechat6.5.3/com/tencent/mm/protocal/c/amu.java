package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class amu extends aqx {
    public String efy;
    public int gll;
    public String mLT;
    public int mNl;
    public int mNm;
    public int mNn;
    public int mwM;
    public int mwN;
    public String myI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mNl);
            aVar.dV(3, this.gll);
            if (this.mLT != null) {
                aVar.e(4, this.mLT);
            }
            if (this.myI != null) {
                aVar.e(5, this.myI);
            }
            if (this.efy != null) {
                aVar.e(6, this.efy);
            }
            aVar.dV(7, this.mNm);
            aVar.dV(8, this.mwM);
            aVar.dV(9, this.mwN);
            aVar.dV(10, this.mNn);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mNl)) + a.a.a.a.dS(3, this.gll);
            if (this.mLT != null) {
                r0 += a.a.a.b.b.a.f(4, this.mLT);
            }
            if (this.myI != null) {
                r0 += a.a.a.b.b.a.f(5, this.myI);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(6, this.efy);
            }
            return (((r0 + a.a.a.a.dS(7, this.mNm)) + a.a.a.a.dS(8, this.mwM)) + a.a.a.a.dS(9, this.mwN)) + a.a.a.a.dS(10, this.mNn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
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
            amu com_tencent_mm_protocal_c_amu = (amu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amu.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amu.mNl = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amu.gll = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amu.mLT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amu.myI = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amu.efy = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_amu.mNm = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_amu.mwM = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_amu.mwN = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_amu.mNn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
