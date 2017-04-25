package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class bdj extends aqp {
    public int hNX;
    public String mNw;
    public String mNx;
    public int mNy;
    public String mNz;
    public are mZl;
    public int mZm;
    public int mZn;
    public String mZo;
    public String mdM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mZl == null) {
                throw new b("Not all required fields were included: Receipt");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mZl != null) {
                aVar.dX(2, this.mZl.aHr());
                this.mZl.a(aVar);
            }
            if (this.mdM != null) {
                aVar.e(3, this.mdM);
            }
            aVar.dV(4, this.mZm);
            aVar.dV(5, this.hNX);
            if (this.mNw != null) {
                aVar.e(6, this.mNw);
            }
            if (this.mNx != null) {
                aVar.e(7, this.mNx);
            }
            if (this.mNz != null) {
                aVar.e(8, this.mNz);
            }
            aVar.dV(9, this.mZn);
            if (this.mZo != null) {
                aVar.e(10, this.mZo);
            }
            aVar.dV(11, this.mNy);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mZl != null) {
                r0 += a.a.a.a.dU(2, this.mZl.aHr());
            }
            if (this.mdM != null) {
                r0 += a.a.a.b.b.a.f(3, this.mdM);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.mZm)) + a.a.a.a.dS(5, this.hNX);
            if (this.mNw != null) {
                r0 += a.a.a.b.b.a.f(6, this.mNw);
            }
            if (this.mNx != null) {
                r0 += a.a.a.b.b.a.f(7, this.mNx);
            }
            if (this.mNz != null) {
                r0 += a.a.a.b.b.a.f(8, this.mNz);
            }
            r0 += a.a.a.a.dS(9, this.mZn);
            if (this.mZo != null) {
                r0 += a.a.a.b.b.a.f(10, this.mZo);
            }
            return r0 + a.a.a.a.dS(11, this.mNy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mZl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Receipt");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bdj com_tencent_mm_protocal_c_bdj = (bdj) objArr[1];
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
                        com_tencent_mm_protocal_c_bdj.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bdj.mZl = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdj.mdM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdj.mZm = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdj.hNX = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdj.mNw = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bdj.mNx = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bdj.mNz = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_bdj.mZn = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_bdj.mZo = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bdj.mNy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
