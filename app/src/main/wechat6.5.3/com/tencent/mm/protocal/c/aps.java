package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aps extends aqp {
    public String itR;
    public int mFd;
    public String mio;
    public String mip;
    public String miq;
    public String mir;
    public String mis;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mio != null) {
                aVar.e(2, this.mio);
            }
            if (this.mip != null) {
                aVar.e(3, this.mip);
            }
            if (this.miq != null) {
                aVar.e(4, this.miq);
            }
            if (this.mir != null) {
                aVar.e(5, this.mir);
            }
            if (this.mis != null) {
                aVar.e(6, this.mis);
            }
            aVar.dV(7, this.mFd);
            if (this.itR == null) {
                return 0;
            }
            aVar.e(8, this.itR);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(2, this.mio);
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(3, this.mip);
            }
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(4, this.miq);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(5, this.mir);
            }
            if (this.mis != null) {
                r0 += a.a.a.b.b.a.f(6, this.mis);
            }
            r0 += a.a.a.a.dS(7, this.mFd);
            if (this.itR != null) {
                r0 += a.a.a.b.b.a.f(8, this.itR);
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
            aps com_tencent_mm_protocal_c_aps = (aps) objArr[1];
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
                        com_tencent_mm_protocal_c_aps.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aps.mio = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aps.mip = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aps.miq = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aps.mir = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aps.mis = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aps.mFd = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aps.itR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
