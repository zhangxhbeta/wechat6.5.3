package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class arl extends aqp {
    public amz mQD;
    public float mQE;
    public float mQF;
    public int maG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQD == null) {
                throw new b("Not all required fields were included: UserPos");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mQD != null) {
                aVar.dX(2, this.mQD.aHr());
                this.mQD.a(aVar);
            }
            aVar.dV(3, this.maG);
            aVar.j(4, this.mQE);
            aVar.j(5, this.mQF);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mQD != null) {
                r0 += a.a.a.a.dU(2, this.mQD.aHr());
            }
            return ((r0 + a.a.a.a.dS(3, this.maG)) + (a.a.a.b.b.a.cw(4) + 4)) + (a.a.a.b.b.a.cw(5) + 4);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserPos");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            arl com_tencent_mm_protocal_c_arl = (arl) objArr[1];
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
                        com_tencent_mm_protocal_c_arl.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        amz com_tencent_mm_protocal_c_amz = new amz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_amz.a(aVar4, com_tencent_mm_protocal_c_amz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arl.mQD = com_tencent_mm_protocal_c_amz;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arl.maG = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arl.mQE = aVar3.pMj.readFloat();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arl.mQF = aVar3.pMj.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
