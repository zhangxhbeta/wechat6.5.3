package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class anm extends aqp {
    public String gom;
    public long mNN;
    public int mNO;
    public String mNP;
    public long mNQ;
    public int mqS;
    public long mqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mqS);
            aVar.C(3, this.mqT);
            if (this.gom != null) {
                aVar.e(4, this.gom);
            }
            aVar.C(5, this.mNN);
            aVar.dV(6, this.mNO);
            if (this.mNP != null) {
                aVar.e(7, this.mNP);
            }
            aVar.C(8, this.mNQ);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.B(3, this.mqT);
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(4, this.gom);
            }
            r0 = (r0 + a.a.a.a.B(5, this.mNN)) + a.a.a.a.dS(6, this.mNO);
            if (this.mNP != null) {
                r0 += a.a.a.b.b.a.f(7, this.mNP);
            }
            return r0 + a.a.a.a.B(8, this.mNQ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anm com_tencent_mm_protocal_c_anm = (anm) objArr[1];
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
                        com_tencent_mm_protocal_c_anm.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anm.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anm.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anm.gom = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anm.mNN = aVar3.pMj.mI();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_anm.mNO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anm.mNP = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_anm.mNQ = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
