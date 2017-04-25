package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ans extends aqp {
    public String gom;
    public String gon;
    public long mNN;
    public int mNO;
    public String mNP;
    public int mNW;
    public int mNX;
    public int mNY;
    public int mnk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gon != null) {
                aVar.e(2, this.gon);
            }
            if (this.mNP != null) {
                aVar.e(3, this.mNP);
            }
            aVar.dV(4, this.mnk);
            aVar.C(5, this.mNN);
            aVar.dV(6, this.mNO);
            if (this.gom != null) {
                aVar.e(7, this.gom);
            }
            aVar.dV(8, this.mNX);
            aVar.dV(9, this.mNW);
            aVar.dV(10, this.mNY);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(2, this.gon);
            }
            if (this.mNP != null) {
                r0 += a.a.a.b.b.a.f(3, this.mNP);
            }
            r0 = ((r0 + a.a.a.a.dS(4, this.mnk)) + a.a.a.a.B(5, this.mNN)) + a.a.a.a.dS(6, this.mNO);
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(7, this.gom);
            }
            return ((r0 + a.a.a.a.dS(8, this.mNX)) + a.a.a.a.dS(9, this.mNW)) + a.a.a.a.dS(10, this.mNY);
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
            ans com_tencent_mm_protocal_c_ans = (ans) objArr[1];
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
                        com_tencent_mm_protocal_c_ans.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ans.gon = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ans.mNP = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ans.mnk = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ans.mNN = aVar3.pMj.mI();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ans.mNO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ans.gom = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ans.mNX = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ans.mNW = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ans.mNY = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
