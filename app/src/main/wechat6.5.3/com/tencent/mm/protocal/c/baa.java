package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class baa extends aqp {
    public acj mWG;
    public int mWH;
    public String meq;
    public String mnR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mnR != null) {
                aVar.e(2, this.mnR);
            }
            if (this.meq != null) {
                aVar.e(3, this.meq);
            }
            if (this.mWG != null) {
                aVar.dX(4, this.mWG.aHr());
                this.mWG.a(aVar);
            }
            aVar.dV(5, this.mWH);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mnR != null) {
                r0 += a.a.a.b.b.a.f(2, this.mnR);
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(3, this.meq);
            }
            if (this.mWG != null) {
                r0 += a.a.a.a.dU(4, this.mWG.aHr());
            }
            return r0 + a.a.a.a.dS(5, this.mWH);
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
            baa com_tencent_mm_protocal_c_baa = (baa) objArr[1];
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
                        com_tencent_mm_protocal_c_baa.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baa.mnR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_baa.meq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        acj com_tencent_mm_protocal_c_acj = new acj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acj.a(aVar4, com_tencent_mm_protocal_c_acj, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_baa.mWG = com_tencent_mm_protocal_c_acj;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_baa.mWH = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
