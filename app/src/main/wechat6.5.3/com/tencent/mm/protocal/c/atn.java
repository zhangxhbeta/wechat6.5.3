package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class atn extends aqp {
    public String gkz;
    public int mRD;
    public String mRE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gkz != null) {
                aVar.e(2, this.gkz);
            }
            aVar.dV(3, this.mRD);
            if (this.mRE == null) {
                return 0;
            }
            aVar.e(4, this.mRE);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkz != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkz);
            }
            r0 += a.a.a.a.dS(3, this.mRD);
            if (this.mRE != null) {
                r0 += a.a.a.b.b.a.f(4, this.mRE);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            atn com_tencent_mm_protocal_c_atn = (atn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atn.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atn.gkz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atn.mRD = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atn.mRE = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
