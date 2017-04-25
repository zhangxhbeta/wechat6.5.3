package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class axh extends aqp {
    public String mSV;
    public long mSW;
    public long mUm;
    public int mUn;
    public int mcP;
    public String mdw;

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
            if (this.mdw != null) {
                aVar.e(3, this.mdw);
            }
            aVar.C(4, this.mSW);
            aVar.dV(5, this.mcP);
            aVar.C(6, this.mUm);
            aVar.dV(7, this.mUn);
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
            if (this.mdw != null) {
                r0 += a.a.a.b.b.a.f(3, this.mdw);
            }
            return (((r0 + a.a.a.a.B(4, this.mSW)) + a.a.a.a.dS(5, this.mcP)) + a.a.a.a.B(6, this.mUm)) + a.a.a.a.dS(7, this.mUn);
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
            axh com_tencent_mm_protocal_c_axh = (axh) objArr[1];
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
                        com_tencent_mm_protocal_c_axh.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axh.mSV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axh.mdw = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axh.mSW = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axh.mcP = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_axh.mUm = aVar3.pMj.mI();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_axh.mUn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
