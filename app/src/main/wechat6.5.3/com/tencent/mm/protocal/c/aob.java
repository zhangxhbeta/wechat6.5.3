package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aob extends aqp {
    public long mNN;
    public long mNQ;
    public String mOk;
    public int mOl;
    public int mOm;
    public int mqS;
    public long mqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mOk == null) {
                throw new b("Not all required fields were included: FromUsername");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mOk != null) {
                aVar.e(2, this.mOk);
            }
            aVar.dV(3, this.mqS);
            aVar.C(4, this.mqT);
            aVar.C(5, this.mNN);
            aVar.dV(6, this.mOl);
            aVar.C(7, this.mNQ);
            aVar.dV(8, this.mOm);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mOk != null) {
                r0 += a.a.a.b.b.a.f(2, this.mOk);
            }
            return (((((r0 + a.a.a.a.dS(3, this.mqS)) + a.a.a.a.B(4, this.mqT)) + a.a.a.a.B(5, this.mNN)) + a.a.a.a.dS(6, this.mOl)) + a.a.a.a.B(7, this.mNQ)) + a.a.a.a.dS(8, this.mOm);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mOk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUsername");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aob com_tencent_mm_protocal_c_aob = (aob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aob.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aob.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aob.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aob.mqT = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aob.mNN = aVar3.pMj.mI();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aob.mOl = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aob.mNQ = aVar3.pMj.mI();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aob.mOm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
