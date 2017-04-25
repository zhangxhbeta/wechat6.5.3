package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class alp extends aqp {
    public String hNP;
    public int hNX;
    public String hOj;
    public int mMw;
    public am mkb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mMw);
            if (this.hNP != null) {
                aVar.e(3, this.hNP);
            }
            aVar.dV(4, this.hNX);
            if (this.hOj != null) {
                aVar.e(5, this.hOj);
            }
            if (this.mkb == null) {
                return 0;
            }
            aVar.dX(6, this.mkb.aHr());
            this.mkb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mMw);
            if (this.hNP != null) {
                r0 += a.a.a.b.b.a.f(3, this.hNP);
            }
            r0 += a.a.a.a.dS(4, this.hNX);
            if (this.hOj != null) {
                r0 += a.a.a.b.b.a.f(5, this.hOj);
            }
            if (this.mkb != null) {
                r0 += a.a.a.a.dU(6, this.mkb.aHr());
            }
            return r0;
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
            alp com_tencent_mm_protocal_c_alp = (alp) objArr[1];
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
                        com_tencent_mm_protocal_c_alp.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alp.mMw = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alp.hNP = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alp.hNX = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alp.hOj = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        am amVar = new am();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amVar.a(aVar4, amVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alp.mkb = amVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
