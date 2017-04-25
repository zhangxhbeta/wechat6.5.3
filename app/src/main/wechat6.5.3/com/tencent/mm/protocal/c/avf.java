package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class avf extends aqp {
    public arf mSC;
    public avn mSD;
    public arf mSE;
    public String mbN;
    public int mcP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mSD == null) {
                throw new b("Not all required fields were included: Action");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mSD != null) {
                aVar.dX(2, this.mSD.aHr());
                this.mSD.a(aVar);
            }
            if (this.mbN != null) {
                aVar.e(3, this.mbN);
            }
            if (this.mSC != null) {
                aVar.dX(4, this.mSC.aHr());
                this.mSC.a(aVar);
            }
            aVar.dV(5, this.mcP);
            if (this.mSE == null) {
                return 0;
            }
            aVar.dX(6, this.mSE.aHr());
            this.mSE.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mSD != null) {
                r0 += a.a.a.a.dU(2, this.mSD.aHr());
            }
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(3, this.mbN);
            }
            if (this.mSC != null) {
                r0 += a.a.a.a.dU(4, this.mSC.aHr());
            }
            r0 += a.a.a.a.dS(5, this.mcP);
            if (this.mSE != null) {
                r0 += a.a.a.a.dU(6, this.mSE.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mSD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Action");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avf com_tencent_mm_protocal_c_avf = (avf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            arf com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_avf.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        avn com_tencent_mm_protocal_c_avn = new avn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avn.a(aVar4, com_tencent_mm_protocal_c_avn, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avf.mSD = com_tencent_mm_protocal_c_avn;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avf.mbN = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avf.mSC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avf.mcP = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avf.mSE = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
