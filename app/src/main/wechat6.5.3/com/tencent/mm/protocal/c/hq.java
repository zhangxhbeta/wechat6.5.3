package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class hq extends aqp {
    public int lZo;
    public String lZp;
    public String mhz;
    public agq miA;
    public ark miB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mhz != null) {
                aVar.e(2, this.mhz);
            }
            if (this.miA != null) {
                aVar.dX(3, this.miA.aHr());
                this.miA.a(aVar);
            }
            if (this.miB != null) {
                aVar.dX(4, this.miB.aHr());
                this.miB.a(aVar);
            }
            aVar.dV(5, this.lZo);
            if (this.lZp == null) {
                return 0;
            }
            aVar.e(6, this.lZp);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhz != null) {
                r0 += a.a.a.b.b.a.f(2, this.mhz);
            }
            if (this.miA != null) {
                r0 += a.a.a.a.dU(3, this.miA.aHr());
            }
            if (this.miB != null) {
                r0 += a.a.a.a.dU(4, this.miB.aHr());
            }
            r0 += a.a.a.a.dS(5, this.lZo);
            if (this.lZp != null) {
                r0 += a.a.a.b.b.a.f(6, this.lZp);
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
            hq hqVar = (hq) objArr[1];
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
                        hqVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    hqVar.mhz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        agq com_tencent_mm_protocal_c_agq = new agq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_agq.a(aVar4, com_tencent_mm_protocal_c_agq, aqp.a(aVar4))) {
                        }
                        hqVar.miA = com_tencent_mm_protocal_c_agq;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ark com_tencent_mm_protocal_c_ark = new ark();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ark.a(aVar4, com_tencent_mm_protocal_c_ark, aqp.a(aVar4))) {
                        }
                        hqVar.miB = com_tencent_mm_protocal_c_ark;
                    }
                    return 0;
                case 5:
                    hqVar.lZo = aVar3.pMj.mH();
                    return 0;
                case 6:
                    hqVar.lZp = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
