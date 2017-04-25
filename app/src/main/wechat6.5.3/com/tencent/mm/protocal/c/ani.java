package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ani extends aqp {
    public String gor;
    public int hNX;
    public String mNw;
    public String mNx;
    public int mNy;
    public String mdM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mdM != null) {
                aVar.e(2, this.mdM);
            }
            if (this.mNw != null) {
                aVar.e(3, this.mNw);
            }
            if (this.mNx != null) {
                aVar.e(4, this.mNx);
            }
            aVar.dV(5, this.hNX);
            if (this.gor != null) {
                aVar.e(7, this.gor);
            }
            aVar.dV(8, this.mNy);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdM != null) {
                r0 += a.a.a.b.b.a.f(2, this.mdM);
            }
            if (this.mNw != null) {
                r0 += a.a.a.b.b.a.f(3, this.mNw);
            }
            if (this.mNx != null) {
                r0 += a.a.a.b.b.a.f(4, this.mNx);
            }
            r0 += a.a.a.a.dS(5, this.hNX);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(7, this.gor);
            }
            return r0 + a.a.a.a.dS(8, this.mNy);
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
            ani com_tencent_mm_protocal_c_ani = (ani) objArr[1];
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
                        com_tencent_mm_protocal_c_ani.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ani.mdM = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ani.mNw = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ani.mNx = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ani.hNX = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ani.gor = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ani.mNy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
