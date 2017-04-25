package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class axc extends aqp {
    public are mSH;
    public String mSV;
    public long mSW;
    public long mUm;
    public int mUn;
    public long mUo;
    public int mfm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mSV != null) {
                aVar.e(2, this.mSV);
            }
            aVar.C(3, this.mSW);
            aVar.C(4, this.mUm);
            aVar.dV(5, this.mUn);
            aVar.C(6, this.mUo);
            if (this.mSH != null) {
                aVar.dX(7, this.mSH.aHr());
                this.mSH.a(aVar);
            }
            aVar.dV(8, this.mfm);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mSV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mSV);
            }
            r0 = (((r0 + a.a.a.a.B(3, this.mSW)) + a.a.a.a.B(4, this.mUm)) + a.a.a.a.dS(5, this.mUn)) + a.a.a.a.B(6, this.mUo);
            if (this.mSH != null) {
                r0 += a.a.a.a.dU(7, this.mSH.aHr());
            }
            return r0 + a.a.a.a.dS(8, this.mfm);
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
            axc com_tencent_mm_protocal_c_axc = (axc) objArr[1];
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
                        com_tencent_mm_protocal_c_axc.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axc.mSV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axc.mSW = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axc.mUm = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axc.mUn = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axc.mUo = aVar3.pMj.mI();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axc.mSH = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_axc.mfm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
